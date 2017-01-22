package com.example.andreasantoro.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*
         * This data structure HashMap contains different types of categories of food.
         */
        HashMap<String, String[]> categories = new HashMap<>();

        String[] fish = {"Cod", "Salmon", "Tuna"};
        String[] vegetables = {"Grilled vegetables", "Salad", "Boiled Vegetables", "Healthy Food"};
        String[] desserts = {"Cake", "Ice cream", "Fruit Salads"};

        categories.put("FISH", fish);
        categories.put("VEGETABLES", vegetables);
        categories.put("DESSERTS", desserts);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String getCategory = intent.getStringExtra(MainActivity.EXTRA_MESSAGE).toUpperCase().trim();

        TextView textView = new TextView(this);
        textView.setTextSize(40);

        /*
        * The try catch, captures the exception whether the category is found in the HashMap or not
        * without this, the app will crash, as an exception will be returned.
        * The for loop goes over all the categories there are for the category selected.
        */
        try{
            for(int i = 0; i < categories.get(getCategory).length; i++){
                textView.append(categories.get(getCategory)[i] + "\n");
            }
        }catch (NullPointerException noCategory){
            textView.setText("Sorry the category '" + getCategory + "' was not found.");
        }

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        layout.addView(textView);

    }
}
