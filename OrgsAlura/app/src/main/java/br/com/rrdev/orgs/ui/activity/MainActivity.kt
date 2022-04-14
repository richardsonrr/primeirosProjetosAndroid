package br.com.rrdev.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.model.Produtos
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Locamos o recyclerView em uma val
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //depois usamos o componente padrao do recyler para fazer as configurações
        // o chamado adpter, deve se mandar uma referencia basica propria pro recycler


        recyclerView.adapter  = br.com.rrdev.orgs.adpter.ListaProdutosAdapter(context = this, produtos =
        listOf(
            Produtos(
                nome = "Abacaxi", descrição = "Abacaxi amarelo grande", valor = BigDecimal("13.9")
            ),
            Produtos(
                nome = "Laranja", descrição = "laranja grande", valor = BigDecimal(12.99).setScale(2,RoundingMode.UP)
            )

        ))
        // somos obrigados a implementar uma class para referenciar esse adpter quando
        //criamos um reyclerView

        recyclerView.layoutManager = LinearLayoutManager(this)


    }



}