package com.example.nikhil.animal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animal_info.*

class AnimalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        var bundle:Bundle=intent.extras
        val name=bundle.getString("name")
        val des=bundle.getString("des")
        val image=bundle.getInt("image")

        tv_info_name.text=name
        tv_info_des.text=des
        iv_info_image.setImageResource(image)



    }
}
