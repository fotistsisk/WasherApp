package com.example.washing_machine;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TempsFragment extends Fragment {
    private int type;

    private MainActivity main;

    private DialogFragment dialogFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle
            savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_temps, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        type = main.getWashType();
        ListView listViewTemps = (ListView) view.findViewById(R.id.temps_listview);
        ListView listViewRotations = (ListView) view.findViewById(R.id.rotations_listview);
        Button beginButton = view.findViewById(R.id.start_button_temps);
        TextView timeText = view.findViewById(R.id.time_text);
        timeText.setText("2:10");



        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        String[] temps = {"20","30","40","60","90"};
        String[] rotations = {"600","800","1200","1400","1600"};


        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        myArrayAdapter<String> arrayAdapterTemps = new myArrayAdapter<String>(
                view.getContext(),
                R.layout.list_item,
                temps);

        myArrayAdapter<String> arrayAdapterRotations = new myArrayAdapter<String>(
                view.getContext(),
                R.layout.list_item,
                rotations);

        arrayAdapterTemps.changeSelected(type);

        arrayAdapterRotations.changeSelected(type);

        listViewTemps.setAdapter(arrayAdapterTemps);

        listViewRotations.setAdapter(arrayAdapterRotations);

        listViewTemps.setOnItemClickListener((parent, view1, position, arg3) -> {
            arrayAdapterTemps.changeSelected(position);
            arrayAdapterTemps.notifyDataSetChanged();
        });

        listViewRotations.setOnItemClickListener((parent, view1, position, arg3) -> {
            arrayAdapterRotations.changeSelected(position);
            arrayAdapterRotations.notifyDataSetChanged();
        });

        beginButton.setOnClickListener(v -> {
            dialogFragment = new DetergentDialogFragment();
            dialogFragment.show(main.getSupportFragmentManager(), "detergent");
        });
    }

    @Override
    public void onAttach(Activity activity) {
        main = (MainActivity) activity;
        super.onAttach(activity);
    }

    public DialogFragment getDialogFragment() {
        return dialogFragment;
    }
}