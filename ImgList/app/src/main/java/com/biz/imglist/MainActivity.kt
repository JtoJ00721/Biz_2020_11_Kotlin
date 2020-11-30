package com.biz.imglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    
    private val petList = arrayListOf<PetVO>(
        PetVO("카보스", 20, "도지", "pet1"),
        PetVO("Snoop dog", 15, "약쟁이", "pet2"),
        PetVO("펀치독", 20, "암스트롱", "pet3"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val petListView = findViewById<RecyclerView>(R.id.pet_list)
        petListView.layoutManager = LinearLayoutManager(this)
        petListView.setHasFixedSize(true)
        petListView.adapter = PetViewAdapter(petList, this)

    }
}