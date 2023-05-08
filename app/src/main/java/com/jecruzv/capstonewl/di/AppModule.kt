package com.jecruzv.capstonewl.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.SavedStateHandle
import com.jecruzv.capstonewl.domain.usecases.GetMovieUseCase
import com.jecruzv.capstonewl.ui.viewmodels.MovieViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}