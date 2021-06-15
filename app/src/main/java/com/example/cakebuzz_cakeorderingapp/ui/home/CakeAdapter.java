package com.example.cakebuzz_cakeorderingapp.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.cakebuzz_cakeorderingapp.R;

import java.util.ArrayList;
// i want to use arraylist
public class CakeAdapter extends ArrayAdapter<Cake> {
    private Context mContext;
    private int mResource;
    public CakeAdapter(@NonNull FragmentActivity context, int resource, @NonNull ArrayList<Cake> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource,parent,false);
        ImageView imageView= convertView.findViewById(R.id.image);
        TextView txtname= convertView.findViewById(R.id.txtname);
        TextView txtDes= convertView.findViewById(R.id.txtsub);
        imageView.setImageResource(getItem(position).getImage());
        txtname.setText(getItem(position).getName());
        txtDes.setText(getItem(position).getDes());

        return convertView;
    }
    }
