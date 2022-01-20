package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapplication.R
import com.example.myapplication.list.ListActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val extraData = intent.getStringExtra("extra_data")
        Log.d("SecondActivity","extra data is $extraData")
        button2.setOnClickListener(this)
    }

    override fun onClick(v : View?) {
        when(v ?.id){
            R.id.button2 ->{
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
