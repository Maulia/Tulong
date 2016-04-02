package com.example.user.tulong;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by LIA on 02-Apr-16.
 */
public class HubungiActivity extends Activity {
    TextView activityTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubungi);
        setTitle("Menghubungi");

        activityTitle = (TextView) findViewById(R.id.textView);
        activityTitle.setText("Hey");

        Bundle bundle = getIntent().getExtras();

        String option = bundle.getString("option");

        Toast.makeText(getApplicationContext(), "Mencari kantor "+option, Toast.LENGTH_SHORT).show();
    }
}
