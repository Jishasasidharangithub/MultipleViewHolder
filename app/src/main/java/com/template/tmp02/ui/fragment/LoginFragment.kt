package com.template.tmp02.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.template.tmp02.R
import com.template.tmp02.databinding.FragmentLoginBinding
import com.template.tmp02.ui.adapter.ViewPagerAdaptor

class LoginFragment : Fragment() {
    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    private val fragmentList = arrayListOf<Fragment>(
        SignInFragment(),
        SignUpFragment()
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdaptor(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding?.vpLogin?.adapter = adapter

        moveToNext()

    }

    private fun moveToNext() {
        var currentPos=binding?.vpLogin?.currentItem ?: 0
        currentPos++
        if (currentPos < fragmentList.size){
            binding?.vpLogin?.currentItem = currentPos
        }else{
            findNavController().navigate(R.id.homeFragment)
        }
    }


}