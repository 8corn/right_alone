package com.example.right.widget

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedProgressBar(
    modifier: Modifier = Modifier,
    currentStep: Int,
    totalSteps: Int = 10,
) {
    val progressFraction = (currentStep.coerceIn(0, totalSteps)).toFloat() / totalSteps

    val animatedProgress by animateFloatAsState(
        targetValue =  progressFraction,
        animationSpec = tween(durationMillis = 500),
        label = "progressBarAnimation"
    )

    Box (
        modifier = modifier
            .fillMaxWidth()
            .height(5.dp)
            .padding(horizontal = 16.dp)
            .background(Color(0x4DCDCDCD))
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(animatedProgress)
                .background(Color(0xFFFF717C))
        )
    }
}