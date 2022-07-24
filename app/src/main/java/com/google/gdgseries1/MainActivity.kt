package com.google.gdgseries1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.google.gdgseries1.ui.theme.GDGSeries1Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDGSeries1Theme {
                //TODO move this to a separate screen
                //TODO create navigation controller
                //TODO create navigation host
                //TODO move the logic to a separate class
                val viewmodel: CartViewModel = viewModel()

                 val quantity by viewmodel.quantity.observeAsState(0)
                CartItem(
                    quantity,
                    onPlus = viewmodel::increment,
                    onMinus = viewmodel::decrement
                )
            }
        }
    }
}
//TODO(1) import navigation compose dependencies
//TODO(2)  Create Details Screen
//TODO()  Create NavHost
//TODO(3)  Navigate between main and details screen
//TODO(4) pass Arguments
//TODO(5)  best practices using AppNavigation Class
//TODO(6)  state hoisting for navigation


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GDGSeries1Theme {
        var quantity by rememberSaveable {
            mutableStateOf(0)
        }
        var perfumQuantity by rememberSaveable {
            mutableStateOf(1)
        }
        Column {
            CartItem(quantity, onPlus = {
                quantity += 2
            }, onMinus = {
                quantity -= 3
            })
            CartItem(perfumQuantity, onPlus = {
                perfumQuantity += 5
            }, onMinus = {
                perfumQuantity -= 5
            })
        }

    }
}

@Composable
fun CartItem(quantity: Int, onPlus: () -> Unit, onMinus: () -> Unit) {

    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { onPlus() }) {
            Text(text = "+")
        }

        Text(text = "Qt:${quantity}", fontSize = 40.sp)

        Button(onClick = { onMinus() }) {
            Text(text = "-")
        }
    }
}
