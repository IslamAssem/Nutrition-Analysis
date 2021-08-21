package com.banquemisr.usecases.remote_datasource.gateway
import com.banquemisr.entities.Resource
import com.google.gson.Gson
import retrofit2.HttpException
import retrofit2.Response
suspend inline fun <reified T> getResult(call: suspend () -> Response<T>): Resource<T> {
    try {
        val response = call()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null)
                return Resource.success(body)
        }
        var errorData : T? = null
        try {
            if (response.errorBody() != null)
            errorData = Gson().fromJson(response.errorBody()!!.string(),T::class.java)
        }catch (e : Exception){

        }
        return error(response.message(),errorData)
    }catch (e : HttpException){
        return error(e.message ?: e.toString())
    }
    catch (e: Exception) {
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

fun <T> error(message: String): Resource<T> {
    return error(message,null)
}
fun <T> error(message: String,data : T?): Resource<T> {
    return Resource.error(message,data)
}