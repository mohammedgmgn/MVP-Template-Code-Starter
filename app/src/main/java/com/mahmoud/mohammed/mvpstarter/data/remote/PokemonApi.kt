package com.mahmoud.mohammed.mvpstarter.data.remote


import com.mahmoud.mohammed.mvpstarter.data.model.Pokemon
import com.mahmoud.mohammed.mvpstarter.data.model.PokemonListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int): Single<PokemonListResponse>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Single<Pokemon>

}
