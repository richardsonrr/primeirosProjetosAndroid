package br.com.rrdev.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.dados.ProdutosDao
import br.com.rrdev.orgs.model.Produtos
import java.math.BigDecimal

class FormularioDeCadastroActivity : AppCompatActivity(R.layout.formulario_de_cadastro) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val buttonAdicionar = findViewById<Button>(R.id.buttonAdicionar)


        buttonAdicionar.setOnClickListener {
            val novoProduto = findViewById<EditText>(R.id.editTextProduto).text.toString()
            val novaDescricao = findViewById<EditText>(R.id.editTextDescricao).text.toString()
            val novoValor = findViewById<EditText>(R.id.editTextValor).text.toString()

            if (autenticador(novoProduto,novaDescricao,novoValor)){
                val produtoCriado = Produtos(novoProduto,novaDescricao,BigDecimal(novoValor))
                val armazenador = ProdutosDao()
                armazenador.adicionar(produtoCriado)
                Log.i("teste","ButtonListener: ${armazenador.buscaTodos()}")

            }else{
              Toast.makeText(this, "COMPLETE TODOS OS CAMPOS",Toast.LENGTH_SHORT).show()

            }

        }



    }

    fun autenticador (novoProduto:String,novaDescricao:String,novoValor:String):Boolean{
        var validador = false
            if (!novoProduto.isEmpty()){
                if (!novaDescricao.isEmpty()){
                    if (!novoValor.isEmpty()){
                        validador = true
                    }
                }
            }

            return validador

    }




}