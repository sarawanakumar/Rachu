package com.example.rachu

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rachu.databinding.EventItemRowBinding
import kotlinx.android.synthetic.main.event_item_row.view.*

class EventRecyclerAdapter(var events: List<Event>): RecyclerView.Adapter<EventRecyclerAdapter.EventHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
//        val inflatedView = parent.inflate(R.layout.event_item_row, false)
//        return EventHolder(inflatedView)

        val viewInflater = LayoutInflater.from(parent.context)
        val holderEventItemBinding = EventItemRowBinding.inflate(viewInflater, parent, false)
        return EventHolder(holderEventItemBinding)
    }

    override fun getItemCount() = events.size

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val itemEvent = events[position]
//        holder.bindEvent(itemEvent)
        holder.setEventItem(itemEvent)
    }

//    class EventHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
//        private var view: View = v
//        private var event: Event1? = null
//
//        init {
//            v.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View?) {
//            Log.d("Recycler", "CLICK!")
////            val context = itemView.context
////            val showPhotoIntent = Intent(context, PhotoActivity::class.java)
//        }
//
//        companion object  {
//            private val PHOTO_KEY = "PHOTO"
//        }
//
//        fun bindEvent(event: Event1) {
//            this.event = event
//            view.name.text = event.name
//            view.image.setImageResource(event.image)
////            Picasso.with(view.context).load(event.url).into(view.itemImage)
//            view.date.text = event.date
////            view.description.text = event.desc
//        }
//    }

    data class EventHolder(val eventItemRowBinding: EventItemRowBinding): RecyclerView.ViewHolder(eventItemRowBinding.root) {
        fun setEventItem(event: Event) {
            eventItemRowBinding.event = event
            eventItemRowBinding.executePendingBindings()
        }
    }
}