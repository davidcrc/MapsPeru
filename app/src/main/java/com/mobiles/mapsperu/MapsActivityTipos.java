package com.mobiles.mapsperu;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityTipos extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Button btn_Hibrido, btn_Normal, btn_Satelital, btn_Terreno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_tipos);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btn_Hibrido = findViewById(R.id.btn_hibrido);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng aqp = new LatLng(-16.39871566652775, -71.53667298251604);
        mMap.addMarker(new MarkerOptions().position(aqp).title("Arequipa - Peru").snippet("Plaza de armas de arequipa!!").icon(BitmapDescriptorFactory.fromResource(R.drawable.arequipa)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aqp, 15));

        //////////// HBILITAR MAS CONTROLES POR DEFECTO
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(false);
    }

    public void CambiarHibrido(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void CambiarSatelital(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }

    public void CambiarTerreno(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
    }

    public void CambiarNormal(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
