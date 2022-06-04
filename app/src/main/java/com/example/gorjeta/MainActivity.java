package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textValor;
    private TextView textPorcentagem, textGorjeta, textTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textValor = findViewById(R.id.textValor);
        textGorjeta = findViewById(R.id.textGorjeta);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGojeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              porcentagem = progress;
              textPorcentagem.setText( Math.round( porcentagem ) + "%" );
              calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){
     String valorRegistrado = textValor.getText().toString();
     if (valorRegistrado == null || valorRegistrado.equals("")){
         Toast.makeText(
                 getApplicationContext(),
                 "Digite um valor primeiro!",
                 Toast.LENGTH_LONG
         ).show();
     }
     else {
         double valorDigitado = Double.parseDouble(valorRegistrado);
         double gorjeta = valorDigitado * (porcentagem/100);
         double total = gorjeta + valorDigitado;

         textGorjeta.setText("R$ " + Math.round(gorjeta));
         textTotal.setText("R$ " + total);
     }
    }
}