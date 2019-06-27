package com.example.rachu.events

import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil
import com.example.rachu.databinding.ActivityEventsBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rachu.R
import com.example.rachu.common.RachuApplication
import com.example.rachu.databinding.ContentEventsBinding
import com.example.rachu.store.AppDatabase
import com.example.rachu.store.Event
import com.example.rachu.store.EventDao

import kotlinx.android.synthetic.main.activity_events.*
import kotlinx.android.synthetic.main.content_events.*

class EventsActivity : AppCompatActivity() {
//    private lateinit var activityEventBinding: ActivityEventsBinding

    private lateinit var adapter: EventRecyclerAdapter
    private lateinit var contentEventsBinding: ContentEventsBinding
    private lateinit var appDatabase: AppDatabase
    private lateinit var eventDao: EventDao
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)
//        activityEventBinding = DataBindingUtil.setContentView(this, R.layout.activity_events)

        setSupportActionBar(toolbar)

        addEvent.setOnClickListener { view ->
//            Snackbar.make(coordinatorLayout, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
            val toast = Toast.makeText(applicationContext, "Hello Javatpoint", Toast.LENGTH_LONG)
            toast.show()
        }

//        activityEventBinding = ActivityEventsBinding.inflate(getLayoutInflater())
//        activityEventBinding = DataBindingUtil.inflate(layoutInflater, R.layout.activity_events, null, true)
//        setContentView(activityEventBinding.root)

        linearLayoutManager = LinearLayoutManager(this)
        eventRecyclerView.layoutManager = linearLayoutManager

        appDatabase = RachuApplication.database!!
        eventDao = appDatabase.eventDao()

//        createTempData()
        setupRecyclerAdapter()
    }

    override fun onResume() {
        super.onResume()

        AsyncTask.execute {
            adapter.events = eventDao.getAll()
            runOnUiThread { adapter.notifyDataSetChanged() }
        }
    }

    private fun setupRecyclerAdapter() {

        adapter = EventRecyclerAdapter(listOf())
        eventRecyclerView.adapter = adapter

//        val linearLayoutManager = LinearLayoutManager(this)
//        contentEventsBinding = activityEventBinding.contentEvents
//        contentEventsBinding.eventRecyclerView.layoutManager = linearLayoutManager
//
//        adapter = EventRecyclerAdapter(listOf())
//        contentEventsBinding.eventRecyclerView.adapter = adapter
    }

    fun createTempData() {
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