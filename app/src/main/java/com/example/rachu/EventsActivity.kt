package com.example.rachu

import android.os.AsyncTask
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil
import com.example.rachu.databinding.ActivityEventsBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rachu.databinding.ContentEventsBinding
import com.example.rachu.store.AppDatabase
import com.example.rachu.store.Event
import com.example.rachu.store.EventDao

import kotlinx.android.synthetic.main.activity_events.*

class EventsActivity : AppCompatActivity() {

//    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: EventRecyclerAdapter

    private lateinit var contentEventsBinding: ContentEventsBinding
    private lateinit var appDatabase: AppDatabase
    private lateinit var eventDao: EventDao

    private lateinit var activityEventBinding: ActivityEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        activityEventBinding = DataBindingUtil.setContentView(this, R.layout.activity_events)

//        linearLayoutManager = LinearLayoutManager(this)
//        eventRecyclerView.layoutManager = linearLayoutManager
//
//        adapter = EventRecyclerAdapter(arrayListOf(p1, p2, p3))
//        eventRecyclerView.adapter = adapter

        appDatabase = RachuApplication.database!!
        eventDao = appDatabase.eventDao()

        setupRecyclerAdapter()

        //somef()
    }

    override fun onResume() {
        super.onResume()

        AsyncTask.execute {
            adapter.events = eventDao.getAll()
            runOnUiThread { adapter.notifyDataSetChanged() }
        }
    }

    private fun setupRecyclerAdapter() {
        val linearLayoutManager = LinearLayoutManager(this)
        contentEventsBinding = activityEventBinding.contentEvents
        contentEventsBinding.eventRecyclerView.layoutManager = linearLayoutManager

        adapter = EventRecyclerAdapter(listOf())
        contentEventsBinding.eventRecyclerView.adapter = adapter
    }

    fun somef() {
        val p1 = Event(0, "Birthday", "31-12-2018", "Landing on earth", "drawable")
        val p2 = Event(0, "Vaccine 1", "14-02-2019", "First Vaccination", "drawable")
        val p3 = Event(0, "Vaccine 2", "31-03-2019", "Second Vaccination", "drawable")

        AsyncTask.execute {
            eventDao.insertAll(p1)
            eventDao.insertAll(p2)
            eventDao.insertAll(p3)

            adapter.events = eventDao.getAll()

            runOnUiThread { adapter.notifyDataSetChanged() }
        }
    }
}


class Event1(val image: Int, val date: String, val name: String)