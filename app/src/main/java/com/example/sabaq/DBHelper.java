package com.example.sabaq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String Student_ID = "StudentID";
    public static final String Student_Name= "Name";
    public static final String Student_TABLE = "Sutdent";

    public static final String Student_S_ID = "SutdentID";
    public static final String Student_Sabaq = "Sabaq";
    public static final String Student_Sabqi = "Sabqi";
    public static final String Student_Manzil = "Manzil";

    public static final String Sabaq_TABLE = "StudentSabaq";


    public DBHelper(Context context) {
        super(context,"SabaqDb.db",null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase StudentDB) {
        String createTableSTatement = "CREATE TABLE " + Student_TABLE + "(" + Student_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + Student_Name + " Text) ";
        StudentDB.execSQL(createTableSTatement);

        String createSabaqTableSTatement = "CREATE TABLE " + Sabaq_TABLE + "(" + Student_S_ID + " Integer PRIMARY KEY, " + Student_Sabaq + " Integer, " + Student_Sabqi + " Integer, " + Student_Manzil + " Integer) ";
        StudentDB.execSQL(createSabaqTableSTatement);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addStudent(StudentModel Student_Data){

        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv= new ContentValues();

        cv.put(Student_Name, Student_Data.getName());

        db.insert(Student_TABLE, null, cv);
        db.close();
    }
    public ArrayList<StudentModel> getAllStudents() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Student_cursor = db.rawQuery("SELECT * FROM " + Student_TABLE, null);

        ArrayList<StudentModel> StudentArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (Student_cursor.moveToFirst()) {
            do {
                StudentArrayList.add(new StudentModel(
                        Student_cursor.getInt(0),
                        Student_cursor.getString(1)

                        )
                );
            } while (Student_cursor.moveToNext());

        }
        Student_cursor.close();
        return StudentArrayList;
    }
    public void addSSabaq(StudentSabaqModel Student_Data){

        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv= new ContentValues();

        cv.put(Student_S_ID, Student_Data.getId());
        cv.put(Student_Sabaq, Student_Data.getSabaqParaNo());
        cv.put(Student_Sabqi, Student_Data.getSabqiParaNo());
        cv.put(Student_Manzil, Student_Data.getManzilParaNo());

        db.insert(Sabaq_TABLE, null, cv);
        db.close();
    }

    public ArrayList<StudentSabaqModel> getStudentsSabaq() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Sabaq_cursor = db.rawQuery("SELECT * FROM " + Sabaq_TABLE, null);

        ArrayList<StudentSabaqModel> SabaqArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (Sabaq_cursor.moveToFirst()) {
            do {
                SabaqArrayList.add(new StudentSabaqModel(
                        Sabaq_cursor.getInt(0),
                        Sabaq_cursor.getInt(1),
                        Sabaq_cursor.getInt(2),
                        Sabaq_cursor.getInt(3)
                        )
                );
            } while (Sabaq_cursor.moveToNext());

        }
        Sabaq_cursor.close();
        return SabaqArrayList;
    }
    public StudentSabaqModel getStudentsbaq(int i) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Sabaq_cursor = db.rawQuery("SELECT * FROM " + Sabaq_TABLE + " WHERE Student_ID " + "=" + i , null);

       StudentSabaqModel SabaqData = new StudentSabaqModel();

        // moving our cursor to first position.
        if (Sabaq_cursor.moveToFirst()) {
            do {
                   SabaqData.setSabaqParaNo(Sabaq_cursor.getInt(1));
                   SabaqData.setSabqiParaNo(Sabaq_cursor.getInt(2));
                   SabaqData.setManzilParaNo(Sabaq_cursor.getInt(3));

            } while (Sabaq_cursor.moveToNext());

        }
        Sabaq_cursor.close();
        return SabaqData;
    }
    public void UpdateSSabaq(StudentSabaqModel Student_Data){

        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles

        ContentValues cv= new ContentValues();

        //Cursor Sabaq_cursor = db.rawQuery(" UPDATE " + Sabaq_TABLE + " SET " + Student_Sabaq + " = " + Student_Data.getSabaqParaNo() +Student_Sabqi + " = "+ Student_Data.getSabqiParaNo()+ Student_Manzil+ " = " +Student_Data.getManzilParaNo() + " WHERE Student_ID " + "=" + Student_Data.getId(), null);

        cv.put(Student_Sabaq, Student_Data.getSabaqParaNo());
        cv.put(Student_Sabqi, Student_Data.getSabqiParaNo());
        cv.put(Student_Manzil, Student_Data.getManzilParaNo());

        String whereclause = "Student_ID = ?";
        String[] whereargs = {String.valueOf(Student_Data.getId())};
        db.update(Sabaq_TABLE, cv, whereclause,whereargs);

        db.close();
    }

}
