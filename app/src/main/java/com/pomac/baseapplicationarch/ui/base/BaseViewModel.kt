package com.pomac.baseapplicationarch.ui.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pomac.baseapplicationarch.domain.model.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

open class BaseViewModel : ViewModel() {


    protected fun <T>handleCommonErrors(error : Exception?) : ResultState<T> {
        if(error?.message?.contains("host",ignoreCase = true) == true){
            return ResultState.NetworkException(error.message)
        }
        val unExpectedErrMsg : String= if(Locale.getDefault().toString() == "en" ){
            "Something wrong please try again later !!"
        }else{
            "حدث خطا ما برجاء المحاولة مرة اخري"
        }
        Log.e("ApiError","Err : $error")
        return ResultState.Error(unExpectedErrMsg)
    }

    protected fun <T>asyncRequest(call : suspend () -> T, doOnMainThread : suspend (T)-> Unit, onError : suspend (Exception?) -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = call()
                withContext(Dispatchers.Main){
                    doOnMainThread(data)
                }
            }catch (e: Exception){
                e.printStackTrace()
                onError(e)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

}