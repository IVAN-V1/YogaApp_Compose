package com.DevTools.info_device.View

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.DevTools.info_device.Components.Navigation_Bar
import com.DevTools.info_device.R
import kotlinx.coroutines.launch


class HomePage : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            CenterAlignedTopAppBarExample()
        }


    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CenterAlignedTopAppBarExample() {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
        val NavigaionBar_ = Navigation_Bar()

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
                    Text(
                        text = "Find your",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black,
                    )


                    Text(
                        text = "Workout Class",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )

                    NonEditableSearchBar()

                    Spacer(modifier = Modifier.height(12.dp))

                    ActivityCard()

                    Spacer(modifier = Modifier.height(12.dp))

                    RecomendationsClass()

                    Spacer(modifier = Modifier.height(12.dp))

                    YogaClassCard()

                    Spacer(modifier = Modifier.height(12.dp))

                    Categories()

                    Spacer(modifier = Modifier.height(12.dp))

                    WorkoutCardList()
                }
            }
        }
    }

}

@Composable
fun ActivityCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE6F5FF)), // Fondo azul claro
        shape = RoundedCornerShape(16.dp), // Bordes redondeados
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Today's \nactivity",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A) // Color oscuro para el título
                )

                Spacer(modifier = Modifier.height(16.dp)) // Reduce espacio entre el título y la hora

                Text(
                    text = "8.00 AM - 1.30 PM",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF8A8A8A) // Color gris claro para la hora
                )
            }

            Image(
                painter = painterResource(id = R.drawable.jogging1), // Sustituye con tu icono de zapatillas
                contentDescription = "Activity Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .alpha(0.5f) // Hace el icono más tenue
            )
        }
    }
}



@Composable
fun RecomendationsClass(){

    Row (Modifier.fillMaxWidth(), Arrangement.SpaceBetween){

        Text("Recomendations class",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("See all",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF48D0FE))

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

        Text("Categories",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        Spacer(modifier = Modifier.height(4.dp))

        Text("See all",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF48D0FE))

    }

}


@Composable
fun WorkoutCard(title: String, imageRes: Int, backgroundColor: Color) {

    val context = LocalContext.current



    Card(
        modifier = Modifier
            .width(140.dp)
            .height(240.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        onClick = {

            if (imageRes.let { it == R.drawable.war }) {



                }






        }

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

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
fun WorkoutCardList() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        WorkoutCard("Warm up", R.drawable.war, Color(0xFFE5F3FF))  // Azul claro
        WorkoutCard("Yoga", R.drawable.yoga_model, Color(0xFFF3F7FF))       // Blanco azulado
        WorkoutCard("Squats", R.drawable.squard, Color(0xFFFFE8D6))    // Beige claro
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NonEditableSearchBar() {

        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = "", // Texto vacío porque no es editable
            onQueryChange = { /* No hacer nada */ }, // No permitir cambios
            onSearch = { /* No hacer nada */ }, // No permitir búsqueda
            active = false, // Siempre inactivo
            onActiveChange = { /* No hacer nada */ }, // No permitir activación
            placeholder = {
                Text("Search...")
                          // Placeholder del campo de búsqueda
            },

            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Saeach",
                )
            },

            enabled = false // Deshabilitar la interacción
        ) {
            // Sin contenido adicional
        }
    }
