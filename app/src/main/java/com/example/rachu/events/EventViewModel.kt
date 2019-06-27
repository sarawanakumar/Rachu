package com.example.rachu.events

import com.example.rachu.store.Event

data class EventViewModel(val event: Event = Event(0, "name", "01-01-1970", "Description", "none")) {
    fun getEventName() = event.eventName

    fun getEventDate() = event.eventDate

    fun getMedia() = event.media
}