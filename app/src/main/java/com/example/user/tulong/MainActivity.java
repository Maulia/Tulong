package com.example.user.tulong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button policeButton;
    Button fireButton;
    Button hospitalButton;
    Button relativesButton;

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

            policeButton = (Button) findViewById(R.id.buttonPolice);
            hospitalButton = (Button) findViewById(R.id.buttonHospital);
            fireButton = (Button) findViewById(R.id.buttonFire);
            relativesButton = (Button) findViewById(R.id.buttonRelatives);

            policeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent hub = new Intent (MainActivity.this, HubungiActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("option", "police");
                    hub.putExtras(bundle);

                    MainActivity.this.startActivity(hub);

                }
            });

            hospitalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent hub = new Intent (MainActivity.this, HubungiActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("option", "hospital");
                    hub.putExtras(bundle);

                    MainActivity.this.startActivity(hub);

                }
            });


            fireButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent hub = new Intent (MainActivity.this, HubungiActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("option", "fire_station");
                    hub.putExtras(bundle);

                    MainActivity.this.startActivity(hub);

                }
            });

            relativesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent hub = new Intent (MainActivity.this, HubungiActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("option", "relatives");
                    hub.putExtras(bundle);

                    MainActivity.this.startActivity(hub);

                }
            });


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
