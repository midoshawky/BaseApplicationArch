package com.pomac.baseapplicationarch.domain.repository.sampleRepository

import com.pomac.baseapplicationarch.data.model.ResponseModel

interface SampleRepository {
    suspend fun fetchData() : ResponseModel<String>
}