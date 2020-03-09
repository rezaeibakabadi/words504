package com.example.words504;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Proadapter extends BaseAdapter {
    List<Wordclass> arraylist;
    Context context;

    public Proadapter(List<Wordclass> items, Context context) {
        this.context = context;
        this.arraylist = items;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return arraylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_proadapter, viewGroup, false);
        }
        Wordclass proclass = (Wordclass) getItem(i);
        TextView name = view.findViewById(R.id.textname);
        int i1 = i + 1;
        name.setText(i1 + " -" + arraylist.get(i).name);
        return view;
    }
}
