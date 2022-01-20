package com.example.myapplication.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        val button1 : Button = findViewById(R.id.button1)
        button1.setOnClickListener {
//            Toast.makeText(this, "你点击了这个按钮", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data= Uri.parse("tel:10086")
            startActivity(intent)

        }
        button2.setOnClickListener{
            val data ="你好 我的第二个程序"
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("extra_data",data)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.add_item ->Toast.makeText(this,"你点击了这个add",Toast.LENGTH_SHORT).show()
            R.id.remove_item ->Toast.makeText(this,"你点击了这个remove",Toast.LENGTH_SHORT).show()
        }
    return true
    }

}

