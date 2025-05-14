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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.right.R
import com.example.right.mypage.EditProfile

@Preview(showBackground = true)
@Composable
fun MyPageNavScreen() {
    val context = LocalContext.current

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 60.dp)
        ) {
            Text(
                text = "마이 페이지",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(26.dp))

            Row {


                Column {
                    Row  (
                        verticalAlignment = Alignment.CenterVertically
                    ){
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

                    Row (
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

            Surface (
                color = Color(0x80FFDEE0),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row (
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

                    Column (
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

            Spacer(modifier = Modifier.height(20.dp))

            HorizontalDivider(
                color = Color(0xFFF9FAFB),
                modifier = Modifier
                    .height(6.dp)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "필터 관리",
                color = Color(0xFF949BA8),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
        }
    }
}