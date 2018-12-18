package com.example.darfe.multiscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.darfe.multiscreen.fragments.DetailFragment
import com.example.darfe.multiscreen.fragments.MasterFragment

class MainActivity : AppCompatActivity(), MasterFragment.OnColorSelected {

    val phone:Boolean by lazy { resources.getBoolean(R.bool.phone) }
    val port:Boolean by lazy {resources.getBoolean(R.bool.port)}

    var detail:DetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container1, MasterFragment.instance())
            .commit()

        if(!phone && !port){
            detail = DetailFragment.instance(DetailFragment.RED)
            supportFragmentManager.beginTransaction()
                .add(R.id.container2, detail!!)
                .commit()
        }

    }

    override fun onSelected(position: Int) {
        if(!phone && !port){
            detail?.color = position
        }else{
            supportFragmentManager.beginTransaction()
                .add(R.id.container1, DetailFragment.instance(position))
                .addToBackStack(null)
                .commit()
        }
    }
}
