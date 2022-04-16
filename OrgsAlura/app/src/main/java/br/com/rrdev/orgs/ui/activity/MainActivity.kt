package br.com.rrdev.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.dados.dados
import br.com.rrdev.orgs.model.Produtos
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //bidding do recycler
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //implementação do adapter
        recyclerView.adapter  = br.com.rrdev.orgs.adpter.ListaProdutosAdapter(context = this, produtos = dados)



    }



}