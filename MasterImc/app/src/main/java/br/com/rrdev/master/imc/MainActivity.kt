package br.com.rrdev.master.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.rrdev.master.imc.functions.autenticador
import br.com.rrdev.master.imc.functions.imc


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val resultA = findViewById<TextView>(R.id.result)
        val peso = findViewById<EditText>(R.id.editTextTextPersonName)
        val altura = findViewById<EditText>(R.id.editTextTextPersonName2)
        val boottom = findViewById<Button>(R.id.calcular)

        boottom.setOnClickListener {
            val autenticador = autenticador(peso = peso.text, altura = altura.text)
            if (autenticador) {
                resultA.text = imc(peso = peso.text.toString(), altura = altura.text.toString())
            } else {
                resultA.text = "Preencha os campos de acordo com a descrição"


            }

        }


    }






}



