package com.bombaysoftwares.todoapp

import android.app.Application
import com.bombaysoftwares.todoapp.redux.Store

class ThisApp : Application() {

    companion object {
        val store = Store()
    }

}