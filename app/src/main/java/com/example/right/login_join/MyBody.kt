package com.example.right.login_join

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R

class MyBody : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBodyScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBodyScreen() {
    val content = LocalContext.current

    val selectedBody by remember { mutableStateOf(listOf<String>()) }
    val selectBody = remember { mutableStateOf<String?>(null) }

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
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                color = Color(0x4DCDCDCD),
                thickness = 1.dp,
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                color = Color(0x4DCDCDCD),
                thickness = 5.dp,
            )
            Text(
                text = "어떤 체형에 가까우신가요?",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "당신은 어떤 체형인가요?\n가장 가까운 체형을 선택해주세요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                SelectedBodyBtn(
                    onClick = {selectBody.value = "마름"},
                    text = "마름",
                    modifier = Modifier
                        .weight(1f),
                    isSelected = selectBody.value == "마름"
                )

                Spacer(modifier = Modifier.width(12.dp))

                SelectedBodyBtn(
                    onClick = {selectBody.value = "보통"},
                    text = "보통",
                    modifier = Modifier
                        .weight(1f),
                    isSelected = selectBody.value == "보통"
                )

                Spacer(modifier = Modifier.width(12.dp))

                SelectedBodyBtn(
                    onClick = {selectBody.value = "글램"},
                    text = "글램",
                    modifier = Modifier
                        .weight(1f),
                    isSelected = selectBody.value == "글램"
                )
            }

            Spacer(modifier = Modifier.height(57.dp))

            Text(
                text = "Tip.\n키-몸무게로 계산했을 때",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Start),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xFFA2A2A2),
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "000이상 - 마름",
                    modifier = Modifier
                        .padding(vertical = 7.dp)
                        .weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFA2A2A2),
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "000 ~ 000 - 보통",
                    modifier = Modifier
                        .padding(vertical = 7.dp)
                        .weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFA2A2A2),
                    textAlign = TextAlign.Start
                )

                Text(
                    text = "000이하 - 글램",
                    modifier = Modifier
                        .padding(vertical = 7.dp)
                        .weight(1f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFA2A2A2),
                    textAlign = TextAlign.Start
                )
            }

            Text(
                text = "으로 계산하면 편리해요.",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Start),
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = Color(0xFFA2A2A2),
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val intent = Intent(content, Introduce::class.java)
                    content.startActivity(intent)
                },
                enabled = selectedBody.isNotEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedBody.isNotEmpty()) Color(0xFFFF717C) else Color(0xFFE8E8E8),
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

@Composable
fun SelectedBodyBtn(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(100.dp)
            .border(
                1.dp,
                if (isSelected) Color(0xFFFF717C) else Color(0xFFCDCDCD),
                RoundedCornerShape(12.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0x33FF717C) else Color.White,
            contentColor = if (isSelected) Color(0x33FF717C) else Color(0xFFA2A2A2)
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.Black else Color(0xFFA2A2A2),
            fontSize = 18.sp,
            fontWeight = FontWeight.Light
        )
    }
}