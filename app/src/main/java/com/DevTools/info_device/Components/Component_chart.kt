package com.DevTools.info_device.Components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.abs

@Composable
fun Component_chart() {
    val points = listOf(
        ChartData(Offset(0f, 200f), "8AM", 50),
        ChartData(Offset(100f, 150f), "10AM", 84),
        ChartData(Offset(200f, 180f), "12PM", 60),
        ChartData(Offset(300f, 120f), "2PM", 100),
        ChartData(Offset(400f, 50f), "4PM", 74),
        ChartData(Offset(500f, 40f), "6PM", 80),
        ChartData(Offset(600f, 30f), "8PM", 34),
        ChartData(Offset(700f, 70f), "8PM", 34),
        ChartData(Offset(800f, 60f), "8PM", 34),
        ChartData(Offset(900f, 10f), "10PM", 34),
        ChartData(Offset(1000f, 10f), "12PM", 34)

    )

    var selectedPoint by remember { mutableStateOf<ChartData?>(null) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.height(220.dp).fillMaxWidth() ) {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .pointerInput(Unit) {
                        detectTapGestures { tapOffset ->
                            // Detectar punto más cercano
                            val nearest = points.minByOrNull { abs(it.position.x - tapOffset.x) }
                            if (nearest != null && abs(nearest.position.x - tapOffset.x) < 50) {
                                selectedPoint = nearest
                            }
                        }
                    }
            ) {
                val path = Path().apply {
                    moveTo(points.first().position.x, points.first().position.y)
                    for (i in 1 until points.size) {
                        lineTo(points[i].position.x, points[i].position.y)
                    }
                }

                // Dibujar la sombra debajo de la línea
                drawPath(
                    path = Path().apply {
                        addPath(path)
                        lineTo(points.last().position.x, size.height)
                        lineTo(points.first().position.x, size.height)
                        close()
                    },
                    color = Color(0xFFB3E5FC) // Sombra azul claro
                )

                // Dibujar la línea principal
                drawPath(
                    path = path,
                    color = Color(0xFF1BB0E3),
                    style = Stroke(width = 8f, cap = StrokeCap.Round, join = StrokeJoin.Round)
                )

                // Dibujar puntos en la línea
                points.forEach {
                    drawCircle(
                        color = Color(0xFF1BB0E3),
                        radius = 10f,
                        center = it.position
                    )
                }

                // Dibujar indicador seleccionado
                selectedPoint?.let { point ->
                    drawCircle(
                        color = Color.Red,
                        radius = 12f,
                        center = point.position
                    )
                }
            }

            // Mostrar etiqueta de calorías
            selectedPoint?.let { point ->
                Card(
                    modifier = Modifier
                        .offset(x = point.position.x.dp - 30.dp, y = 20.dp)
                        .wrapContentSize(),
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFE0CC))
                ) {
                    Text(
                        text = "${point.calories} cal",
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

        // Dibujar línea de tiempo
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            points.forEach {
                Text(
                    text = it.time,
                    style = TextStyle(fontSize = 12.sp, color = Color.DarkGray),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

data class ChartData(
    val position: Offset,
    val time: String,
    val calories: Int
)
