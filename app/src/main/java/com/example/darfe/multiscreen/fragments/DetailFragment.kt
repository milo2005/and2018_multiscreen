package com.example.darfe.multiscreen.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.darfe.multiscreen.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private val colors:IntArray by lazy{ resources.getIntArray(R.array.colors) }
    private val colorsNames:Array<String>
            by lazy { resources.getStringArray(R.array.color_names) }

    var color:Int = RED
        set(value){
            field = value
            txtColor?.text = colorsNames[value]
            root?.setBackgroundColor(colors[value])
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onResume() {
        super.onResume()
        color = arguments?.getInt("color") ?: RED
    }

    companion object {

        val RED = 0
        val GREEN = 1
        val BLUE = 2
        val YELLOW = 3
        val VIOLET = 4

        fun instance(color:Int):DetailFragment = DetailFragment().apply {
            arguments = Bundle().apply {
                putInt("color", color)
            }
        }
    }


}
