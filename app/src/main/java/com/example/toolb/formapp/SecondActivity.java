package com.example.toolb.formapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private TextView messageView;
    private Button loginBtn;
    private EditText nameIn;
    private EditText userNameIn;
    private EditText emailIn;
    private TextView dobIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        TextView nameDisplay = findViewById(R.id.nameDisplayTextView);
        TextView ageDisplay = findViewById(R.id.ageDisplayTextView);
        TextView jobDisplay = findViewById(R.id.occupationDisplayTextView);
        TextView descriptionDisplay = findViewById(R.id.descriptionDisplayTextView);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Log.i(TAG, "intent");

        assert b != null;
        if (b.containsKey(Constants.KEY_NAME)){
            String name = b.getString(Constants.KEY_NAME);
            String lowerCaseName = name.toLowerCase();
            String properName = lowerCaseName.substring(0, 1).toUpperCase() + lowerCaseName.substring(1);
            nameDisplay.setText(properName);
        }

        if (b.containsKey(Constants.KEY_AGE)){
            String str = b.getString(Constants.KEY_AGE);
            ageDisplay.setText(str);
        }

        if (b.containsKey(Constants.KEY_JOB)){
            String str = b.getString(Constants.KEY_JOB);
            jobDisplay.setText(str);
        }

        if (b.containsKey(Constants.KEY_DESC)){
            String str = b.getString(Constants.KEY_DESC);
            descriptionDisplay.setText(str);
        }

        /*
        profilename.setText(name);
        profileage.setText(age);
        profileocuppation.setText(job);
        profilebio.setText(bio);
        */
    }
    public void goToMainActivity(View view){
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
        //this.finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}