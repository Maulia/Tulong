package com.example.user.tulong;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView locationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLocation();
    }

    public void getLocation(){

        GPSTracker gps = new GPSTracker(this);

        if(gps.canGetLocation()){
            //final Location location = gps.getLocation();
            double lat = gps.getLatitude();
            double lng = gps.getLongitude();
            locationText = (TextView) findViewById(R.id.currentLocation);
            locationText.setText("Anda berada di...\nlat: " + lat + "\nlong: " + lng);

            Toast.makeText(getApplicationContext(), "Selesai", Toast.LENGTH_SHORT).show();

        }else{
            gps.showSettingsAlert();
            Toast.makeText(getApplicationContext(), "Not active", Toast.LENGTH_SHORT).show();
        }
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
