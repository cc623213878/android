package com.chchyu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivityLife","now onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivityLife","now onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivityLife","now onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivityLife","now onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivityLife","now onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivityLife","now onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivityLife","now onRestart");
    }
}