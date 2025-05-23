package com.example.todoapp.model

data class Task(
    val id: String,
    val title: String,
    val dueDate: String,
    val description: String,
    var isDone: Boolean = false
)