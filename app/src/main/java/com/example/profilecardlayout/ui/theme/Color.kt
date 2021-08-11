package com.example.profilecardlayout.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

// use a color in a predefine components(surface for example) in Material theme
val CustomLightGrey = Color(0x60DCDCDC)
val customLightGreen200 = Color(0x9932CD32)
//appBar colors
val appBarTextColor = Color(0x60DCDCAD)
val appBarBgrColor = Color.Transparent

// extension for an own color for any component
val Colors.customLightGreen: Color
    @Composable
    get() = customLightGreen200

val Colors.appBarText: Color
    @Composable
    get() = appBarTextColor

val Colors.appBarBgr: Color
    @Composable
    get() = appBarBgrColor


