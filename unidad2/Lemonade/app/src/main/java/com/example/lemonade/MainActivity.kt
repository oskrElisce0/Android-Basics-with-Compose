package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(                    containerColor = Color(0xFFFFEB3B)
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> LemonadeStep(
                    imageRes = R.drawable.lemon_tree,
                    description = "Tap the lemon tree to select a lemon",
                    onClick = {
                        currentStep = 2
                        squeezeCount = (2..4).random()
                    }
                )
                2 -> LemonadeStep(
                    imageRes = R.drawable.lemon_squeeze,
                    description = "Keep tapping the lemon to squeeze it",
                    onClick = {
                        squeezeCount--
                        if (squeezeCount == 0) currentStep = 3
                    }
                )
                3 -> LemonadeStep(
                    imageRes = R.drawable.lemon_drink,
                    description = "Tap the lemonade to drink it",
                    onClick = { currentStep = 4 }
                )
                4 -> LemonadeStep(
                    imageRes = R.drawable.lemon_restart,
                    description = "Tap the empty glass to start again",
                    onClick = { currentStep = 1 }
                )
            }
        }
    }
}

@Composable
fun LemonadeStep(
    imageRes: Int,
    description: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(Color(0xFFCCEA9E))
                .clickable { onClick() }
                .padding(32.dp)
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = description
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = description,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}