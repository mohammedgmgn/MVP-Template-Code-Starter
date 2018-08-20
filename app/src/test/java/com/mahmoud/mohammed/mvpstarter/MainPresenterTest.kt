package com.mahmoud.mohammed.mvpstarter

import com.nhaarman.mockito_kotlin.*
import com.mahmoud.mohammed.mvpstarter.common.TestDataFactory
import com.mahmoud.mohammed.mvpstarter.data.DataManager
import com.mahmoud.mohammed.mvpstarter.features.main.MainMvpView
import com.mahmoud.mohammed.mvpstarter.features.main.MainPresenter
import com.mahmoud.mohammed.mvpstarter.util.RxSchedulersOverrideRule
import io.reactivex.Single
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyBoolean
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by Siko on 24/12/16.
 */
@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    val pokemonList = TestDataFactory.makePokemonNamesList(10)

    val mockMainMvpView: MainMvpView = mock()
    val mockDataManager: DataManager = mock {
        on { getPokemonList(10) } doReturn Single.just(pokemonList)
        on { getPokemonList(5) } doReturn Single.error<List<String>>(RuntimeException())
    }
    private var mainPresenter: MainPresenter? = null

    @JvmField
    @Rule
    val overrideSchedulersRule = RxSchedulersOverrideRule()

    @Before
    fun setUp() {
        mainPresenter = MainPresenter(mockDataManager)
        mainPresenter?.attachView(mockMainMvpView)
    }

    @After
    fun tearDown() {
        mainPresenter?.detachView()
    }

    @Test
    @Throws(Exception::class)
    fun getPokemonReturnsPokemonNames() {

        mainPresenter?.getPokemon(10)

        verify(mockMainMvpView, times(2)).showProgress(anyBoolean())
        verify(mockMainMvpView).showPokemon(pokemonList)
        verify(mockMainMvpView, never()).showError(RuntimeException())

    }

    @Test
    @Throws(Exception::class)
    fun getPokemonReturnsError() {

        mainPresenter?.getPokemon(5)

        verify(mockMainMvpView, times(2)).showProgress(anyBoolean())
        verify(mockMainMvpView).showError(any())
        verify(mockMainMvpView, never()).showPokemon(any())
    }
}