package pl.skamycki.find3.welcome

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import dagger.android.AndroidInjection
import pl.skamycki.find3.BuildConfig
import pl.skamycki.find3.R
import pl.skamycki.find3.app.activity.BaseActivity
import pl.skamycki.find3.app.extensions.activityBinding
import pl.skamycki.find3.app.extensions.getViewModel
import pl.skamycki.find3.databinding.ActivityWelcomeBinding
import javax.inject.Inject

class WelcomeActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var interactor: WelcomeInteractor

    private val binding by activityBinding<ActivityWelcomeBinding>(layoutResId)

    private val viewModel by lazy { getViewModel<WelcomeViewModel>(factory) }

    override val layoutResId: Int
        get() = R.layout.activity_welcome

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel.server.value = BuildConfig.DEFAULT_URL

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
    }
}
