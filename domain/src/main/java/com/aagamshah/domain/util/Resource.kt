package com.aagamshah.domain.util

sealed class Resource<T>(val data: T? = null, val error: DataError? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(error: DataError, data: T? = null) : Resource<T>(data, error)
    class Loading<T>(data: T? = null) : Resource<T>(data)
}