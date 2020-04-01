package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView height;
    private TextView weight;
    private TextView result;
    private  TextView age;
    private RadioGroup sexRadioButtonGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity_main);
    }

    public void calcuteBMI(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        String ageStr = age.getText().toString();
        int checkedRadioButtonId = sexRadioButtonGroup.getCheckedRadioButtonId();
        View radioButton = sexRadioButtonGroup.findViewById(checkedRadioButtonId);
        int indexOfChild = sexRadioButtonGroup.indexOfChild(radioButton);

        if (heightStr != null && !heightStr.equals("") && weightStr != null && !weightStr.equals("") && ageStr != null && !ageStr.equals("")) {
           float heightFloat = Float.parseFloat(heightStr) / 100;
           float weightFloat = Float.parseFloat(weightStr);
           float ageFloat = Float.parseFloat(ageStr);
           float bmi = weightFloat / (heightFloat * heightFloat);

            showMessage(bmi, indexOfChild, weightFloat, heightFloat, ageFloat);
        }
    }

    public void moveToCalculator(View view) {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        weight = (TextView) findViewById(R.id.weight);
        height = (TextView) findViewById(R.id.height);
        result = (TextView) findViewById(R.id.result);
        age = (TextView) findViewById(R.id.age);
        sexRadioButtonGroup = (RadioGroup) findViewById(R.id.sex);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Witaj PJATK!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void moveToQuiz(View view) {
        Intent myIntent = new Intent(MainActivity.this, QuizActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    private void showMessage(float bmi, int indexOfChild, float weight, float height, float age) {
        String message = "";
        String foodRecomendation = "";
        double kcal = 0;

        if (Float.compare(bmi, 18.5f) <= 0) {
            message = "Underweight!";
            foodRecomendation = "Rustle up a spicy supper using fish, \n vegetables or meat and a blend of rich flavours.";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 24.9f) <= 0) {
            message = "Correct weight";
            foodRecomendation = "Head to your spice rack to make this butter chicken curry, a dish \n that symbolises Indian food for millions of people all over the world";
        } else if (Float.compare(bmi, 24.9f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            message = "Overweight";
            foodRecomendation = "This gluten-free alternative is packed with lean protein \n from the chicken, and healthy, heart-friendly fats from the avocado";
        } else if (Float.compare(bmi, 30f) > 0) {
            message = "Obesity";
            foodRecomendation = "Grill whole sweetcorn and serve with paprika-spiced \n chicken and crisp Little Gem for a healthy, speedy salad";
        }

        if (indexOfChild == 0) {
            kcal = 655.1 + (9.563 * weight) + (1.85 + height) - (4.676 * age);
        } else if (indexOfChild == 1) {
            kcal = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
        }

        message = bmi + " = " + message + "\n \n You should eat " + kcal + "kcal to not loss weight" + "\n\n COVID-19 FOOD RECOMENDATION:\n " + foodRecomendation;
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
