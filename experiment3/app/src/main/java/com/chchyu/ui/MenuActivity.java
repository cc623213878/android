package com.chchyu.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.crazyit.ui.R;

public class MenuActivity extends Activity {
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //导入菜单布局
        getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(1, Menu.FIRST+10, 100, "登录");
        menu.add(1, Menu.FIRST+20, 200, "主页");
        menu.add(1, Menu.FIRST+30, 300, "上下文菜单页");
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        //创建菜单项的点击事件
        EditText editText=(EditText)findViewById(R.id.text_test);

        switch (item.getItemId()) {
            case Menu.FIRST+20:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case Menu.FIRST+10:
                new Login().login(this);
                break;
            case Menu.FIRST+30:
                startActivity(new Intent(this,LongDelete.class));
                break;
            case R.id.mune_text_size:
                break;
            case R.id.mune_text_size_10:
                editText.setTextSize(10);
                break;
            case R.id.mune_text_size_16:
                editText.setTextSize(16);
                break;
            case R.id.mune_text_size_20:
                editText.setTextSize(20);
                break;
            case R.id.mune_toast:
                Toast.makeText(this, "点击了普通菜单项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mune_text_color:
                break;
            case R.id.mune_text_color_red:
                editText.setTextColor(Color.RED);
                break;
            case R.id.mune_text_color_black:
                editText.setTextColor(Color.BLACK);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
