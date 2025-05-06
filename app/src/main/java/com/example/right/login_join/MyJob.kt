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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.widget.AnimatedProgressBar

class MyJob : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyJobScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyJobScreen() {
    val content = LocalContext.current
    val activity = content as? ComponentActivity

    val selectedJob = remember { mutableStateOf<String?>(null) }

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
                    .clickable{
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

            AnimatedProgressBar(currentStep = 8)

            Text(
                text = "어떤 일을 하시나요?",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "당신은 어떤 일을 하고 계신가요?\n현재 당신과 가장 가까운 직업을 선택해주세요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(16.dp))

            JobSelection(
                selectedJob = selectedJob.value,
                onJobSelected = { selectedJob.value = it }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val intent = Intent(content, CheckHobby::class.java)
                    content.startActivity(intent)
                },
                enabled = selectedJob.value != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (selectedJob.value != null)
                        Color(0xFFFF717C)
                    else
                        Color(0xFFE8E8E8),
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
fun JobSelection(
    selectedJob: String?,
    onJobSelected: (String) -> Unit
) {
    val highlightColor = Color(0xFFFF717C)
    val highlightBackground = Color(0x33FF717C)
    val defaultBorderColor = Color(0xFFCDCDCD)
    val defaultTextColor = Color(0xFFA2A2A2)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
        ) {
            JobButton(
                label = "학생",
                iconRes = R.drawable.school_icon,
                isSelected = selectedJob == "학생",
                onClick = { onJobSelected("학생") },
                highlightColor = highlightColor,
                highlightBackground = highlightBackground,
                defaultBorderColor = defaultBorderColor,
                defaultTextColor = defaultTextColor,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(7.dp))

            JobButton(
                label = "직장인",
                iconRes = R.drawable.presentation_icon,
                isSelected = selectedJob == "직장인",
                onClick = { onJobSelected("직장인") },
                highlightColor = highlightColor,
                highlightBackground = highlightBackground,
                defaultBorderColor = defaultBorderColor,
                defaultTextColor = defaultTextColor,
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            JobButton(
                label = "전문직",
                iconRes = R.drawable.stethoscope_icon,
                isSelected = selectedJob == "전문직",
                onClick = { onJobSelected("전문직") },
                highlightColor = highlightColor,
                highlightBackground = highlightBackground,
                defaultBorderColor = defaultBorderColor,
                defaultTextColor = defaultTextColor,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(7.dp))

            JobButton(
                label = "기타",
                iconRes = R.drawable.guitar_icon,
                isSelected = selectedJob == "기타",
                onClick = { onJobSelected("기타") },
                highlightColor = highlightColor,
                highlightBackground = highlightBackground,
                defaultBorderColor = defaultBorderColor,
                defaultTextColor = defaultTextColor,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun JobButton(
    label: String,
    iconRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    highlightColor: Color,
    highlightBackground: Color,
    defaultBorderColor: Color,
    defaultTextColor: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) highlightBackground else Color.White,
            contentColor = if (isSelected) highlightColor else defaultTextColor,
        ),
        modifier = modifier
            .height(155.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) highlightColor else defaultBorderColor,
                shape = RoundedCornerShape(16.dp),
            ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Column (
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(iconRes),
                contentDescription = label,
                modifier = Modifier
                    .size(40.dp),
                colorFilter = ColorFilter.tint(if (isSelected) highlightColor else defaultTextColor)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = label,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                color = if (isSelected) Color.Black else defaultTextColor
            )
        }
    }
}