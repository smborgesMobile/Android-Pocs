package com.example.playground.networkcalls.booking

import android.content.Context
import android.content.Intent
import com.example.playground.R
import com.example.playground.networkcalls.BaseNetworkCallActivityApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingActivity : BaseNetworkCallActivityApi() {

    override val viewModel: BookingViewModel by viewModel()

    override val backgroundColor: Int
        get() = getColor(R.color.white)

    override val title: String
        get() = "BookingActivity"

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, BookingActivity::class.java)
    }
}