package id.sanggar.pair.di

import id.sanggar.pair.di.network.CallStateAdapterFactory
import id.sanggar.pair.di.network.util.ErrorMessageDelegate
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule constructor(
    private val errorMessage: ErrorMessageDelegate
) {

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    fun provideRetrofit(): Retrofit {
        val baseUrl = "https://isfa.dev/"

        return Retrofit.Builder()
            .client(provideOkHttpClient())
            .addCallAdapterFactory(CallStateAdapterFactory(errorMessage))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

}