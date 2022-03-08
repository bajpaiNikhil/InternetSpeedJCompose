package com.example.internetspeedjcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.example.internetspeedjcompose.ui.theme.InternetSpeedJComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPython()

        setContent {
            InternetSpeedJComposeTheme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var value by remember { mutableStateOf(0) }

                    CustomUiComponent(indicatorValue = value)
                    TextField(value = value.toString()
                        , onValueChange = {
                            value = if(it.isNotEmpty()){
                                it.toInt()
                            }else{
                                0
                            }
                        } ,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number
                        )
                    )
                }
                val b = pythonHolder()
                Log.d("mainActivity" , b)
                val loader = Thread{
                    when{
                        NetworkReachability.hasInternetConnected(this)->runOnUiThread{
                            Log.d("mainActivity" ,"internetAvailable")
                        }else->{
                            Log.d("mainActivity" , "no internet")
                        }
                    }
                }
                loader.start()
            }
        }
    }

    private fun pythonHolder(): String {
        val python = Python.getInstance()
        val pythonFile = python.getModule("FirstPythonScript")
        val c = pythonFile.callAttr("pythonFunctionIs").toString()
        Log.d("mainActivity" , c)
        return pythonFile.callAttr("pythonFunctionIs").toString()

    }

    private fun initPython() {
        if(!Python.isStarted()){
            Python.start(AndroidPlatform(this))
        }
    }

}

