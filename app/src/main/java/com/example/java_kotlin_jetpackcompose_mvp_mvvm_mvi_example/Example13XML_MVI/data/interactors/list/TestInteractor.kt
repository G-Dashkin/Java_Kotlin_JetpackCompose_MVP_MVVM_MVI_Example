package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.interactors.list

import android.util.Log
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.Interactor
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list.ItemListAction
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list.ItemListState

class TestInteractor : Interactor<ItemListState, ItemListAction> {

    override suspend fun invoke(state: ItemListState, action: ItemListAction): ItemListAction {
        return if (action is ItemListAction.Test) {
            Log.d("MyLog","action data: ${action.testData}, current items size: ${state.items.size}")
            ItemListAction.None
        } else {
            ItemListAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: ItemListAction): Boolean {
        return action is ItemListAction.Test
    }
}