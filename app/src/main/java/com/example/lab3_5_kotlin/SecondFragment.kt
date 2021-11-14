package com.example.lab3_5_kotlin

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        view.findViewById<View>(R.id.bnToThird).setOnClickListener {
            Navigation.findNavController(
                view
            ).navigate(R.id.action_secondFragment_to_thirdFragment)
        }
        view.findViewById<View>(R.id.bnToFirst).setOnClickListener {
            Navigation.findNavController(
                view
            ).navigate(R.id.action_secondFragment_to_firstFragment)
        }
        return view
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.activity_about) {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_about)
        }
        return super.onOptionsItemSelected(item)
    }
}