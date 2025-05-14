package com.example.right.other

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.right.R

class MatchingComplete : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MatchingCompleteScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MatchingCompleteScreen() {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("composition.json"))
    val progress by animateLottieCompositionAsState(composition)

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xB3FFFFFF))
    ) {
        Surface (
            color = Color.White,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 145.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column {
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 23.96.dp, horizontal = 23.96.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.cross_out),
                        contentDescription = "cross_out",
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.CenterEnd),
                    )
                }

                LottieAnimation(
                    composition,
                    progress,
                    modifier = Modifier
                        .size(height = 314.dp, width = 298.dp)
                        .padding(horizontal = 18.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "매칭 성공!",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black,
                    )

                    //                Text(
                    //                    text = "$name 님과\n매칭되었어요.",
                    //                    fontSize = 18.sp,
                    //                    color = Color(0xFF121212),
                    //                    textAlign = Alignment.Center,
                    //                )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "지금 바로 좋아요를 보내보세요!",
                        fontSize = 16.sp,
                        color = Color(0xFF8E8E93)
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .height(52.dp),
                        onClick = {  },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF717C),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "프로필 보기",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}