package com.example.vulpes.phoneadvisorwithaa.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by vulpes on 21/01/15.
 */
public class MyDialogFragment extends DialogFragment {

    // Container Activity must implement this interface
    public interface OnChoiceSelectedListener {
        public void onPositiveSelected(boolean positiveSelected, int phoneId);
    }

    OnChoiceSelectedListener mListener;
    int phoneId;
    String fragTitle;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnChoiceSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnChoiceSelectedListener");
        }
        phoneId = getArguments().getInt("phoneId", 0);
        fragTitle = getArguments().getString("fragTitle");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder
                .setTitle(fragTitle)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onPositiveSelected(true, phoneId);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onPositiveSelected(false, phoneId);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}

