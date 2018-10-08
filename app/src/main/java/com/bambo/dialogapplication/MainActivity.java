package com.bambo.dialogapplication;

import android.app.Dialog;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomDialogActivity.OnInputListener {

    private static final String TAG = "MainActivity";

    //widgets
    private Button mOpenDialog, mShowFragment;
    public TextView mInputDisplay;

    //vars
    public String mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOpenDialog = findViewById(R.id.open_dialog);
        mShowFragment = findViewById(R.id.showfragment);
        mInputDisplay = findViewById(R.id.input_display);

        
        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: opening dialog.");

                MyCustomDialogActivity dialog = new MyCustomDialogActivity();
                dialog.show(getSupportFragmentManager(), "MyCustomDialog");
            }
        });

        mShowFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment();
            }
        });
    }

    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: got the input: " + input);

        //mInputDisplay.setText(input);
        setInputToTextView();
    }

    private void setInputToTextView(){
        mInputDisplay.setText(mInput);
    }

    private void openFragment(){
        MainFragment fragment = new MainFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, "MainFragment");
        transaction.commit();
    }
}
