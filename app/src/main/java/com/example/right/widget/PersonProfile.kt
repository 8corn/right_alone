package com.example.right.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R

@Composable
fun PersonProfile(
    modifier: Modifier = Modifier,
    image: Int,
    aka: String,
    age: Int,
    location: String,
    percent: Int,
    lastDay: Int
) {
    Surface (
        modifier = modifier
            .height(192.dp)
            .padding(horizontal = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            Image(
                painter = painterResource(R.drawable.linear_custom),
                contentDescription = "linear",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = "${age}세, $location",
                    fontSize = 12.sp,
                    color = Color.White
                )

                Text(
                    text = aka,
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(
                text = "${percent}%",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 14.dp, bottom = 9.dp)
            )

            Image(
                painter = painterResource(R.drawable.lastday_back),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            )

            Text(
                text = "D-$lastDay",
                fontSize = 12.sp,
                color = Color.Red,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 5.dp)
                    .align(Alignment.TopEnd)
            )
        }
    }
}

data class Person(val image: Int, val aka: String, val age: Int, val location: String, val percent: Int, val lastDay: Int)