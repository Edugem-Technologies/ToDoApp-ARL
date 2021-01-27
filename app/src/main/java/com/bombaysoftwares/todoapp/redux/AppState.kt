package com.bombaysoftwares.todoapp.redux

import androidx.lifecycle.LiveData
import com.bombaysoftwares.todoapp.model.ToDoTask

data class AppState(
    val tasks: LiveData<ArrayList<ToDoTask>>,
    var isLoading: LiveData<Boolean>
)
