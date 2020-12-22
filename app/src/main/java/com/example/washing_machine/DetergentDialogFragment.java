package com.example.washing_machine;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class DetergentDialogFragment extends androidx.fragment.app.DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.detergent_dialog)
                .setPositiveButton(R.string.continue_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity main = (MainActivity) getActivity();
                        if(main.isDetergentSensor())
                            main.changeFragment(new WashingFragment());
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();

    }
    @Override
    public void onStart() {
        super.onStart();
        MainActivity main = (MainActivity) getActivity();
        if(!main.isDetergentSensor())
            ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getContext().getResources().getColor(R.color.red));
        else
            ((AlertDialog) getDialog()).getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(getContext().getResources().getColor(R.color.green));
    }
}