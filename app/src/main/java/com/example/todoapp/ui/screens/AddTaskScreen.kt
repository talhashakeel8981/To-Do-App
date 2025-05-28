package com.example.todoapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AddTaskScreen() {
//    var title by remember { mutableStateOf("") }
//    var dueDate by remember { mutableStateOf("") }
//
//    Scaffold(
//        topBar = {
//            SmallTopAppBar(title = { Text("Add New Task") })
//        }
//    ) { padding ->
//        Column(
//            modifier = Modifier
//                .padding(padding)
//                .padding(16.dp)
//                .fillMaxSize()
//        ) {
//            TextField(
//                value = title,
//                onValueChange = { title = it },
//                label = { Text("Task Title") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//            TextField(
//                value = dueDate,
//                onValueChange = {dueDate=it},
//                label={ Text("Due Date")
//                }
//            )
//            Spacer(modifier = Modifier.fillMaxWidth())
//
//            Button(onClick = {
//                // You can add logic to save the task
//            }) {
//                Text("Save Task")
//            }
//        }
//    }
//}





import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun AddTaskScreen(
    onSave: () -> Unit,
    viewModel: TaskViewModel = viewModel()
) {
    var taskTitle by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }
    var Description by remember { mutableStateOf("") }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECEFF1))
            .padding(16.dp)
    ){
        Column(modifier = Modifier.padding(16.dp))


        {
            TextField(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                label = { Text("Enter new task") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = dueDate,
                onValueChange = {dueDate=it},
                label = { Text("Due Date") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value =Description,
                onValueChange = {Description=it},
                label = {Text("Description")}
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                viewModel.addTask(taskTitle,dueDate,Description)
                onSave()
            },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save")
            }
        }
    }

}