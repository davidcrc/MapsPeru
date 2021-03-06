package com.mobiles.mapsperu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSitios, btnTipos,btnUbicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Boton para cargar el activity de mapas
        btnSitios = findViewById(R.id.btn_Sitios);

        btnSitios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);

                startActivity(intent);

            }
        });

        // Boton para cargar el activity de tipos de mapas
        btnTipos = findViewById(R.id.btn_Tipos);

        // Boton para cargar el activity de tipos de mapas
        btnUbicacion = findViewById(R.id.btn_Ubicacion);

    }

    public void  MapaSitios(View view){
        Intent intent = new Intent(getApplicationContext(), MapsActivityTipos.class);

        startActivity(intent);
    }

    public void MiLocalizacion(View view) {

        Intent intent = new Intent(getApplicationContext(), MapsActivityLocalizacion.class);

        startActivity(intent);
    }
}
