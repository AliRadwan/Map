package com.example.map1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final LatLng CAIRO = new LatLng(30.0595581,31.2234449);
    private static final LatLng MANSOURA = new LatLng(31.0414217,31.3653301);
    private static final LatLng ALEX = new LatLng(31.2242387,29.8848461);

    private Marker mCairo;
    private Marker mMansoura;
    private Marker mAlex;

    private GoogleMap mMap;

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
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        List<Marker> markerList = new ArrayList<>();

        mCairo = mMap.addMarker(new MarkerOptions()
        .position(CAIRO)
        .title("Cairo"));
        mCairo.setTag(0);
        markerList.add(mCairo);

        mMansoura = mMap.addMarker(new MarkerOptions()
        .position(MANSOURA)
        .title("Mansoura")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        mMansoura.setTag(0);
        markerList.add(mMansoura);

        mAlex = mMap.addMarker(new MarkerOptions()
        .position(ALEX)
        .title("Alex")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mAlex.setTag(0);
        markerList.add(mAlex);


        for (Marker m : markerList){
//            Log.d("Marker: ",m.getTitle());

            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,7));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,4));

        }

        // Add a marker in Sydney and move the camera

//        LatLng mansoura = new LatLng(30.0595581,31.2234449);
//       // LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(mansoura).title("Marker in mansoura")
//        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mansoura,15));
    }
}
