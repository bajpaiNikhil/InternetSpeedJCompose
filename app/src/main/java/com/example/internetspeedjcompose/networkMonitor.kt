package com.example.internetspeedjcompose

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log


fun hasNetwork(context: Context): Boolean{

    val service = Context.CONNECTIVITY_SERVICE
    val manager = context.getSystemService(service) as ConnectivityManager
    val network = manager.activeNetworkInfo
    Log.d("networkMonitor","hasnetwork ${network!=null} , $network")
    return (network!=null)

}