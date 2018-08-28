package pl.skamycki.find3.data

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.jayway.jsonpath.JsonPath
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import pl.skamycki.find3.app.di.ApplicationModule
import pl.skamycki.find3.app.infrastructure.AppExecutors
import pl.skamycki.find3.app.settings.AppSettings
import pl.skamycki.find3.data.model.GpsData
import pl.skamycki.find3.data.model.LearnData
import pl.skamycki.find3.data.model.ScanData
import pl.skamycki.find3.test.di.DaggerTestApplicationComponent
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class Find3ServiceTest {

    private lateinit var mockWebServer: MockWebServer

    private val appExecutors = AppExecutors(Unconfined, Unconfined, Unconfined)

    @Inject
    lateinit var service: Find3Service

    @Before
    fun setup() {
        startServer()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun learn_body_is_properly_serialized() = runBlocking(appExecutors.network) {
        mockWebServer.enqueue(
                MockResponse().setResponseCode(200)
        )

        service.sendLearnData(
                LearnData(
                        family = "family",
                        device = "device",
                        location = "location",
                        scanData = ScanData(
                                wifiNameToRssi = mapOf("mac1" to -40, "mac2" to -50),
                                bluetoothNameToRssi = mapOf("bt_mac_1" to -60, "bt_mac_2" to -70)
                        ),
                        gpsData = GpsData(50.40, 20.30, 20.0)
                )
        )

        val requestJson = mockWebServer.takeRequest().body.readUtf8()

        val readContext = JsonPath.parse(requestJson)

        assertThat(readContext.read("$.f"), `is`("family"))
        assertThat(readContext.read("$.d"), `is`("device"))
        assertThat(readContext.read("$.l"), `is`("location"))
        assertThat(readContext.read("$.gps.lat"), `is`(50.40))
        assertThat(readContext.read("$.gps.lon"), `is`(20.30))
        assertThat(readContext.read("$.gps.alt"), `is`(20.0))
        assertThat(readContext.read("$.s.wifi.mac1"), `is`(-40))
        assertThat(readContext.read("$.s.wifi.mac2"), `is`(-50))
        assertThat(readContext.read("$.s.bluetooth.bt_mac_1"), `is`(-60))
        assertThat(readContext.read("$.s.bluetooth.bt_mac_2"), `is`(-70))
    }

    private fun startServer() {
        mockWebServer = MockWebServer()
        val appSettings = mock<AppSettings> {
            on { getServerUrl() } doReturn mockWebServer.url("/").toString()
        }

        val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
        val component = DaggerTestApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(
                        context = app as Context,
                        appExecutors = appExecutors,
                        appSettings = appSettings)
                )
                .build()
        component.inject(this)
    }
}
