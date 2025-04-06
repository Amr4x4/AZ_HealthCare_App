package com.example.azhealthcare.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.azhealthcare.R
import com.example.azhealthcare.common_ui.BackgroundScreen
import com.example.azhealthcare.navegation.NavController
import com.example.azhealthcare.navegation.Screen
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    navController: NavController
) {
    val pagerState = rememberPagerState(initialPage = 0) { 4 }
    val coroutineScope = rememberCoroutineScope()

    val pages = listOf(
        OnboardingPage(R.drawable.oo, R.string.onboarding_title1, R.string.onboarding_description1),
        OnboardingPage(R.drawable.gg, R.string.onboarding_title2, R.string.onboarding_description2),
        OnboardingPage(R.drawable.op, R.string.onboarding_title3, R.string.onboarding_description3),
        OnboardingPage(R.drawable.uu, R.string.onboarding_title4, R.string.onboarding_description4)
    )

    BackgroundScreen()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingPageContent(page = pages[page])
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (pagerState.currentPage < pages.size - 1) {
                TextButton(
                    onClick = { navController.navigateTo(Screen.GetStartScreen.route) }
                ) {
                    Text(
                        text = stringResource(R.string.skip),
                        color = Color.White
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(1.dp))
            }

            Row {
                repeat(pages.size) { index ->
                    val color = if (pagerState.currentPage == index) Color.White else Color.Gray
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(8.dp)
                            .background(color = color, shape = RoundedCornerShape(4.dp))
                    )
                }
            }

            Button(
                onClick = {
                    if (pagerState.currentPage < pages.size - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    } else {
                        navController.navigateTo(Screen.GetStartScreen.route)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = if (pagerState.currentPage == pages.size - 1)
                        stringResource(R.string.get_started)
                    else
                        stringResource(R.string.next),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}
