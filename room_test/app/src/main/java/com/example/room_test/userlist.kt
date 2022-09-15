package com.example.room_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class userlist : AppCompatActivity() {
    lateinit var userlist : List<RoomEntity>
    lateinit var db : database.RoomDbHelper
    //lateinit var recyclerView :RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)
        db = database.RoomDbHelper(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var user  = listOf<RoomEntity>()
        GlobalScope.launch {
            user = db.getRoomDao().getAll()
            recyclerView.adapter = MyAdapter(user)
            runOnUiThread {recyclerView.layoutManager = LinearLayoutManager(this@userlist, LinearLayoutManager.VERTICAL, false)
            }
        }


    }


}