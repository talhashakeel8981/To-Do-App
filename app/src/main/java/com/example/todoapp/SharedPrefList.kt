package com.example.todoapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun TaskApp() {
    val context = LocalContext.current
    val prefManager = remember { PreferenceManager(context) }

    val taskList = remember { mutableStateListOf<Task>() }

    // 🔸 NEW STATE for name input
    var newTaskName by remember { mutableStateOf("") }

    // EXISTING STATE
    var newTaskTitle by remember { mutableStateOf("") }

    // Load saved tasks
    LaunchedEffect(Unit) {
        val savedTasks = prefManager.loadTaskList()
        taskList.clear()
        taskList.addAll(savedTasks)
    }

    Column(modifier = Modifier.padding(16.dp)) {

        // 🔸 NEW: Name TextField
        TextField(
            value = newTaskName,
            onValueChange = { newTaskName = it },
            label = { Text("Enter Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // EXISTING: Title TextField
        TextField(
            value = newTaskTitle,
            onValueChange = { newTaskTitle = it },
            label = { Text("Enter Task") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (newTaskName.isNotBlank() && newTaskTitle.isNotBlank()) {
                // 🔸 NEW: Create Task with name
                val newTask = Task(newTaskName, newTaskTitle, false)
                taskList.add(newTask)
                prefManager.saveTaskList(taskList)
                newTaskName = ""
                newTaskTitle = ""
            }
        }) {
            Text("Add Task")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Task List:")

        LazyColumn {
            items(taskList) { task ->
                // 🔸 UPDATED DISPLAY
                Text("• ${task.name}")
                Text("• ${task.title}")
            }
        }
    }
}
