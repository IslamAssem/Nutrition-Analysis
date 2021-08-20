package com.banquemisr.usecases.datasource.remote.gateway
import com.banquemisr.entities.Resource
import retrofit2.Response
suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
    try {
        val response = call()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null)
                return Resource.success(body)
        }
        return error(response.message())
    } catch (e: Exception) {
        return error(e.message ?: e.toString())
    }
    /**
     *
     *     catch (exception: IOException) {
     *emit(Resource.error(data = null, message = exception.message ?: "IOException Occurred!"))
     *}catch (exception: TimeoutException) {
     *emit(Resource.error(data = null, message = exception.message ?: "TimeoutException Occurred!"))
     *}catch (exception: HttpException) {
     *emit(Resource.error(data = null, message = exception.message ?: "HttpException Occurred!"))
     *}
     */
}

private fun <T> error(message: String): Resource<T> {
    return Resource.error(message)
}