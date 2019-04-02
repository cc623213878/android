package com.chchyu.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import static android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import org.crazyit.ui.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity
{
	private ListView listView;
	private String[] names = new String[]
			{ "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant"};
	private int[] imageIds = new int[]
			{ R.drawable.lion , R.drawable.tiger
					, R.drawable.monkey , R.drawable.dog,R.drawable.cat,R.drawable.elephant};
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 创建一个List集合，List集合的元素是Map
		List<Map<String, Object>> listItems =
				new ArrayList<Map<String, Object>>();
		for (int i = 0; i < names.length; i++)
		{
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("personName", names[i]);
			listItem.put("header", imageIds[i]);
			listItems.add(listItem);
		}
		// 创建一个SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
				R.layout.simple_item,
				new String[] {  "personName","header"},
				new int[] { R.id.name ,R.id.header });
		listView = (ListView) findViewById(R.id.mylist);
		// 为ListView设置Adapter
		listView.setAdapter(simpleAdapter);
		// 为ListView的列表项的单击事件绑定事件监听器
		listView.setOnItemClickListener(new OnItemClickListener()
		{
			// 第position项被单击时激发该方法
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id)
			{
				Toast.makeText(getApplicationContext(),names[position],Toast.LENGTH_SHORT).show();
			}
		});

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
				intent=new Intent(MainActivity.this,MenuActivity.class);
				startActivity(intent);
				break;
			case Menu.FIRST+10:
				new Login().login(this);
				break;
			case Menu.FIRST+30:
				intent=new Intent(MainActivity.this,LongDelete.class);
				startActivity(intent);
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
