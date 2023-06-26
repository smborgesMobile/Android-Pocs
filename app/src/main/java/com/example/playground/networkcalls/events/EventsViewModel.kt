package com.example.playground.networkcalls.events

import com.example.playground.networkcalls.BaseNetworkCallViewModel
import com.example.playground.networkcalls.business.OrderBusiness

class EventsViewModel(private val business: OrderBusiness) : BaseNetworkCallViewModel() {

    override fun loadData() {
        currentList.value = State.Loading
        currentList.value = State.Success(business.getOderHistory())
    }
}