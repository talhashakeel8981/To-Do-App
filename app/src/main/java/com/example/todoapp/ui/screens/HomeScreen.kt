import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.navOptions
import com.example.todoapp.ui.screens.TaskViewModel

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(navigateToAddTask: () -> Unit) {
//    val tasks = listOf("Buy groceries", "Finish project", "Call mom", "Read book")
//
//    Scaffold(
//        topBar = {
//            SmallTopAppBar(
//                title = { Text("To-Do List") },
//                colors = TopAppBarDefaults.smallTopAppBarColors()
//            )
//        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = navigateToAddTask) {
//                Text("+")
//            }
//        }
//    ) { paddingValues ->
//        LazyColumn(
//            contentPadding = paddingValues,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            items(tasks) { task ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp)
//                ) {
//                    Text(
//                        text = task,
//                        modifier = Modifier.padding(16.dp)
//                    )
//                }
//            }
//        }
//    }
//}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToAddTask: () -> Unit,
    navigateToDetail: (Int) -> Unit,
    viewModel: TaskViewModel = viewModel()
) {
    val tasks = viewModel.tasks

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("To-Do List") },
                colors = TopAppBarDefaults.smallTopAppBarColors()
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToAddTask) {
                Text("+")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            // Use itemsIndexed to get the index of each task
            itemsIndexed(tasks) { index, task ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        // Make the whole card clickable to navigate to detail screen
                        .clickable {
                            navigateToDetail(index)
                        }
                ) {
                    Text(
                        text = task.taskTitle,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}
