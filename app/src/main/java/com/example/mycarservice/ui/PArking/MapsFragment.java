package com.example.mycarservice.ui.PArking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.location.LocationListener;
import com.example.mycarservice.R;
import com.example.mycarservice.databinding.FragmentMapsBinding;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.*;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private ParkingViewModel homeViewModel;
    private FragmentMapsBinding binding;
    FragmentManager fragManager;
    private GoogleMap mMap;
    private GoogleApiClient apiClient;
    private LocationRequest locationRequest;
    private Location lastLoocation;
    private Marker current;
    private Marker previus;
    private static final int Request_user_Location_code = 99;
    ArrayList<Marker>mark;


    protected synchronized void buildGoogleApiClient() {
        apiClient = new GoogleApiClient.Builder(getView().getContext()).addConnectionCallbacks(this).addConnectionCallbacks(this).addApi(LocationServices.API).build();
        apiClient.connect();

    }

    public MapsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(ParkingViewModel.class);

        binding = FragmentMapsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkUser();
        }

        ImageButton but=binding.buttonX;
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng parking = new LatLng(lastLoocation.getLatitude(), lastLoocation.getLongitude());
                mMap.addMarker(new MarkerOptions()
                        .position(parking)
                        .title("Marker in parking"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(parking));
                mMap.animateCamera(CameraUpdateFactory.zoomBy(14));
                System.out.println("edw");

            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);

        }
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        lastLoocation = location;

        if (current != null) {
            previus=current;

            current.remove();
        }


        //LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        //MarkerOptions markerOptions = new MarkerOptions();
       //markerOptions.position(latLng);
        //markerOptions.title("Parking Location");
        //current = mMap.addMarker(markerOptions);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        //mMap.animateCamera(CameraUpdateFactory.zoomBy(14));

        LatLng now = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions()
                .position(now)
                .title("Marker in current location")).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_menu_send));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(now));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(50));











        if (apiClient != null) {

            LocationServices.FusedLocationApi.removeLocationUpdates(apiClient, this);
        }


    }

    public void ParkingLocation(Marker current){
        mark=new ArrayList<>();
        mark.add(current);




    }




    @Override
    public void onConnected(@Nullable @org.jetbrains.annotations.Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1100);
        locationRequest.setFastestInterval(1100);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ActivityCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(apiClient, locationRequest, this);
        }


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull @NotNull ConnectionResult connectionResult) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);



        }
    }

    public boolean checkUser() {


        if (ContextCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            } else {

                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 99);
            }
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        switch (requestCode) {
            case Request_user_Location_code:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(binding.getRoot().getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                        if (apiClient == null) {

                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                } else {

                    Toast.makeText(binding.getRoot().getContext(), "permision Denied", Toast.LENGTH_LONG).show();

                }
                return;


        }
    }
}


