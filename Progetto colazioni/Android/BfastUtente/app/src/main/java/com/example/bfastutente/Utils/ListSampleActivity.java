package com.example.bfastutente.Utils;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.bfastutente.R;

public class ListSampleActivity extends CursorAdapter {


    public ListSampleActivity(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.activity_listaprodotti, parent, false);
        return retView;
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textViewPersonUsername = (TextView) view.findViewById(R.id.ETcopass);
        textViewPersonUsername.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0))));
        TextView textViewPersonName = (TextView) view.findViewById(R.id.ETnome);
        textViewPersonName.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));
    }
}