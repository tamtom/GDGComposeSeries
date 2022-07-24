package com.google.gdgseries1

sealed class Screen(val route:String){
    object Main : Screen("Main")
    object Details:Screen("Details")

}
