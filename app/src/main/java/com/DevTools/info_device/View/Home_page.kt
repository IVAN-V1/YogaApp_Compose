package com.DevTools.info_device.View

import Component_SearchBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.DevTools.info_device.Components.Component_Card
import com.DevTools.info_device.Components.Component_Navigation_Bar
import com.DevTools.info_device.Components.Component_Text
import com.DevTools.info_device.R
import com.DevTools.info_device.ui.theme.Info_deviceTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home_screen(NavigationToActivity: () -> Unit, NavigationToWarmUp: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val NavigaionBar_ = Component_Navigation_Bar()

    //obtener context de la actividad
    val context = LocalContext.current

    val component_Search= Component_SearchBar()


    Info_deviceTheme {

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Color(0xFFFFFFFF),
                        titleContentColor = Color(0xFF000000),
                    ),
                    title = {
                        Text(
                            "Hello, Adam Smith",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },

                    navigationIcon = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.List,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Image(
                                painter = painterResource(id = R.drawable.avatar),
                                contentDescription = "Localized description",
                                modifier = Modifier.size(40.dp) // Reducir tamaño del avatar
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            },
            bottomBar = {
                NavigaionBar_.NavigaionBar_()
            }
        ) { innerPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // Asegura que el contenido no se superponga con la AppBar
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()) // Agrega scroll
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp) // Espaciado uniforme
                ) {

                    val text= Component_Text()


                    text.Component_text_Light("Find your")

                    text.Component_text_Bold("Workout Class",30)

                    Spacer(modifier = Modifier.height(12.dp))

                    component_Search.Material3SearchBar()


                    Spacer(modifier = Modifier.height(12.dp))


                    val card_= Component_Card()
                    card_.ActivityCard(NavigationToActivity)


                    Spacer(modifier = Modifier.height(12.dp))

                    RecomendationsClass()

                    Spacer(modifier = Modifier.height(12.dp))

                    YogaClassCard()

                    Spacer(modifier = Modifier.height(12.dp))

                    Categories()

                    Spacer(modifier = Modifier.height(12.dp))

                    WorkoutCardList(NavigationToWarmUp)
                }
            }
        }

    }



}


@Composable
fun RecomendationsClass(){

    Row (Modifier.fillMaxWidth(), Arrangement.SpaceBetween){

        val text = Component_Text()

        text.Component_text_Bold("Recomendations Class",20)

        Spacer(modifier = Modifier.height(4.dp))


        text.Component_text__mediun("See all")


    }


}


@Composable
fun YogaClassCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF1F3FA)), // Fondo claro
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = {}
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.yoga), // Reemplaza con tu imagen
                contentDescription = "Yoga Class",
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {

                Text(
                    text = "Yoga Class",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0B2E40) // Azul oscuro
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "With Rachael Wisdom",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF8A9BAE) // Azul grisáceo
                )
            }

            IconButton(
                onClick = { /* Acción de favorito */ },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    Icons.Outlined.FavoriteBorder, // Ícono de corazón
                    contentDescription = "Favorite",
                    tint = Color(0xFF78A1C6), // Azul
                    modifier = Modifier.size(20.dp)
                )

            }


        }
    }
}



@Composable
fun Categories(){

    Row (Modifier.fillMaxWidth(), Arrangement.SpaceBetween){

        val text= Component_Text()

        text.Component_text_Bold("Categories",20)

        Spacer(modifier = Modifier.height(4.dp))

        text.Component_text__mediun(R.string.Categories.toString())


    }

}


@Composable
fun WorkoutCard(title: String, imageRes: Int, backgroundColor: Color, NavigationToWarmup: () -> Unit) {
    val Tex_bold = Component_Text()

    Card(
        modifier = Modifier
            .width(140.dp)
            .height(240.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = {
            if (imageRes == R.drawable.war) {

                NavigationToWarmup()

            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Tex_bold.Component_text_Bold(title, 18)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
        }
    }



}
@Composable
fun WorkoutCardList(NavigationToWarmup: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        WorkoutCard("Warm up", R.drawable.war, Color(0xFFE5F3FF),NavigationToWarmup)  // Azul claro
        WorkoutCard("Yoga", R.drawable.yoga_model, Color(0xFFF3F7FF),NavigationToWarmup)       // Blanco azulado
        WorkoutCard("Squats", R.drawable.squard, Color(0xFFFFE8D6),NavigationToWarmup)    // Beige claro
    }
}




