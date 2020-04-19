package com.example.sampleformeetup.domain.pojo

data class EventResponse (val eventList: MutableList<Event>,
                          val page: Int) {
}