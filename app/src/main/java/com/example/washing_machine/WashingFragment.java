package com.example.washing_machine;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.le.ScanSettings;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WashingFragment extends Fragment {
    private MainActivity main;
    private boolean colonBool;
    TextView stageTextView,timeTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle
            savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_washing, parent, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int type = main.getWashType();
        colonBool = true;
        stageTextView = view.findViewById(R.id.washing_stage_text);
        timeTextView = view.findViewById(R.id.time_left_washing_text);
        timeTextView.setText("1 : 35");
        blinkingColon();

        int time = 0;

        switch(type){
            case 0:
                time = 8100000;
                break;
            case 1:
                time = 7200000;
                break;
            case 2:
                time = 6300000;
                break;
        }

    }

    private void blinkingColon() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 1000;
                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
                handler.post(() -> {
                    String time = timeTextView.getText().toString();
                    if(colonBool)
                        time = time.substring(0,2)+':'+time.substring(3);
                    else
                        time = time.substring(0,2)+' '+time.substring(3);
                    colonBool = !colonBool;
                    timeTextView.setText(time);
                    blinkingColon();
                });
            }
        }).start();
    }

    @Override
    public void onAttach(Activity activity) {
        main = (MainActivity) activity;
        super.onAttach(activity);
    }


}