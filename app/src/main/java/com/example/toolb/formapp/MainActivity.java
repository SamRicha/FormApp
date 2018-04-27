package com.example.toolb.formapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText nameInput;
    private EditText jobInput;
    private EditText descriptionInput;
    private EditText ageInput;
    private Button errorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameInput = findViewById(R.id.nameTextEdit);
        ageInput = findViewById(R.id.ageTextEdit);
        errorButton = findViewById(R.id.SubmitButton);
        jobInput = findViewById(R.id.jobTextEdit);
        descriptionInput = findViewById(R.id.descriptionTextEdit);

    }

    public void goToSecondActivity(View view) {

        StringBuilder errMsg = new StringBuilder();
        int numErrors = 0;
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        if (isValid(nameInput)){
            intent.putExtra(Constants.KEY_NAME, nameInput.getText().toString());

        } else {
            numErrors += 1;
            errMsg.append("name input error").append("\n");
        }

        if (isValid(jobInput)) {
            intent.putExtra(Constants.KEY_JOB, jobInput.getText().toString());
        } else {
            numErrors += 1;
            errMsg.append("job input error").append("\n");
        }

        if (isValid(ageInput)) {
            intent.putExtra(Constants.KEY_AGE, ageInput.getText().toString());
        } else {
            numErrors += 1;
            errMsg.append("age input error").append("\n");
        }

        if (isValid(descriptionInput)) {
            intent.putExtra(Constants.KEY_DESC, descriptionInput.getText().toString());
        } else {
            numErrors += 1;
            errMsg.append("description input error").append("\n");
        }

        if (numErrors == 0) {
            errorButton.setText("Submit");
            startActivity(intent);

        } else {
            errorButton.setText(errMsg.toString());
        }


    }


    public boolean isValid(EditText input) {

        String name = input.getText().toString();
        int num = name.length();

        if (num >= 1){
            return true;
        }

        return false;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_NAME)) {
            nameInput.setText((String)savedInstanceState.get(Constants.KEY_NAME));
        }

        if (savedInstanceState.containsKey(Constants.KEY_AGE)) {
            ageInput.setText((String) savedInstanceState.get(Constants.KEY_AGE));
        }

        if (savedInstanceState.containsKey(Constants.KEY_JOB)) {
            jobInput.setText((String) savedInstanceState.get(Constants.KEY_JOB));
        }

        if (savedInstanceState.containsKey(Constants.KEY_DESC)) {
            descriptionInput.setText((String) savedInstanceState.get(Constants.KEY_DESC));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_NAME, nameInput.getText().toString());
        outState.putString(Constants.KEY_JOB, jobInput.getText().toString());
        outState.putString(Constants.KEY_DESC, descriptionInput.getText().toString());
        outState.putString(Constants.KEY_AGE, ageInput.getText().toString());    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
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
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

}
