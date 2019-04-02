package com.chchyu.ui;

import android.app.Activity;
import android.app.admin.SystemUpdateInfo;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.crazyit.ui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongDelete extends Activity {

    private ListView listView;
    private String[] names = new String[]
            { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant"};
    private int[] imageIds = new int[]
            { R.drawable.lion , R.drawable.tiger
                    , R.drawable.monkey , R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    SimpleAdapter simpleAdapter=null;
    List<Integer> dellist=new ArrayList<Integer>();
    List<Map<String, Object>> listItems =
            new ArrayList<Map<String, Object>>();
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.long_delete);
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("personName", names[i]);
            listItem.put("header", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.long_delete_item,
                new String[] {  "personName","header"},
                new int[] { R.id.name ,R.id.header });
        listView = (ListView) findViewById(R.id.deletelist);
        // 为ListView设置Adapter
        listView.setAdapter(simpleAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                //listItems.remove(position);
                dellist.add(position);
                view.setBackgroundColor(Color.parseColor("#cccccc"));
                startActionMode(new MyCallback());
                return true;
            }
        });
    }

    private class MyCallback implements ActionMode.Callback {
        AdapterView.OnItemClickListener adapterViewlister;
        MyCallback(){
            adapterViewlister=new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dellist.add(position);
                    view.setBackgroundColor(Color.parseColor("#cccccc"));
                }
            };
            listView.setOnItemClickListener(adapterViewlister);
        }
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.delete, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if(item.getItemId()==R.id.delete_true){
                int len=dellist.size();
                for (int i=0;i<len;i++){
                    mode.finish();
                    listItems.remove(dellist.get(i).intValue());
                    simpleAdapter.notifyDataSetChanged();
                }
                dellist.clear();
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //导入菜单布局
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        menu.add(1, Menu.FIRST+10, 100, "登录");
        menu.add(1, Menu.FIRST+20, 200, "菜单页");
        menu.add(1, Menu.FIRST+30, 300, "上下文菜单页");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        //创建菜单项的点击事件
        switch (item.getItemId()) {
            case Menu.FIRST+20:
                intent=new Intent(this,MenuActivity.class);
                startActivity(intent);
                break;
            case Menu.FIRST+10:
                new Login().login(this);
                break;
            case Menu.FIRST+30:
                intent=new Intent(this,LongDelete.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
