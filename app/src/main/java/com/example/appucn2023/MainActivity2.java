package com.example.appucn2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView txtBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //se inicializan los editext y el boton con los recursos del xml
        txtBienvenido = (TextView) findViewById(R.id.txtBienvenido);
        //Se obtiene el intent de la clase MainActivity
        String nombre = getIntent().getStringExtra("name");
        //Se asigna el nombre en el txtBienvenido
        txtBienvenido.setText("¡Bienvenido "+nombre+"!");
    }
}