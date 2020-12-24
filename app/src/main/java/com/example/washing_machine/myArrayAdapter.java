package com.example.washing_machine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

public class myArrayAdapter<S> extends ArrayAdapter {

    int mSelectedItem = -1;

    public myArrayAdapter(@NonNull Context context, int resource, @NonNull Object[] objects) {
        super(context, resource, objects);
    }

    public myArrayAdapter(@NonNull Context context, int resource, @NonNull Object[] objects, int defaultItem) {
        super(context, resource, objects);
        mSelectedItem = defaultItem;
    }

    public void changeSelected(int selected){

        mSelectedItem = selected;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View view = super.getView(position, convertView, parent);
        if (position == mSelectedItem) {
            view.setBackgroundColor(ResourcesCompat.getColor(getContext().getResources(), R.color.green, null));
        }
        else {
            view.setBackgroundColor(0x00000000); //transparent
        }

        return view;
    }
}
