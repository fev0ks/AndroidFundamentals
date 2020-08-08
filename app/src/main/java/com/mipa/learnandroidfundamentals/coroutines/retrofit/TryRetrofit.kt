package com.mipa.learnandroidfundamentals.coroutines.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mipa.learnandroidfundamentals.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
const val TAG = "TryRetrofit"

class TryRetrofit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_try_retrofit)

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
//            val response = api.getComments().awaitResponse()
            val response = api.getCommentsAsSuspendFun()

            if (response.isSuccessful) {
                response.body()?.let {
                    for (comment in it) {
                        Log.d(TAG, comment.toString())
                    }
                }
            }
        }

//        api.getComments().enqueue(object : Callback<List<Comment>> {
//            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//                Log.e(TAG, "ERROR: $t")
//
//            }
//
//            override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//                if (response.isSuccessful) {
//                    response.body()?.let {
//                        for (comment in it) {
//                            Log.d(TAG, comment.toString())
//                        }
//                    }
//                }
//            }
//        })
        }
    }