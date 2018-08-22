package pl.skamycki.find3.app.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData

fun <T> LiveData<T>.toMutableLiveData(): MutableLiveData<T> = takeIfInstance<MutableLiveData<T>>() ?: mutableLiveDataOf(this)
fun <T> mutableLiveDataOf(): MutableLiveData<T> = MutableLiveData()
fun <T> mutableLiveDataOf(value: T): MutableLiveData<T> = MutableLiveData<T>().apply { this.value = value }
fun <T> mutableLiveDataOf(source: LiveData<T>): MutableLiveData<T> = MediatorLiveData<T>().apply { addSource(source, ::setValue) }
fun <S, T> MediatorLiveData<T>.addValueSource(source: LiveData<S>, resultFunction: (sourceValue: S?) -> T) = this.apply { addSource(source) { value = resultFunction(it) } }

