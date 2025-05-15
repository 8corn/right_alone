package com.example.right.mypage

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.right.R

class EditProfile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EditProfileScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreen() {
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

    val prefs = context.getSharedPreferences("profile", Context.MODE_PRIVATE)
    val (nickname, setNickname) = remember { mutableStateOf(prefs.getString("aka", "") ?: "") }

    LaunchedEffect(nickname) {
        prefs.edit().putString("aka", nickname).apply()
    }

    Surface(
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = "프로필 수정",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center)
                )

                Row {
                    Icon(
                        painter = painterResource(R.drawable.back_arrow),
                        contentDescription = "back_arrow",
                        tint = Color.Black,
                        modifier = Modifier
                            .clickable {
                                activity?.onBackPressedDispatcher?.onBackPressed()
                            }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "취소",
                        fontSize = 16.sp,
                        color = Color(0xFF63B5F6),
                        modifier = Modifier
                            .clickable {
                                activity?.onBackPressedDispatcher?.onBackPressed()
                            }
                    )
                }
            }

            Spacer(modifier = Modifier.height(17.dp))

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(17.dp))

                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp)
                ) {
                    val totalWidth = maxWidth
                    val leftWidth = totalWidth * 0.5f
                    val smallImageSize = (totalWidth * 0.5f - 8.dp * 1.5f) / 2

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(leftWidth)
                    ) {
                        Box(
                            modifier = Modifier
                                .width(leftWidth)
                                .fillMaxHeight()
                                .clickable {
                                    imagePickerLauncher.launch("image/*")
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            if (imageUris[0] == null) {
                                Image(
                                    painter = painterResource(R.drawable.default_profile_choice),
                                    contentDescription = "default_profile",
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            } else {
                                Image(
                                    painter = rememberAsyncImagePainter(imageUris[0]),
                                    contentDescription = "selected_image",
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            for (rowIndex in 0 until 2) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    for (colIndex in 0 until 2) {
                                        val index = rowIndex * 2 + colIndex + 1
                                        val image = imageUris.getOrNull(index)

                                        Box(
                                            modifier = Modifier
                                                .size(smallImageSize)
                                                .border(
                                                    width = 2.dp,
                                                    color = if (image != null) Color(0xFFFF717C) else Color.Transparent
                                                )
                                                .clickable {
                                                    imagePickerLauncher.launch("image/*")
                                                },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            if (image == null) {
                                                Image(
                                                    painter = painterResource(R.drawable.default_profile_choice),
                                                    contentDescription = "default_profile",
                                                    modifier = Modifier
                                                        .fillMaxSize()
                                                )
                                            } else {
                                                Image(
                                                    painter = rememberAsyncImagePainter(image),
                                                    contentDescription = "selected_image",
                                                    modifier = Modifier
                                                        .fillMaxSize()
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "닉네임",
                    fontSize = 14.sp,
                    color = Color(0xFF949BA8)
                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = nickname,
                    onValueChange = { setNickname(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .border(
                            1.dp,
                            Color(0xFFE2E4EC),
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
            }
        }
    }
}