package com.example.dixtechapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.dixtechapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerDragListener {

    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
   private Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        geocoder = new Geocoder(this);
    }

   
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.setOnMapLongClickListener(this);
        mMap.setOnMarkerDragListener(this);

        try {
            List<Address> addresses = geocoder.getFromLocationName("R. Guaipá, 678 - Vila Leopoldina, São Paulo - SP, 05089-000", 1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                LatLng leopoldina = new LatLng(address.getLatitude(), address.getLongitude());
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(leopoldina)
                        .title(address.getLocality());
                mMap.addMarker(markerOptions);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(leopoldina, 16));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void onMapLongClick(LatLng latLng){
        try{
            List<Adrress> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            if(addresses.size() > 0){
                Adress adress = adresses.get(0);
                String streetAdress = adress.getAdressLine(0);
                mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(streetAdress)
                    .draggable(true)          
                );
            }
        } catch (IOExceotion e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void onMarkerDragStart(Marker marker){
        
    }
    
    @Override
    public void onMarkerDrag(Marker marker){
        
    }
    
    @Override
    public void onMarkerDragEnd(Marker marker){
        LatLng latLng = marker.getPosition();
        try{
            List<Adrress> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
            if(addresses.size() > 0){
                Adress adress = adresses.get(0);
                String streetAdress = adress.getAdressLine(0);
                marker.setTitle(streetAdress);
            }
        } catch (IOExceotion e){
            e.printStackTrace();
        }
    }
}
