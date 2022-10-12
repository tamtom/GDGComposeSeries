package com.google.gdgseries1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(goToDetails: (quantity: Int) -> Unit) {
    val viewmodel: CartViewModel = viewModel()

    val quantity by viewmodel.quantity.observeAsState(0)
    val loading by viewmodel.loading.observeAsState(false)
    MainContent(
        quantity,
        onPlus = viewmodel::increment,
        onMinus = viewmodel::decrement,
        showHideLoader = viewmodel::loading,
        loading,
        goToDetails
    )

}

@Composable
fun MainContent(
    quantity: Int,
    onPlus: () -> Unit,
    onMinus: () -> Unit,
    showHideLoader: (Boolean) -> Unit,
    showLoader: Boolean,
    goToDetails: (quantity: Int) -> Unit
) {
    val scope = rememberCoroutineScope()

    Column {
        CartItem(
            quantity,
            onPlus = onPlus,
            onMinus = onMinus
        )
        Button(onClick = {
            showHideLoader.invoke(true)
            scope.launch {
                delay(5000)
                goToDetails.invoke(quantity)

            }


        }, Modifier.testTag(CHECKOUT)) {
            Text(text = "Checkout")
        }
        var text by remember { mutableStateOf("") }
        if (showLoader)
            CircularProgressIndicator()

    }

}

@Composable
fun CartItem(quantity: Int, onPlus: () -> Unit, onMinus: () -> Unit) {

    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = { onPlus() }, modifier = Modifier.testTag(PLUS_BUTTON)) {
            Text(text = "+")
        }

        Text(text = "Qt:${quantity}", fontSize = 40.sp, modifier = Modifier.testTag(QUANTITY))

        Button(onClick = { onMinus() }, modifier = Modifier.testTag(MINUS_BUTTON)) {
            Text(text = "-")
        }
    }
}

@Preview
@Composable
fun PrevuewMain() {
    MainContent(10, {}, {}, {}, false, {})
}

const val PLUS_BUTTON = "plusButton"
const val QUANTITY = "quantity"
const val MINUS_BUTTON = "minusButton"
const val CHECKOUT = "checkout"