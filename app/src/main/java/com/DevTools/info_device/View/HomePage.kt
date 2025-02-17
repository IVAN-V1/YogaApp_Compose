package com.DevTools.info_device.View

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.DevTools.info_device.R
import com.n3t0l0b0.blogspot.mpc.view.searchbarcompose.MainViewModel

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

        val viewModel = MainViewModel()
        val searchText by viewModel.searchText.collectAsState()
        val isSearching by viewModel.isSearching.collectAsState()
        val countriesList by viewModel.countriesList.collectAsState()

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
        ) { innerPadding ->


            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = innerPadding.calculateTopPadding())
            ) {
                Text(
                    text = "Find your",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 2.dp) // Reduce espacio entre textos
                )

                Text(
                    text = "Workout Class",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp) // Reduce espacio entre este texto y el buscador
                )




                Spacer(modifier = Modifier.height(8.dp)) // Reduce espacio entre el buscador y el Card


            ActivityCard()

            Spacer(modifier = Modifier.height(16.dp)) // Reduce espacio entre el Card y la lista de recomendaciones

                RecomendationsClass()

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
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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








