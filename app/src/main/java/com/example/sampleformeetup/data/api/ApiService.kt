package com.example.sampleformeetup.data.api

import com.example.sampleformeetup.domain.pojo.EventList
import com.example.sampleformeetup.domain.pojo.EventResponse
import retrofit2.Response
import retrofit2.http.Field

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @GET("api/events")
    suspend fun getEvent(
        @Header("Accept") accept: String
    ): Response<EventResponse>

    @POST("api/events")
    suspend fun postEvent(
        @Field("eventTitle") eventTitle: String = ""
    ): Response<EventList>
}