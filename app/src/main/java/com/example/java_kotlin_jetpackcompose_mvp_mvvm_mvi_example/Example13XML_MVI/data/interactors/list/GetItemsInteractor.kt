package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.interactors.list

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.Interactor
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list.ItemListAction
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list.ItemListState
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.util.ItemHolder

class GetItemsInteractor : Interactor<ItemListState, ItemListAction> {

    override suspend fun invoke(state: ItemListState, action: ItemListAction): ItemListAction {
        return if (action is ItemListAction.LoadItems) {
            ItemListAction.ItemsLoaded(ItemHolder.items)
        } else {
            ItemListAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: ItemListAction): Boolean {
        return action is ItemListAction.LoadItems
    }

}