package com.example.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.profilecardlayout.ui.theme.MyTheme
import com.example.profilecardlayout.userprofile.User

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainScreen(arrayListOf(
                    //TODO Mocked Users
                    User(name = "John Doe", photo = R.drawable.profile_ico, isAvailable = false),
                            User(name = "Jack Rasel", photo = R.drawable.profile_ico, isAvailable = true)))
            }
        }
    }
}