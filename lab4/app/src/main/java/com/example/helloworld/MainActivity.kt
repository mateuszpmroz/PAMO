package com.example.helloworld

import android.content.Intent
import android.os.Bundle

import com.google.android.material.snackbar.Snackbar

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var height: TextView? = null
    private var weight: TextView? = null
    private var result: TextView? = null
    private var age: TextView? = null
    private var sexRadioButtonGroup: RadioGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity_main)
    }

    fun calcuteBMI(view: View) {
        val heightStr = height!!.text.toString()
        val weightStr = weight!!.text.toString()
        val ageStr = age!!.text.toString()
        val checkedRadioButtonId = sexRadioButtonGroup!!.checkedRadioButtonId
        val radioButton = sexRadioButtonGroup!!.findViewById<View>(checkedRadioButtonId)
        val indexOfChild = sexRadioButtonGroup!!.indexOfChild(radioButton)

        if (heightStr != null && heightStr != "" && weightStr != null && weightStr != "" && ageStr != null && ageStr != "") {
            val heightFloat = java.lang.Float.parseFloat(heightStr) / 100
            val weightFloat = java.lang.Float.parseFloat(weightStr)
            val ageFloat = java.lang.Float.parseFloat(ageStr)
            val bmi = weightFloat / (heightFloat * heightFloat)

            showMessage(bmi, indexOfChild, weightFloat, heightFloat, ageFloat)
        }
    }

    fun moveToCalculator(view: View) {
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        weight = findViewById(R.id.weight) as TextView
        height = findViewById(R.id.height) as TextView
        result = findViewById(R.id.result) as TextView
        age = findViewById(R.id.age) as TextView
        sexRadioButtonGroup = findViewById(R.id.sex) as RadioGroup
        val fab = findViewById<View>(R.id.fab)
        fab.setOnClickListener(View.OnClickListener { view ->
            Snackbar.make(view, "Witaj PJATK!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        })
    }

    fun moveToQuiz(view: View) {
        val myIntent = Intent(this@MainActivity, QuizActivity::class.java)
        this@MainActivity.startActivity(myIntent)
    }

    fun moveToChart(view: View) {
        val myIntent = Intent(this@MainActivity, ChartActivity::class.java)
        this@MainActivity.startActivity(myIntent)
    }

    private fun showMessage(bmi: Float, indexOfChild: Int, weight: Float, height: Float, age: Float) {
        var message = ""
        var foodRecomendation = ""
        var kcal = 0.0

        if (java.lang.Float.compare(bmi, 18.5f) <= 0) {
            message = "Underweight!"
            foodRecomendation = "Rustle up a spicy supper using fish, \n vegetables or meat and a blend of rich flavours."
        } else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(bmi, 24.9f) <= 0) {
            message = "Correct weight"
            foodRecomendation = "Head to your spice rack to make this butter chicken curry, a dish \n that symbolises Indian food for millions of people all over the world"
        } else if (java.lang.Float.compare(bmi, 24.9f) > 0 && java.lang.Float.compare(bmi, 30f) <= 0) {
            message = "Overweight"
            foodRecomendation = "This gluten-free alternative is packed with lean protein \n from the chicken, and healthy, heart-friendly fats from the avocado"
        } else if (java.lang.Float.compare(bmi, 30f) > 0) {
            message = "Obesity"
            foodRecomendation = "Grill whole sweetcorn and serve with paprika-spiced \n chicken and crisp Little Gem for a healthy, speedy salad"
        }

        if (indexOfChild == 0) {
            kcal = 655.1 + 9.563 * weight + (1.85 + height) - 4.676 * age
        } else if (indexOfChild == 1) {
            kcal = 66.5 + 13.75 * weight + 5.003 * height - 6.775 * age
        }

        message = bmi.toString() + " = " + message + "\n \n You should eat " + kcal + "kcal to not loss weight" + "\n\n COVID-19 FOOD RECOMENDATION:\n " + foodRecomendation
        result!!.text = message
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
