package com.example.sampleformeetup.presentation.view.eventList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleformeetup.domain.events.EventsRepository
import com.example.sampleformeetup.domain.pojo.Event
import com.example.sampleformeetup.domain.pojo.EventList
import com.example.sampleformeetup.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class EventListViewModel : BaseViewModel() {

    val eventLiveList = MutableLiveData<MutableList<Event>>()

    fun getEventList () {
        CoroutineScope(Main).launch {
            dataLoading.value = true
            EventsRepository().requestGetEvents { isSuccess, response ->
                dataLoading.value = false
                if (isSuccess) {
                    eventLiveList.value = response?.eventList
                    empty.value = false
                } else {
                    empty.value = true
                }
            }
        }
    }

}