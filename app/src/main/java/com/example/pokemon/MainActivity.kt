package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.pokemonlist.PokemonListScreen
import com.example.pokemon.ui.theme.PokemonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "pokemon_list_screen") {
                composable("pokemon_list_screen") {
                    PokemonListScreen(navController = navController)
                }
                //Detay sayfasına göndereceğimiz bilgileri argumentste liste şeklinde belirliyoruz.
                composable("pokemon_detail_screen/{dominantColor}/{pokemonName}",
                    arguments = listOf(
                        navArgument("dominantColor") {
                            type = NavType.IntType
                        },
                        navArgument("pokemonName") {
                            type = NavType.StringType
                        }
                    )
                ) {
                    val dominantColor = remember{
                        val color = it.arguments?.getInt("dominantColor")
                        color?.let { Color(it) }?: Color.White
                    }
                    val pokemonName = remember {
                        it.arguments?.getString("pokemonName")
                    }
                }
            }
        }
    }

}

