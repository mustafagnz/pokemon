package com.example.pokemon.di

import com.example.pokemon.data.remote.PokeApi
import com.example.pokemon.repository.PokemonRepository
import com.example.pokemon.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(Singleton::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokemonRepository(
        api: PokeApi
    ) = PokemonRepository(api)


    //retrofit kullanılarak pokeApiye apiden bilgi çektiğimiz yer burasıdır. Constant sınıfından URL'i çekeriz.
    @Singleton
    @Provides
    fun providePokeApi(): PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java
            )
    }
}