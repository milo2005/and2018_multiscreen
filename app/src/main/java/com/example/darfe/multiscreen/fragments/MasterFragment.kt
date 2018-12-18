package com.example.darfe.multiscreen.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.darfe.multiscreen.R
import kotlinx.android.synthetic.main.fragment_master.*

class MasterFragment : Fragment() {

    interface OnColorSelected{
        fun onSelected(position:Int)
    }

    var selected:OnColorSelected? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        selected = context as? OnColorSelected
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.f_master, container, false)
    }

    override fun onResume() {
        super.onResume()

        list.setOnItemClickListener{ _, _, pos, _ -> selected?.onSelected(pos)}
    }

    companion object {
        fun instance():MasterFragment = MasterFragment()
    }

}
