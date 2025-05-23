package com.example.taskapp.ui.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.todoapp.ui.screens.AddTaskScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navigateToAddTask = {
                navController.navigate("addTask")
            })
        }
        composable("addTask") {
            AddTaskScreen(onSave = {
                navController.popBackStack()
            })
        }
    }
}