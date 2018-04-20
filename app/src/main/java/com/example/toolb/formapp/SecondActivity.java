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
    private EditText nameIn;
    private EditText userNameIn;
    private EditText emailIn;
    private TextView dobIn;
    private Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        messageView = findViewById(R.id.messageTextView);

        StringBuilder msg = new StringBuilder("Thanks for signing up, ");

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Log.i(TAG, "intent");

        assert b != null;
        if (b.containsKey(Constants.KEY_NAME)){
            String name = b.getString(Constants.KEY_NAME);
            String lowerCaseName = name.toLowerCase();
            String properName = lowerCaseName.substring(0, 1).toUpperCase() + lowerCaseName.substring(1);
            msg.append(properName).append("!");
        }

        messageView.setText(msg);
    }

    public void goToMainActivity(View view){
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
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
