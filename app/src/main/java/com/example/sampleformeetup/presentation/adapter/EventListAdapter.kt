package com.example.sampleformeetup.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleformeetup.databinding.EventListItemBinding
import com.example.sampleformeetup.domain.pojo.Event
import com.example.sampleformeetup.presentation.adapter.viewholders.EventListViewHolder

class EventListAdapter () : RecyclerView.Adapter<EventListViewHolder>() {

    private val eventList = mutableListOf<Event>()

    fun addEvents(eventList: MutableList<Event>) {
        this.eventList.addAll(eventList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = EventListItemBinding.inflate(inflater, parent, false)
        return EventListViewHolder(dataBinding)
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        holder.bind(eventList[position])
    }

    override fun getItemCount(): Int {
        return eventList.size
    }
}