package com.example.sabaq;

import static com.example.sabaq.R.color.grey;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
    Button RBtn, UBtn, ABtn;

    @SuppressLint("ResourceAsColor")
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
        ABtn = findViewById(R.id.AddNew);

        Current_Student = Student_Db.getStudentsbaq(selectedStudent);

        if(Current_Student.getSabaqParaNo()==0){
            CSabq.setText("None");
            CSbqi.setText("None");
            CManzil.setText("None");
            ABtn.setEnabled(true);
            UBtn.setEnabled(false);
            UBtn.setBackgroundColor(grey);
        }
        else {
            ABtn.setEnabled(false);
            ABtn.setBackgroundColor(grey);
            CSabq.setText(String.valueOf(Current_Student.getSabaqParaNo()));
            CSbqi.setText(String.valueOf(Current_Student.getSabqiParaNo()));
            CManzil.setText(String.valueOf(Current_Student.getManzilParaNo()));
        }
        RBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AllStudentActivity = new Intent(MainActivity3.this,MainActivity2.class);
                MainActivity3.this.startActivity(AllStudentActivity);
            }
        });

        ABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent SingleStudentActivity = new Intent(MainActivity3.this,MainActivity4.class);
                SingleStudentActivity.putExtra("Selected_Option", selectedStudent);
                MainActivity3.this.startActivity(SingleStudentActivity);
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
              Student_Db.UpdateSSabaq(UpdateSsabq);
              UBtn.setText("Sabaq Is Updated");
              Intent SingleStudentActivity = new Intent(MainActivity3.this,MainActivity2.class);
              MainActivity3.this.startActivity(SingleStudentActivity);
            }
        });

    }
}