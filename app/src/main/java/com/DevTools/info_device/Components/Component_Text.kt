package com.DevTools.info_device.Components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class Component_Text {

    @Composable
    fun Component_text_Light(text: String) {

        Text(
            text = text,
            fontSize = 30.sp,
            fontWeight = FontWeight.Light,
            color = MaterialTheme.colorScheme.primary,
        )



    }


    @Composable
    fun Component_text_Bold(text: String , size: Int) {

        Text(
            text = text,
            fontSize = size.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
        )

    }



    @Composable
    fun Component_text__mediun(text: String) {

            Text("See all",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.tertiary,
            )


    }


}
