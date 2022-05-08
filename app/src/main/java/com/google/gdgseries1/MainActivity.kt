package com.google.gdgseries1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gdgseries1.ui.theme.GDGSeries1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GDGSeries1Theme {



            }
        }
    }
}


/**
 *
 *
 *  1-show how to  place composable in either rows or column
Garage cars Example:
2- show the Horizontal Alignment

3-show the default size of the composable ( add a background)

4-show the vertical arrangement

5-Modifier explenation

6-explore more methods

7-padding

8-offset

9-Spacer

10-Modifier sequential action by border and padding

11-Card Sample
//https://developer.android.com/codelabs/jetpack-compose-layouts#2
 */


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GDGSeries1Theme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, Color.Green)
                .padding(16.dp)
                .border(2.dp, Color.Red)
                .padding(16.dp)
                .border(4.dp, Color.Blue)

        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_leo), contentDescription = "leonardo",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(100.dp)
                        .clip(CircleShape)

                )
                Column() {
                    Text(text = "leonardo Dav", fontSize = 24.sp, fontWeight = Bold)
                    Text(text = "500 years ago")
                }

            }
            val current = LocalContext.current
            Card(modifier = Modifier
                .align(CenterHorizontally)
                .clickable {
                    Toast
                        .makeText(current, "Clicked", Toast.LENGTH_LONG)
                        .show()
                }) {
                Image(painter = painterResource(id = R.drawable.ic_work), contentDescription = "mona lisa")
            }
        }
    }
}


@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.ic_leo),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author)
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}

data class Message(val author: String, val body: String)