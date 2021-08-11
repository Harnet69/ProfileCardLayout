package com.example.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecardlayout.ui.theme.MyTheme
import com.example.profilecardlayout.ui.theme.appBarBgr
import com.example.profilecardlayout.ui.theme.appBarText
import com.example.profilecardlayout.ui.theme.customLightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    // container for app bar
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column {
                ProfileCard()
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(navigationIcon = {
        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu Btn"
            )
        }
    },
        backgroundColor = MaterialTheme.colors.appBarBgr,
        contentColor = MaterialTheme.colors.appBarText,
        elevation = 2.dp,
        title = { Text(text = "Users Profiles") }
    )
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 4.dp, start = 16.dp, end = 16.dp )
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
            ProfilePicture()
            ProfileContent()
        }
    }
}

@Composable
fun ProfilePicture() {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = MaterialTheme.colors.customLightGreen),
        modifier = Modifier.padding(16.dp),
        elevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_ico),
            contentDescription = "",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "John Doe",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h4
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_user_available),
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp)
                    .padding(4.dp),
                alignment = Alignment.Center
            )
            // add some transparency
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = "Active now",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        MainScreen()
    }
}