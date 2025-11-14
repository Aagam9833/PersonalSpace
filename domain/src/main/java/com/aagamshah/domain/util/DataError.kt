package com.aagamshah.domain.util

sealed interface DataError {
    data object Network : DataError
    data object Server : DataError
    data object Serialization : DataError
    data class Unknown(val message: String) : DataError
}
