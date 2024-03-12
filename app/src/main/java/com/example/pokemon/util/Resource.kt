package com.example.pokemon.util


//Kullanıcı arayüzünde başarı, hatalı ve yükleme durumlarını göstermek için 3 tane alt sınıf kullandık.
sealed class Resource <T>(val data: T? = null, message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)

    // error bir hata mesajı alabilir (message: string) ama success ve loading datayı gösterir.
    class Error<T>(message: String, data: T? =null) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)


}