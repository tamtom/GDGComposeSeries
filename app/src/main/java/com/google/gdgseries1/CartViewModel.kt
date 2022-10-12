package com.google.gdgseries1

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow

class CartViewModel : ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    fun loading(show: Boolean) {
        loading.value = show
    }

    private val _quantity = MutableLiveData<Int>(0)
    val quantity: LiveData<Int> = _quantity
    fun increment() {
        _quantity.value = _quantity.value?.plus(1)
    }

    fun decrement() {
        _quantity.value = _quantity.value?.minus(1)
    }
}