package com.example.banquemisrchallenge05.utils.shared_components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.banquemisrchallenge05.R
import com.example.banquemisrchallenge05.utils.test_utils.TestTags

@Composable
fun BackButton(onBackClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 35.dp, start = 16.dp)
            .clickable {
                onBackClick()
            }.testTag(TestTags.BACK_BUTTON_TAG)
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            modifier = Modifier
                .size(45.dp),
            contentDescription = "back circle",
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(id = R.drawable.back_arrow),
            modifier = Modifier
                .size(25.dp),
            contentDescription = "back arrow",
            contentScale = ContentScale.Fit
        )
    }
}


