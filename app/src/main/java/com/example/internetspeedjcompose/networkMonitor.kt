package com.example.internetspeedjcompose

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.compose.material.contentColorFor
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

//fun hasNetworkAvailable(context: Context): Boolean{
//    // function to check if the network is available
//    val service = Context.CONNECTIVITY_SERVICE
//    val manager = context.getSystemService(service) as ConnectivityManager
//    val network = manager.activeNetworkInfo
//    Log.d("networkMonitor","hasnetwork ${network!=null} , $network")
//    return (network!=null)
//}
//
//fun  hasInternetConnected(context: Context):Boolean{
//
//    if(hasNetworkAvailable(context)){
//        try {
//            val connection = URL(REACHABILITY_SERVER).openConnection() as HttpURLConnection
//            connection.setRequestProperty("User_Agent" , "ConnectionTest")
//            connection.setRequestProperty("Connection" , "close")
//            connection.connectTimeout = 1000
//            connection.connect()
//            Log.d("hasInternetAvailable" , "$connection  , ${connection.responseCode==200} , ${connection.responseCode}")
//            return (connection.responseCode == 200)
//        }catch (e: Exception){
//            Log.d("hasInternetNetwork" , "Error checking internetConnection")
//        }
//    }else{
//        Log.d("hasInternetAvailable" ,"no network available")
//    }
//    Log.d("hasInternetAvailable" ,"internet not available")
//    return false
//}