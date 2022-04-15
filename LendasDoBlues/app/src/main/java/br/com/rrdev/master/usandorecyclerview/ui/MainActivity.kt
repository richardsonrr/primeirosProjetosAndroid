package br.com.rrdev.master.usandorecyclerview.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rrdev.master.usandorecyclerview.R
import br.com.rrdev.master.usandorecyclerview.model.DataSource

class MainActivity : AppCompatActivity() {

    private  lateinit var dadosAdapter: DadosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSorce()


    }

    private fun addDataSorce() {
        val dataSource = DataSource.createDataSet()
        this.dadosAdapter.setDataSet(dataSource)
    }

    private fun initRecyclerView() {
        this.dadosAdapter = DadosAdapter { dados ->
            openLink(dados.link)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = this.dadosAdapter
    }

    private fun openLink(url:String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}