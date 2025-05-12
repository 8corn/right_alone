package com.example.right.like_nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R

@Preview(showBackground = true)
@Composable
fun ReceiveLikeScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.empty_screen_icon),
                contentDescription = "empty_icon",
                modifier = Modifier
                    .size(102.dp),
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "아직 좋아요를 보낸 상대가 없어요.",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFAEAEB2),
            )

            Text(
                text = "맘에 드는 그분에게 좋아요를 보내세요!",
                fontSize = 16.sp,
                color = Color(0xFFC7C7CC),
            )
        }
    }
}