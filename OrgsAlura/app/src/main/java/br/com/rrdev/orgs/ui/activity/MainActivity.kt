package br.com.rrdev.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.R

class MainActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Locamos o recyclerView em uma val
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //depois usamos o componente padrao do recyler para fazer as configurações
        // o chamado adpter, deve se mandar uma referencia basica propria pro recycler
        recyclerView.adapter  = br.com.rrdev.orgs.adpter.ListaProdutosAdapter()
        // somos obrigados a implementar uma class para referenciar esse adpter quando
        //criamos um reyclerView



    }



}