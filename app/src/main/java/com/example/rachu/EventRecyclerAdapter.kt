package com.example.rachu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rachu.databinding.EventItemRowBinding
import com.example.rachu.store.Event

class EventRecyclerAdapter(var events: List<Event>): RecyclerView.Adapter<EventRecyclerAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
//        val inflatedView = parent.inflate(R.layout.event_item_row, false)
//        return EventViewHolder(inflatedView)

        val viewInflater = LayoutInflater.from(parent.context)
        val holderEventItemBinding = EventItemRowBinding.inflate(viewInflater, parent, false)
        return EventViewHolder(holderEventItemBinding)
    }

    override fun getItemCount() = events.size

    override fun onBindViewHolder(viewHolder: EventViewHolder, position: Int) {
        val itemEvent = events[position]
//        viewHolder.bindEvent(itemEvent)
        viewHolder.setEventItem(itemEvent)
    }

//    class EventViewHolder(v: View): RecyclerView.ViewHolder(v), View.OnClickListener {
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

    data class EventViewHolder(val eventItemRowBinding: EventItemRowBinding): RecyclerView.ViewHolder(eventItemRowBinding.root) {
        fun setEventItem(event: Event) {
            eventItemRowBinding.event = event
            eventItemRowBinding.executePendingBindings()
        }
    }
}