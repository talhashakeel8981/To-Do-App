package com.example.todoapp.ui.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    // ✅ First define tasks
    private val tasks = mutableStateListOf<String>()

    // ✅ Then expose it as taskList
    val taskList = tasks

    // Function to add task
    fun addTask(task: String) {
        if (task.isNotBlank()) {
            tasks.add(task)
        }
    }
}