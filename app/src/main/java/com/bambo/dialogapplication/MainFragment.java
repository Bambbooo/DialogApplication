package com.bambo.dialogapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainFragment extends Fragment implements MyCustomDialogFragment.OnInputSelected {
    private static final String TAG = "MainFragment";



    //widgets
    private Button mOpenDialog;
    public TextView mInputDisplay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mOpenDialog = view.findViewById(R.id.open_dialog);
        mInputDisplay = view.findViewById(R.id.input_display);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog.");

                MyCustomDialogFragment dialog = new MyCustomDialogFragment();
                dialog.setTargetFragment(MainFragment.this, 1); /* can be any number */
                dialog.show(getFragmentManager(), "MyCustomDialog");
            }
        });


        return  view;
    }

    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: got the message" + input);

        mInputDisplay.setText(input);
    }
}
