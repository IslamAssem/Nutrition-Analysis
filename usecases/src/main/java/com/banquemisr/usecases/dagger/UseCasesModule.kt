package com.banquemisr.usecases.dagger

import com.banquemisr.usecases.remote_datasource.abstraction.RemoteDataSource
import com.banquemisr.usecases.remote_datasource.gateway.BASE_URL
import com.banquemisr.usecases.remote_datasource.gateway.ServerGateway
import com.banquemisr.usecases.remote_datasource.implmentation.RemoteDataSourceImpl
import com.banquemisr.usecases.repositories.abstraction.Repository
import com.banquemisr.usecases.repositories.implmentation.RepositoryImpl
import com.banquemisr.usecases.usecases.abstraction.AnalyseUseCase
import com.banquemisr.usecases.usecases.implmentation.AnalyseUseCaseImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.sql.DataSource
import kotlin.reflect.KClass


@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Provides
    fun provideRetrofitService(retrofit: Retrofit): ServerGateway {
        return retrofit.create(ServerGateway::class.java)
    }

    @Provides
    fun provideRemoteDataSource(serverGateway: ServerGateway) : RemoteDataSource = RemoteDataSourceImpl(serverGateway)
    @Provides
    fun provideRepository(dataSource: RemoteDataSource) : Repository = RepositoryImpl(dataSource)
    @Provides
    fun provideUseCase(repository: Repository) : AnalyseUseCase = AnalyseUseCaseImpl(repository)

}