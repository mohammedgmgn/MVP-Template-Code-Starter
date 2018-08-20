package com.mahmoud.mohammed.mvpstarter.features.detail

import com.mahmoud.mohammed.mvpstarter.data.model.Pokemon
import com.mahmoud.mohammed.mvpstarter.data.model.Statistic
import com.mahmoud.mohammed.mvpstarter.features.base.MvpView

interface DetailMvpView : MvpView {

    fun showPokemon(pokemon: Pokemon)

    fun showStat(statistic: Statistic)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}