package com.example.locationpinned;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        // Initializing my edit and text views
    }

    public void button(View view){
        // view for location button

        Geocoder geocoder = new Geocoder(this);
        // adding geocoder to application
        List<Address> addressList;
        // creates address list variable to be used in geocoding function

        try {
            addressList = geocoder.getFromLocationName(editText.getText().toString(),1);
            // gets string from text input and grabs location
            if (addressList != null) {
                // checks if location exists
                double doubleLAT = addressList.get(0).getLatitude();
                double doubleLong = addressList.get(0).getLongitude();
                // gets latitude and longitude in Long to get all decimal places

                textView.setText("Lat = " + String.valueOf(doubleLAT)
                        + " I " + "Long =: " + String.valueOf(doubleLong));
                // displays latitude and longitude on textview
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}