package com.pomac.baseapplicationarch.domain.di


import com.pomac.baseapplicationarch.data.service.Services
import com.pomac.baseapplicationarch.domain.repository.sampleRepository.SampleRepository
import com.pomac.baseapplicationarch.domain.repository.sampleRepository.SampleRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.annotation.Nullable


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providerUserRepo(services: Services) : SampleRepository {
        return SampleRepositoryImp(services)
    }
}

