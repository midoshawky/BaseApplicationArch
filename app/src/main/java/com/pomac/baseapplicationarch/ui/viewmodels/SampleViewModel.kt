package com.pomac.baseapplicationarch.ui.viewmodels

import com.pomac.baseapplicationarch.domain.model.ResultState
import com.pomac.baseapplicationarch.domain.useCase.GetSampleDataUseCase
import com.pomac.baseapplicationarch.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(private val sampleDataUseCase: GetSampleDataUseCase) : BaseViewModel() {
    private val _dataFlow : MutableSharedFlow<ResultState<String>> = MutableSharedFlow()
    val dataFlow : SharedFlow<ResultState<String>> = _dataFlow

    fun getSampleData(){
        asyncRequest(
            call = { sampleDataUseCase.invoke() }
            , doOnMainThread = {
                _dataFlow.emit(it)
            }
            , onError = {
                _dataFlow.emit(handleCommonErrors(it))
            })
    }
}