package com.example.ex_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity implements View.OnCreateContextMenuListener, AdapterView.OnItemClickListener {

    String add_string, start_string;
    boolean matmtOrGeomt,yes;
    ListView series;
    int startInt, addInt ,x,sum,a;
    String[] listViweString = new String[20];
    TextView textViewMenuConteext,tveXpln;
    int[]arr=new int[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        series = findViewById(R.id.lv);
        textViewMenuConteext=findViewById(R.id.tv2);
        tveXpln=findViewById(R.id.tv);
        series.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        data();
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, //
                R.layout.support_simple_spinner_dropdown_item, listViweString);
        series.setAdapter(adp);
        series.setOnCreateContextMenuListener(this);
        backToMain();
        data();
    }

    private void backToMain() {
        Intent NO = getIntent();
        yes = Boolean.valueOf(NO.getStringExtra("YES"));
        if(yes){ finish();}
    }


    public void data() {
        Intent noa = getIntent();
        add_string = noa.getStringExtra("add");
        start_string = noa.getStringExtra("start");
        matmtOrGeomt = Boolean.valueOf(noa.getStringExtra("noa"));
        startInt = Integer.valueOf(start_string);
        addInt = Integer.valueOf(add_string);
        series.setOnItemClickListener(this);
        if (matmtOrGeomt) {
            for (int i = 0; i <= 20; i++) {
                listViweString[i] = String.valueOf(startInt + addInt);
                startInt = startInt + addInt;
            }
        } else {
            for (int i = 0; i <= 20; i++) {
                listViweString[i] = String.valueOf(startInt * addInt);
                startInt = startInt * addInt;
            }
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Operations");
        menu.add("where is that?");
        menu.add("sum?");
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        x=position;

    }
    public boolean onContextItemSelected(MenuItem item) {
        String oper=item.getTitle().toString();
        if (oper.equals("sum")) {
           tveXpln.setText("sum is:");
            for (int i = 0; i <=x ; i++) {
                a = Integer.valueOf(listViweString[i]);
                sum = a + sum;
            }
            return true;
            }

        if (oper.equals("where is that?")) {
            tveXpln.setText("where is that:");
            textViewMenuConteext.setText(x);


            return true;
        }
        return super.onContextItemSelected(item);
    }






}