package com.example.banquemisrchallenge05.utils.shared_components

import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisrchallenge05.R
import com.example.weather.utils.managers.InternetChecker

@Composable
fun NoInternetScreen() {
    val context = LocalContext.current

    var isConnected by remember { mutableStateOf(false) }

    fun checkInternetConnection() {
        isConnected = InternetChecker(context).isInternetAvailable()
    }

    LaunchedEffect(Unit) {
        checkInternetConnection()
    }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp)
        ) {
            CustomLottieAnimation(
                lottieRawRes = R.raw.no_internet,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Text(
            text = stringResource(id = R.string.no_internet_title),
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.no_internet_message),
            modifier = Modifier.padding(horizontal = 16.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
                context.startActivity(intent)
            }
        ) {
            Text(text = stringResource(id = R.string.turn_on_wifi))
        }

        if (isConnected) {
            Text(
                text = stringResource(id = R.string.connection_restored),
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
