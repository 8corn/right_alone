package com.example.right.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R

@Composable
fun PayArrow(
    modifier: Modifier = Modifier,
    currentPay: Int,
) {
    Row (
        modifier = modifier
            .background(
                color = Color(0xFFFFE9EB), shape = RoundedCornerShape(61.dp)
            )
            .border(
                width = 0.8.dp,
                color = Color(0xFFFF717C),
                shape = RoundedCornerShape(61.dp)
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.pay_arrow),
            contentDescription = "pay_arrow",
            modifier = Modifier
                .size(23.21.dp)
        )

        Text(
            text = currentPay.toString(),
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}