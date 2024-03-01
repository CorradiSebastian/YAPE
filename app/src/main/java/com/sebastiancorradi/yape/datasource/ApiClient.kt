package com.sebastiancorradi.yape.datasource

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.ssl.TrustManager

/*object ApiClient {

    private val httpClient : OkHttpClient = OkHttpClient()

    //api users not used for the moment but intended for the future.
    private val companies: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(EndpointService.fromPath("/companies-service/"))
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                httpClient.newBuilder()
                    //.addInterceptor(RequestInterceptor())
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .build()
            )
            .build()
    }


    val saleReceiptRepository: SaleReceiptRepository by lazy {
        companies.create(SaleReceiptRepository::class.java)
    }

}*/

object RetrofitClient {
    private const val BASE_URL = "https://demo6387585.mockable.io/"

    val intercepter = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
    val client = OkHttpClient.Builder().apply {
        this.addInterceptor(intercepter)
            // time out setting
            .connectTimeout(3,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(25,TimeUnit.SECONDS)

    }.build()


    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
}

