package br.com.rrdev.orgs.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.dados.dados

class MainActivity : AppCompatActivity(R.layout.activity_main){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       //bidding do recycler
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //implementação do adapter
        recyclerView.adapter  = br.com.rrdev.orgs.adpter.ListaProdutosAdapter(context = this, produtos = dados)



    }



}