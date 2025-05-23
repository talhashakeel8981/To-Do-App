//package com.example.todoapp
//
//import android.content.Context
//import android.content.SharedPreferences
//import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
//import com.google.gson.Gson
//
//class PreferenceManager(context: Context) {
//
//    private val sharedPreferences: SharedPreferences =
//        context.getSharedPreferences("task_prefs", Context.MODE_PRIVATE)
//
//    private val gson = Gson()
//
//    fun saveTaskList(taskList: List<Task>) {
//        val json = gson.toJson(taskList)
//        sharedPreferences.edit().putString("task_list", json).apply()
//    }
//
//
//    fun loadTaskList(): List<Task> {
//        val json = sharedPreferences.getString("task_list", null)
//        return if (json != null) {
//            val type = object : TypeToken<List<Task>>() {}.type
//            gson.fromJson(json, type)
//        } else {
//            emptyList()
//        }
//    }
//}
