package com.ckey.golfcard;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Putting extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_putting );
        TableLayout table = (TableLayout) findViewById( R.id.table_layout );
        TableRow row = new TableRow( this );
        EditText text = new EditText( this );
        EditText text2 = new EditText( this );
        text.setInputType( InputType.TYPE_CLASS_NUMBER );
        row.addView(text, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
        row.addView(text2, new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
        table.addView( row );

        /*for(int i = 0; i < 9; i++) {
            table.addView( text );
        }*/
    }
}
