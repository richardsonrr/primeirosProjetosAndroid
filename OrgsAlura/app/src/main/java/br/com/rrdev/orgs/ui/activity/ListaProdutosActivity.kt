package br.com.rrdev.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.adpter.ListaProdutosAdapter
import br.com.rrdev.orgs.dados.ProdutosDao
import br.com.rrdev.orgs.databinding.ActivityListaProdutosBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }
    private val buscaTodos by lazy { ProdutosDao() }
    private val adapter by lazy {
        ListaProdutosAdapter(
            context = this,
            produtos = buscaTodos.buscaTodos()
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFAB()
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(buscaTodos.buscaTodos())

    }

    private fun configuraFAB() {
        //implementação de floatingAction para adicionar produto
        val floatAction = binding.floatingActionButton

        floatAction.setOnClickListener {

            //Dessa forma bindamos outra activity do nosso progama,
            // usando Intent(Recebe context, e a activity + ::class.java)
            val intentFormulario = Intent(this, FormularioDeCadastroActivity::class.java)
            // e com essa função iniciamos e colocamos oq queremos iniciar dentro
            startActivity(intentFormulario)


        }
    }

    private fun configuraRecyclerView() {
        //bidding do recycler
        val recyclerView = binding.recyclerView
        //implementação do adapter
        recyclerView.adapter = adapter
    }

}