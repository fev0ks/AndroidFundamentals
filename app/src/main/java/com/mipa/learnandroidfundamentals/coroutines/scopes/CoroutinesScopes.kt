package com.mipa.learnandroidfundamentals.coroutines.scopes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_coroutines_scopes.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG = "CoroutinesScopes"
class CoroutinesScopes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_scopes)
        cr_start.setOnClickListener {
            //will not be stopped after finish activity
//            GlobalScope.launch {
            lifecycleScope.launch {
                while(true){
                    delay(1000L)
                    Log.d(TAG, "Still running...")
                }
            }
            GlobalScope.launch {
                delay(5000L)
               Intent(this@CoroutinesScopes, CoroutinesSecondActivity::class.java).also {
                   startActivity(it)
                   finish()
               }
            }
        }
    }
}