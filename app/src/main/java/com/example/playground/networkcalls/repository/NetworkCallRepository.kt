package com.example.playground.networkcalls.repository

interface NetworkCallRepository {

    fun getFirstList(): List<String>

    fun getSecondList(): List<String>
}