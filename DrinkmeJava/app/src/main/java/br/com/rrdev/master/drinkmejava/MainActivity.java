package br.com.rrdev.master.drinkmejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import br.com.rrdev.master.drinkmejava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button btnNotify;
    private EditText editText;
    private TimePicker setTimerPicker;
    private int hour;
    private int min;
    private int interval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        btnNotify = binding.btnNotificar;
        editText = binding.editTextInterval;
        setTimerPicker = binding.timePicker;




        setTimerPicker.setIs24HourView(true);
        btnNotify.setOnClickListener(userClicker);

        //Receber click no java temos 3 formas, no xml e criando o function
        //e outras 2 que vou mostrar aqui.


    }

    public View.OnClickListener userClicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hour = setTimerPicker.getHour();
            min = setTimerPicker.getMinute();
            interval = Integer.parseInt(editText.getText().toString());


            Log.d("buttonNotify", "Horas: " +  hour + " Minutos: " + min + " Intervelo: " + interval);

        }
    };

}