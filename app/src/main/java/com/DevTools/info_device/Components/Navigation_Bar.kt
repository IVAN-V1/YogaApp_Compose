package com.DevTools.info_device.Components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.DevTools.info_device.R

class Navigation_Bar {

    @Composable
    fun NavigaionBar_(){

        var selectedItem by remember { mutableIntStateOf(0) }
        val items = listOf("Songs", "Artists", "Playlists","")
        val selectedIcons = listOf(
            ImageVector.vectorResource(id = R.drawable.home_icon), // ic_home es un icono en tu drawable
            ImageVector.vectorResource(id = R.drawable.graph), // ic_favorite es otro icono
            ImageVector.vectorResource(id = R.drawable.user),
            ImageVector.vectorResource(id = R.drawable.settings),


// ic_star es otro icono
        )

        val unselectedIcons =
            listOf(
                ImageVector.vectorResource(id = R.drawable.home_icon), // ic_home es un icono en tu drawable
                ImageVector.vectorResource(id = R.drawable.graph), // ic_favorite es otro icono
                ImageVector.vectorResource(id = R.drawable.user),
                ImageVector.vectorResource(id = R.drawable.settings),

                )

        NavigationBar (containerColor = Color.White) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                            contentDescription = item
                        )
                    },

                    selected = selectedItem == index,
                    onClick = { selectedItem = index }
                )
            }
        }


    }



}