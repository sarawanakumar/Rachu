package com.example.rachu.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rachu.R
import com.example.rachu.common.inflate
import com.example.rachu.databinding.EventItemRowBinding
import com.example.rachu.store.Event
import kotlinx.android.synthetic.main.event_item_row.view.*

class EventRecyclerAdapter(var events: List<Event>) : RecyclerView.Adapter<EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
//        val viewInflater = LayoutInflater.from(parent.context)
//        val holderEventItemBinding = EventItemRowBinding.inflate(viewInflater, parent, false)
//        return EventViewHolder(holderEventItemBinding)
        val view = parent.inflate(R.layout.event_item_row, false)
        return EventViewHolder(view)
    }

    override fun getItemCount() = events.size

    override fun onBindViewHolder(viewHolder: EventViewHolder, position: Int) = viewHolder.bindEvent(events[position])
}

data class EventViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
    //private var view: View = v
    private var event: Event? = null

    fun bindEvent(event: Event) {
        this.event = event

        view.name.text = event.eventName
        view.date.text = event.eventDate
    }

    override fun onClick(v: View?) {
        print("Click the event")
        //when the view is tapped
    }
}

//data class EventViewHolder(val eventItemRowBinding: EventItemRowBinding): RecyclerView.ViewHolder(eventItemRowBinding.root), View.OnClickListener {
//    fun setEventItem(event: Event) {
//        eventItemRowBinding.event = EventViewModel(event)
//        eventItemRowBinding.executePendingBindings()
//    }
//
//    override fun onClick(v: View?) {
//        print("Click the event")
//        //when the view is tapped
//    }
//}