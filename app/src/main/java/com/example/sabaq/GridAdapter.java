package com.example.sabaq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {

    Context context;
    List<StudentSabaqModel> list=new ArrayList<StudentSabaqModel>();

    public GridAdapter(Context context, List<StudentSabaqModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myview= inflater.inflate(R.layout.grid_item,null);

        TextView S_ID,S_Sabaq,S_Sabqi,S_Manzil;

        S_ID = myview.findViewById(R.id.SId);
        S_Sabaq = myview.findViewById(R.id.SSabaq);
        S_Sabqi = myview.findViewById(R.id.SSabaqi);
        S_Manzil = myview.findViewById(R.id.SManzil);

        String Sid = String.valueOf(list.get(position).getId());
        String Ssabaq  = String.valueOf(list.get(position).getSabaqParaNo());
        String Ssabqi  = String.valueOf(list.get(position).getSabqiParaNo());
        String Smanzil  = String.valueOf(list.get(position).getManzilParaNo());

        S_ID.setText(Sid);
        S_Sabaq.setText(Ssabaq);
        S_Sabqi.setText(Ssabqi);
        S_Manzil.setText(Smanzil);

        return myview;

    }

}
