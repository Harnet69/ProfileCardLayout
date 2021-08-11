package com.example.profilecardlayout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profilecardlayout.ui.theme.MyTheme
import com.example.profilecardlayout.ui.theme.appBarBgr
import com.example.profilecardlayout.ui.theme.appBarText
import com.example.profilecardlayout.userprofile.ProfileCard
import com.example.profilecardlayout.userprofile.User

@Composable
fun MainScreen(usersList: ArrayList<User>) {
    // container for app bar
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column {
                usersList.forEach {
                    ProfileCard(it)
                }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        MainScreen(arrayListOf(
            //TODO Mocked Users
            User(name = "John Doe", photo = R.drawable.profile_ico, isAvailable = false),
            User(name = "Jack Rasel", photo = R.drawable.profile_ico, isAvailable = true)))
    }
}