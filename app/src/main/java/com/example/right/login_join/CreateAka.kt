package com.example.right.login_join

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.right.R
import com.example.right.widget.AnimatedProgressBar

class CreateAka : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CreateAkaScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateAkaScreen() {
    val content = LocalContext.current
    val activity = content as? ComponentActivity

    val (aka, setAka) = remember { mutableStateOf("") }
    val isAkaValid = aka.isNotBlank()
    val akaInteractionSource = remember { MutableInteractionSource() }
    val isAkaFocused by akaInteractionSource.collectIsFocusedAsState()

    val highlightColor = Color(0xFFFF717C)
    val defaultBorderColor = Color.Black
    val inactiveButtonColor = Color(0xFFCDCDCD)

    Surface(
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

            AnimatedProgressBar(3)

            Text(
                text = "어떻게 불러드릴까요?",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "라잇에서 당신이 사용할 닉네임을 입력해주세요.\n닉네임은 나중에 변경할 수 있어요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(68.dp))

            TextField(
                value = aka,
                onValueChange = { if (it.length <= 10) setAka(it) },
                interactionSource = akaInteractionSource,
                placeholder = {
                    Text(
                        text = "닉네임을 입력해주세요.",
                        color = Color(0xFFA2A2A2),
                        fontWeight = FontWeight.Light,
                        fontSize = 18.sp,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(56.dp)
                    .border(
                        1.dp,
                        when {
                            isAkaFocused -> highlightColor
                            isAkaValid -> defaultBorderColor
                            else -> inactiveButtonColor
                        },
                        RoundedCornerShape(8.dp)
                    ),
                textStyle = TextStyle(fontSize = 20.sp),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.White,
                    cursorColor = Color(0xFFCDCDCD),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "특수문자는 사용할 수 없어요.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFFA2A2A2),
                    lineHeight = 16.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .weight(1f)
                )
                Text(
                    text = "${aka.length} / 10자",
                    fontSize = 14.sp,
                    color = if (aka.length > 10) Color(0xFFFF717C) else Color(0xFFA2A2A2),
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                enabled = aka.isNotBlank(),
                onClick = {
                    val intent = Intent(content, ChoiceBirth::class.java)
                    content.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (aka.isNotBlank()) highlightColor else Color(0xFFE8E8E8),
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