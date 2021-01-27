package com.bombaysoftwares.todoapp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bombaysoftwares.todoapp.R
import com.bombaysoftwares.todoapp.ThisApp
import com.bombaysoftwares.todoapp.model.ToDoTask
import kotlinx.android.synthetic.main.task_item_layout.view.*


class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(View.inflate(parent.context, R.layout.task_item_layout, null))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = ThisApp.store.state.tasks.value!![position]
        holder.bind(task,position)
    }

    override fun getItemCount(): Int {
        return ThisApp.store.state.tasks.value!!.size
    }
}

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(task: ToDoTask, position: Int) {
        itemView.taskTitleTV.text = task.title
        itemView.taskDescTV.text = task.description
        itemView.taskCheck.isChecked = task.isCompleted

        itemView.alpha = if (task.isCompleted) 0.5f else 1f

        itemView.taskCheck.setOnClickListener {
            ThisApp.store.reducer.updateTask(position,!task.isCompleted)
        }

        itemView.deleteTaskBtn.setOnClickListener {
            ThisApp.store.reducer.deleteTask(task)
        }
    }
}