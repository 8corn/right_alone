package com.example.right.login_join

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import kotlin.math.sin

class LoginPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPageScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPageScreen() {
    val (id, setId) = remember { mutableStateOf("") }
    val (pw, setPw) = remember { mutableStateOf("") }
    val content = LocalContext.current

    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 142.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "쉽게 가입하고\n간편하게 로그인하세요.",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                lineHeight = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 148.dp)
            )

            Text(
                text = "나의 진짜 이상형 찾기, 라잇",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp),
            )

            Spacer(modifier = Modifier.height(38.dp))

            TextField(
                value = id,
                onValueChange = setId,
                label = {
                    Text(
                        text = "아이디를 입력해주세요.",
                        fontSize = 16.sp,
                        color = Color(0xFFA2A2A2)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 4.dp)
                    .border(1.dp, Color(0xFFFF717C), RoundedCornerShape(8.dp)),
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

            TextField(
                value = pw,
                onValueChange = setPw,
                label = {
                    Text(
                        text = "비밀번호를 입력해주세요.",
                        color = Color(0xFFA2A2A2),
                        fontSize = 16.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 4.dp)
                    .border(1.dp, Color(0xFFFF717C), RoundedCornerShape(8.dp)),
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

            Spacer(modifier = Modifier.height(22.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults
                    .buttonColors(containerColor = Color(0xFFFF7F8D)),
            ) {
                Text(
                    text = "로그인",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "또는",
                color = Color.Gray,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                Image(
                    painter = painterResource(R.drawable.kakao_login),
                    contentDescription = "Kakao",
                    modifier = Modifier
                        .size(44.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Image(
                    painter = painterResource(R.drawable.google_login),
                    contentDescription = "Google",
                    modifier = Modifier
                        .size(44.dp)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "계정을 잊으셨나요?",
                    color = Color(0xFFA2A2A2),
                    fontSize = 12.sp
                )

                Image(
                    painter = painterResource(R.drawable.skip_arrow),
                    contentDescription = "forgot_id",
                    modifier = Modifier
                        .size(height = 16.dp, width = 12.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "회원가입",
                color = Color(0xFFA2A2A2),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .clickable {
                        val intent = Intent(content, JoinIdPw::class.java)
                        content.startActivity(intent)
                    }
            )
        }
    }
}