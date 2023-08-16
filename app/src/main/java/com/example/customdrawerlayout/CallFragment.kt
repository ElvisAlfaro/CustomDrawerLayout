package com.example.customdrawerlayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customdrawerlayout.databinding.FragmentCallBinding

private const val ARG_COLOR_RES = "ARG_COLOR_RES"

class CallFragment : Fragment() {
    private var colorRes: Int? = null
    private val binding: FragmentCallBinding by lazy {
        FragmentCallBinding.inflate(layoutInflater)
    }

    companion object {
        @JvmStatic
        fun newInstance(colorRes: Int): CallFragment {
            val args = Bundle()
            args.putInt(ARG_COLOR_RES, colorRes)
            val fragment = CallFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        colorRes = arguments?.getInt(ARG_COLOR_RES, android.R.color.transparent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setBackgroundResource(colorRes!!)
    }
}