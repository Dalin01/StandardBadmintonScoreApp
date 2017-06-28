package com.example.darlington.standardbadmintonscoreapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Darlington on 5/15/2017.
 */

public class StatisticsDialog extends DialogFragment {

    String statMessage = "Player 1\n\nName: "+Singles.player_one_name+"\nGames Won: "+ScoreSheet.no_of_games_won_one+
            "\nWinner: "+ScoreSheet.player_one_wins+"\n\nPlayer 2\n\nName: "+Singles.player_two_name+
            "\nGames Won: "+ScoreSheet.no_of_games_won_two+"\nWinner: "+ScoreSheet.player_two_wins;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Statistics And Result");
        builder.setMessage(statMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
