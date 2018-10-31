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
    //objeto GoogleMap
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_tipos);
        // Obtener SupportMapFragment y reciba una notificación cuando el mapa esté listo para ser utilizado.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng aqp = new LatLng(-16.39871566652775, -71.53667298251604);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(aqp, 15));//[latitud, longitud, zoom]

        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(true); //brújula
        uiSettings.setZoomControlsEnabled(true); //zoom
    }

    public void CambiarHibrido(View view) { mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); }

    public void CambiarSatelital(View view) { mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE); }

    public void CambiarTerreno(View view) { mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN); }

    public void CambiarNormal(View view) { mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL); }
}
