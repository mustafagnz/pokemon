package com.example.pokemon.util


//Kullanıcı arayüzünde başarı ve hatalı durumlarını göstermek için 2 tane alt sınıf kullandık.
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}