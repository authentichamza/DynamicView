package com.example.dynamicview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyPersonAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<Person> data;
    public MyPersonAdapter(@NonNull Context context, int resource, @NonNull ArrayList data) {
        super(context, resource, data);
        this.data=data;
        this.resource=resource;
        this.context=context;
    }

    public void add(@Nullable Person person) {
        data.add(person);
        notifyDataSetChanged();
    }
    public void remove(int position){
        data.remove(position);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder holder;
        if(convertView!=null){
            view=convertView;
            holder=(ViewHolder) view.getTag();
        }
        else{
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(resource,parent,false);
            holder=new ViewHolder();
            holder.firstName=view.findViewById(R.id.f_person);
            holder.secondName=view.findViewById(R.id.s_person);
        }

        Person p=data.get(position);
        holder.firstName.setText(p.firstName);
        holder.secondName.setText(p.secondName);

        return view;
    }
    static class ViewHolder{
        TextView firstName,secondName;
    }
}
