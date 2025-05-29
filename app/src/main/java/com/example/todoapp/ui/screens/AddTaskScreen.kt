package com.example.todoapp.ui.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar
import androidx.compose.material3.TextFieldDefaults




@Composable
fun AddTaskScreen(
    onSave: () -> Unit,
    viewModel: TaskViewModel = viewModel()
) {
    var taskTitle by remember { mutableStateOf("") }
    var dueDate by remember { mutableStateOf("") }
    var Description by remember { mutableStateOf("") }
// Inside your @Composable
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

// Set up the DatePickerDialog
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            dueDate = "$dayOfMonth/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFECEFF1))
            .padding(16.dp)
    ){
        Column(modifier = Modifier.padding(8.dp))

        {
            TextField(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                label = { Text("Enter new task") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { datePickerDialog.show() } // ✅ Now click works
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { datePickerDialog.show() }
            ) {
                TextField(
                    value = dueDate,
                    onValueChange = {},
                    label = { Text("Due Date") },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    enabled = false,
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        disabledTextColor = LocalContentColor.current,
                        disabledLabelColor = LocalContentColor.current,
                        disabledPlaceholderColor = LocalContentColor.current,
                        disabledIndicatorColor = LocalContentColor.current.copy(alpha = 0.5f)
                    )
                )
            }



            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value =Description,
                onValueChange = {Description=it},
                label = {Text("Description")},
                modifier = Modifier.fillMaxWidth()
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