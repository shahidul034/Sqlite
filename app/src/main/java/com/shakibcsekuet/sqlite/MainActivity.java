package com.shakibcsekuet.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    Button b,b1;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.bday);
        b=(Button)findViewById(R.id.save);
        b1=(Button)findViewById(R.id.show);
        final MyDBFunctions mf = new MyDBFunctions(getApplicationContext());
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _name=e1.getText().toString();
                String _bday=e2.getText().toString();
                DataTemp dt = new DataTemp(_name, _bday);

                mf.addingDataToTable(dt);
                Toast.makeText(getApplicationContext(),"Data added successfully!", Toast.LENGTH_SHORT).show();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BirthdayOfFriends.class));
            }
        });


    }
}
