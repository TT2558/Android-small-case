package com.example.myapplication.activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.example.myapplication.R
import com.example.myapplication.fragment.MainActivity2
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var timeChangeReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send.setOnClickListener(this)
        button3.setOnClickListener(this)            //进行跳转页面
        pic.setOnClickListener(this)                //glide测试
        alert1.setOnClickListener(this)             //警告弹窗
        convertFrag.setOnClickListener(this)        //fragment测试
        BroadcastTest.setOnClickListener(this)      //broadcast测试

        val intentFilter = IntentFilter()
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    inner class TimeChangeReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context,"时间正在流逝......",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.send -> {
                val inputText = input_message.text.toString()
                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show()
                "ModifyToast".showToast(this ,Toast.LENGTH_SHORT)
                Log.d("MainActivity","哈哈哈哈哈哈哈哈哈哈😝")
                
            }
            R.id.button3 ->{
                startActivity<FirstActivity>(this){
                    putExtra("param1","data")
                    putExtra("param2","123")
                }
//                val intent = Intent(this, FirstActivity::class.java)
//                startActivity(intent)
            }
            R.id.pic ->{
                val url: String = "https://pt-starimg.didistatic.com/static/starimg/img/L0bdv8wIy31642405816555.png"
                //Glide.with(this).load(url).into(glideimage_view)
                Glide.with(this).load(url).into(glideimage_view);


            }
            R.id.convertFrag ->{
                val intent = Intent(this , MainActivity2::class.java)
                startActivity(intent)
            }
            R.id.alert1 ->{
                AlertDialog.Builder(this).apply {
                    setTitle("🐿️🆘🤭")
                    setMessage("就是让你看看而已")
                    setCancelable(false)
                    setPositiveButton("滚蛋"){dialog , which->
                    }
                    setNegativeButton("mua"){ dialog, which->
                    }
                    show()
                }
            }
            R.id.BroadcastTest ->{
                val intent = Intent("com.example.broadcasttest.MY_BROADCAST")
                intent.setPackage(packageName)
                //sendBroadcast(intent)
                sendOrderedBroadcast(intent, null)
            }
        }
    }


}
