package com.example.tutorialapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.tutorialapp.R
import com.google.android.material.tabs.TabLayout

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BellowFragment : Fragment() {

    lateinit var txtBellow: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bellow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        txtBellow = view.findViewById<TextView>(R.id.txtBellow)
    }

    fun updateBellowText(text: String) {
        txtBellow.text = text
    }

}