package com.example.rachu

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class EventDaoTest {

    @Rule
    @JvmField
    val rule: TestRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var eventDao: EventDao

    @Before
    fun setup() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        try {
            database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).allowMainThreadQueries().build()
        } catch (e: Exception) {
            Log.i("test", e.message)
        }

        eventDao = database.eventDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun testAddAndRetreiveData() {
        val preInsertRetrievedCats = eventDao.getAll()

        val event = Event(1,"Birthday","25-12-88", "First Brthdat", "drawables/media")
        eventDao.insertAll(event)

        val postInsertEvents = eventDao.getAll()
        val sizeDiff = postInsertEvents.size - preInsertRetrievedCats.size

        Assert.assertEquals(1, sizeDiff)
        val retreivedEvent = postInsertEvents.last()
        Assert.assertEquals(retreivedEvent.eventName, "Birthday")
    }
}