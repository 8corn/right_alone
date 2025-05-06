package com.example.right.login_join

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.MainActivity
import com.example.right.R
import com.example.right.widget.AnimatedProgressBar
import kotlinx.coroutines.delay

class Introduce : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroduceScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IntroduceScreen() {
    val content = LocalContext.current
    val activity = content as? ComponentActivity

    val (introduce, setIntroduce) = remember { mutableStateOf("") }

    val selectedIntroduce by remember { mutableStateOf(listOf<String>()) }
    var showSnackbar by remember { mutableStateOf(false) }

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            delay(3000)
            showSnackbar = false
        }
    }

    Surface (
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 36.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.back_arrow),
                contentDescription = "back",
                modifier = Modifier
                    .padding(start = 10.dp, top = 57.dp)
                    .size(size = 26.dp)
                    .clickable {
                        activity?.onBackPressedDispatcher?.onBackPressed()
                    }
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                color = Color(0x4DCDCDCD),
                thickness = 1.dp,
            )

            AnimatedProgressBar(currentStep = 10)

            Text(
                text = "당신에 대해 소개해주세요",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "상대방에게 당신에 대해 더 알리고 싶은 정보를\n입력해주세요. 혹은 간단한 인삿말도 좋아요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(32.dp))

            TextField(
                value = introduce,
                onValueChange = setIntroduce,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(172.dp)
                    .padding(horizontal = 16.dp)
                    .border(1.dp, Color(0xFFCDCDCD), RoundedCornerShape(8.dp)),
                placeholder = {
                    Text(
                        text = "예) 안녕하세요! 마음이 맞고 친구 같은 연애가 좋아\n요. 같이 카페 가서 책 읽으실 분?",
                        color = Color(0xFFA2A2A2),
                        fontWeight = FontWeight.Light,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .align(Alignment.Start)
                            .fillMaxSize(),
                    )
                },
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Start,
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    cursorColor = Color(0xFFCDCDCD),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )

            Text(
                text = "${introduce.length} / 100자",
                fontSize = 14.sp,
                color = if (introduce.length > 10) Color(0xFFFF717C) else Color(0xFFA2A2A2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.weight(1f))

            if (selectedIntroduce.isEmpty() && !showSnackbar) {
                showSnackbar = true
            }

            Box (
                modifier = Modifier
                    .height(71.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                if (showSnackbar) {
                    androidx.compose.animation.AnimatedVisibility(
                        visible = showSnackbar,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.skip_snackbar),
                            contentDescription = "snackbar",
                            modifier = Modifier
                                .size(width = 144.dp, height = 71.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "건너뛰기",
                    color = Color(0xFFA8A8A8),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable {
                            val intent = Intent(content, MyHeight::class.java)
                            content.startActivity(intent)
                        }
                )

                Image(
                    painter = painterResource(R.drawable.skip_arrow),
                    contentDescription = "skip",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            val intent = Intent(content, MainActivity::class.java)
                            content.startActivity(intent)
                        }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                enabled = introduce.isNotBlank(),
                onClick = {
                    val intent = Intent(content, MainActivity::class.java)
                    content.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (introduce.isNotBlank()) Color(0xFFFF717C) else Color(0xFFE8E8E8),
                    contentColor = Color.White,
                ),
            ) {
                Text(
                    text = "다음",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp,
                )
            }
        }
    }
}