package com.project.namae

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.project.viewmodelexperiment2.Frag2ViewModel

class Fragment2 : Fragment() {
    lateinit var viewModel: Frag2ViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        viewModel = ViewModelProvider(this)[Frag2ViewModel::class.java]
        val name = Fragment2Args.fromBundle(requireArguments()).name
        Log.d("Hi", name)
        view.findViewById<TextView>(R.id.tv).text = viewModel.text+" $name"
        view.findViewById<TextView>(R.id.tv).setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment2_to_fragment1)
        }
        return view
    }
}