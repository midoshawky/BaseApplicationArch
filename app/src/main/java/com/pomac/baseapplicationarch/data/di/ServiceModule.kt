package com.pomac.baseapplicationarch.data.di


import com.pomac.baseapplicationarch.data.service.Services
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.annotation.Nullable


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    fun provideSampleService(@Nullable retrofit: Retrofit?): Services{
        return retrofit!!.create(Services::class.java)
    }
}

