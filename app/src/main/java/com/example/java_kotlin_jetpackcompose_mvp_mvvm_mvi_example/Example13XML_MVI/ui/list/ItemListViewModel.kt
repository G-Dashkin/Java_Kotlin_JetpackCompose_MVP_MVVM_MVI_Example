package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.BaseViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.Interactor

class ItemListViewModel(
    interactors: Set<Interactor<ItemListState, ItemListAction>>
) : BaseViewModel<ItemListState, ItemListAction>(
    interactors = interactors,
    reducer = ItemListReducer()
) {

    fun loadItems() {
        action(ItemListAction.LoadItems)
    }

    fun test() {
        action(ItemListAction.Test("Test string"))
    }

}