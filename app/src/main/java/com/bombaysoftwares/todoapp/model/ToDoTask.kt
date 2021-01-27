package com.bombaysoftwares.todoapp.model

data class ToDoTask(
    val id:Int,
    val title:String,
    val description:String,
    var isCompleted:Boolean
)
