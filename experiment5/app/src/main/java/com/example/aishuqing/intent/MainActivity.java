package com.example.aishuqing.intent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
//import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private WebView webview;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button but1 = findViewById(R.id.bu_load_web);
        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                editText=findViewById(R.id.edit_url);
                intent.setAction("android.intent.action.VIEW");
                String url=editText.getText().toString();
                intent.putExtra("url",url);
                intent.setClass(MainActivity.this,WebViewActivity.class);
             //   System.out.println("aaaaaaaaaaaaaaaaaaaa"+url);
                Intent choose = Intent.createChooser(intent,"666");
             //  startActivity(choose);
               startActivity(intent);
4§AZ能b n m n b
            }
        });
    }



}