package com.example.pokemon.repository

import com.example.pokemon.data.remote.PokeApi
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
){
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>{
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            //Resource sınıfından hata mesajını çektik ve mesajı belirttik
            return Resource.Error("Hata: getPokemonList")
        }
        //response içinde mesaj data olarak tutuluyor.
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo (pokemonName: String): Resource<Pokemon>{
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            //Resource sınıfından hata mesajını çektik ve mesajı belirttik
            return Resource.Error("Hata: getPokemonInfo")
        }
        //response içinde mesaj data olarak tutuluyor.
        return Resource.Success(response)
    }
}