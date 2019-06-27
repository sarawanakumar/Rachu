package com.example.rachu

import android.os.AsyncTask
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rachu.common.RachuApplication
import com.example.rachu.databinding.ActivityEventsBinding
import com.example.rachu.databinding.ActivityTestBinding
import com.example.rachu.databinding.ContentEventsBinding
import com.example.rachu.databinding.ContentTestBinding
import com.example.rachu.events.EventRecyclerAdapter
import com.example.rachu.store.AppDatabase
import com.example.rachu.store.EventDao

import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {
    private lateinit var activityEventBinding: ActivityTestBinding

    private lateinit var adapter: EventRecyclerAdapter
    private lateinit var contentEventsBinding: ContentTestBinding
    private lateinit var appDatabase: AppDatabase
    private lateinit var eventDao: EventDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        //activityEventBinding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        activityEventBinding = ActivityTestBinding.inflate(getLayoutInflater())

        appDatabase = RachuApplication.database!!
        eventDao = appDatabase.eventDao()

//        setupRecyclerAdapter()
    }

//        override fun onResume() {
//        super.onResume()
//
//        AsyncTask.execute {
//            adapter.events = eventDao.getAll()
//            runOnUiThread { adapter.notifyDataSetChanged() }
//        }
//    }

//    private fun setupRecyclerAdapter() {
//        val linearLayoutManager = LinearLayoutManager(this)
//        contentEventsBinding = activityEventBinding
//        contentEventsBinding.eventRecyclerView.layoutManager = linearLayoutManager
//
//        adapter = EventRecyclerAdapter(listOf())
//        contentEventsBinding.eventRecyclerView.adapter = adapter
//    }
}
