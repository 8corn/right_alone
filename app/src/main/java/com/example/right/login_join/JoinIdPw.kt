package com.example.right.login_join

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R

class JoinIdPw : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JoinIdPwScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JoinIdPwScreen() {
    val (newId, setNewId) = remember { mutableStateOf("") }
    val (newPw, setNewPw) = remember { mutableStateOf("") }
    val (newCheckPw, setNewCheckPw) = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    val isIdValid = newId.isNotBlank()
    val isPwValid = newPw.isNotBlank()
    val isCheckPwValid = newCheckPw.isNotBlank()
    val isPwSame = newPw == newCheckPw
    val isNextEnabled = isIdValid && isPwValid && isCheckPwValid && isPwSame

    val highlightColor = Color(0xFFFF717C)
    val defaultBorderColor = Color.Black
    val inactiveButtonColor = Color(0xFFE8E8E8)

    val idInteractionSource = remember { MutableInteractionSource() }
    val isIdFocused by idInteractionSource.collectIsFocusedAsState()

    val pwInteractionSource = remember { MutableInteractionSource() }
    val isPwFocused by pwInteractionSource.collectIsFocusedAsState()

    val checkPwInteractionSource = remember { MutableInteractionSource() }
    val isCheckPwFocused by checkPwInteractionSource.collectIsFocusedAsState()

    Surface(
        color = Color.White
    ) {
        Column (
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.back_arrow),
                contentDescription = "back",
                modifier = Modifier
                    .padding(start = 10.dp, top = 57.dp)
                    .size(size = 26.dp)
            )
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                color = Color(0x4DCDCDCD),
                thickness = 1.dp,
            )
            HorizontalDivider(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 16.dp),
                color = Color(0x4DCDCDCD),
                thickness = 5.dp,
            )
            Text(
                text = "가나다라마바사",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "당신에 대해 알려주세요.\n꼭 맞는 이상형을 매칭해드릴게요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )
            Text(
                text = "아이디",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                TextField(
                    value = newId,
                    onValueChange = setNewId,
                    interactionSource = idInteractionSource,
                    placeholder = {
                        Text(
                            text = "아이디를 입력해주세요.",
                            color = Color(0xFFA2A2A2),
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp,
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .border(
                            1.dp,
                            when {
                                isIdFocused -> highlightColor
                                isIdValid -> defaultBorderColor
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

                Spacer(modifier = Modifier.width(7.dp))

                Button(
                    enabled = isIdValid,
                    onClick = {
                        keyboardController?.hide()
                    },
                    modifier = Modifier
                        .width(107.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isIdValid) highlightColor else Color(0xFFCDCDCD),
                        contentColor = Color.White,
                    ),
                ) {
                    Text(
                        text = "중복확인",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        color = if (isIdValid) Color.White else Color(0xFFA2A2A2),
                        maxLines = 1,
                    )
                }
            }

            Text(
                text = "비밀번호",
                color = Color.Black,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(start = 16.dp, top = 40.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                TextField(
                    value = newPw,
                    onValueChange = setNewPw,
                    interactionSource = pwInteractionSource,
                    placeholder = {
                        Text(
                            text = "비밀번호를 입력해주세요.",
                            color = Color(0xFFA2A2A2),
                            fontWeight = FontWeight.Light,
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .border(
                            1.dp,
                            when {
                                isPwFocused -> highlightColor
                                isPwValid -> defaultBorderColor
                                else -> inactiveButtonColor
                            },
                            RoundedCornerShape(8.dp)
                        ),
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation('\u2022'),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        cursorColor = Color(0xFFCDCDCD),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
                Box(
                    modifier = Modifier
                        .padding(top = 8.dp)
                ) {
                    TextField(
                        value = newCheckPw,
                        onValueChange = setNewCheckPw,
                        interactionSource = checkPwInteractionSource,
                        placeholder = {
                            Text(
                                text = "비밀번호를 한번 더 입력해주세요.",
                                color = Color(0xFFA2A2A2),
                                fontWeight = FontWeight.Light,
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .border(
                                1.dp,
                                when {
                                    isCheckPwFocused -> highlightColor
                                    isCheckPwValid -> defaultBorderColor
                                    else -> inactiveButtonColor
                                },
                                RoundedCornerShape(8.dp)
                            ),
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation('\u2022'),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            cursorColor = Color(0xFFCDCDCD),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(176.dp))

            Button(
                enabled = isNextEnabled,
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isNextEnabled) highlightColor else inactiveButtonColor,
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