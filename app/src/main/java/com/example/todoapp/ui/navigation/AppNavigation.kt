package com.example.todoapp.ui.navigation

import HomeScreen
import android.app.Application
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
<<<<<<< HEAD
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.models.TaskViewModelFactory
import com.example.todoapp.ui.screens.*
=======
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.todoapp.ui.screens.AddTaskScreen
import com.example.todoapp.ui.screens.TaskViewModel
>>>>>>> e4a4e5cf9787aca519c53f50dedf6d7db162e5ac

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

<<<<<<< HEAD
    val taskViewModel: TaskViewModel = viewModel(
        factory = TaskViewModelFactory(LocalContext.current.applicationContext as Application)
    )
=======
    // ✅ Shared ViewModel
    val taskViewModel: TaskViewModel = viewModel()
>>>>>>> e4a4e5cf9787aca519c53f50dedf6d7db162e5ac

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                viewModel = taskViewModel,
                navigateToAddTask = {
                    navController.navigate("addTask")
<<<<<<< HEAD
                },
                navigateToDetail = { index ->
                    navController.navigate("detail/$index")
                }
            )

=======
                }
            )
>>>>>>> e4a4e5cf9787aca519c53f50dedf6d7db162e5ac
        }

        composable("addTask") {
            AddTaskScreen(
                viewModel = taskViewModel,
                onSave = {
                    navController.popBackStack()
                }
            )
<<<<<<< HEAD
        }

        composable("detail/{index}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("index")?.toIntOrNull()
            if (index != null && index in taskViewModel.tasks.indices) {
                DetailScreen(
                    task = taskViewModel.tasks[index],
                    onBack = {
                        navController.popBackStack()
                    }
                )
            } else {
                Text("Task not found")
            }
        //ss
=======
>>>>>>> e4a4e5cf9787aca519c53f50dedf6d7db162e5ac
        }
    }
}