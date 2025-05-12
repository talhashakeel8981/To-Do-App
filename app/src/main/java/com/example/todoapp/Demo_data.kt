package com.example.todoapp

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun FirstExampleDateStore() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // Observe saved value
    val darkModeFlow = ThemeDataStore.getDarkMode(context)
    val isDarkMode = darkModeFlow.collectAsState(initial = false)

    // UI
    TodoAppTheme(darkTheme = isDarkMode.value) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("Current Mode: ${if (isDarkMode.value) "Dark" else "Light"}")
                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    scope.launch {
                        ThemeDataStore.saveDarkMode(context, !isDarkMode.value)
                    }
                }) {
                    Text("Toggle Theme")
                }
            }
        }
    }
}
