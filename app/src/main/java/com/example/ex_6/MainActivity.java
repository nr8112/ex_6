package com.example.ex_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Switch sw;
    Button calculation;
    boolean geo_mat ,yes;
    EditText add, start;
    String adds, starts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        add = findViewById(R.id.ed1);
        start = findViewById(R.id.ed2);
        sw = findViewById(R.id.sw);
        calculation = findViewById(R.id.calculation);
        setContentView(R.layout.activity_main);

    }



    public void cred(View view) {
        Intent cr=new Intent(this,credits.class);
        startActivity(cr);
    }


    public void ret(View view) {
        yes =true;
        Intent ac=new Intent(this,Activity2.class);
        ac.putExtra("YES",yes );
        startActivity(ac);

    }
    public void calculat(View view) {
        geo_mat = sw.isChecked();
        adds = add.getText().toString();
        starts = start.getText().toString();

        while (adds.isEmpty()) {
            Toast.makeText(this, "please enter a number in Adds / multiplies", Toast.LENGTH_SHORT).show();
            add.setText("");
        }

        while (starts.isEmpty()) {
            Toast.makeText(this, "please enter a number in start", Toast.LENGTH_SHORT).show();
            add.setText("");
        }

            Intent ac2=new Intent(this,Activity2.class);
            ac2.putExtra("add",adds );
            ac2.putExtra("start",starts );
            ac2.putExtra("noa",geo_mat );
            startActivity(ac2);
        }

    }

