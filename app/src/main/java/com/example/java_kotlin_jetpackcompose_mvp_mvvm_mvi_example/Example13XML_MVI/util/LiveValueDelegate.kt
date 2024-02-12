package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.BaseViewModel
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun <T> MutableLiveData<T>.delegate() = LiveValueDelegate(this)

class LiveValueDelegate<T>(
    private val liveData: MutableLiveData<T>
) : ReadWriteProperty<BaseViewModel<*, *>, T> {

    override fun getValue(thisRef: BaseViewModel<*, *>, property: KProperty<*>): T {
        return liveData.value!!
    }

    override fun setValue(thisRef: BaseViewModel<*, *>, property: KProperty<*>, value: T) {
        liveData.value = value
    }
}