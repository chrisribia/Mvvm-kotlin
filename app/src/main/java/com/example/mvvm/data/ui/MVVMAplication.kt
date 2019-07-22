package com.example.mvvm.data.ui

import android.app.Application
import com.example.mvvm.data.ui.data.db.entites.AppDatabase
import com.example.mvvm.data.ui.data.network.MyApi
import com.example.mvvm.data.ui.data.network.NetworkConnectionInterceptor
import com.example.mvvm.data.ui.data.preferences.PreferencesProvider
import com.example.mvvm.data.ui.data.repositories.QuotesRepository
import com.example.mvvm.data.ui.data.repositories.UserRepository
import com.example.mvvm.data.ui.profile.ProfileViewModelFactory
import com.example.mvvm.data.ui.ui.auth.AuthViewModelFactory
import com.example.mvvm.data.ui.ui.auth.Quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMAplication : Application(), KodeinAware{
    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMAplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton {AppDatabase(instance())}
        bind() from singleton {PreferencesProvider(instance())}
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from singleton { QuotesRepository(instance(),instance(),instance()) }
        bind() from provider {AuthViewModelFactory(instance())}
        bind() from provider { ProfileViewModelFactory(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }
    }

}