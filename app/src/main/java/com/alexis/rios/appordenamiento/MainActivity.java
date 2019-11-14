package com.alexis.rios.appordenamiento;
//Aplicación que ordena 20 valores aleatorio por el metodo de ordenamiento bubble sort

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText[] editTextNumeros;
    private Button buttonOrdenar;
    private TextView resultado;
    private int[] numeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
        buttonOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerNumeros();
                bubbleSort(numeros);
                String ordenamiento = "";
                for (int i = 0; i < numeros.length; i++) {
                    if (numeros[i] != 0) {
                        ordenamiento += numeros[i] + " - ";
                    }
                }
                resultado.setText(ordenamiento);
            }
        });

    }

    private void inicializar() {
        resultado = findViewById(R.id.resultado);
        buttonOrdenar = findViewById(R.id.button_ordenar);
        editTextNumeros = new EditText[20];
        numeros = new int[20];
        for (int i = 1; i <= editTextNumeros.length; i++) {
            int tmp = getResources().getIdentifier("editText" + i, "id", getPackageName());
            editTextNumeros[i-1]  = findViewById(tmp);
        }
    }

    private void obtenerNumeros() {
        for (int i = 0; i < editTextNumeros.length; i++) {
            String numero = editTextNumeros[i].getText().toString();
            if (TextUtils.isEmpty(numero)) {
                numeros[i] = 0;
            } else {
                numeros[i] = Integer.parseInt(numero);
            }
        }
    }

    private void bubbleSort(int numeros[]) {
        int limite = numeros.length;
        for (int i = 0; i < limite-1; i++) {
            for (int j = 0; j < limite-i-1; j++) {
                if (numeros[j] > numeros[j+1]) {
                    int tmp = numeros[j];
                    numeros[j] = numeros[j+1];
                    numeros[j+1] = tmp;
                }
            }
        }
    }
}
