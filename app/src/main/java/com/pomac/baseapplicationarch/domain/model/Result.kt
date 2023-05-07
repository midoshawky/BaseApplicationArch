package com.pomac.baseapplicationarch.domain.model

sealed class ResultState<out T> {
    object Loading : ResultState<Nothing>()
    object Initial : ResultState<Nothing>()

    data class Success<T>(val data: T?,val successMsg : String? = null,val status:Boolean? = false ) : ResultState<T>()
    data class Error(val error: String) : ResultState<Nothing>()
    data class AuthError(val error: String) : ResultState<Nothing>()
    data class NetworkException(val errorMsg : String?) : ResultState<Nothing>()
    data class EmptyData(val errorMsg : String?) : ResultState<Nothing>()
    object Complete : ResultState<Nothing>()

    override fun toString() : String {
        return when (this) {
            is Initial -> "Loading .. "
            is Loading -> "Loading .. "
            is Success -> "Success[$successMsg , data: $data]"
            is Error -> "Error [error: $error]"
            is NetworkException -> "Error [error: $errorMsg]"
            is EmptyData ->  "Error [error: $errorMsg]"
            is AuthError ->  "Error [error: $error]"
            is Complete -> "Complete .."
        }
    }
}