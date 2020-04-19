package com.example.sampleformeetup.domain.events

import com.example.sampleformeetup.data.api.ApiClient
import com.example.sampleformeetup.domain.pojo.Event
import com.example.sampleformeetup.domain.pojo.EventList
import com.example.sampleformeetup.domain.pojo.EventResponse
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext

class EventsRepository : IEventsRepository{

    override suspend fun requestGetEvents(onResult: (isSuccess: Boolean, response: EventResponse?) -> Unit) {
        withContext(IO) {
            val client = ApiClient.makeApiService()
            val response = client.getEvent("application/json")
            if (response.isSuccessful) {
                if (response.body()?.eventList != null) {
                    onResult(true, response.body())
                } else {
                    onResult(true, null)
                }
            } else {
                onResult(false, null)
            }
        }
    }

    override suspend fun postEvent(
        eventData: Event,
        onResult: (isSuccess: Boolean, response: String?) -> Unit
    ) {
        //TODO:: make post request
    }

}