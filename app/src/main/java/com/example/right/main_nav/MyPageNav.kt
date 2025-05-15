package com.example.right.main_nav

import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.mypage.EditProfile
import com.example.right.other.ToggleSwitch

@Preview(showBackground = true)
@Composable
fun MyPageNavScreen() {
    val context = LocalContext.current

    var toggleOn by remember { mutableStateOf(false) }

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            Text(
                text = "마이 페이지",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(13.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    Spacer(modifier = Modifier.height(13.dp))

                    Row {


                        Column {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "봄날의 햇살",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF121212)
                                )

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(
                                    text = "24",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF121212)
                                )
                            }

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = "부산시 수영구",
                                fontSize = 14.sp,
                                color = Color(0xFF8E8E93)
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "프로필 완성도",
                                    fontSize = 12.sp,
                                    color = Color(0xFF8E8E93)
                                )

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(
                                    text = "60%",
                                    fontSize = 12.sp,
                                    color = Color(0xFFFF717C)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(1.dp, Color(0xFFDEDDDD), RoundedCornerShape(8.dp))
                            .height(44.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White,
                            contentColor = Color.White
                        ),
                        onClick = {
                            val intent = Intent(context, EditProfile::class.java)
                            context.startActivity(intent)
                        },
                    ) {
                        Text(
                            text = "프로필 수정하기",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF121212)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Surface(
                        color = Color(0x80FFDEE0),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(76.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 18.dp)
                        ) {
                            Spacer(modifier = Modifier.width(20.dp))

                            Icon(
                                painter = painterResource(R.drawable.shop_icon_my_page),
                                contentDescription = "shop_icon",
                                tint = Color(0xFFFF717C),
                                modifier = Modifier
                                    .size(20.dp)
                                    .align(Alignment.CenterVertically),
                            )

                            Spacer(modifier = Modifier.width(14.dp))

                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically)
                            ) {
                                Text(
                                    text = "화살을 충전하고",
                                    fontSize = 15.sp,
                                    color = Color(0xFFFF717C),
                                    fontWeight = FontWeight.Bold
                                )

                                Text(
                                    text = "내 이상형을 만나보세요.",
                                    fontSize = 15.sp,
                                    color = Color(0xFFFF717C),
                                )
                            }

                            Icon(
                                painter = painterResource(R.drawable.skip_arrow),
                                contentDescription = "skip_arrow",
                                tint = Color(0xFFFF717C),
                                modifier = Modifier
                                    .padding(top = 40.dp)
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Column(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    text = "나의 화살",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color(0xFF7F7F7F),
                                )

                                Text(
                                    text = "13",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFF121212),
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDivider(
                    color = Color(0xFFF9FAFB),
                    modifier = Modifier
                        .height(6.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                ) {
                    Text(
                        text = "필터 관리",
                        color = Color(0xFF949BA8),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "필터 수정",
                            fontSize = 14.sp,
                            color = Color(0xFF323439)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(R.drawable.skip_arrow),
                            contentDescription = "skip_arrow",
                            tint = Color(0xFF858C9A),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "아는 사람 만나지 않기",
                            fontSize = 14.sp,
                            color = Color(0xFF323439)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(R.drawable.skip_arrow),
                            contentDescription = "skip_arrow",
                            tint = Color(0xFF858C9A),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDivider(
                    color = Color(0xFFF9FAFB),
                    modifier = Modifier
                        .height(6.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                ) {
                    Text(
                        text = "계정 설정",
                        color = Color(0xFF949BA8),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "비밀번호 변경",
                            fontSize = 14.sp,
                            color = Color(0xFF323439)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(R.drawable.skip_arrow),
                            contentDescription = "skip_arrow",
                            tint = Color(0xFF858C9A),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "로그아웃",
                            fontSize = 14.sp,
                            color = Color(0xFFE43D45)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(R.drawable.skip_arrow),
                            contentDescription = "skip_arrow",
                            tint = Color(0xFF858C9A),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDivider(
                    color = Color(0xFFF9FAFB),
                    modifier = Modifier
                        .height(6.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                ) {
                    Text(
                        text = "알림",
                        color = Color(0xFF949BA8),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "마케팅 수신동의",
                            fontSize = 14.sp,
                            color = Color(0xFF323439)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        ToggleSwitch(
                            isChecked = toggleOn,
                            onToggle = { toggleOn = !toggleOn }
                        )
                    }

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        text = "알림이 오지 않을 경우,\n기기 설정 > 라잇 앱의 알림 허용 여부를 확인해 주세요!",
                        fontSize = 10.sp,
                        color = Color(0xFFAFB8C1)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                HorizontalDivider(
                    color = Color(0xFFF9FAFB),
                    modifier = Modifier
                        .height(6.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                Column(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                ) {
                    Text(
                        text = "서비스 정보",
                        color = Color(0xFF949BA8),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "라이센스 안내",
                            fontSize = 14.sp,
                            color = Color(0xFF323439)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(R.drawable.skip_arrow),
                            contentDescription = "skip_arrow",
                            tint = Color(0xFF858C9A),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "개인정보 처리방침",
                            fontSize = 14.sp,
                            color = Color(0xFF323439)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(R.drawable.skip_arrow),
                            contentDescription = "skip_arrow",
                            tint = Color(0xFF858C9A),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "고객센터 문의",
                            fontSize = 14.sp,
                            color = Color(0xFF323439)
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Icon(
                            painter = painterResource(R.drawable.skip_arrow),
                            contentDescription = "skip_arrow",
                            tint = Color(0xFF858C9A),
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }
            }
        }
    }
}