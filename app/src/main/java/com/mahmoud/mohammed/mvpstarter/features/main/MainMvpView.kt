package com.mahmoud.mohammed.mvpstarter.features.main

import com.mahmoud.mohammed.mvpstarter.features.base.MvpView

interface MainMvpView : MvpView {

    fun showPokemon(pokemon: List<String>)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}