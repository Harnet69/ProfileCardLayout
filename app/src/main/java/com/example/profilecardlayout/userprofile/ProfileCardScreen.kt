package com.example.profilecardlayout.userprofile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profilecardlayout.R
import com.example.profilecardlayout.ui.theme.customLightGreen

@Composable
fun ProfileCard(user: User) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top),
        elevation = 8.dp,
        border = BorderStroke(3.dp, Color.Black), backgroundColor = Color.Yellow
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            ProfilePicture(user.photo, user.isAvailable)
            ProfileContent(user.name, user.isAvailable)
        }
    }
}

@Composable
private fun ProfilePicture(userPhoto: Int, isAvailable: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = if(isAvailable)MaterialTheme.colors.customLightGreen else MaterialTheme.colors.error),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = userPhoto),
            contentDescription = "",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun ProfileContent(userName: String, isAvailable: Boolean) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = userName,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h4
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(if (isAvailable) R.drawable.ic_user_available else R.drawable.ic_user_disabled),
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .padding(4.dp),
                alignment = Alignment.Center
            )
            // add some transparency
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = if (isAvailable) "Active now" else "Unavailable",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}