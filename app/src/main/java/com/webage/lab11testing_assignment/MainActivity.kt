package com.webage.lab11testing_assignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.webage.lab11testing_assignment.ui.theme.Lab11TestingAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab11TestingAssignmentTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Testing()
                }
            }
        }
    }
}

@Composable
fun Testing( vm :AdditionViewModel = AdditionViewModel() ) {

    var a by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }
    var c by remember { mutableStateOf("") }

    Row(
        modifier = Modifier.padding(10.dp)
    ) {

        OutlinedTextField(
            value = a.toString(),
            onValueChange = { a = it },
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )

        OutlinedTextField(
            value = b.toString(),
            onValueChange = { b = it },
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )

        Button(
            onClick = { c = vm.add(a.toInt(),b.toInt()).toString() },
            modifier = Modifier
                .width(100.dp)
                .padding(10.dp)
        ) {Text("ADD")}

        OutlinedTextField(
            value = c.toString(),
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )

    }
}

class AdditionViewModel : ViewModel() {

    fun add( a :Int, b :Int ) : Int { return a + b }

}