package com.mahmoud.mohammed.mvpstarter.injection.component

import android.app.Application
import android.content.Context
import dagger.Component
import com.mahmoud.mohammed.mvpstarter.data.DataManager
import com.mahmoud.mohammed.mvpstarter.data.remote.PokemonApi
import com.mahmoud.mohammed.mvpstarter.injection.ApplicationContext
import com.mahmoud.mohammed.mvpstarter.injection.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun dataManager(): DataManager

    fun pokemonApi(): PokemonApi
}
