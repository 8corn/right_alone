package com.example.right.main_nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.right.R
import com.example.right.like_nav.ReceiveLikeScreen
import com.example.right.like_nav.SearchProfileScreen
import com.example.right.like_nav.SendLikeScreen
import com.example.right.widget.PayArrow

@Preview(showBackground = true)
@Composable
fun LikeNavScreen() {
    val navController = rememberNavController()

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 54.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "화살 모아보기",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.alarm_like),
                        contentDescription = "alarm_like",
                        modifier = Modifier
                            .size(40.dp)
                    )

                    PayArrow(currentPay = 13)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Scaffold(
                topBar = { TopBarLike(navController) },
                modifier = Modifier.fillMaxSize(),
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = "sendLike",
                    modifier = Modifier.padding(innerPadding)
                ) {
                    composable("sendLike") { SendLikeScreen() }
                    composable("receiveLike") { ReceiveLikeScreen() }
                    composable("searchProfile") { SearchProfileScreen() }
                }
            }
        }
    }
}

@Composable
fun TopBarLike(navController: NavController) {
    val items = listOf(
        LikeNavItem("sendLike", "보낸 좋아요"),
        LikeNavItem("receiveLike", "받은 좋아요"),
        LikeNavItem("searchProfile", "조회한 프로필")
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Surface(
        color = Color.White
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(36.dp)
                        .padding(horizontal = 41.5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items.forEach { item ->
                        val isSelected = currentRoute == item.route

                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(item.route) {
                                        popUpTo("sendLike") { inclusive = false }
                                        launchSingleTop = true
                                    }
                                }
                        ) {
                            Text(
                                text = item.label,
                                fontSize = 15.sp,
                                color = if (isSelected) Color.Black else Color(0xFFB8B8B8),
                                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                textAlign = TextAlign.Center,
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            if (isSelected) {
                                Box(
                                    modifier = Modifier
                                        .width(44.dp)
                                        .height(2.dp)
                                        .background(Color.Black)
                                )
                            } else {
                                Spacer(modifier = Modifier.height(4.dp))
                            }
                        }
                    }
                }
                HorizontalDivider(
                    color = Color(0xFFE5E5E5),
                    thickness = 1.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}

data class LikeNavItem(val route: String, val label: String)