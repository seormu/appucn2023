package com.example.appucn2023;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private EditText txtnames, txtpwd;
    private Button btnsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se inicializan los editext y el boton con los recursos del xml
        txtnames = (EditText) findViewById(R.id.txtnames);
        txtpwd = (EditText) findViewById(R.id.txtpwd);
        btnsesion = (Button) findViewById(R.id.btnsesion);

        //Si hay un evento en el boton de iniciar sesion, se llamara el metodo de iniciarSesion()
        btnsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });
    }

    private void iniciarSesion() {
        //Se crea la peticion
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://appucn2023.000webhostapp.com/login.php?"
                .concat("user=").concat(txtnames.getText().toString())
                .concat("&pwd=").concat(txtpwd.getText().toString());
        //Se instancia la clase JsonObjectRequest para poder recibir el JSONObject del webservice
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Si los datos son correctos, ingresa al if
                if (response.optString("mensaje").equals("OK")){
                    //Se intancia la clase intent para redireccionar al MainActivity2 y adicional se envia el nombre por putExtra
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("name", response.optString("name"));
                    startActivity(intent);
                }else{
                    //si los datos de los editext son incorrectos, se muestra el toast
                    Toast.makeText(getApplicationContext(), "Los datos ingresados son invalidos", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //si ocurre un error al consumir el webservice se muestra el toast
                Toast.makeText(getApplicationContext(), "Error al consumir el servicio", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}