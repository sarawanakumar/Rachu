package com.example.rachu

import com.example.rachu.store.Event

data class EventViewModel(val event: Event = Event(0, "", "", "", "")) {
    fun getEventName() = event.eventName

    fun getEventDate() = event.eventDate

    fun getMedia() = event.media
}