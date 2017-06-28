package com.example.darlington.standardbadmintonscoreapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreSheet extends AppCompatActivity {

    int player_one_score;
    int player_two_score;
    int fouls_player_one;
    int fouls_player_two;
    public static int no_of_games_won_one;
    public static int no_of_games_won_two;
    public static String player_one_wins = "Undecided";
    public static String player_two_wins = "Undecided";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_sheet);

        TextView name1 = (TextView) findViewById(R.id.player1Name);
        name1.setText(Singles.player_one_name);
        TextView name2 = (TextView) findViewById(R.id.player2Name);
        name2.setText(Singles.player_two_name);

        ImageView img1 = (ImageView) findViewById(R.id.player1Img);
        ImageView img2 = (ImageView) findViewById(R.id.player2Img);
        if (Singles.player_one_gender == "Male") {
            img1.setImageResource(R.drawable.black_male);
        } else {
            img1.setImageResource(R.drawable.black_woman);
        }
        if (Singles.player_two_gender == "Male") {
            img2.setImageResource(R.drawable.white_male1);
        } else {
            img2.setImageResource(R.drawable.white_female);
        }

    }

    public void playerOnePoint(View view) {
        player_one_score += 1;
        TextView score1 = (TextView) findViewById(R.id.score1);
        score1.setText(Integer.toString(player_one_score));
        checkScore1();
        if(no_of_games_won_one == 3){
            player_one_wins = "Yes";
            player_two_wins = "No";
            endGame(view);
        }
    }

    public void playerTwoPoint(View view) {
        player_two_score += 1;
        TextView score2 = (TextView) findViewById(R.id.score2);
        score2.setText(Integer.toString(player_two_score));
        checkScore2();
        if(no_of_games_won_two == 3){
            player_two_wins = "Yes";
            player_one_wins = "No";
            endGame(view);
        }
    }

    public void playerOneFoul(View view) {
        player_two_score += 1;
        fouls_player_one += 1;
        TextView score2 = (TextView) findViewById(R.id.score2);
        score2.setText(Integer.toString(player_two_score));
        TextView fouls1 = (TextView) findViewById(R.id.foulsPlayer1);
        fouls1.setText(Integer.toString(fouls_player_one));
        checkScore2();
        if(no_of_games_won_two == 3){
            endGame(view);
        }
    }

    public void playerTwoFoul(View view) {
        player_one_score += 1;
        fouls_player_two += 1;
        TextView score1 = (TextView) findViewById(R.id.score1);
        score1.setText(Integer.toString(player_one_score));
        TextView fouls2 = (TextView) findViewById(R.id.foulsPlayer2);
        fouls2.setText(Integer.toString(fouls_player_two));
        checkScore1();
        if(no_of_games_won_one == 3){
            endGame(view);
        }
    }

    public void checkScore1(){
        if((player_one_score == 21 && (player_one_score - player_two_score >= 2)) || player_one_score == 30){
            no_of_games_won_one += 1;
            TextView gamesWon1 = (TextView) findViewById(R.id.gamesWon1);
            gamesWon1.setText(Integer.toString(no_of_games_won_one));
            defaultValues();
        }
    }

    public void checkScore2(){
        if((player_two_score == 21 && (player_two_score - player_one_score >= 2)) || player_two_score == 30){
            no_of_games_won_two += 1;
            TextView gamesWon2 = (TextView) findViewById(R.id.gamesWon2);
            gamesWon2.setText(Integer.toString(no_of_games_won_two));
            defaultValues();
        }
    }

    public void reset(View view){
        defaultValues();
        no_of_games_won_one = 0;
        TextView gamesWon1 = (TextView) findViewById(R.id.gamesWon1);
        gamesWon1.setText(Integer.toString(no_of_games_won_one));
        no_of_games_won_two = 0;
        TextView gamesWon2 = (TextView) findViewById(R.id.gamesWon2);
        gamesWon2.setText(Integer.toString(no_of_games_won_two));
    }

    public void defaultValues(){
        player_one_score = 0;
        TextView score1 = (TextView) findViewById(R.id.score1);
        score1.setText(Integer.toString(player_one_score));
        player_two_score = 0;
        TextView score2 = (TextView) findViewById(R.id.score2);
        score2.setText(Integer.toString(player_two_score));
        fouls_player_one = 0;
        TextView fouls1 = (TextView) findViewById(R.id.foulsPlayer1);
        fouls1.setText(Integer.toString(fouls_player_one));
        fouls_player_two = 0;
        TextView fouls2 = (TextView) findViewById(R.id.foulsPlayer2);
        fouls2.setText(Integer.toString(fouls_player_two));
    }

    public void endGame(View view){
        DialogFragment fragment = new DialogForWinner();
        fragment.show(getSupportFragmentManager(), "game");
    }

    public void statistics(View view){
        DialogFragment fragment = new StatisticsDialog();
        fragment.show(getSupportFragmentManager(), "Statistics");
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


