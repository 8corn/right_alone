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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.widget.AnimatedProgressBar

class MyHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyHomeScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyHomeScreen() {
    val content = LocalContext.current
    val activity = content as? ComponentActivity

    val (location, setLocation) = remember { mutableStateOf("") }
    val locationInteractionSource = remember { MutableInteractionSource() }
    val isLocationFocused by locationInteractionSource.collectIsFocusedAsState()

    val suggestions = listOf(
        "서울 강남구", "서울 강동구", "서울 강북구", "서울 강서구", "서울 관악구", "서울 광진구", "서울 구로구", "서울 금천구",
        "서울 노원구", "서울 도봉구", "서울 동대문구", "서울 동작구", "서울 마포구", "서울 서대문구", "서울 서초구", "서울 성동구",
        "서울 성북구", "서울 송파구", "서울 양천구", "서울 영등포구", "서울 용산구", "서울 은평구", "서울 종로구", "서울 중구", "서울 중랑구",

        "부산 강서구", "부산 금정구", "부산 기장군", "부산 남구", "부산 동구", "부산 동래구", "부산 부산진구", "부산 북구", "부산 사상구",
        "부산 사하구", "부산 서구", "부산 수영구", "부산 연제구", "부산 영도구", "부산 중구", "부산 해운대구",

        "대구 남구", "대구 달서구", "대구 달성군", "대구 동구", "대구 북구", "대구 서구", "대구 수성구", "대구 중구",

        "인천 강화군", "인천 계양구", "인천 남동구", "인천 동구", "인천 미추홀구", "인천 부평구", "인천 서구", "인천 연수구", "인천 옹진군", "인천 중구",

        "광주 광산구", "광주 남구", "광주 동구", "광주 북구", "광주 서구",

        "대전 대덕구", "대전 동구", "대전 서구", "대전 유성구", "대전 중구",

        "울산 남구", "울산 동구", "울산 북구", "울산 울주군", "울산 중구",

        "세종 세종시",

        "경기 가평군", "경기 고양시", "경기 과천시", "경기 광명시", "경기 광주시", "경기 구리시", "경기 군포시", "경기 김포시", "경기 남양주시",
        "경기 동두천시", "경기 부천시", "경기 성남시", "경기 수원시", "경기 시흥시", "경기 안산시", "경기 안성시", "경기 안양시", "경기 양주시",
        "경기 양평군", "경기 여주시", "경기 연천군", "경기 오산시", "경기 용인시", "경기 의왕시", "경기 의정부시", "경기 이천시", "경기 파주시",
        "경기 평택시", "경기 포천시", "경기 하남시", "경기 화성시",

        "강원 강릉시", "강원 고성군", "강원 동해시", "강원 삼척시", "강원 속초시", "강원 양구군", "강원 양양군", "강원 영월군", "강원 원주시",
        "강원 인제군", "강원 정선군", "강원 철원군", "강원 춘천시", "강원 태백시", "강원 평창군", "강원 홍천군", "강원 화천군", "강원 횡성군",

        "충북 괴산군", "충북 단양군", "충북 보은군", "충북 영동군", "충북 옥천군", "충북 음성군", "충북 제천시", "충북 증평군", "충북 진천군",
        "충북 청주시", "충북 충주시",

        "충남 계룡시", "충남 공주시", "충남 금산군", "충남 논산시", "충남 당진시", "충남 보령시", "충남 부여군", "충남 서산시", "충남 서천군",
        "충남 아산시", "충남 예산군", "충남 천안시", "충남 청양군", "충남 태안군", "충남 홍성군",

        "전북 고창군", "전북 군산시", "전북 김제시", "전북 남원시", "전북 무주군", "전북 부안군", "전북 순창군", "전북 완주군", "전북 익산시",
        "전북 임실군", "전북 장수군", "전북 전주시", "전북 정읍시", "전북 진안군",

        "전남 강진군", "전남 고흥군", "전남 곡성군", "전남 광양시", "전남 구례군", "전남 나주시", "전남 담양군", "전남 목포시", "전남 무안군",
        "전남 보성군", "전남 순천시", "전남 신안군", "전남 여수시", "전남 영광군", "전남 영암군", "전남 완도군", "전남 장성군", "전남 장흥군",
        "전남 진도군", "전남 함평군", "전남 해남군", "전남 화순군",

        "경북 경산시", "경북 경주시", "경북 고령군", "경북 구미시", "경북 군위군", "경북 김천시", "경북 문경시", "경북 봉화군", "경북 상주시",
        "경북 성주군", "경북 안동시", "경북 영덕군", "경북 영양군", "경북 영주시", "경북 영천시", "경북 예천군", "경북 울릉군", "경북 울진군",
        "경북 의성군", "경북 청도군", "경북 청송군", "경북 칠곡군", "경북 포항시",

        "경남 거제시", "경남 거창군", "경남 고성군", "경남 김해시", "경남 남해군", "경남 밀양시", "경남 사천시", "경남 산청군", "경남 양산시",
        "경남 의령군", "경남 진주시", "경남 창녕군", "경남 창원시", "경남 통영시", "경남 하동군", "경남 함안군", "경남 함양군", "경남 합천군",

        "제주 서귀포시", "제주 제주시"
    )

    val filteredSuggestions = remember(location) {
        suggestions.filter { it.contains(location, ignoreCase = true) && location.isNotBlank() }
    }

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

            AnimatedProgressBar(currentStep = 5)

            Text(
                text = "어디에 거주하시나요?",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "당신은 어디에 거주하시나요?\n위치 필터로 가까운 이상형을 찾을 수 있어요.",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 15.sp,
                color = Color.Black,
            )

            Spacer(modifier = Modifier.height(44.dp))

            Column (
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                BasicTextField(
                    value = location,
                    onValueChange = setLocation,
                    interactionSource = locationInteractionSource,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            1.dp,
                            if (isLocationFocused) Color(0xFFFF717C) else Color(0xFFCDCDCD),
                            RoundedCornerShape(8.dp)
                        ),
                    textStyle = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Start,
                        textDecoration = null
                    ),
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier
                                .height(56.dp)
                                .padding(horizontal = 20.dp)
                        ) {
                            Row(
                                modifier = Modifier
                            ) {
                                if (location.isEmpty()) {
                                    Text(
                                        text = "예) 서울 송파구",
                                        fontSize = 18.sp,
                                        lineHeight = 20.sp,
                                        fontWeight = FontWeight.Light,
                                        color = Color(0xFFA2A2A2),
                                    )
                                }

                                Spacer(modifier = Modifier.weight(1f))

                                Image(
                                    painter = painterResource(R.drawable.search_icon),
                                    contentDescription = "search_icon",
                                    modifier = Modifier
                                        .size(24.dp),
                                    colorFilter = ColorFilter.tint(
                                        if (isLocationFocused) Color(0xFFFF717C) else Color(0xFFCDCDCD)
                                    )
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                filteredSuggestions.forEach { suggestion ->
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { setLocation(suggestion) }
                            .verticalScroll(rememberScrollState())
                            .padding(horizontal = 12.dp, vertical = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = suggestion,
                            modifier = Modifier
                                .weight(1f),
                            fontSize = 16.sp,
                            color = Color.Black
                        )

                        if (suggestion == location) {
                            Image(
                                painter = painterResource(R.drawable.join_id_check),
                                contentDescription = "check",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier
                            .padding(horizontal = 6.dp),
                        color = Color(0xFFCDCDCD),
                        thickness = 1.dp,
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val intent = Intent(content, MyHeight::class.java)
                    content.startActivity(intent)
                },
                enabled = location.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =
                    if (location.isNotBlank()) Color(0xFFFF717C) else Color(0xFFE8E8E8),
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