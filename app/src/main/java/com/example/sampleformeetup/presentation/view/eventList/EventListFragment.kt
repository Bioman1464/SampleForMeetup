package com.example.sampleformeetup.presentation.view.eventList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sampleformeetup.R
import com.example.sampleformeetup.databinding.FragmentEventListBinding
import com.example.sampleformeetup.presentation.adapter.EventListAdapter
import kotlinx.android.synthetic.main.fragment_event_list.*
import org.jetbrains.anko.longToast

class EventListFragment : Fragment(), IEventListFragment {

    private lateinit var viewDataBinding: FragmentEventListBinding
    private lateinit var adapter: EventListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentEventListBinding.inflate(inflater, container, false).apply {
            viewmodel = ViewModelProviders.of(this@EventListFragment).get(EventListViewModel::class.java)
            setLifecycleOwner (viewLifecycleOwner)
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.getEventList()

        configRecycler()
        configObservers()
    }

    override fun configObservers() {
        viewDataBinding.viewmodel?.eventLiveList?.observe(viewLifecycleOwner, Observer {
            adapter.addEvents(it)
        })

        viewDataBinding.viewmodel?.toastMessage?.observe(viewLifecycleOwner, Observer {
            activity?.longToast(it)
        })
    }

    override fun configRecycler() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = EventListAdapter()
            val layoutManager = LinearLayoutManager(activity)
            event_list_rv.layoutManager = layoutManager
            event_list_rv.addItemDecoration(DividerItemDecoration(activity, layoutManager.orientation))
            event_list_rv.adapter = adapter
        }
    }
}
