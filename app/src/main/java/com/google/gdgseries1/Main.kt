package com.google.gdgseries1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(goToDetails: (quantity: Int) -> Unit) {
    val viewmodel: CartViewModel = viewModel()

    val quantity by viewmodel.quantity.observeAsState(0)
    MainContent(
        quantity,
        onPlus = viewmodel::increment,
        onMinus = viewmodel::decrement,goToDetails
    )

}

@Composable
fun MainContent(quantity: Int, onPlus: () -> Unit, onMinus: () -> Unit,goToDetails: (quantity: Int) -> Unit) {
    Column {
        CartItem(
            quantity,
            onPlus = onPlus,
            onMinus = onMinus
        )
        Button(onClick = { goToDetails.invoke(quantity) }) {
            Text(text = "Checkout")
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

@Preview
@Composable
fun PrevuewMain() {
    MainContent(10, {}, {},{})
}