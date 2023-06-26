package com.example.playground.networkcalls.repository

class NetworkCallsBookingRepository : NetworkCallRepository {
    override fun getFirstList(): List<String> {
        return listOf(
            "NetworkCallsBookingRepository1",
            "NetworkCallsBookingRepository2",
            "NetworkCallsBookingRepository3",
            "NetworkCallsBookingRepository4"
        )
    }

    override fun getSecondList(): List<String> {
        return listOf(
            "NetworkCallsBookingRepositorySecond1",
            "NetworkCallsBookingRepositorySecond2",
            "NetworkCallsBookingRepositorySecond3",
            "NetworkCallsBookingRepositorySecond4"
        )
    }
}