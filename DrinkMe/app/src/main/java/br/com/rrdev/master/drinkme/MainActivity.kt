package br.com.rrdev.master.drinkme

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.com.rrdev.master.drinkme.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    //O binding tem que ser iniciado como lazy e depois ser devolvido no contentView.
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.timePicker.setIs24HourView(true)

        binding.btnNotify.setOnClickListener {
            val numberIntervalTxt = binding.editTxtNumberInterval.text.toString().toInt()
            val hour = binding.timePicker.hour
            val min = binding.timePicker.minute

            Log.d("test", "Horas: $hour:$min Intervalo: $numberIntervalTxt min" )
        }

    }
}