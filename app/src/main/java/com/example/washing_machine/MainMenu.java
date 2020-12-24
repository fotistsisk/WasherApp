package com.example.washing_machine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainMenu extends Fragment implements View.OnClickListener{

// The onCreateView method is called when Fragment should create its View object hierarchy,
// either dynamically or via XML layout inflation.
private View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle
            savedInstanceState) {
        // Defines the xml file for the fragment
        mView = inflater.inflate(R.layout.fragment_main_menu, parent, false);

        return mView;
    }

    // This event is triggered soon after onCreateView().
// Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        LinearLayout whites_layout = (LinearLayout) view.findViewById(R.id.whites_layout);
        LinearLayout blacks_layout = (LinearLayout) mView.findViewById(R.id.blacks_layout);
        LinearLayout colors_layout = (LinearLayout) mView.findViewById(R.id.colors_layout);

        whites_layout.setOnClickListener(this);
        blacks_layout.setOnClickListener(this);
        colors_layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ((MainActivity)getActivity()).changeFragment(new TempsFragment());
    }

}