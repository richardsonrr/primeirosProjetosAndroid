package br.com.rrdev.master.drinkmejava;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rrdev.master.drinkmejava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private ActivityMainBinding binding;
    private EditText editText;
    private TimePicker setTimerPicker;
    private Button btnNotify;
    private int hour;
    private int min;
    private int interval;
    boolean press = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        preferences = getSharedPreferences("db", Context.MODE_PRIVATE);
        btnNotify = binding.btnNotificar;
        editText = binding.editTextInterval;
        setTimerPicker = binding.timePicker;

        setTimerPicker.setIs24HourView(true);
        btnNotify.setOnClickListener(userClicker);


        press = preferences.getBoolean("activated", false);

        if (press) {
            btnNotify.setBackgroundColor(getColor(R.color.black));
            btnNotify.setText(getText(R.string.pause));
            int hours = preferences.getInt("hour", setTimerPicker.getHour());
            int minute = preferences.getInt("min", setTimerPicker.getMinute());
            int intervals = preferences.getInt("interval", 0);
            editText.setText(String.valueOf(intervals));
            setTimerPicker.setHour(hours);
            setTimerPicker.setMinute(minute);


        } else {
            btnNotify.setBackgroundColor(getColor(R.color.teal_700));
            btnNotify.setText(getText(R.string.notificar));

        }

        //Receber click no java temos 3 formas, no xml e criando o function
        //e outras 2 que vou mostrar aqui.


    }

    public View.OnClickListener userClicker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            hour = setTimerPicker.getHour();
            min = setTimerPicker.getMinute();
            checkingInEditText();


        }
    };

    private void checkingInEditText() {
        if (editText.getText().toString().isEmpty()) {
            String texto = "Defina um Intervalo";
            Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
        } else {
            interval = Integer.parseInt(editText.getText().toString());
            btnNotifyWorking();
            Log.d("buttonNotify", "Horas: " + hour + " Minutos: " + min + " Intervelo: " + interval);
        }
    }

    private void btnNotifyWorking() {
        if (!press) {
            btnsetPausar();
            setEditor();
        } else {
            btnSetNotificar();
            removeEdit();
        }


    }

    private void removeEdit() {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean("activated", press);
        edit.remove("interval");
        edit.remove("hour");
        edit.remove("min");
        edit.apply();
    }

    private void setEditor() {
        SharedPreferences.Editor edit = preferences.edit();
        edit.putBoolean("activated", press);
        edit.putInt("interval", interval);
        edit.putInt("hour", hour);
        edit.putInt("min", min);
        edit.apply();
    }

    private void btnsetPausar() {
        btnNotify.setBackgroundColor(getColor(R.color.black));
        btnNotify.setText(getText(R.string.pause));
        press = true;
    }

    private void btnSetNotificar() {
        btnNotify.setBackgroundColor(getColor(R.color.teal_700));
        btnNotify.setText(getText(R.string.notificar));
        press = false;
    }

}