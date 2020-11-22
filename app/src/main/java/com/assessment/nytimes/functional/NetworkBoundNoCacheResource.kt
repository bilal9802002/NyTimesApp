package com.assessment.nytimes.functional

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

/**
 * A generic class that can provide a resource backed by network.
 */
abstract class NetworkBoundNoCacheResource<ResultType>(coroutineContext: CoroutineContext) {

    private val result: LiveData<Resource<ResultType>>

    init {
        result = liveData(context = coroutineContext + Dispatchers.IO) {
            emit(Resource.loading())
            try {
                emit(Resource.success(loadFromNetwork()))
            } catch (e: Exception) {
                emit(Resource.error(e.message ?: "Bad Response"))
            }
        }
    }

    abstract suspend fun loadFromNetwork(): ResultType

    fun asLiveData() = result
}
