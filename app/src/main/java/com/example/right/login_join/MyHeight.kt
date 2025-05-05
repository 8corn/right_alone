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
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.widget.AnimatedProgressBar

class MyHeight : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHeightScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyHeightScreen() {
    val content = LocalContext.current
    val activity = content as? ComponentActivity

    val (cm, setCm) = remember { mutableStateOf("") }
    val (kg, setKg) = remember { mutableStateOf("") }

    val cmFocusRequester = remember { FocusRequester() }
    val kgFocusRequester = remember { FocusRequester() }

    val cmInteractionSource = remember { MutableInteractionSource() }
    val isCmFocused by cmInteractionSource.collectIsFocusedAsState()
    val kgInteractionSource = remember { MutableInteractionSource() }
    val isKgFocused by kgInteractionSource.collectIsFocusedAsState()

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

            AnimatedProgressBar(6)

            Text(
                text = "키와 몸무게를 알려주세요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "당신의 키와 몸무게를 알려주세요.\n원하는 이상형 매칭을 위해, 정확하게 알려주세요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Image(
                painter = painterResource(R.drawable.no_warning_sign),
                contentDescription = "no_warning_sign",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(80.dp))

            Row (
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                BasicTextField(
                    value = cm,
                    onValueChange = {
                        val digits = it.filter { ch -> ch.isDigit() }
                        setCm(digits.take(3))
                        if (digits.length == 3) {
                            kgFocusRequester.requestFocus()
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .focusRequester(cmFocusRequester)
                        .border(
                            1.dp,
                            if (isCmFocused) Color(0xFFFF717C) else Color(0xFFCDCDCD),
                            RoundedCornerShape(8.dp)
                        )
                        .height(56.dp)
                        .width(104.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.End
                    ),
                    interactionSource = cmInteractionSource,
                    decorationBox = { innerTextField ->
                        Box (
                            contentAlignment = Alignment.CenterEnd,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp)
                        ) {
                            if (cm.isEmpty()) {
                                Text(
                                    text = "0",
                                    color = Color(0xFFA2A2A2),
                                    fontWeight = FontWeight.Light,
                                    fontSize = 30.sp,
                                )
                            }
                            innerTextField()
                        }
                    },
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "cm",
                    color = Color(0xFFCDCDCD),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(22.dp))

                BasicTextField(
                    value = kg,
                    onValueChange = {
                        val digits = it.filter { ch -> ch.isDigit() }
                        setKg(digits.take(3))
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .focusRequester(kgFocusRequester)
                        .border(
                            1.dp,
                            if (isKgFocused) Color(0xFFFF717C) else Color(0xFFCDCDCD),
                            RoundedCornerShape(8.dp)
                        )
                        .height(56.dp)
                        .width(104.dp),
                    singleLine = true,
                    interactionSource = kgInteractionSource,
                    textStyle = TextStyle(
                        fontSize = 30.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.End
                    ),
                    decorationBox = { innerTextField ->
                        Box (
                            contentAlignment = Alignment.CenterEnd,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 8.dp)
                        ) {
                            if (cm.isEmpty()) {
                                Text(
                                    text = "0",
                                    color = Color(0xFFA2A2A2),
                                    fontWeight = FontWeight.Light,
                                    fontSize = 30.sp,
                                )
                            }
                            innerTextField()
                        }
                    },
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Kg",
                    color = Color(0xFFCDCDCD),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )
            }
            
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val intent = Intent(content, MyBody::class.java)
                    content.startActivity(intent)
                },
                enabled = kg.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (cm.isNotBlank() && kg.isNotBlank())
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