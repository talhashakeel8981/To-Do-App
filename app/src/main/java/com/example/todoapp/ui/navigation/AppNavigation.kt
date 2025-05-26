package com.example.taskapp.ui.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.todoapp.ui.screens.AddTaskScreen
import com.example.todoapp.ui.screens.TaskViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // ✅ Shared ViewModel
    val taskViewModel: TaskViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                viewModel = taskViewModel,
                navigateToAddTask = {
                    navController.navigate("addTask")
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
    }
}