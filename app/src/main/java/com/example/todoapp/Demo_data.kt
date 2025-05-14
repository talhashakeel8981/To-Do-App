package com.example.todoapp

import android.content.Context
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

//@Composable
//fun FirstExampleDateStore() {
//    val context = LocalContext.current
//    val scope = rememberCoroutineScope()
//
//    // Observe saved value
//    val darkModeFlow = ThemeDataStore.getDarkMode(context)
//    val isDarkMode = darkModeFlow.collectAsState(initial = false)
//
//    // UI
//    TodoAppTheme(darkTheme = isDarkMode.value) {
//        Surface(modifier = Modifier.fillMaxSize()) {
//            Column(modifier = Modifier.padding(24.dp)) {
//                Text("Current Mode: ${if (isDarkMode.value) "Dark" else "Light"}")
//                Spacer(modifier = Modifier.height(20.dp))
//
//                Button(onClick = {
//                    scope.launch {
//                        ThemeDataStore.saveDarkMode(context, !isDarkMode.value)
//                    }
//                }) {
//                    Text("Toggle Theme")
//                }
//            }
//        }
//    }
//}

@Composable
fun SharedPreferenceExample(context: Context) {
    val helper = remember { SharedPrefHelper(context) }

    var name by remember { mutableStateOf("") }
    var savedName by remember { mutableStateOf(helper.getName()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            helper.saveName(name)
            savedName = helper.getName()
        }) {
            Text("Save Name")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Saved Name: $savedName")
    }
}

//@Composable
//fun SharedPreferenceExamplePractise(context: Context)
//{
//    val hel= remember { SharedPrefHelper(context) }
//    var username= remember { mutableStateOf("") }
//    var savedName by remember { mutableStateOf(hel.getName()) }
//    Column (
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center
//    )
//    {
//        TextField(
//            value = username.value,
//            onValueChange = {username.value=it},
//            label={ Text("enter your name") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//    Button(onClick = {
//        hel.saveName(username.value)
//        savedName=hel.getName()
//    }) {
//        Text("Save Name")
//    }
//        Spacer(modifier = Modifier.height(16.dp))
//        Text("Saved name=$savedName")
//    }
//}