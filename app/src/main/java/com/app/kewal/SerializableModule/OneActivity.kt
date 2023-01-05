package com.app.kewal.SerializableModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.app.kewal.R

class OneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)

        var name1 ="keval"
        var age ="10"

        var obj = ModelClass(name1,age)
    }

}