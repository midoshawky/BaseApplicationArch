package com.pomac.baseapplicationarch.domain.repository.sampleRepository

import com.pomac.baseapplicationarch.data.model.ResponseModel
import com.pomac.baseapplicationarch.data.service.Services
import org.jetbrains.annotations.NotNull
import javax.inject.Inject

class SampleRepositoryImp @Inject constructor(private val services: Services) : SampleRepository {

    override suspend fun fetchData(): ResponseModel<String> {
        return services.getData()
    }
}