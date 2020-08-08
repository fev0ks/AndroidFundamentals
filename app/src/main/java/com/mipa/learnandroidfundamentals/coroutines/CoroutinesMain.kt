package com.mipa.learnandroidfundamentals.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mipa.learnandroidfundamentals.R
import com.mipa.learnandroidfundamentals.coroutines.fiebase_firestore.FirebaseFirestore
import com.mipa.learnandroidfundamentals.coroutines.retrofit.TryRetrofit
import com.mipa.learnandroidfundamentals.coroutines.scopes.CoroutinesScopes
import kotlinx.android.synthetic.main.activity_coroutines_main.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

const val TAG = "CoroutinesMain"

class CoroutinesMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_main)

        cr_scope.setOnClickListener {
            Intent(this, CoroutinesScopes::class.java).also {
                startActivity(it)
            }
        }

        firebaseFirestore.setOnClickListener {
            Intent(this, FirebaseFirestore::class.java).also {
                startActivity(it)
            }
        }

        retrofit.setOnClickListener {
            Intent(this, TryRetrofit::class.java).also {
                startActivity(it)
            }
        }

//        GlobalScope.launch(Dispatchers.Main) {
//        GlobalScope.launch(Dispatchers.IO) {
////        GlobalScope.launch(newSingleThreadContext("mey Thread")) {
//            Log.d(TAG, "Coroutine says hello from thread IO ${Thread.currentThread().name}")
//            val answer = doNetworkCall(0)
//
//            withContext(Dispatchers.Main) {
//                Log.d(TAG, "Coroutine says hello from thread Main ${Thread.currentThread().name}")
//                Toast.makeText(this@CoroutinesMain, answer, Toast.LENGTH_SHORT).show()
//            }
//            Log.d(TAG, "Coroutine says hello ${doNetworkCall(123)}")
//
//        }
//
//        runBlocking {
//            launch(Dispatchers.IO) {
//                delay(3000L)
//                Log.d(TAG, "finished IO 1")
//            }
//            launch(Dispatchers.IO) {
//                delay(3000L)
//                Log.d(TAG, "finished IO 2")
//            }
//            delay(1000L)
//            Log.d(
//                TAG,
//                "runBlocking coroutine says hello from thread ${Thread.currentThread().name}"
//            )
//        }
//
//        val job = GlobalScope.launch(Dispatchers.Default) {
////            var c = 0;
////            repeat(5) {
////                Log.d(TAG, "${c++} Coroutine is working...")
////                delay(1000L)
////            }
//            Log.d(TAG, "Start long calculation...")
//            withTimeout(3000L) {
//                for (i in 30..400) {
//                    if (isActive) {
//                        Log.d(TAG, "result fib for $i: ${fib(i)}")
//                    }
//                }
//            }
//
//            Log.d(TAG, "Finish long calculation")
//        }
//
//        runBlocking {
//            delay(4000L)
//            Log.d(TAG, "Cancel job!")
//            job.cancel()
////            job.join()
//            delay(1000L)
//            Log.d(TAG, "Main thread is continuing....")
//        }

        Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")

        GlobalScope.launch(Dispatchers.IO){
            val time = measureTimeMillis {
                val answer1 = async {
                    doNetworkCall(1)
                }
                val answer2 = async {
                    doNetworkCall(2)
                }
                Log.d(TAG, "Network answer1 ${answer1.await()}")
                Log.d(TAG, "Network answer2 ${answer2.await()}")
//                var answer1: String? = null
//                var answer2: String? = null
//                val job1 = launch {
//                    answer1 = doNetworkCall(1)
//                }
//                val job2 = launch {
//                    answer2 = doNetworkCall(2)
//                }
//                job1.join()
//                job2.join()
//                Log.d(TAG, "Network answer1 $answer1")
//                Log.d(TAG, "Network answer2 $answer2")
            }
            Log.d(TAG, "Network request took $time ms")
        }
    }

    suspend fun doNetworkCall(v: Int): String {
        delay(2000L)
        return "Call answer $v"
    }

    fun fib(n: Int): Long {
        return if (n == 0) 0
        else if (n == 1) 1
        else fib(n - 1) + fib(n - 2)
    }
}