package com.example.helloworld;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView height;
    private TextView weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        weight = (TextView) findViewById(R.id.weight);
        height = (TextView) findViewById(R.id.height);
        result = (TextView) findViewById(R.id.result);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Witaj PJATK!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calcuteBMI(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !heightStr.equals("") && weightStr != null && !weightStr.equals("")) {
           float heightFloat = Float.parseFloat(heightStr) / 100;
           float weightFloat = Float.parseFloat(weightStr);
           float bmi = weightFloat / (heightFloat * heightFloat);

           showBMI(bmi);
        }
    }

    private void showBMI(float bmi) {
        String message = "";

        if (Float.compare(bmi, 18.5f) <= 0) {
            message = "Niedowaga!";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 24.9f) <= 0) {
            message = "Waga prawidłowa";
        } else if (Float.compare(bmi, 24.9f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            message = "Nadwaga";
        } else if (Float.compare(bmi, 30f) > 0) {
            message = "Otyłość";
        }

        message = bmi + "\n = \n" + message;
        result.setText(message);
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
