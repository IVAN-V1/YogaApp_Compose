package com.DevTools.info_device.View

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.DevTools.info_device.Components.Component_Date_Selector
import com.DevTools.info_device.Components.Component_Text
import com.DevTools.info_device.Components.Component_chart
import com.DevTools.info_device.ViewModel.List_
import com.DevTools.info_device.ui.theme.Info_deviceTheme

@ExperimentalMaterial3Api
@Composable
fun Activity_page_screen(NavigationToBack :() -> Unit) {

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val text= Component_Text()
    val list_activity= List_()


    Info_deviceTheme {


        Scaffold (modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),


            topBar = {



                CenterAlignedTopAppBar(

                    title = {
                        Text(
                            text = "",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary,
                            textAlign = TextAlign.Center,
                        )
                    },

                    navigationIcon = {


                        IconButton(onClick = {

                            NavigationToBack()

                        }) {

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }

                    },


                    actions = {

                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "Back"
                            )
                        }


                    }


                )
            }


        ) { innerPadding ->


            Column (modifier =

            Modifier
                .padding(innerPadding)
                .fillMaxSize()) {

                Column (modifier = Modifier.padding(horizontal = 16.dp)) {

                    text.Component_text_Bold("Your Activities",35)

                    Spacer(modifier = Modifier.height(16.dp))

                    text.Component_text_Bold("This week",25)


                    Spacer(modifier = Modifier.height(16.dp))


                    Component_Date_Selector().DateSelector()

                    Spacer(modifier = Modifier.height(16.dp))

                    text.Component_text_Bold("1680 kcal",18)

                    Component_chart()


                    Spacer(modifier = Modifier.height(16.dp))

                    list_activity.List_activitys()


                }


            }




        }



    }


}
