package com.aagamshah.data.utils

import com.aagamshah.data.BuildConfig
import com.aagamshah.domain.util.DataError
import kotlinx.serialization.SerializationException
import java.io.IOException

fun Exception.mapExceptionToError(): DataError {

    if (BuildConfig.DEBUG) {
        this.printStackTrace()
    }

    return when (this) {
        is IOException -> DataError.Network
        is SerializationException -> DataError.Serialization
        else -> DataError.Unknown(this.message ?: "Unknown Error")
    }
}