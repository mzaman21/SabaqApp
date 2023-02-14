package com.example.sabaq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    GridView sabaqgird;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DBHelper Student_Db = new DBHelper(MainActivity2.this);
        sabaqgird  = findViewById(R.id.Sbaqgrid);

        List<StudentSabaqModel> list = Student_Db.getStudentsSabaq();

        GridAdapter gridAdapter = new GridAdapter(MainActivity2.this,list);
        sabaqgird.setAdapter(gridAdapter);


    }
}