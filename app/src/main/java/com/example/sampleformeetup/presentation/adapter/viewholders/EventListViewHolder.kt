package com.example.sampleformeetup.presentation.adapter.viewholders

import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleformeetup.R
import com.example.sampleformeetup.BR
import com.example.sampleformeetup.domain.pojo.Event
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.sdk27.coroutines.onClick

class EventListViewHolder (private val dataBinding: ViewDataBinding)
    : RecyclerView.ViewHolder (dataBinding.root) {

    fun bind (item: Event) {
        dataBinding.setVariable(BR.itemData, item)
        dataBinding.executePendingBindings()

        itemView.onClick {
            itemView.findNavController().navigate(R.id.act_EventListFrag_to_EventItem)
        }
    }
}