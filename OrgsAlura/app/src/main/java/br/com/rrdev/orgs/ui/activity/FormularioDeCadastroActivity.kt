package br.com.rrdev.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.rrdev.orgs.R
import br.com.rrdev.orgs.dados.ProdutosDao
import br.com.rrdev.orgs.databinding.FormularioDeCadastroBinding
import br.com.rrdev.orgs.model.Produtos
import java.math.BigDecimal

class FormularioDeCadastroActivity : AppCompatActivity() {
    private val binding by lazy{ FormularioDeCadastroBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val buttonAdicionar = binding.buttonAdicionar
        configuraBotaoAdicionar(buttonAdicionar)
        setContentView(binding.root)

    }

    private fun configuraBotaoAdicionar(buttonAdicionar: Button) {
         val armazenador = ProdutosDao()
        buttonAdicionar.setOnClickListener {
            val novoProduto = binding.editTextProduto.text.toString()
            val novaDescricao = binding.editTextDescricao.text.toString()
            val novoValor = binding.editTextValor.text.toString()

            if (autenticador(novoProduto, novaDescricao, novoValor)) {
                val produtoCriado = Produtos(novoProduto, novaDescricao, BigDecimal(novoValor))
                armazenador.adicionar(produtoCriado)
                finish()
                Log.i("teste", "ButtonListener: ${armazenador.buscaTodos()}")

            } else {
                Toast.makeText(this, "COMPLETE TODOS OS CAMPOS", Toast.LENGTH_SHORT).show()

            }

        }
    }

    private fun autenticador(novoProduto: String, novaDescricao: String, novoValor: String
    ): Boolean {
        var validador = false
        if (!novoProduto.isEmpty()) {
            if (!novaDescricao.isEmpty()) {
                if (!novoValor.isEmpty()) {
                    validador = true
                }
            }
        }

        return validador

    }


}