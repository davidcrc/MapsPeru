package com.mobiles.mapsperu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    // Crear un marcador desde cero
    private Marker markerPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera - Latitud, longitud
        LatLng aqp = new LatLng(-16.39871566652775, -71.53667298251604);
        mMap.addMarker(new MarkerOptions().position(aqp).title("Arequipa - Peru").snippet("Plaza de armas de arequipa!!").icon(BitmapDescriptorFactory.fromResource(R.drawable.arequipa)));

        LatLng parqueSelva = new LatLng(-16.39007867124903, -71.53099669378967);
        mMap.addMarker(new MarkerOptions().position(parqueSelva).draggable(true).title("Arequipa - Peru").snippet("Parque selva alegre").icon(BitmapDescriptorFactory.fromResource(R.drawable.peru)));

        //Marcador de prueba
        LatLng prueba = new LatLng(-16.40487652036424,-71.52662374006134);
        markerPrueba = googleMap.addMarker(new MarkerOptions()
                .position(prueba)
                .draggable(true)        // para arrastrar el marcador
                .title("Prueba")
        );

        // Posicionar la camara , con un zoom
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(aqp));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aqp, 14));

        // Habilitar para escuchar eventos de los marcadores
        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if(marker.equals(markerPrueba)){
            //Obtener la latitud y longitud desde el marcador
            String lat, lng;
            lat = Double.toString(marker.getPosition().latitude);
            lng = Double.toString(marker.getPosition().longitude);

            Toast.makeText(this, lat+", "+lng, Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
