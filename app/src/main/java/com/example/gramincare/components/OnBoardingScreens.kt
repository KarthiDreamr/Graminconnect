package com.example.gramincare.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardPage(
    onboardPageDetails: List<OnboardPage>,
    finishOnboarding: () -> Unit,
    navController: NavController
) {

    val pageCount = 3
    val pagerState = rememberPagerState { onboardPageDetails.size }
    val screenIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    var page = onboardPageDetails[screenIndex.value]
    HorizontalPager(state = pagerState) { pageIndex ->
        // Our page content

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.size(5.dp))
            TextButton(
                modifier = Modifier.align(Alignment.End),
                onClick = {
                    finishOnboarding()
                    navController.navigate("welcomePage")
                }) {
                Text(text = "Skip")
            }

            Spacer(modifier = Modifier.size(10.dp))

            Image(
                contentScale = ContentScale.Fit,
                painter = painterResource(id = onboardPageDetails[pageIndex].drawableImage),
                contentDescription = onboardPageDetails[pageIndex].titleText,
                modifier = Modifier.size(width = 343.dp, height = 350.dp)
            )

            Spacer(modifier = Modifier.size(40.dp))

            Text(
                text = onboardPageDetails[pageIndex].titleText,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color(0xFF432C81),
                textAlign = TextAlign.Center,
//            line spacing
                lineHeight = 40.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = onboardPageDetails[pageIndex].bodyText,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                color = Color(0xFF82799D),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.size(10.dp))

            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                repeat(pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(10.dp)

                    )
                }
            }

            Spacer(modifier = Modifier.size(10.dp))

            val couroutineScope = rememberCoroutineScope()
            Button(
                onClick = {
                    if (pageIndex == 2) {
                        finishOnboarding()
                        navController.navigate("welcomePage")
                    } else {
                        couroutineScope.launch {
                            pagerState.scrollToPage(pageIndex + 1)
                        }
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(10.dp),

                ) {

                if (pageIndex == 2) {
                    Text(
                        modifier = Modifier.padding(vertical = 6.dp),
                        text = "Get Started",
                        fontSize = 16.sp,
                    )
                } else {
                    Text(
                        modifier = Modifier.padding(vertical = 6.dp),
                        text = "Next",
                        fontSize = 16.sp,
                    )
                }

            }

            Spacer(modifier = Modifier.size(10.dp))

        }
    }//HorizontalPager


}

data class OnboardPage(
    val drawableImage: Int,
    val titleText: String,
    val bodyText: String
)
