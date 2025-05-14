package com.example.right.other

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.right.R

class MyProfileChoice : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyProfileChoiceScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyProfileChoiceScreen() {
    val imageUris = remember { mutableStateListOf<Uri?>().apply { repeat(6) { add(null) } } }

    val context = LocalContext.current
    val activity = context as? ComponentActivity
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        val index = imageUris.indexOfFirst { it == null }
        if (index != -1 && uri != null) {
            imageUris[index] = uri
        }
    }

    val hasAtLeast = remember(imageUris) {
        derivedStateOf { imageUris.any { it != null } }
    }

    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 34.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 60.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box (
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = "back_arrow",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(top = 2.dp)
                            .clickable {
                                activity?.onBackPressedDispatcher?.onBackPressed()
                            },
                    )

                    Text(
                        text = "내 프로필",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }

            Text(
                text = "프로필 사진을 업로드 해주세요!",
                modifier = Modifier
                    .padding(start = 16.dp, top = 30.dp)
                    .align(Alignment.Start),
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "여기에 사진 가이드 작성할 예정입니다\n프로필 사진에 대한 사진 가이드에 대해 간단히 설명",
                modifier = Modifier
                    .padding(start = 16.dp, top = 15.dp)
                    .align(Alignment.Start),
                fontSize = 12.sp,
                color = Color(0xFFAEAEB2),
            )

            Column (
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 22.dp)
            ) {
                for (rowIndex in 0 until 2) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        for (colIndex in 0 until 3) {
                            val index = rowIndex * 3 + colIndex
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .aspectRatio(1f)
                                    .clickable {
                                        imagePickerLauncher.launch("image/*")
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                if (imageUris[index] == null) {
                                    Image(
                                        painter = painterResource(R.drawable.default_profile_choice),
                                        contentDescription = "default_profile",
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )
                                } else {
                                    Image(
                                        painter = rememberAsyncImagePainter(imageUris[index]),
                                        contentDescription = "selected_image",
                                        modifier = Modifier
                                            .fillMaxSize()
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val intent = Intent(context, MyFaceCheck::class.java)
                    context.startActivity(intent)
                },
                enabled = hasAtLeast.value,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF717C),
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFFE8E8E8),
                    disabledContentColor = Color(0xFFE8E8E8)
                )
            ) {
                Text(
                    text = "다음(1/2)",
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}