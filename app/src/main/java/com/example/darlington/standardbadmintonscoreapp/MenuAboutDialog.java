package com.example.darlington.standardbadmintonscoreapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Darlington on 5/15/2017.
 */

public class MenuAboutDialog extends DialogFragment {

    String message = "In a major tournament, a coin toss is used to decide which side will serve first.\n\n" +
            "Every time you win a rally, you get a point. Starting from zero, the first person to reach 21 points wins the game." +
            "A match is the best of three games: you win the match by winning 3 games.\n\n" +
            "NOTE: You have to win the game by at least two points. If the score reaches 20–20, then 21 points are no longer enough to win the game." +
            " You need to win two clear points: two points in a row, one after the other. " +
            "For example, 22–20 would be a winning score, as would 25–23. But 21–20 would not be enough," +
            " and neither would 24–23. If you reach 30–29, however, you’ve won the game. 30 points is the upper limit." +
            "\n\n\n\n Courtesy: www.badmintonbible.com";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("About");
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }
}
