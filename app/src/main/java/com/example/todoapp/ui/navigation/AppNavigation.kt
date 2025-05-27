package com.example.todoapp.ui.navigation

import HomeScreen
import android.app.Application
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.ui.models.TaskViewModelFactory
import com.example.todoapp.ui.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val taskViewModel: TaskViewModel = viewModel(
        factory = TaskViewModelFactory(LocalContext.current.applicationContext as Application)
    )

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                viewModel = taskViewModel,
                navigateToAddTask = {
                    navController.navigate("addTask")
                },
                navigateToDetail = { index ->
                    navController.navigate("detail/$index")
                }
            )

        }

        composable("addTask") {
            AddTaskScreen(
                viewModel = taskViewModel,
                onSave = {
                    navController.popBackStack()
                }
            )
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
        //ss isdjnsduifsd
        }
    }
}