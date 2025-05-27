package com.example.todoapp.ui.screens

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.ui.models.Task
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs: SharedPreferences =
        application.getSharedPreferences("task_prefs", Context.MODE_PRIVATE)

    val tasks = mutableStateListOf<Task>()

    init {
        loadTasks() // Load when ViewModel starts
    }

    fun addTask(taskTitle: String, dueDate: String, Description: String) {
        if (taskTitle.isNotBlank()) {
            tasks.add(Task(taskTitle, dueDate, Description))
            saveTasks()
        }
    }

    private fun saveTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            val json = Gson().toJson(tasks)
            prefs.edit().putString("tasks_json", json).apply()
        }
    }

    private fun loadTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            val json = prefs.getString("tasks_json", null)
            if (!json.isNullOrEmpty()) {
                val type = object : TypeToken<List<Task>>() {}.type
                val loadedTasks: List<Task> = Gson().fromJson(json, type)
                tasks.addAll(loadedTasks)
            }
        }
    }
}
