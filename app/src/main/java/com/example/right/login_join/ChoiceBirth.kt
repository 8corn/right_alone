package com.example.right.login_join

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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

class ChoiceBirth : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChoiceBirthScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChoiceBirthScreen() {
    val content = LocalContext.current

    val (name, setName) = remember { mutableStateOf("") }
    val (year, setYear) = remember { mutableStateOf("") }
    val (month, setMonth) = remember { mutableStateOf("") }
    val (day, setDay) = remember { mutableStateOf("") }

    val yearFocusRequester = remember { FocusRequester() }
    val monthFocusRequester = remember { FocusRequester() }
    val dayFocusRequester = remember { FocusRequester() }

    val selectedGender = remember { mutableStateOf<String?>(null) }

    val nameInteractionSource = remember { MutableInteractionSource() }
    val isNameFocused by nameInteractionSource.collectIsFocusedAsState()
    val yearInteractionSource = remember { MutableInteractionSource() }
    val isYearFocused by yearInteractionSource.collectIsFocusedAsState()
    val monthInteractionSource = remember { MutableInteractionSource() }
    val isMonthFocused by monthInteractionSource.collectIsFocusedAsState()
    val dayInteractionSource = remember { MutableInteractionSource() }
    val isDayFocused by dayInteractionSource.collectIsFocusedAsState()

    val highlightColor = Color(0xFFFF717C)
    val inactiveButtonColor = Color(0xFFCDCDCD)

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
                text = "반가워요!",
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

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "이름",
                color = Color(0xFF121212),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )

            TextField(
                value = name,
                onValueChange = setName,
                interactionSource = nameInteractionSource,
                placeholder = {
                    Text(
                        text = "홍길동",
                        color = Color(0xFFA2A2A2),
                        fontWeight = FontWeight.Light,
                        fontSize = 18.sp,
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
                    .height(56.dp)
                    .border(
                        1.dp,
                        when {
                            isNameFocused -> highlightColor
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

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "생년월일",
                color = Color(0xFF121212),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp)
            ) {
                TextField(
                    value = year,
                    onValueChange = {
                        val digits = it.filter { ch -> ch.isDigit() }
                        setYear(digits.take(4))
                        if (digits.length == 4) {
                            monthFocusRequester.requestFocus()
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    interactionSource = yearInteractionSource,
                    placeholder = {
                        Text(
                            text = "년도",
                            color = Color(0xFFA2A2A2),
                            fontWeight = FontWeight.Light,
                            fontSize = 18.sp,
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .border(
                            1.dp,
                            when {
                                isYearFocused -> highlightColor
                                else -> inactiveButtonColor
                            },
                            RoundedCornerShape(8.dp)
                        )
                        .focusRequester(yearFocusRequester),
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

                Spacer(modifier = Modifier.width(4.dp))

                TextField(
                    value = month,
                    onValueChange = {
                        val digits = it.filter { ch -> ch.isDigit() }
                        setMonth(digits.take(2))
                        if (digits.length == 2) {
                            dayFocusRequester.requestFocus()
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    interactionSource = monthInteractionSource,
                    placeholder = {
                        Text(
                            text = "월",
                            color = Color(0xFFA2A2A2),
                            fontWeight = FontWeight.Light,
                            fontSize = 18.sp,
                        )
                    },
                    modifier = Modifier
                        .width(100.dp)
                        .height(56.dp)
                        .border(
                            1.dp,
                            when {
                                isMonthFocused -> highlightColor
                                else -> inactiveButtonColor
                            },
                            RoundedCornerShape(8.dp)
                        )
                        .focusRequester(monthFocusRequester),
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

                Spacer(modifier = Modifier.width(4.dp))

                TextField(
                    value = day,
                    onValueChange = {
                        val digits = it.filter { ch -> ch.isDigit() }
                        setDay(digits.take(2))
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    interactionSource = dayInteractionSource,
                    placeholder = {
                        Text(
                            text = "일",
                            color = Color(0xFFA2A2A2),
                            fontWeight = FontWeight.Light,
                            fontSize = 18.sp,
                        )
                    },
                    modifier = Modifier
                        .width(100.dp)
                        .height(56.dp)
                        .border(
                            1.dp,
                            when {
                                isDayFocused -> highlightColor
                                else -> inactiveButtonColor
                            },
                            RoundedCornerShape(8.dp)
                        )
                        .focusRequester(dayFocusRequester),
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
            }
            
            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "성별",
                fontSize = 15.sp,
                color = Color(0xFF121212),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )

            GenderSelection(
                selectedGender = selectedGender.value,
                onGenderSelected = { selectedGender.value = it }
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val intent = Intent(content, CheckHobby::class.java)
                    content.startActivity(intent)
                },
                enabled = selectedGender.value != null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (name.isNotBlank() && year.isNotBlank() && month.isNotBlank() && day.isNotBlank() && selectedGender.value != null)
                        highlightColor
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
fun GenderSelection(
    selectedGender: String?,
    onGenderSelected: (String) -> Unit
) {
    val highlightColor = Color(0xFFFF717C)
    val highlightBackground = Color(0x33FF717C)
    val defaultBorderColor = Color(0xFFCDCDCD)
    val defaultTextColor = Color(0xFFA2A2A2)

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
    ) {
        GenderButton(
            label = "남성",
            iconRes = R.drawable.man_head,
            isSelected = selectedGender == "남성",
            onClick = { onGenderSelected("남성") },
            highlightColor = highlightColor,
            highlightBackground = highlightBackground,
            defaultBorderColor = defaultBorderColor,
            defaultTextColor = defaultTextColor,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(7.dp))

        GenderButton(
            label = "여성",
            iconRes = R.drawable.woman_head,
            isSelected = selectedGender == "여성",
            onClick = { onGenderSelected("여성") },
            highlightColor = highlightColor,
            highlightBackground = highlightBackground,
            defaultBorderColor = defaultBorderColor,
            defaultTextColor = defaultTextColor,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun GenderButton(
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
            .height(56.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) highlightColor else defaultBorderColor,
                shape = RoundedCornerShape(8.dp),
            ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = label,
            modifier = Modifier.size(20.dp),
            colorFilter = ColorFilter.tint(if (isSelected) highlightColor else defaultTextColor)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) Color.Black else defaultTextColor
        )
    }
}