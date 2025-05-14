package com.example.right.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
fun PayArrow2(
    currentPay: Int,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false
) {
    val backgroundColor = if (isEnabled) Color.White else Color(0x80FFFFFF)
    val textColor = if (isEnabled) Color.Black else Color(0xFF8E8E93)
    val iconRes = if (isEnabled) R.drawable.pay_arrow else R.drawable.unenable_pay_arrow

    Row (
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(61.dp)
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = "pay_array_icon",
            modifier = Modifier.size(23.31.dp)
        )

        Text(
            text = currentPay.toString(),
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}