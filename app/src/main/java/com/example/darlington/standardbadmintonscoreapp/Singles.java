package com.example.darlington.standardbadmintonscoreapp;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Singles extends AppCompatActivity {

    public static String player_one_name = "Player 1";
    public static String player_two_name = "Player 2";
    public static String player_one_gender, player_two_gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singles);
    }

    //method that selects the next player and eventually starts the game
    public void startGame(View view) {
        EditText name1 = (EditText) findViewById(R.id.name1);
        EditText name2 = (EditText) findViewById(R.id.name2);
        if (name1.getText().toString().isEmpty()){
            player_one_name = "Player 1";
        }
        else{
            player_one_name = name1.getText().toString();
        }
        if (name2.getText().toString().isEmpty()){
            player_two_name = "Player 2";
        }
        else{
            player_two_name = name2.getText().toString();
        }
        Intent i = new Intent(this, ScoreSheet.class);
        startActivity(i);
    }

    // Method that returns the selected/checked radio button
    public void gender1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.genderMale1:
                if (checked)
                    player_one_gender = "Male";
                break;
            case R.id.genderFemale1:
                if (checked)
                    player_one_gender = "Female";
                break;
        }

    }

    // Method that returns the selected/checked radio button
    public void gender2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.genderMale2:
                if (checked)
                    player_two_gender = "Male";
                break;
            case R.id.genderFemale2:
                if (checked)
                    player_two_gender = "Female";
                break;
        }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                DialogFragment fragment = new MenuAboutDialog();
                fragment.show(getSupportFragmentManager(), "About");
                return true;
            case R.id.exit:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

