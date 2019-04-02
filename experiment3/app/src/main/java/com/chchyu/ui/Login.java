package com.chchyu.ui;

import android.app.AlertDialog;
import android.content.Context;

import android.view.View;

import org.crazyit.ui.R;

public class Login {

    public void login(Context context){
        View view = View.inflate(context, R.layout.login, null);
        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
