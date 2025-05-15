package com.example.todoapp


//import android.content.Context
//
//class SharedPrefHelper(context: Context) {
//    private val sharedPref = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
//
//    fun saveName(name: String) {
//        sharedPref.edit().putString("user_name", name).apply()
//    }
//
//    fun getName(): String {
//        return sharedPref.getString("user_name", "") ?: ""
//    }
//}

import android.content.Context
class SharedPrefHelper(context: Context){
    private val sharedPref=context.getSharedPreferences("talha",Context.MODE_PRIVATE)
    fun saveName(username:String)
    {
        sharedPref.edit().putString("user_name",username).apply()
    }
    fun getName():String{
        return sharedPref.getString("user_name","")?:""
    }
    fun savedesc(desc:String)
    {
        sharedPref.edit().putString("desc_ription",desc).apply()
    }
    fun getdesc():String{
        return sharedPref.getString("desc_ription","")?:""
    }

}