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

        txtBienvenido = (TextView) findViewById(R.id.txtBienvenido);

        String nombre = getIntent().getStringExtra("name");
        txtBienvenido.setText("¡Bienvenido "+nombre+"!");
    }
}