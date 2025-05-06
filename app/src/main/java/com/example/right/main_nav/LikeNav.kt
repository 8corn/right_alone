package com.example.right.main_nav

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
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
    val selectedIndex = items.indexOfFirst { it.route == currentRoute }.coerceAtLeast(0)

    val windowInfo = LocalWindowInfo.current
    val screenWidth = with(LocalDensity.current) { windowInfo.containerSize.width.toDp() }

    val indicatorOffset by animateDpAsState(
        targetValue = selectedIndex * 72.dp,
        label = "indicatorOffset"
    )

    Surface(
        color = Color.White
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            HorizontalDivider(
                color = Color(0xFFE5E5E5),
                thickness = 1.dp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )

            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .padding(horizontal = 41.5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items.forEach { item ->
                        val isSelected = currentRoute == item.route

                        Text(
                            text = item.label,
                            fontSize = 15.sp,
                            color = if (isSelected) Color.Black else Color(0xFFB8B8B8),
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate(item.route) {
                                        popUpTo("sendLike") { inclusive = false }
                                        launchSingleTop = true
                                    }
                                },
                            textAlign = TextAlign.Center
                        )
                    }
                }
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = ((screenWidth - (72.dp * items.size)) / 2)),
                ) {
                    Box(
                        modifier = Modifier
                            .offset { IntOffset(indicatorOffset.value.dp.roundToPx(), 0) }
                            .width(72.dp)
                            .height(2.dp)
                            .background(Color.Black)
                    )
                }
            }
        }
    }
}

data class LikeNavItem(val route: String, val label: String)