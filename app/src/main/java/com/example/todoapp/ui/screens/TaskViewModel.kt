package com.example.todoapp.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    // This list will store tasks
    var taskList = mutableStateListOf<String>()
        private set

    // Function to add a new task
    fun addTask(task: String) {
        if (task.isNotBlank()) {
            taskList.add(task)
        }
    }
}