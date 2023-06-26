package com.example.playground.di

import com.example.playground.networkcalls.booking.BookingViewModel
import com.example.playground.networkcalls.business.OrderBusiness
import com.example.playground.networkcalls.business.OrderBusinessImpl
import com.example.playground.networkcalls.events.EventsViewModel
import com.example.playground.networkcalls.repository.NetworkCallEventsRepository
import com.example.playground.networkcalls.repository.NetworkCallRepository
import com.example.playground.networkcalls.repository.NetworkCallsBookingRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

class PlaygroundModuleDI {

    fun loadModules() =
        module {
            single<NetworkCallRepository>(named(EVENT_REPOSITORY)) { NetworkCallEventsRepository() }
            single<NetworkCallRepository>(named(BOOKING_REPOSITORY)) { NetworkCallsBookingRepository() }
            single<OrderBusiness>(named(EVENT_BUSINESS)) { OrderBusinessImpl(get(named(EVENT_REPOSITORY))) }
            single<OrderBusiness>(named(BOOKING_BUSINESS)) { OrderBusinessImpl(get(named(BOOKING_REPOSITORY))) }
            viewModel { BookingViewModel(get(named(BOOKING_BUSINESS))) }
            viewModel { EventsViewModel(get(named(EVENT_BUSINESS))) }
        }

    companion object {
        const val EVENT_REPOSITORY = "eventsRepository"
        const val BOOKING_REPOSITORY = "bookingRepository"
        const val EVENT_BUSINESS = "eventBusiness"
        const val BOOKING_BUSINESS = "bookingBusiness"
    }
}