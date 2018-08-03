package com.example.nikhil.animal

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listofAnimals= arrayListOf<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listofAnimals.add(Animal("Babbon","Baboons are Old World monkeys belonging to the genus Papio, part of the subfamily Cercopithecinae which are found natively in very specific areas of Africa and the Arabian Peninsula.",R.drawable.babbon))
        listofAnimals.add(Animal("Cow","Cows are the most common type of large domesticated ungulates. They are a prominent modern member of the subfamily Bovinae, are the most widespread species of the genus Bos, and are most commonly classified collectively as Bos taurus.",R.drawable.cow))
        listofAnimals.add(Animal("Deer","Deer are the hoofed ruminant mammals forming the family Cervidae. The two main groups are the Cervinae, including the muntjac, the elk, the fallow deer and the chital, and the Capreolinae, including the reindeer, the roe deer and the moose.",R.drawable.deer))
        listofAnimals.add(Animal("Dog","Dogs have four legs and make a \"bark,\" \"woof,\" or \"arf\" sound. Dogs often chase cats, and most dogs will fetch a ball or stick.\n" +
                "\n" +
                "Dogs can smell and hear better than humans, but cannot see well in color because they are color blind. Due to the anatomy of the eye, dogs can see better in dim light than humans. They also have a wider field of vision.",R.drawable.dog))
        listofAnimals.add(Animal("Lion","The lion is a species in the cat family; it is a muscular, deep-chested cat with a short, rounded head, a reduced neck and round ears, and a hairy tuft at the end of its tail.",R.drawable.lionpng))
        listofAnimals.add(Animal("Donkey","The donkey or ass is a domesticated member of the horse family, Equidae. The wild ancestor of the donkey is the African wild ass, E. africanus. The donkey has been used as a working animal for at least 5000 years.",R.drawable.donkey))

      adapter= AnimalsAdapter(this,listofAnimals)
        list_view.adapter=adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var listofAnimals=ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context,listofAnimals: ArrayList<Animal>):super(){
            this.listofAnimals=listofAnimals
            this.context=context

        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var animal=listofAnimals[p0]
            var inflater= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var my_view=inflater.inflate(R.layout.animal_ticket,null)
            my_view.tv_name.text=animal.name!!
            my_view.tv_des.text=animal.des!!
            my_view.iv_ani.setImageResource(animal.image!!)

            my_view.iv_ani.setOnClickListener {
                var intent=Intent(context,AnimalInfo::class.java)
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)

                context!!.startActivity(intent)
            }

         return my_view
        }

        override fun getItem(p0: Int): Any {
            return listofAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
        return p0.toLong()
        }

        override fun getCount(): Int {
               return listofAnimals.size
        }

    }
}

// #@cker's Studio App
// By Ankush Shrivastva
