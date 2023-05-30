package com.template.tmp02.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.template.tmp02.R
import com.template.tmp02.databinding.FragmentCartBinding
import com.template.tmp02.databinding.FragmentFilterBottomSheetBinding
import com.template.tmp02.ui.adapter.CartItemAdapter
import com.template.tmp02.ui.adapter.FilterDataItemAdapter
import com.template.tmp02.ui.adapter.FilterItemAdapter
import com.template.tmp02.ui.modelclass.CartItem
import com.template.tmp02.ui.modelclass.FilterDataItem
import com.template.tmp02.ui.modelclass.FilterItem

class FilterBottomSheetFragment : BottomSheetDialogFragment(),
    FilterItemAdapter.FilterItemClickListener {

    private var subList = mutableListOf<FilterItem>()
    private var filterList = mutableListOf<FilterDataItem>()
    private var binding: FragmentFilterBottomSheetBinding? = null
    private val filterItemAdapter: FilterItemAdapter by lazy { FilterItemAdapter(this) }
    private val filterDataItemAdapter: FilterDataItemAdapter by lazy { FilterDataItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFilterBottomSheetBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        filterListData()

    }

    private fun initView() {
        binding?.apply {
            rvFilterCategorySet.apply {
                layoutManager =
                    LinearLayoutManager(requireContext())
                adapter = filterItemAdapter
            }
            rvFilterCategoryDescriptionSet.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = filterDataItemAdapter
            }
        }

    }

    private fun filterListData() {
        val brandsList= listOf(FilterDataItem("All"),FilterDataItem("Annemarie Borlind"),FilterDataItem("Biokap"),FilterDataItem("Desert Essence"),FilterDataItem("Dr.Organic"),FilterDataItem("Ecrinal"))
        subList.addAll(
            listOf(
                FilterItem("Price", null),
                FilterItem("Brand", brandsList),
                FilterItem("Size", null),
                FilterItem("Color", null),
                FilterItem("Discount", null)
            )
        )
        filterItemAdapter.updateList(subList)
    }

    override fun onItemClick(filterItem: FilterItem) {
        filterDataItemAdapter.updateList(filterItem.subCategories?: emptyList())
    }
}