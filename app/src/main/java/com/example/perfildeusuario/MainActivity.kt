package com.example.perfildeusuario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.OutlinedTextField

// colores
val PinkSoft = Color(0xFFD88A8A)
val GrayDark = Color(0xFF474843)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp() {
    var searchText by remember { mutableStateOf("") }

    // Listas de imágenes
    val moviesRecommended = listOf(
        R.drawable.pelicula1,
        R.drawable.pelicula2,
        R.drawable.pelicula3,
        R.drawable.pelicula4
    )

    val moviesPopular = listOf(
        R.drawable.pelicula5,
        R.drawable.pelicula7,
        R.drawable.pelicula6
    )

    Scaffold(
        containerColor = GrayDark,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mis Pelis",
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Black,
                        fontSize = 24.sp,
                        fontStyle = FontStyle.Italic,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PinkSoft
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = GrayDark) {
                NavigationBarItem(
                    selected = true,
                    onClick = { },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    label = { Text("Inicio", fontFamily = FontFamily.Cursive) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = PinkSoft,
                        selectedTextColor = PinkSoft,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
                    label = { Text("Buscar", fontFamily = FontFamily.Cursive) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = PinkSoft,
                        selectedTextColor = PinkSoft,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White
                    )
                )
                NavigationBarItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
                    label = { Text("Perfil", fontFamily = FontFamily.Cursive) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = PinkSoft,
                        selectedTextColor = PinkSoft,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White
                    )
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(GrayDark)
                .padding(16.dp)
        ) {
            // Barra de búsqueda
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Buscar película",
                    color = PinkSoft,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 24.sp) },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PinkSoft,
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    cursorColor = PinkSoft
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Chips de géneros
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                AssistChip(
                    onClick = { },
                    label = { Text("Acción",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp) },
                    colors = AssistChipDefaults.assistChipColors(containerColor = PinkSoft)
                )
                AssistChip(
                    onClick = { },
                    label = { Text("Comedia",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp) },
                    colors = AssistChipDefaults.assistChipColors(containerColor = PinkSoft)
                )
                AssistChip(
                    onClick = { },
                    label = { Text("Romance",
                        fontFamily = FontFamily.Cursive,
                        fontSize = 20.sp) },
                    colors = AssistChipDefaults.assistChipColors(containerColor = PinkSoft)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Lista horizontal
            Text(
                text = "Recomendadas",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(moviesRecommended) { movie ->
                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(220.dp),
                        colors = CardDefaults.cardColors(containerColor = GrayDark)
                    ) {
                        Image(
                            painter = painterResource(id = movie),
                            contentDescription = "Movie poster",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Lista horizontal
            Text(
                text = "Populares",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = FontFamily.Cursive
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(moviesPopular) { movie ->
                    Card(
                        modifier = Modifier
                            .width(150.dp)
                            .height(220.dp),
                        colors = CardDefaults.cardColors(containerColor = GrayDark)
                    ) {
                        Image(
                            painter = painterResource(id = movie),
                            contentDescription = "Movie poster",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieApp() {
    MovieApp()
}
