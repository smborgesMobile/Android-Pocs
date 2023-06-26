package com.example.playground.networkcalls.booking

import com.example.playground.networkcalls.BaseNetworkCallViewModel
import com.example.playground.networkcalls.business.OrderBusiness

class BookingViewModel(private val repository: OrderBusiness) : BaseNetworkCallViewModel() {

    override fun loadData() {
        currentList.value = State.Loading
        currentList.value = State.Success(repository.getOderHistory())
    }
}