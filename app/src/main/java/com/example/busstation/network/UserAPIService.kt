package com.example.busstation.network


import com.example.busstation.data2.BankAccount
import com.example.busstation.data2.Driver
import com.example.busstation.data2.TransportInfo
import com.example.busstation.data2.User
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface UserAPIService {
    
    @GET("users/{name}")
    fun getUserByName(@Path("name") name:String): Deferred<Response<User>>
    @GET("users")
    fun getAllUsers():Deferred<Response<List<User>>>

    @POST("users/save")
    fun insertUser(@Body user:User):Deferred<Response<User>>
    ////Driver
    @GET("drivers/{name}")
    fun getDriverByName(@Path("name") name:String): Deferred<Response<Driver>>
    @GET("drivers")
    fun getAllDrivers():Deferred<Response<List<Driver>>>

    @POST("drivers/save")
    fun insertDriver(@Body driver:Driver):Deferred<Response<Driver>>
    /////BankAccount
    @GET("accounts/{accno}")
    fun getAccountByAccountNumber(@Path("accno") accno:String): Deferred<Response<BankAccount>>
    @GET("accounts")
    fun getAllAccounts():Deferred<Response<List<BankAccount>>>

    @PUT("accounts/save")
    fun updateAccount(@Body account:BankAccount):Deferred<Response<BankAccount>>
    ///TransportInfo
    @GET("infos/{id}")
    fun getTInfoByDriverId(@Path("id") id:String): Deferred<Response<TransportInfo>>
    @GET("infos")
    fun getAllTInfos():Deferred<Response<List<TransportInfo>>>

    @POST("infos/save")
    fun insertTInfo(@Body info:TransportInfo):Deferred<Response<TransportInfo>>



    companion object{
       // private val url = "http://192.168.88.1:8080/api/"
        private val url = "http://192.168.43.208:8080/api/"

       fun geInstance():UserAPIService{
          //val interceptor = HttpLoggingInterceptor()
        //interceptor.level = HttpLoggingInterceptor.Level.BASIC
         //val client=OkHttpClient.Builder().addInterceptor(interceptor).build()
           val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

           val retrofit:Retrofit = Retrofit.Builder()
               .baseUrl(url)
               .addCallAdapterFactory(CoroutineCallAdapterFactory())
               .addConverterFactory(MoshiConverterFactory.create(moshi))
               .build()
            return  retrofit.create(UserAPIService::class.java)

       }
    }
}