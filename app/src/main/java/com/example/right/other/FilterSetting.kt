package com.example.right.other

import android.os.Bundle
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.widget.PayArrow
import kotlin.math.roundToInt

class FilterSetting : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FilterSettingScreen()
        }
    }
}

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterSettingScreen() {
    val content = LocalContext.current
    val activity = content as? ComponentActivity

    var selectedOption by remember { mutableStateOf (listOf<String>()) }
    var toggleOn by remember { mutableStateOf(false) }

    val faceShapeOptions = listOf("계란형", "둥근형", "역삼각형", "긴 얼굴형", "각진형", "마름모형")
    val eyeOptions = listOf("동그란 눈", "올라간 눈", "찢어진 눈")
    val eyeLineOptions = listOf("유쌍", "무쌍")
    val noseOptions = listOf("둥근 코", "작은 코", "큰 코")
    val lipOptions = listOf("둥근 입술", "얇은 입술", "두꺼운 입술")
    val hairOptions = listOf("긴 생머리", "단발 머리", "웨이브 머리")
    val locationOptions = listOf("수도권", "경상도권", "충청권", "전라권", "강원권", "제주권")

    Scaffold (
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(94.dp)
                    .padding(top = 46.dp),
                title = {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.back_arrow),
                            contentDescription = "back_arrow",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                                .size(30.dp)
                                .clickable {
                                    activity?.onBackPressedDispatcher?.onBackPressed()
                                },
                        )

                        Text(
                            text = "필터 설정",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .offset(x = (-8).dp)
                        )

                        PayArrow(
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .padding(vertical = 4.dp, horizontal = 16.dp),
                            currentPay = 30
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "나이",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(36.dp))

            AgeRangeSelector()

            Spacer(modifier = Modifier.height(51.dp))

            Row (
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "이상형",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Icon(
                    painter = painterResource(R.drawable.crown),
                    contentDescription = "crown",
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.CenterVertically),
                    tint = Color(0xFFFF717C)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(R.drawable.pro_version_info),
                    contentDescription = "pro_version_info",
                    modifier = Modifier
                        .size(height = 56.dp, width = 230.dp)
                        .align(Alignment.CenterVertically),
                )
            }

            Text(
                text = "얼굴형",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 1.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterBtn(
                filters = faceShapeOptions,
                selectedFilters = selectedOption,
                onToggleFilter = { filter ->
                    selectedOption = if (filter in selectedOption) {
                        selectedOption - filter
                    } else {
                        selectedOption + filter
                    }
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "눈",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterBtn(
                filters = eyeOptions,
                selectedFilters = selectedOption,
                onToggleFilter = { filter ->
                    selectedOption = if (filter in selectedOption) {
                        selectedOption - filter
                    } else {
                        selectedOption + filter
                    }
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "쌍커풀",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterBtn(
                filters = eyeLineOptions,
                selectedFilters = selectedOption,
                onToggleFilter = { filter ->
                    selectedOption = if (filter in selectedOption) {
                        selectedOption - filter
                    } else {
                        selectedOption + filter
                    }
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "코",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterBtn(
                filters = noseOptions,
                selectedFilters = selectedOption,
                onToggleFilter = { filter ->
                    selectedOption = if (filter in selectedOption) {
                        selectedOption - filter
                    } else {
                        selectedOption + filter
                    }
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "입술",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterBtn(
                filters = lipOptions,
                selectedFilters = selectedOption,
                onToggleFilter = { filter ->
                    selectedOption = if (filter in selectedOption) {
                        selectedOption - filter
                    } else {
                        selectedOption + filter
                    }
                }
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "헤어",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterBtn(
                filters = hairOptions,
                selectedFilters = selectedOption,
                onToggleFilter = { filter ->
                    selectedOption = if (filter in selectedOption) {
                        selectedOption - filter
                    } else {
                        selectedOption + filter
                    }
                }
            )

            Spacer(modifier = Modifier.height(56.dp))

            Row (
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "지역",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Icon(
                    painter = painterResource(R.drawable.crown),
                    contentDescription = "crown",
                    modifier = Modifier
                        .size(14.dp)
                        .align(Alignment.CenterVertically),
                    tint = Color(0xFFFF717C)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            FilterBtn(
                filters = locationOptions,
                selectedFilters = selectedOption,
                onToggleFilter = { filter ->
                    selectedOption = if (filter in selectedOption) {
                        selectedOption - filter
                    } else {
                        selectedOption + filter
                    }
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column {
                    Row {
                        Text(
                            text = "매력적인 사용자",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Icon(
                            painter = painterResource(R.drawable.crown),
                            contentDescription = "crown",
                            tint = Color(0xFFFF717C),
                            modifier = Modifier
                                .size(14.dp),
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "매력적이라 평가받은 사용자만 매칭해요.",
                        color = Color(0xFFC7C7CC),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.weight(1f))

                ToggleSwitch(
                    isChecked = toggleOn,
                    onToggle = { toggleOn = !toggleOn }
                )
            }
        }
    }
}

@Composable
fun AgeRangeSelector(
    minAge: Int = 18,
    maxAge: Int = 40,
    initialStart: Int = 25,
    initialEnd: Int = 30
) {
    var startValue by remember { mutableStateOf(initialStart) }
    var endValue by remember { mutableStateOf(initialEnd) }

    val barHeight = 4.dp
    val thumbRadius = 12.dp
    val barColor = Color(0xFFF2F2F7)
    val activeColor = Color(0xFFFF717C)

    val density = LocalDensity.current
    val thumbRadiusPx = with(density) { thumbRadius.toPx() }

    val totalSteps = maxAge - minAge
    val windowSize = LocalWindowInfo.current.containerSize.width.toFloat()
    val sliderWidthPx = windowSize - with(density) { 64.dp.toPx() }
    val sliderWidthDp = with(LocalDensity.current) { sliderWidthPx.toDp() }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp)
    ) {
        Text(
            text = "${startValue}세 ~ ${endValue}세",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box (
            modifier = Modifier
                .width(sliderWidthDp)
                .height(thumbRadius * 2)
                .align(Alignment.CenterHorizontally)
                .clipToBounds()
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        val percentPerPixel = totalSteps / sliderWidthPx
                        val dragValue = (dragAmount.x * percentPerPixel).roundToInt()

                        if (change.position.x < size.width / 2) {
                            startValue = (startValue + dragValue).coerceIn(minAge, endValue)
                        } else {
                            endValue = (endValue + dragValue).coerceIn(startValue, maxAge)
                        }
                    }
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .height(barHeight)
                    .background(barColor, RoundedCornerShape(2.dp))
            )

            val startRatio = (startValue - minAge).toFloat() / totalSteps
            val endRatio = (endValue - minAge).toFloat() / totalSteps
            val startPx = sliderWidthPx * startRatio
            val endPx = sliderWidthPx * endRatio

            Box(
                modifier = Modifier
                    .offset { IntOffset(startPx.roundToInt(), 0) }
                    .width(with(density) { (endPx - startPx).toDp() })
                    .align(Alignment.CenterStart)
                    .height(barHeight)
                    .background(activeColor, RoundedCornerShape(2.dp))
            )

            Box(
                modifier = Modifier
                    .offset { IntOffset(startPx.roundToInt() - thumbRadiusPx.toInt(), 0) }
                    .size(thumbRadius * 2)
                    .align(Alignment.CenterStart)
                    .background(activeColor, CircleShape)
            )

            Box(
                modifier = Modifier
                    .offset { IntOffset(endPx.roundToInt() - thumbRadiusPx.toInt(), 0) }
                    .size(thumbRadius * 2)
                    .align(Alignment.CenterStart)
                    .background(activeColor, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "18",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "40+",
                color = Color(0xFF8E8E93),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun FilterChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (isSelected) Color(0xFFFF717C) else Color(0xFFE5E5EA)
    val textColor = if (isSelected) Color(0xFFF83848) else Color(0xFF8E8E93)
    val backgroundColor = if (isSelected) Color(0xFFFFE9EB) else Color.White

    Surface(
        shape = RoundedCornerShape(30.dp),
        border = BorderStroke(1.dp, borderColor),
        color = backgroundColor,
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = 4.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 14.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun FilterBtn(
    filters: List<String>,
    selectedFilters: List<String>,
    onToggleFilter: (String) -> Unit,
) {
    FlowRow (
        modifier = Modifier
            .fillMaxWidth()
    ) {
        filters.forEach { filter ->
            FilterChip(
                text = filter,
                isSelected = filter in selectedFilters,
                onClick = { onToggleFilter(filter) }
            )
        }
    }
}

@Composable
fun ToggleSwitch(
    isChecked: Boolean,
    onToggle: () -> Unit
) {
    val trackColor = if (isChecked) Color(0xFFFF717C) else Color(0xFFE5E5EA)

    Box(
        modifier = Modifier
            .width(56.dp)
            .height(31.dp)
            .background(trackColor, shape = CircleShape)
            .padding(2.dp)
            .clickable {
                onToggle()
            },
        contentAlignment = if (isChecked) Alignment.CenterEnd else Alignment.CenterStart,
    ) {
        Box(
            modifier = Modifier
                .size(27.dp)
                .background(Color.White, shape = CircleShape)
        )
    }
}