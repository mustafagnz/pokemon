package com.example.pokemon.data.remote
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface PokeApi {

    //burada get ile end_url'i belirledik. Bu api ucundan sayfaya gelecek olan veri sayısını buradan çekiyoruz.
    //20 şer tane gelcek.
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList //responsesten geliyor

    //diğer api ucunu da buradan aldık. Burada ise pokemona ait bilgiler gelecek.
    //pokemon adları değiştiği için name değişkenine atadık bu şekilde url de değişecek.
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon //responsesten geliyor
}