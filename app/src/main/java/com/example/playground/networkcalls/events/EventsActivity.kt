package com.example.playground.networkcalls.events

import android.content.Context
import android.content.Intent
import com.example.playground.R
import com.example.playground.networkcalls.BaseNetworkCallActivityApi
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsActivity : BaseNetworkCallActivityApi() {

    override val backgroundColor: Int
        get() = getColor(R.color.white)

    override val viewModel: EventsViewModel by viewModel()

    override val title: String
        get() = "EventsActivity"

    companion object {
        fun getLaunchIntent(context: Context) = Intent(context, EventsActivity::class.java)
    }
}