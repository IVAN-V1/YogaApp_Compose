package com.DevTools.info_device.ViewModel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.DevTools.info_device.Models.Model_Activity

class List_ {

    val activities = listOf(

        Model_Activity("Running", 0, "10:00 - 11:00", 1.5, 10.0),
        Model_Activity("Swimming", 1, "11:00 - 12:00", 2.5, 20.0),
        Model_Activity("Walking", 2, "12:00 - 13:00", 3.5, 30.0),
    )


    @Composable
    fun ActivityCard(activity: Model_Activity) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp).
            height(120.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE6D5)),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "🏃 ${activity.name}",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF8000)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "• ${activity.timeRange}", color = Color(0xFFFF8000))
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(
                        text = "${activity.duration}",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(text = "hours",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 16.dp))

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = "${activity.distance}",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = " kilometers",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }
    }


    @Composable
    fun List_activitys() {


        LazyColumn(modifier = Modifier.fillMaxSize()) {


            items(activities) { Model_Activity ->

                ActivityCard(Model_Activity)

            }


        }


    }

}


