package com.DevTools.info_device.Core.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.DevTools.info_device.View.Activity_page_screen
import com.DevTools.info_device.View.Home_screen
import com.DevTools.info_device.View.Warm_screen
import com.DevTools.info_device.View.Initial_Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigatioWrapper () {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Initial_page){

        composable<Initial_page>{

            Initial_Screen {navController.navigate(Home_page) }

        }

      composable<Home_page> {
          Home_screen(
              NavigationToActivity = { navController.navigate(Activity_page) },
              NavigationToWarmUp = { navController.navigate(Warm_up_page) }
          )
      }


        composable<Activity_page>{

            Activity_page_screen{navController.popBackStack()}


        }




        composable<Warm_up_page>{

            Warm_screen()


        }


    }


}


