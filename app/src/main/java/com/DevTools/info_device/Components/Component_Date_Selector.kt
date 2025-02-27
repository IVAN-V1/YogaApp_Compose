package com.DevTools.info_device.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

class Component_Date_Selector {

    @Composable
    fun DateSelector() {
        val today = Calendar.getInstance()

        val days = (0..5).map {
            Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, it) }
        }

        var selectedDate by remember { mutableStateOf(today) }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()

        ) {
            items(days) { date ->
                DateItem(date, selectedDate) { selectedDate = it }
            }
        }
    }

    @Composable
    fun DateItem(date: Calendar, selectedDate: Calendar, onClick: (Calendar) -> Unit) {
        val isSelected = date.get(Calendar.DAY_OF_YEAR) == selectedDate.get(Calendar.DAY_OF_YEAR)
        val backgroundColor = if (isSelected) Color(0xFF1EADFF) else Color(0xFFF1F3FA)
        val textColor = if (isSelected) Color.White else Color.Black

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(backgroundColor)
                .clickable { onClick(date) }
                .padding(vertical = 16.dp, horizontal = 16.dp)
        ) {
            val dayOfWeek = date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, java.util.Locale.getDefault()) ?: ""

            Text(text = dayOfWeek, color = textColor, fontSize = 14.sp)

            Text(
                text = date.get(Calendar.DAY_OF_MONTH).toString(),
                fontWeight = FontWeight.Bold,
                color = textColor,
                fontSize = 20.sp
            )
        }
    }



}