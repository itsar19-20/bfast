package com.ifts.bfastutente.Business;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.ifts.bfastutente.R;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, PermissionsListener,
        MapboxMap.OnMapClickListener, NavigationView.OnNavigationItemSelectedListener {
    private MapView mapView;
    private PermissionsManager permissionsManager;
    private MapboxMap mapboxMap;
    private FloatingActionButton btnHome, btnLocation;
    private DrawerLayout drawer;
    private Point originPosition, destinationPosition;
    private Marker destinationMarker; //marker deprecato, da sostituire
    private Button btnStartNavigation, btnPermissions;

    private static final String TAG = "MapActivity";


    public MapActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences ColorPreference = getApplicationContext().getSharedPreferences("color", 0);
        Boolean isDark = ColorPreference.getBoolean("isDark", true);

        //inizializazzione mappa
        Mapbox.getInstance(this, getString(R.string.mapbox_offline_error_region_definition_invalid));
        setContentView(R.layout.activity_main);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


    }

    public void createDrawer(Boolean isDark) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void onMapReady(@NonNull final MapboxMap mapboxMap) {

    }

    @Override
    public boolean onMapClick(@NonNull LatLng point) {
        return true;
    }


    public String createJson(Cursor c) {
        JSONObject featureCollection = new JSONObject();
        try {
            featureCollection.put("type", "FeatureCollection");

            JSONArray features = new JSONArray();
            while (c.moveToNext()) {

            }
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return featureCollection.toString();
    }

    public void setPopUp(Feature feature) {

    }

    private void getRoute(Point origin, Point destination) {

    }

    public void getRouteFromFavIntent(double latitudine, double longitudine) {

    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            mapboxMap.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {

                }
            });
        } else {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_CANCELED) recreate();
        } else if (requestCode == 2) {
            if (resultCode == RESULT_CANCELED) recreate();
        } else if (requestCode == 3) {
            if (resultCode == 1) {
                recreate();
            }
        } else if (requestCode == 4) {
            if (resultCode == 2) {

            }
        }
    }

    public void checkGPS() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertNoGps();
        }
    }

    public void getClosestMarker(Cursor c) {
        if (destinationMarker != null) destinationMarker.remove();
        Location mylocation = new Location("myLocation");
        Location closest = new Location("closest");
        Location temp = new Location("temp");
        double currentDistance = 999999999;
        try {
            mylocation.setLatitude(mapboxMap.getLocationComponent().getLastKnownLocation().getLatitude());
            mylocation.setLongitude(mapboxMap.getLocationComponent().getLastKnownLocation().getLongitude());
        } catch (Exception e) {
            checkGPS();
        }
        while (c.moveToNext()) {
            temp.setLongitude(c.getDouble(9));
            temp.setLatitude(c.getDouble(8));
            double distance = mylocation.distanceTo(temp);
            if (distance < currentDistance) {
                closest.setLatitude(temp.getLatitude());
                closest.setLongitude(temp.getLongitude());
                currentDistance = distance;
            }
        }
        getRouteFromFavIntent(closest.getLatitude(), closest.getLongitude());

    }

    private void buildAlertNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Abbilitare GPS per sfruttare  l'app al meglio?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivityForResult(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), 2);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        final AlertDialog noGps = builder.create();
        noGps.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}