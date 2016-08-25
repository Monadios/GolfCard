package com.ckey.golfcard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Putting extends AppCompatActivity
{
    private TableLayout table;
    private EditText p1score,p2score;
    private ArrayList<Integer> p1scores, p2scores;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_putting );
        p1score = (EditText) findViewById( R.id.p1_field );
        p2score = (EditText) findViewById( R.id.p2_field );
        p1score.setOnEditorActionListener( new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction( TextView textView, int i, KeyEvent keyEvent )
            {
                return false;
            }
        } );

        p2score.setOnEditorActionListener( new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction( TextView textView, int i, KeyEvent keyEvent )
            {
                return false;
            }
        } );
    }




}
