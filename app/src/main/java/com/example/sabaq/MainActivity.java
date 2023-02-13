package com.example.sabaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Student_Name;
    ListView SList;
    Button add_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper Student_Db = new DBHelper(MainActivity.this);

        Student_Name = findViewById(R.id.SName);
        add_btn = findViewById(R.id.Abutton);
        SList = findViewById(R.id.studentlist);


        setItemsInList();

//        ArrayList<String> SutendtsNames = new ArrayList<String>();
//        if(Stlist.size()!=0) {
//            for (int i = 0; i < Stlist.size(); i++) {
//                String str = Stlist.get(i).getName();
//                SutendtsNames.add(str);
//            }
//
//            ArrayAdapter<String> SAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SutendtsNames);
//            SList.setAdapter(SAdapter);
//        }
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentModel New_Student =new StudentModel();
                New_Student.setName(Student_Name.getText().toString());
                Student_Db.addStudent(New_Student);
                setItemsInList();
            }
        });

        SList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent SingleStudentActivity = new Intent(MainActivity.this,MainActivity3.class);
                SingleStudentActivity.putExtra("Selected_Option", i);
                MainActivity.this.startActivity(SingleStudentActivity);

            }
        });

    }

    public  void setItemsInList(){

        DBHelper Student_Db = new DBHelper(MainActivity.this);

        ArrayList<StudentModel> Stlist = new ArrayList<StudentModel>();
        Stlist = Student_Db.getAllStudents();

        ArrayList<String> SutendtsNames = new ArrayList<String>();

        if(Stlist.size()!=0) {
            for (int i = 0; i < Stlist.size(); i++) {
                String str = Stlist.get(i).getName();
                SutendtsNames.add(str);
            }

            ArrayAdapter<String> SAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, SutendtsNames);
            SList.setAdapter(SAdapter);
        }
    }
}