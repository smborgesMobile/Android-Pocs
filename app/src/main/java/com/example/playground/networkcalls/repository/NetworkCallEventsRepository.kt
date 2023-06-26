package com.example.playground.networkcalls.repository

class NetworkCallEventsRepository : NetworkCallRepository {
    override fun getFirstList(): List<String> {
        return listOf(
            "NetworkCallEventsRepository1",
            "NetworkCallEventsRepository2",
            "NetworkCallEventsRepository3",
            "NetworkCallEventsRepository4"
        )
    }

    override fun getSecondList(): List<String> {
        return listOf(
            "NetworkCallEventsRepositorySecond1",
            "NetworkCallEventsRepositorySecond2",
            "NetworkCallEventsRepositorySecond3",
            "NetworkCallEventsRepositorySecond4"
        )
    }
}