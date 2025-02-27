package com.DevTools.info_device.Components
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class Component_BottomSheet {

@OptIn(ExperimentalMaterial3Api::class)
@Composable


  fun Button_Sheett() {
      val scope = rememberCoroutineScope()
      val scaffoldState = rememberBottomSheetScaffoldState()

      BottomSheetScaffold(
          scaffoldState = scaffoldState,
          sheetPeekHeight = 128.dp,
          sheetContent = {
              Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                  Box(Modifier.fillMaxWidth().height(128.dp), contentAlignment = Alignment.Center) {
                      Text("Swipe up to expand sheet")
                  }
                  Text("Sheet content")
                  Button(
                      modifier = Modifier.padding(bottom = 64.dp),
                      onClick = { scope.launch { scaffoldState.bottomSheetState.partialExpand() } }
                  ) {
                      Text("Click to collapse sheet")
                  }
              }
          }
      ) { innerPadding ->
          Box(
              modifier = Modifier.fillMaxSize().padding(innerPadding),
              contentAlignment = Alignment.Center
          ) {
              Text("Scaffold Content")
          }
      }
  }


}