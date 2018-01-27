package com.benshabtay.michal.noahark;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 27.01.2018.
 */

public class ActivityStart extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);
        initSpinner();

        Button btn_startGame = findViewById(R.id.btn_startGame);
        btn_startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });


    }

    private void initSpinner() {
        // Spinner element
        spinner = findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                // On selecting a spinner item
                String item = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Spinner Drop down elements
        List<String> categories = new ArrayList<>();
        categories.add(Constants.DIFFICULTY_EASY);
        categories.add(Constants.DIFFICULTY_MEDIUM);
        categories.add(Constants.DIFFICULTY_HARD);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }


    private void startGame() {
        if(spinner != null) {
            String spinnerSelection = spinner.getSelectedItem().toString();
            if(spinnerSelection != null) {
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra(Constants.DIFFICULTY_KEY, spinnerSelection);
                startActivity(intent);
            }
        } else {
            new CustomSnackBar(findViewById(R.id.root_startView), "Please select difficulty", Snackbar.LENGTH_LONG);
        }
    }
}
