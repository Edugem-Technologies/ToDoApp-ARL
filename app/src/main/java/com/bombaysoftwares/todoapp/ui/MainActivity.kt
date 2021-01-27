package com.bombaysoftwares.todoapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import com.bombaysoftwares.todoapp.R
import com.bombaysoftwares.todoapp.ThisApp
import com.bombaysoftwares.todoapp.adapter.TaskAdapter
import com.bombaysoftwares.todoapp.model.ToDoTask
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    val taskAdapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            startActivity(Intent(this, AddTaskActivity::class.java))
        }

        taskListRV.itemAnimator = DefaultItemAnimator()
        taskListRV.adapter = taskAdapter
        for (i in 1..200){
            ThisApp.store.reducer.addTask(ToDoTask(System.currentTimeMillis().toInt(),"Task #$i","Desc",false))
        }
        ThisApp.store.state.tasks.observe(this) {
            taskAdapter.notifyDataSetChanged()
            if (it.size == 0) emptyView.visibility = View.VISIBLE
            else emptyView.visibility = View.GONE
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        ThisApp.store.state.tasks.removeObservers(this)
    }
}