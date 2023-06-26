package com.example.playground.networkcalls

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseNetworkCallViewModel : ViewModel() {

    abstract fun loadData()

    val currentList: MutableLiveData<State> by lazy {
        MutableLiveData<State>()
    }

    sealed interface State {
        object Loading : State
        data class Success(val eventList: List<String>) : State
        object Error : State
    }
}