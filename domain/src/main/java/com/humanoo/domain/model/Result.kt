package com.humanoo.domain.model


sealed class Result<out T:Any> {
    data class Success<out T:Any>(val data:T):Result<T>()
    data class Error(val data:String):Result<Nothing>()
}