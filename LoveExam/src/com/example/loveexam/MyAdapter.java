package com.example.loveexam;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList<Person> list;
	LayoutInflater inflater;
	
	public MyAdapter(Context context, ArrayList<Person> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ItemHandler handler = null;
		
		if((arg0 % 2) == 0) {
			arg1 = inflater.inflate(R.layout.itemlayout1, null);
		} else {
			arg1 = inflater.inflate(R.layout.itemlayout2, null);
		}
		handler = new ItemHandler();
		handler.iv = (ImageView) arg1.findViewById(R.id.imageView1);
		handler.name = (TextView) arg1.findViewById(R.id.textView1);
		handler.num = (TextView) arg1.findViewById(R.id.textView2);
		
		arg1.setTag(handler);
		
		handler.iv.setImageResource(R.drawable.img1);
		handler.name.setText(list.get(arg0).getTxtName());
		handler.num.setText(list.get(arg0).getTxtNum());
		
		return arg1;
	}
	
	static class ItemHandler {
		ImageView iv;
		TextView name, num;
	}
}
