package com.exvy.chievents;

import android.os.Bundle;

import com.exvy.chievents.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Kiem on 12/21/14.
 */
public class MyMapFragment extends SupportMapFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        GoogleMap googleMap = getMap();

        googleMap.setMyLocationEnabled(true);

        googleMap.getUiSettings().setZoomControlsEnabled(true);

        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(new LatLng(41.875768, -87.625470));
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
        markerOptions.title("Joffrey Ballet Nutcracker");

/**
        markerOptions.position(new LatLng(41.880691, -87.674176));
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        markerOptions.title("Disney On Ice presents Frozen");


        markerOptions.position(new LatLng(41.862313, -87.616688));
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        markerOptions.title("One Direction");

        markerOptions.position(new LatLng(41.938854, -87.648924));
        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher));
        markerOptions.title("Blue Man Group");
**/

        googleMap.addMarker(markerOptions);
    }
}
