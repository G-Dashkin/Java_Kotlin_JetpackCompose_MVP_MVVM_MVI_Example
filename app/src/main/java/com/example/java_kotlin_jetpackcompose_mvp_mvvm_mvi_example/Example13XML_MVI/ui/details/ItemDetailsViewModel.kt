package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.details

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.BaseViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.Interactor

class ItemDetailsViewModel(
    interactors: Set<Interactor<ItemDetailsState, ItemDetailsAction>>,
    itemId: Int
) : BaseViewModel<ItemDetailsState, ItemDetailsAction>(
    interactors = interactors,
    reducer = ItemDetailsReducer(itemId)
) {

    fun loadItem() {
        action(ItemDetailsAction.Load)
    }
}