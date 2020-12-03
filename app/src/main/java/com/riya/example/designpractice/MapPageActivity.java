package com.riya.example.designpractice;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapPageActivity extends FragmentActivity implements OnMapReadyCallback {
   // View view;
    private GoogleMap mMap;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

   // view = inflater.inflate(R.layout.mappage, container, false);

        setContentView(R.layout.mappage);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(19.1231, 12.12312);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Client Address"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        /*LatLng Riya = new LatLng(21, 57);
        mMap.addMarker(new
                MarkerOptions().position(Riya).title("Tutorialspoint.com"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Riya));*/
    }
}
