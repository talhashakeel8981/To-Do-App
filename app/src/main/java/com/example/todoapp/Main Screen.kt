//package com.example.todoapp
//
//import android.net.Uri
//import android.widget.DatePicker
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material3.Button
//import androidx.compose.material3.Divider
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.Icon
//import androidx.compose.material3.*
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import java.util.Calendar
//import android.app.DatePickerDialog
//import androidx.benchmark.perfetto.Row
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.runtime.*
//
//
//
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.launch
//import androidx.datastore.preferences.core.edit
//
//
//
//
//
//@Composable
//fun HomeScreen(navController: NavController, tasks: List<Task>) {
//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(onClick = { navController.navigate("add") }) {
//                Icon(Icons.Default.Add, contentDescription = "Add Task")
//            }
//        }
//    ) { paddingValues ->
//        Column(modifier = Modifier
//            .padding(paddingValues)
//            .padding(16.dp)) {
//
//            Text("🏠 Home Screen", style = MaterialTheme.typography.titleLarge)
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            if (tasks.isEmpty()) {
//                Text("No tasks added yet.")
//            } else {
//                LazyColumn {
//                    items(tasks.size) { index ->
//                        val task = tasks[index]
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable {
//                                    navController.navigate("detail/${Uri.encode(task.title)}/${Uri.encode(task.description)}")
//                                }
//                                .padding(8.dp)
//                        ) {
//                            Text(task.title, style = MaterialTheme.typography.titleMedium)
//                            Text(task.description, style = MaterialTheme.typography.bodySmall)
//                        }
//                        Divider()
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun AddTaskScreen(navController: NavController, onSave: (String, String) -> Unit) {
//    var title by remember { mutableStateOf("") }
//    var desc by remember { mutableStateOf("") }
//
//    Column(modifier = Modifier
//        .padding(16.dp)
//        .fillMaxWidth()
//    ) {
//        Text(text = "➕ Add Task", style = MaterialTheme.typography.titleLarge)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        TextField(
//            value = title,
//            onValueChange = { title = it },
//            label = { Text("Title") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        val context = LocalContext.current
//        val calendar = Calendar.getInstance()
//
//        var dateText by remember { mutableStateOf("") }
//
//        // Date picker dialog
//        val datePickerDialog = remember {
//            DatePickerDialog(
//                context,
//                { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
//                    dateText = "%02d/%02d/%04d".format(dayOfMonth, month + 1, year)
//                },
//                calendar.get(Calendar.YEAR),
//                calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH)
//            )
//        }
//
//        OutlinedTextField(
//            value = dateText,
//            onValueChange = { dateText = it }, // Allow manual editing
//            label = { Text("Date") },
//            trailingIcon= {
//                IconButton(onClick = {
//                    datePickerDialog.show()
//                }) {
//                    Icon(
//                        imageVector = Icons.Default.DateRange,
//                        contentDescription = "Pick Date",
//                        tint = Color.Gray
//                    )
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        )
//        Spacer(modifier = Modifier.padding(16.dp))
//
//        TextField(
//            value = desc,
//            onValueChange = { desc = it },
//            label = { Text("Description") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                if (title.isNotBlank() && desc.isNotBlank()) {
//                    onSave(title, desc)
//                }
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Save Task")
//        }
//    }
//}
//
//@Composable
//fun DetailScreen(navController: NavController, title: String?, description: String?) {
//    Column(modifier = Modifier
//        .padding(16.dp)
//        .fillMaxWidth()
//    ) {
//        Text(text = "📋 Task Detail", style = MaterialTheme.typography.titleLarge)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text("Title: ${title ?: "N/A"}")
//        Spacer(modifier = Modifier.height(8.dp))
//
//        Text("Description: ${description ?: "N/A"}")
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Button(onClick = { navController.popBackStack() }) {
//            Text("Go Back")
//        }
//    }
//}
//
//
//
//
