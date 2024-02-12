package com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.base.BaseFragment
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.interactors.list.GetItemsInteractor
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.interactors.list.TestInteractor
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.data.model.Item
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.ui.details.ItemDetailsFragment
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.Example13XML_MVI.util.createViewModel
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.R
import com.example.java_kotlin_jetpackcompose_mvp_mvvm_mvi_example.databinding.FragmentItemListBinding

class ItemListFragment : BaseFragment<ItemListViewModel, FragmentItemListBinding>() {

    override val viewModelProvider = {
        createViewModel {
            ItemListViewModel(
                interactors = setOf(
                    GetItemsInteractor(),
                    TestInteractor()
                )
            )
        }
    }
    override val viewBindingProvider: (LayoutInflater, ViewGroup?) -> FragmentItemListBinding =
        { inflater, container ->
            FragmentItemListBinding.inflate(inflater, container, false)
        }
    private val adapter by lazy {
        ItemListAdapter {
            navigateToDetails(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.state.observe(viewLifecycleOwner, ::renderState)
        viewModel.loadItems()
    }

    private fun initViews() {
        with(binding) {
            recyclerItems.adapter = adapter
            recyclerItems.layoutManager = LinearLayoutManager(context)
            buttonTest.setOnClickListener {
                viewModel.test()
            }
        }
    }

    private fun renderState(newState: ItemListState) {
        adapter.submitList(newState.items)
    }

    private fun navigateToDetails(item: Item) {
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.container_fragments, ItemDetailsFragment.newInstance(item.id))
            addToBackStack(null)
            commit()
        }

    }

    companion object {

        fun newInstance() = ItemListFragment()

    }

}