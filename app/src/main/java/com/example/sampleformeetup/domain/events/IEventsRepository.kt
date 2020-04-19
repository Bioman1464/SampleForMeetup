package com.example.sampleformeetup.domain.events

import com.example.sampleformeetup.domain.pojo.Event
import com.example.sampleformeetup.domain.pojo.EventList
import com.example.sampleformeetup.domain.pojo.EventResponse

interface IEventsRepository {

    suspend fun requestGetEvents(onResult: (isSuccess: Boolean, response: EventResponse?) -> Unit) {}
    suspend fun postEvent(eventData: Event, onResult: (isSuccess: Boolean, response: String?) -> Unit ) {}

}