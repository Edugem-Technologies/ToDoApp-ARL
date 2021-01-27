package com.bombaysoftwares.todoapp.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bombaysoftwares.todoapp.R
import com.bombaysoftwares.todoapp.ThisApp
import com.bombaysoftwares.todoapp.model.ToDoTask
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fabSave.setOnClickListener {
            val taskTitle = etTitle.text.toString()
            val desc = etDescription.text.toString()

            if (taskTitle.isEmpty() or desc.isEmpty()) {
                return@setOnClickListener
            }
            addTask(taskTitle, desc)
        }
    }

    private fun addTask(taskTitle: String, desc: String) {
        val newTask = ToDoTask(System.currentTimeMillis().toInt(), taskTitle, desc, false)
        ThisApp.store.reducer.addTask(newTask)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}