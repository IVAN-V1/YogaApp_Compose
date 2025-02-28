package com.DevTools.info_device.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.DevTools.info_device.Components.Component_Card
import com.DevTools.info_device.Components.Component_Navigation_Bar
import com.DevTools.info_device.Components.Component_Text
import com.DevTools.info_device.R
import com.DevTools.info_device.ui.theme.Info_deviceTheme
import com.DevTools.info_device.ui.theme.background


@Composable
@Preview

fun Warm_screen() {



    Info_deviceTheme {

        val Tex_bold = Component_Text()


            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()) // Agrega scroll
                        .padding(horizontal = 0.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp) // Espaciado uniforme
                ) {


                    Image(
                        painter = painterResource(id = R.drawable.warm_up), // Reemplaza con tu imagen
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp)
                            ),
                        contentScale = ContentScale.Crop,

                        )

                    Spacer(modifier = Modifier.height(8.dp))


                    Column (modifier = Modifier.fillMaxWidth().padding(16.dp)) {

                        Tex_bold.Component_text_Bold("Warm up",30)

                        Spacer(Modifier.padding(8.dp))


                        Text(
                            "Warm up properly before exercising to prevent \u2028injury and make your workouts more effective.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )


                        Spacer(modifier = Modifier.height(16.dp))


                        ExerciseList()

                    }




                }

        }


            }
        }




data class Exercise(val id: Int, val name: String, val duration: String, val imageRes: Int)

val exercises = listOf(
    Exercise(1, "Exercise 1", "02:30 Minutes", R.drawable.exercise1),
    Exercise(2, "Exercise 2", "02:00 Minutes", R.drawable.exercise2),
    Exercise(3, "Exercise 3", "03:20 Minutes", R.drawable.exercise3),
    Exercise(4, "Exercise 4", "03:20 Minutes", R.drawable.exercise1),
    Exercise(5, "Exercise 5", "03:20 Minutes", R.drawable.exercise2)


)

@Composable
fun ExerciseList() {
    Column() {

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFDFF1FF), shape = RoundedCornerShape(8.dp))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("⏳ 10.00 mins", fontSize = 16.sp,
                    color = Color(0xFF0095FF),
                    fontWeight = FontWeight.Bold)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color(0xFFFFE5D5), shape = RoundedCornerShape(8.dp))
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("🏃 Running", fontSize = 16.sp,
                    color = Color(0xFFFF6B00),
                    fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Exercises", fontSize = 25.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            exercises.forEach { exercise ->

               Card(
                   modifier = Modifier
                       .fillMaxWidth().
                   padding(vertical = 8.dp),
                   shape = RoundedCornerShape(8.dp),
                   colors = CardDefaults.cardColors(
                       containerColor = Color.White
                   )
               ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = exercise.imageRes),
                            contentDescription = exercise.name,
                            modifier = Modifier.size(100.dp).clip(RoundedCornerShape(8.dp))
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(exercise.name, fontSize = 18.sp,)
                            Text(exercise.duration, fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.primary)
                        }

                        IconButton(
                            onClick = { /* Acción de favorito */ },
                            modifier = Modifier
                                .size(40.dp)
                                .background(color = Color(0xFFC5D9E8), shape = CircleShape)
                        ) {
                            Icon(
                                Icons.Filled.PlayArrow, // Ícono de corazón
                                contentDescription = "Favorite",
                                tint = Color(0xFF1BB0E3), // Azul
                                modifier = Modifier.size(30.dp)
                            )

                        }
                    }
                }
            }
        }
    }
}






