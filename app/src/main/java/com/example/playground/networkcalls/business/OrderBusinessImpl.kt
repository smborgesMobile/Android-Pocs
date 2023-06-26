package com.example.playground.networkcalls.business

import com.example.playground.networkcalls.repository.NetworkCallRepository

class OrderBusinessImpl(private val orderBusinessRepository: NetworkCallRepository) : OrderBusiness {
    override fun getOderHistory(): List<String> {
        return orderBusinessRepository.getFirstList() + orderBusinessRepository.getSecondList()
    }
}