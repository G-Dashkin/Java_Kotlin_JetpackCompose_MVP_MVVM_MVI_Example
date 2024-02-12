package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list.ItemListFragment
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R

class Example13XML_MVI_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example13_xml_mvi)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragments, ItemListFragment.newInstance())
            .commit()
    }
}