package com.pomac.baseapplicationarch.domain.useCase

import com.pomac.baseapplicationarch.domain.model.ResultState
import com.pomac.baseapplicationarch.domain.repository.sampleRepository.SampleRepository
import javax.inject.Inject

class GetSampleDataUseCase @Inject constructor(private val sampleRepository : SampleRepository) {
    suspend operator fun invoke(): ResultState<String> {
        val response = sampleRepository.fetchData()
        return if(response.status || response.errors == null) ResultState.Success(response.data) else ResultState.Error("Error Here")
    }
}
