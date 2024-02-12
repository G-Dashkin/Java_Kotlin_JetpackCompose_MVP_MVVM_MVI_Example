package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.details

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.Reducer

class ItemDetailsReducer(itemId: Int) : Reducer<ItemDetailsState, ItemDetailsAction> {

    override val initialState = ItemDetailsState(
        itemId = itemId,
        item = null
    )

    override fun reduce(state: ItemDetailsState, action: ItemDetailsAction): ItemDetailsState {
        return when(action) {
            ItemDetailsAction.None -> state
            ItemDetailsAction.Load -> state
            is ItemDetailsAction.ItemLoaded -> state.copy(
                item = action.item
            )
            is ItemDetailsAction.Error -> state
        }
    }

}