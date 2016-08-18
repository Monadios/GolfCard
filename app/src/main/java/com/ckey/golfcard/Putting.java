package com.ckey.golfcard;

import android.app.Dialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.*;

public class Putting extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_putting );
        drawFields( 2, 9 );
    }

    private void drawFields(int numPlayers, int numRounds)
    {
        TableLayout table = (TableLayout) findViewById( R.id.table_layout );
        for ( int i = 0; i < numRounds; i++ ) {
            TableRow round = new TableRow( this );
            for ( int j = 0; j < numPlayers; j++ ) {
                EditText text = new EditText( this );
                text.setLayoutParams( new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT ) );
                text.setId( i * j );
                text.setInputType( InputType.TYPE_CLASS_NUMBER );
                round.addView( text, new TableRow.LayoutParams( i, TableRow.LayoutParams.WRAP_CONTENT, 1f ) );
            }
            table.addView( round );
        }
    }
}
