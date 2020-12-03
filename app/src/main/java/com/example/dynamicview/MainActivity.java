package com.example.dynamicview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Person> data;
    ListView lw;
    private EditText firstName;
    private EditText secondName;
    private Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dummyData();
        lw=findViewById(R.id.list);
        firstName=findViewById(R.id.inputfn);
        secondName=findViewById(R.id.inputsn);
        add=findViewById(R.id.button);
        final MyPersonAdapter mpa=new MyPersonAdapter(this,R.layout.layout,data);
        lw.setAdapter(mpa);
        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mpa.remove(i);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn= firstName.getText().toString();
                String sn= secondName.getText().toString();
                Person p= new Person(fn,sn);
                mpa.add(p);
            }
        });
    }

    public void dummyData() {
        data=new ArrayList<>();
        data.add(new Person("Hamza","Shams"));
        data.add(new Person("Anas","Shams"));
    }
}