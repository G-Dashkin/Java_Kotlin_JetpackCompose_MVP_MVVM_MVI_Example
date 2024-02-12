package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.util

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.model.Item

object ItemHolder {

    val items by lazy {
        (0 until 20).map {
            Item(
                id = it,
                name = "name$it"
            )
        }
    }

    fun findItemById(itemId: Int) = items.first { it.id == itemId }

}