package com.example.todoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.models.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    task: Task,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {

            SmallTopAppBar(
                title = { Text("Task Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },

            )

        },
        containerColor = Color(0xFFECEFF1)


    )

    { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(text = "Title: ${task.taskTitle}", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Due Date: ${task.dueDate}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description: ${task.Description}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
