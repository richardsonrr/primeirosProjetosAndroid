package br.com.rrdev.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.dados.ProdutosDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       //bidding do recycler
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //implementação do adapter
        val buscaTodos = ProdutosDao()
        recyclerView.adapter  = br.com.rrdev.orgs.adpter.ListaProdutosAdapter(context = this, produtos = buscaTodos.buscaTodos())
        //implementação de floatingAction para adicionar produto

        val floatAction = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        floatAction.setOnClickListener {
            //Dessa forma bindamos outra activity do nosso progama,
            // usando Intent(Recebe context, e a activity + ::class.java)
            val intentFormulario =  Intent(this, FormularioDeCadastroActivity::class.java)
            // e com essa função iniciamos e colocamos oq queremos iniciar dentro
            startActivity(intentFormulario)


        }




    }



}