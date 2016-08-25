package com.ckey.golfcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Putting extends AppCompatActivity
{
    private TableLayout table;
    private EditText p1score, p2score;
    private ArrayList<Integer> p1scores, p2scores;
    private Button nextButton;
    private int curRound;
    private Map<String, ArrayList<Integer>> scores;
    private TextView curRoundText;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_putting );
        curRound = 0;
        p1scores = new ArrayList<Integer>();
        p2scores = new ArrayList<Integer>();
        scores = new HashMap<String,ArrayList<Integer>>();
        p1score = (EditText) findViewById( R.id.p1_field );
        p2score = (EditText) findViewById( R.id.p2_field );
        p1score.setText( "" );
        p2score.setText( "" );
        curRoundText = (TextView) findViewById( R.id.holetext );
        curRoundText.setText( "Round " + curRound );
        nextButton = (Button) findViewById( R.id.next_btn );

        nextButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                /* TODO
                * Add error handling instead of just ignoring it
                *
                */

                if ( p1score.getText().length() != 0 && p1score.getText().length() != 0 ) {

                    int s1 = Integer.parseInt( p1score.getText().toString());
                    int s2 = Integer.parseInt( p2score.getText().toString());

                    p1scores.add(s1);
                    p2scores.add(s2);

                    scores.put( "P1", p1scores);
                    scores.put( "P2", p2scores);
                    p1score.setText( "" );
                    p2score.setText( "" );
                    curRound++;
                    curRoundText.setText(String.valueOf( curRound ));
                }
            }
        } );
    }



}
