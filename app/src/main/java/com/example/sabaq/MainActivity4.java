package com.example.sabaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {

    EditText NSabaq,NSbqi,NManzil;
    Button ABtn;
    int selectedStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        DBHelper Student_Db = new DBHelper(MainActivity4.this);

        Intent mIntent = getIntent();
        selectedStudent  = mIntent.getIntExtra("Selected_Option",0);

        NSabaq = findViewById(R.id.ASabaq);
        NSbqi = findViewById(R.id.ASabaqi);
        NManzil= findViewById(R.id.AManzil);
        ABtn = findViewById(R.id.ANbtn);

        ABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentSabaqModel AddNewSsabq = new StudentSabaqModel();
                AddNewSsabq.setId(selectedStudent);
                AddNewSsabq.setSabaqParaNo(Integer.parseInt(NSabaq.getText().toString()));
                AddNewSsabq.setSabqiParaNo(Integer.parseInt(NSbqi.getText().toString()));
                AddNewSsabq.setManzilParaNo(Integer.parseInt(NManzil.getText().toString()));
                Student_Db.addSSabaq(AddNewSsabq);
                ABtn.setText("Sabaq Is Added");

            }
        });

    }
}