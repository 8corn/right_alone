package com.example.right.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R

class AnotherProfilePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnotherProfilePageScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnotherProfilePageScreen() {
    val pagerState = rememberPagerState(pageCount = { 4 })

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.example1),
            contentDescription = "background_example",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(R.drawable.linear_custom),
            contentDescription = "linear_custom",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> PageContent()
                1 -> PageContent1()
                2 -> PageContent2()
                3 -> PageContent3()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 70.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    repeat(4) { index ->
                        val selected = pagerState.currentPage == index
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .width(if (selected) 20.dp else 5.dp)
                                .height(4.dp)
                                .background(
                                    color = if (selected) Color.White else Color(0xB2717171),
                                    shape = RoundedCornerShape(4.dp)
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 42.dp)
                        .height(56.dp)
                        .padding(horizontal = 4.dp)
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxSize()
                            .border(0.3.dp, Color(0x33FFFFFF), RoundedCornerShape(16.dp))
                            .weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0x1FFFFFFF),
                        ),
                        onClick = {  },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.cross_circle),
                            contentDescription = "cross_circle",
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF717C)
                        ),
                        onClick = {  },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.white_heart),
                            contentDescription = "white_heart",
                            modifier = Modifier
                                .size(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PageContent() {
    val context = LocalContext.current
    val activity = context as? ComponentActivity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 110.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.back_circle_btn),
                contentDescription = "back",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    },
            )

            Icon(
                painter = painterResource(R.drawable.menu_circle_btn),
                contentDescription = "menu",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp),
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "봄날의 햇살",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "24",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(11.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.location_icon),
                    contentDescription = "location_icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(height = 16.dp, width = 13.4.dp)
                )

                Spacer(modifier = Modifier.width(7.6.dp))

                Text(
                    text = "부산시 수영구",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Character("163cm")

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "ai 외모 분석",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 6.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Character("큰 눈")
        }
    }
}

@Composable
fun PageContent1() {
    val context = LocalContext.current
    val activity = context as? ComponentActivity
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 110.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.back_circle_btn),
                contentDescription = "back",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    },
            )

            Icon(
                painter = painterResource(R.drawable.menu_circle_btn),
                contentDescription = "menu",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp),
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun PageContent2() {

}

@Composable
fun PageContent3() {

}

@Composable
fun Character(
    text: String
) {
    Surface(
        modifier = Modifier
            .background(color = Color(0x1FFFFFFF), shape = RoundedCornerShape(16.dp))
            .border(0.3.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 4.dp, vertical = 4.dp),
        color = Color.Transparent
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = Color.White,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 7.dp),
            textAlign = TextAlign.Center,
        )
    }
}