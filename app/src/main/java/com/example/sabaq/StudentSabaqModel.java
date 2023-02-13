package com.example.sabaq;

public class StudentSabaqModel {
    private int Id;
    private int SabaqParaNo;
    private int SabqiParaNo;
    private int ManzilParaNo;

    public StudentSabaqModel(int id, int sabaqParaNo, int sabqiParaNo, int manzilParaNo) {
        Id = id;
        SabaqParaNo = sabaqParaNo;
        SabqiParaNo = sabqiParaNo;
        ManzilParaNo = manzilParaNo;
    }

    public StudentSabaqModel() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSabaqParaNo() {
        return SabaqParaNo;
    }

    public void setSabaqParaNo(int sabaqParaNo) {
        SabaqParaNo = sabaqParaNo;
    }

    public int getSabqiParaNo() {
        return SabqiParaNo;
    }

    public void setSabqiParaNo(int sabqiParaNo) {
        SabqiParaNo = sabqiParaNo;
    }

    public int getManzilParaNo() {
        return ManzilParaNo;
    }

    public void setManzilParaNo(int manzilParaNo) {
        ManzilParaNo = manzilParaNo;
    }
}
