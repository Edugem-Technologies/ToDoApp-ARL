package com.bombaysoftwares.todoapp.redux

import androidx.lifecycle.MutableLiveData
import com.bombaysoftwares.todoapp.model.ToDoTask

class Reducer(private val state: AppState) {

    fun addTask(task: ToDoTask) {
        val taskList = state.tasks.value!!
        taskList.add(task)

        // If you are working on Main thread you can use #setValue(),
        // for background thread use #postValue()
        (state.tasks as MutableLiveData).postValue(taskList)
    }

    fun deleteTask(task: ToDoTask): Unit {
        val taskList = state.tasks.value!!
        taskList.remove(task)
        (state.tasks as MutableLiveData).postValue(taskList)
    }

    fun updateTask(index: Int, isChecked: Boolean): Unit {
        val taskList = state.tasks.value!!
        taskList[index].isCompleted = isChecked
        (state.tasks as MutableLiveData).postValue(taskList)
    }

}