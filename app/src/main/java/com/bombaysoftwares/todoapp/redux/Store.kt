package com.bombaysoftwares.todoapp.redux

import androidx.lifecycle.MutableLiveData

class Store {
    var state: AppState
    var reducer: Reducer

    init {
        // Initial state
        state = AppState(
            MutableLiveData(ArrayList()),
            MutableLiveData(false)
        )
        reducer = Reducer(state)
    }
}
