package com.example.todoapp

import android.content.Context
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var savedesc by remember { mutableStateOf(helper.getdesc()) }
    var desc by remember { mutableStateOf(helper.getName()) }
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

        TextField(
            value = desc,
            onValueChange = {desc=it},
            label={ Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            helper.saveName(name)
            savedName = helper.getName()
            helper.savedesc(desc)
            savedesc=helper.getdesc()
        }) {
            Text("Save Name")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Saved Name: $savedName")
        Text("Desc=$savedesc")


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

//items(fruits) { fruit ->
//    Text(
//        text = fruit,
//        fontSize = 20.sp,
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//    )
//}
//}
//}
@Composable
fun LazyCol()
{
    val fruits= listOf("Apple","Banana","Orange")
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        items(fruits) { fruit ->
            Text(
                text = fruit,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}




@Composable
fun TasksListUsingLazyColumn()
{
    val taskslist= remember { mutableStateListOf<String>() }
    var inputTask by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ){
        TextField(
            value = inputTask,
            onValueChange = {inputTask=it},
            label = { Text("Enter The Task") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (inputTask.isNotBlank())
            {
                taskslist.add(inputTask)
                inputTask=""
            }
        }) {
            Text("Add Task")
        }
        LazyColumn {
            items(taskslist){task ->
                Text(
                    text = task,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )

            }
        }
    }
}

@Preview (showBackground = true)
@Composable fun PreviewTasksListUsingLazyColumn()
{
    TasksListUsingLazyColumn()
}