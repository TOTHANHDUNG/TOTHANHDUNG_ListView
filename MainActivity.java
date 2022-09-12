package com.example.creatlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    Button btnThem;
    EditText editMonHoc;
    Button btnCapNhat;
    Button btnView;
    ArrayList<String> arrayCourse;

    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc=(ListView) findViewById(R.id.listviewMonHoc);
        btnThem=(Button) findViewById(R.id.buttonThem);
        editMonHoc=(EditText) findViewById(R.id.editTextMonHoc);
        btnCapNhat=(Button) findViewById(R.id.buttonCapNhat);
        btnView=(Button) findViewById(R.id.buttonView);
        arrayCourse=new ArrayList<>();

        arrayCourse.add("Adroid");
        arrayCourse.add("PHP");
        arrayCourse.add("IOS");
        arrayCourse.add("Unity");
        arrayCourse.add("ASP.NET");
       final ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );
        lvMonHoc.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String monhoc=editMonHoc.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editMonHoc.setText(arrayCourse.get(i));
                vitri=i;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              arrayCourse.set(vitri,editMonHoc.getText().toString());
              adapter.notifyDataSetChanged();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                doOpenChildActivity();
                return false;
            }
        });
    }
    public void doOpenChildActivity()
    {
        Intent myIntent=new Intent(this, NewLayout.class);
        startActivity(myIntent);
    }
    }