package com.example.right.login_join

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.widget.AnimatedProgressBar
import kotlinx.coroutines.delay

class CheckHobby : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckHobbyScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CheckHobbyScreen() {
    val content = LocalContext.current
    val activity = content as? ComponentActivity

    val allHobbies = listOf(
        "📚 독서", "🐶 강아지", "✈️ 여행", "📸 사진 촬영", "🏃 러닝", "🎨 그림 그리기",
        "🐈 고양이", "💪 운동하기", "🛌 집콕", "☕️ 카페 가기", "🎧 음악 듣기",
        "🧤 패션", "🧙 뮤지컬 관람", "🎹 악기 연주", "📺 드라마", "🎮 게임", "🥘 요리", "🎥 영화", "🎪 전시회",
        "⚽ 스포츠", "💵 재태크", "🛒 쇼핑하기", "💭 애니메이션", "📖 공부", "🥳 파티, 모임", "🥃 술"
    )
    var selectedHobbies by remember { mutableStateOf(listOf<String>()) }
    var showSnackbar by remember { mutableStateOf(false) }

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            delay(3000)
            showSnackbar = false
        }
    }

    Surface(
        color = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
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

            AnimatedProgressBar(currentStep = 9)

            Text(
                text = "관심사",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "당신이 관심있는 주제를 선택해주세요.\n관심사 어쩌고저쩌고.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(32.dp))

            HobbySelection(
                hobbies = allHobbies,
                selectedHobbies = selectedHobbies,
                onToggleHobby = { hobby ->
                    selectedHobbies = if (hobby in selectedHobbies) {
                        selectedHobbies - hobby
                    } else {
                        selectedHobbies + hobby
                    }
                }
            )
        }

        if (selectedHobbies.isEmpty() && !showSnackbar) {
            showSnackbar = true
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 36.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            
            Box(
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
                            val intent = Intent(content, Introduce::class.java)
                            content.startActivity(intent)
                        }
                )

                Image(
                    painter = painterResource(R.drawable.skip_arrow),
                    contentDescription = "skip",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.CenterVertically)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    val intent = Intent(content, Introduce::class.java)
                    content.startActivity(intent)
                },
                enabled = selectedHobbies.isNotEmpty(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedHobbies.isNotEmpty()) Color(0xFFFF717C) else Color(0xFFE8E8E8),
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
fun HobbyChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Surface (
        shape = RoundedCornerShape(30.dp),
        border = BorderStroke(1.dp, if (selected) Color(0xFFFF717C) else Color(0xFFCDCDCD)),
        color = if (selected) Color(0x33FF717C) else Color.White,
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = 4.dp)
    ) {
        Row (
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun HobbySelection(
    hobbies: List<String>,
    selectedHobbies: List<String>,
    onToggleHobby: (String) -> Unit,
) {
    FlowRow (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
        hobbies.forEach{ hobby ->
            HobbyChip(
                text = hobby,
                selected = hobby in selectedHobbies,
                onClick = { onToggleHobby(hobby) }
            )
        }
    }
}