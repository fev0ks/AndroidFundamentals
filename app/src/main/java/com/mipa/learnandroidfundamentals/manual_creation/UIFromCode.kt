package com.mipa.learnandroidfundamentals.manual_creation

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UIFromCode: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout: LinearLayout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        val layoutParam: LayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        setContentView(layout, layoutParam)
        layoutParam.marginStart = 50

        val textView: TextView = TextView(this)
        textView.text = "Hi"
        val textParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        layout.addView(textView, textParams)
    }
}