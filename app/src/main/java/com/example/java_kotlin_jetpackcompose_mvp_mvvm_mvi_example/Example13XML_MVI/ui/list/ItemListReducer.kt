package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.Reducer

class ItemListReducer : Reducer<ItemListState, ItemListAction> {

    override val initialState = ItemListState(
        items = listOf()
    )

    override fun reduce(state: ItemListState, action: ItemListAction): ItemListState {
        return when(action) {
            ItemListAction.None -> state
            ItemListAction.LoadItems -> state
            is ItemListAction.ItemsLoaded -> state.copy(
                items = action.items
            )
            is ItemListAction.Error -> state
            is ItemListAction.Test -> state
        }
    }
}