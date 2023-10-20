package com.example.gramincare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gramincare.ui.theme.GramincareTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GramincareTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val onboardPageDetails = listOf(
//                        OnboardPage(
//                            R.drawable.lifesavers_handonboarding_1,
//                            "Registration of ASHA workers",
//                            "The digitalization of Asha workers in our app streamlines their workflow, allowing easy access to patient data, enabling real-time communication with healthcare professionals."
//                        ),
//                        OnboardPage(
//                            R.drawable.lifesavers_caretakingonboarding_2,
//                            "Delivery of medicines",
//                            "Our system empowers Asha workers to deliver medicines efficiently, ensuring timely access to essential medications for patients in rural areas. This initiative facilitates better health outcomes and increased healthcare accessibility"
//                        ),
//                        OnboardPage(
//                            R.drawable.lifesavers_new_patientonboarding_3,
//                            "First aid services",
//                            "Following audio calls during emergencies, Asha workers provide essential first aid services. Their prompt response and guidance play a vital role in stabilizing the situation, offering immediate care until professional medical assistance can be accessed."
//                        )
//                    )
//
//                    OnBoardPage(onboardPageDetails = onboardPageDetails)


                }
            }
        }
    }
}

//@Composable
//fun OnBoardPage(onboardPageDetails: List<OnboardPage>) {
//
//    var screenIndex = rememberSaveable {
//        mutableStateOf(0)
//    }
//
//    var pageDetail = onboardPageDetails[screenIndex.value];
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 20.dp),
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        Spacer(modifier = Modifier.size(5.dp))
//        TextButton(
//            modifier = Modifier.align(Alignment.End),
//            onClick = {
//                if (screenIndex.value < 3) {
//                    screenIndex.value = screenIndex.value + 1;
//                } else {
//
//                }
//
//            }) {
//            Text(text = "Skip")
//        }
//
//        Spacer(modifier = Modifier.size(10.dp))
//
//        Image(
//            contentScale = ContentScale.Fit,
//            painter = painterResource(id = pageDetail.drawableImage),
//            contentDescription = pageDetail.titleText,
//            modifier = Modifier.size(width = 343.dp, height = 350.dp)
//        )
//
//        Spacer(modifier = Modifier.size(40.dp))
//
//        Text(
//            text = pageDetail.titleText,
//            modifier = Modifier.fillMaxWidth(),
//            fontWeight = FontWeight.Bold,
//            fontSize = 32.sp,
//            color = Color(0xFF432C81),
//            textAlign = TextAlign.Center,
////            line spacing
//            lineHeight = 40.sp
//        )
//
//        Spacer(modifier = Modifier.size(20.dp))
//
//        Text(
//            text = pageDetail.bodyText,
//            modifier = Modifier.fillMaxWidth(),
//            fontSize = 16.sp,
//            color = Color(0xFF82799D),
//            textAlign = TextAlign.Center,
//            lineHeight = 24.sp
//        )
//
//
//        Spacer(modifier = Modifier.size(20.dp))
//
//
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            val spaceSize = 6.dp
//
//            Image(
//                painter = painterResource(id = if (screenIndex.value != 0) R.drawable.white_circle else R.drawable.dark_circle),
//                contentDescription = null,
//                modifier = Modifier.size(6.dp)
//            )
//            Spacer(Modifier.width(spaceSize))
//            Image(
//                painter = painterResource(id = if (screenIndex.value != 1) R.drawable.white_circle else R.drawable.dark_circle),
//                contentDescription = null,
//                modifier = Modifier.size(6.dp)
//            )
//            Spacer(Modifier.width(spaceSize))
//            Image(
//                painter = painterResource(id = if (screenIndex.value != 2) R.drawable.white_circle else R.drawable.dark_circle),
//                contentDescription = null,
//                modifier = Modifier.size(6.dp)
//            )
//
//        }
//
//        Spacer(modifier = Modifier.size(30.dp))
//
//        Button(
//            onClick = {
//                if (screenIndex.value < 3) {
//                    screenIndex.value = screenIndex.value + 1;
//                } else {
//
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp),
//            shape = RoundedCornerShape(10.dp),
//
//            ) {
//            Text(
//                modifier = Modifier.padding(vertical = 6.dp),
//                text = "Next",
//                fontSize = 16.sp,
//            )
//        }
//
//        Spacer(modifier = Modifier.size(30.dp))
//
//    }
//}
//
//data class OnboardPage(
//    val drawableImage: Int,
//    val titleText: String,
//    val bodyText: String
//)
//
//@Composable
//fun Dashboard() {
//    Text(
//        text = "This is the Dashboard Screen"
//    )
//}
