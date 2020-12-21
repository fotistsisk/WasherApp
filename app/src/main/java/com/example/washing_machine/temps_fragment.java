package com.example.washing_machine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class temps_fragment extends Fragment {
    private int type;

    public temps_fragment(int i) {
        type = i;
    }

// The onCreateView method is called when Fragment should create its View object hierarchy,
// either dynamically or via XML layout inflation.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle
            savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_temps, parent, false);
    }

    // This event is triggered soon after onCreateView().
// Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ListView lv = (ListView) view.findViewById(R.id.temps_listview);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        TextView time = view.findViewById(R.id.time_text);
        time.setText("");

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        String[] temps = {"20","30","40","60"};



        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        myArrayAdapter<String> arrayAdapter = new myArrayAdapter<String>(
                view.getContext(),
                R.layout.list_item,
                temps);

        arrayAdapter.changeSelected(type);

        lv.setAdapter(arrayAdapter);

        //arrayAdapter.notifyDataSetChanged();
        Toast.makeText(getActivity(),
                "Position: "+arrayAdapter.getView(1,null,lv),
                Toast.LENGTH_LONG).show();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long arg3) {
                arrayAdapter.changeSelected(position);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity(),
                        "Position: "+position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}