package com.ckey.golfcard;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import org.w3c.dom.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Putting extends AppCompatActivity
{
    private TableLayout table;
    private EditText p1score, p2score;
    private ArrayList<Integer> p1scores, p2scores;
    private Button nextButton, saveButton;
    private int curRound;
    private Map<String, ArrayList<Integer>> scores;
    private TextView curRoundText;
    private static final int MAX_ROUNDS = 2;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_putting );
        curRound = 1;
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
        saveButton = (Button) findViewById( R.id.save_btn );

        nextButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                /* TODO
                * Add error handling instead of just ignoring it
                *
                */
                if( curRound < MAX_ROUNDS) {

                    if ( p1score.getText().length() != 0 && p2score.getText().length() != 0 ) {

                        int s1 = Integer.parseInt( p1score.getText().toString() );
                        int s2 = Integer.parseInt( p2score.getText().toString() );

                        p1scores.add( s1 );
                        p2scores.add( s2 );

                        scores.put( "P1", p1scores );
                        scores.put( "P2", p2scores );
                        p1score.setText( "" );
                        p2score.setText( "" );
                        curRound++;
                        curRoundText.setText( "Round " + String.valueOf( curRound ) );
                        printScores();
                    }
                }else{
                    nextButton.setVisibility( View.GONE );
                    saveButton.setVisibility( View.VISIBLE );
                }
            }
        } );

        saveButton.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View view )
            {
                writeToFile( scoresToString(), getApplicationContext());
                String f = readFromFile(getApplicationContext());
                curRoundText.setText( f );
            }
        } );
    }


    // For debugging Purposes
    void printScores()
    {
        for( HashMap.Entry<String, ArrayList<Integer>> e : scores.entrySet()){
            System.out.println( e.getKey() );
            System.out.println( e.getValue() );
        }

    }

    String scoresToString()
    {
        String s = "";
        for( HashMap.Entry<String, ArrayList<Integer>> e : scores.entrySet()){
            s += e.getKey() + e.getValue();
        }

        return s;
    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}
