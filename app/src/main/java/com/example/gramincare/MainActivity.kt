package com.example.gramincare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gramincare.components.OnBoardPage
import com.example.gramincare.components.OnboardPage
import com.example.gramincare.ui.theme.GramincareTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GramincareTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    PageWithIndicator()

                    var isOnboarded by remember { mutableStateOf(false) }
//
////                    var showWelcome by remember { mutableStateOf(true) }
////
////                    LaunchedEffect(Unit) {
////                        delay(1000L)
////                        showWelcome = false
////                    }
////
////                    if (showWelcome) {
////                        WelcomePage()
////                    } else {
////                        LoginPage()
////                    }
//
                    val onboardPageDetails = listOf(
                        OnboardPage(
                            R.drawable.lifesavers_handonboarding_1,
                            "Registration of ASHA workers",
                            "The digitalization of Asha workers in our app streamlines their workflow, allowing easy access to patient data, enabling real-time communication with healthcare professionals."
                        ),
                        OnboardPage(
                            R.drawable.lifesavers_caretakingonboarding_2,
                            "Delivery of medicines",
                            "Our system empowers Asha workers to deliver medicines efficiently, ensuring timely access to essential medications for patients in rural areas. This initiative facilitates better health outcomes and increased healthcare accessibility"
                        ),
                        OnboardPage(
                            R.drawable.lifesavers_new_patientonboarding_3,
                            "First aid services",
                            "Following audio calls during emergencies, Asha workers provide essential first aid services. Their prompt response and guidance play a vital role in stabilizing the situation, offering immediate care until professional medical assistance can be accessed."
                        )
                    )

                    OnBoardPage(onboardPageDetails = onboardPageDetails)

                }
            }
        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageWithIndicator(){
    var pageCount = 4
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    HorizontalPager(
        state = pagerState
    ) { page ->
        // Our page content

        Box(
            modifier = Modifier.background(Color.Cyan).size(400.dp)
        ){
            Text(
                text = "Page: $page",
            )
        }

    }
    Row(
        Modifier
            .height(50.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        repeat(pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(20.dp)

            )
        }
    }
}



