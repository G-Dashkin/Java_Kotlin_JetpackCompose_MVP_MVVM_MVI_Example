package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.interactors.details

import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.Interactor
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.details.ItemDetailsAction
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.details.ItemDetailsState
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.util.ItemHolder


class GetItemByIdInteractor : Interactor<ItemDetailsState, ItemDetailsAction> {

    override suspend fun invoke(
        state: ItemDetailsState,
        action: ItemDetailsAction
    ): ItemDetailsAction {
        return if (action is ItemDetailsAction.Load) {
            try {
                ItemDetailsAction.ItemLoaded(ItemHolder.findItemById(state.itemId))
            } catch (e: Exception) {
                ItemDetailsAction.Error(e)
            }
        } else {
            ItemDetailsAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: ItemDetailsAction): Boolean {
        return action is ItemDetailsAction.Load
    }

}