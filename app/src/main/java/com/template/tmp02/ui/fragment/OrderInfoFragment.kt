package com.template.tmp02.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.template.tmp02.databinding.FragmentOrderInfoBinding


class OrderInfoFragment : Fragment() {
  private var binding:FragmentOrderInfoBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOrderInfoBinding.inflate(inflater,container,false)
         return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init(){
        binding?.includeToolbar?.tvToolbarTitle?.text="ORDER INFO"
    }

 }