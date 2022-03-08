package com.example.internetspeedjcompose

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import java.io.IOException
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

object NetworkReachability {

    fun hasNetworkAvailable(context: Context): Boolean{
        // function to check if the network is available
        val service = Context.CONNECTIVITY_SERVICE
        val manager = context.getSystemService(service) as ConnectivityManager
        val network = manager.activeNetworkInfo
        Log.d("networkMonitor","hasnetwork ${network!=null} , $network")
        return (network != null)
    }

    fun  hasInternetConnected(context: Context):Boolean{
        // to check if the connection has data or not .
        if(hasNetworkAvailable(context)){
            val REACHABILITY_SERVER = "https://www.google.com"
            Log.d("hasInternetAvailable" , "IamStupid")
            try {
                Log.d("hasInternetAvailable" , "IamStupid111")
                val connection = URL(REACHABILITY_SERVER).openConnection() as HttpURLConnection
                connection.setRequestProperty("User-Agent" , "ConnectionTest")
                connection.setRequestProperty("Connection" , "close")
                connection.connectTimeout = 1000

                connection.connect()
                Log.d("hasInternetAvailable" , "${connection.responseCode}")

                Log.d("hasInternetAvailable" , "$connection  , ${connection.responseCode==200} , ${connection.responseCode}")
                return (connection.responseCode == 200)
            }catch (e: IOException){
                Log.d("hasInternetAvailable" , "Error checking internetConnection")
            }
        }else{
            Log.d("hasInternetAvailable" ,"no network available")
        }
        Log.d("hasInternetAvailable" ,"internet not available")
        return false
    }

}