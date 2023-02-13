package com.example.sabaq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    int selectedStudent;
    EditText USabaq,USbqi,UManzil;
    TextView CSabq,CSbqi,CManzil;
    Button RBtn, UBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        DBHelper Student_Db = new DBHelper(MainActivity3.this);

        StudentSabaqModel Current_Student = new StudentSabaqModel();

        Intent mIntent = getIntent();
        selectedStudent  = mIntent.getIntExtra("Selected_Option",0);

        USabaq = findViewById(R.id.Usbaq);
        USbqi = findViewById(R.id.Usbqi);
        UManzil= findViewById(R.id.Umanzil);

        CSabq = findViewById(R.id.Csbaq);
        CSbqi = findViewById(R.id.Csbaqi);
        CManzil = findViewById(R.id.Cmanzil);

        RBtn = findViewById(R.id.Recordbtn);
        UBtn = findViewById(R.id.Updatebtn);

        Current_Student = Student_Db.getStudentsbaq(selectedStudent);

        CSabq.setText(String.valueOf(Current_Student.getSabaqParaNo()));
        CSbqi.setText(String.valueOf(Current_Student.getSabqiParaNo()));
        CManzil.setText(String.valueOf(Current_Student.getManzilParaNo()));

        RBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AllStudentActivity = new Intent(MainActivity3.this,MainActivity2.class);
                MainActivity3.this.startActivity(AllStudentActivity);
            }
        });

        UBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              StudentSabaqModel UpdateSsabq = new StudentSabaqModel();
              UpdateSsabq.setId(selectedStudent);
              UpdateSsabq.setSabaqParaNo(Integer.parseInt(USabaq.getText().toString()));
              UpdateSsabq.setSabqiParaNo(Integer.parseInt(USbqi.getText().toString()));
              UpdateSsabq.setManzilParaNo(Integer.parseInt(UManzil.getText().toString()));

              UBtn.setText("Sabaq Is Updated");
            }
        });

    }
}