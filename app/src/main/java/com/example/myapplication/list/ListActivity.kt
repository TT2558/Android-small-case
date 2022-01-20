package com.example.myapplication.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private val data = listOf("落雁","丹青","侬寐","司宥","倾城","洛辛","祢肆","迩弘","珂络","捱璃","洛冰","漕卯","酆焘","鸠冥","琵籽","晋丞")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val adapter =ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        list_item1.adapter = adapter
    }
}