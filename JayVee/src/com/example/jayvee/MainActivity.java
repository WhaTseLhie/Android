package com.example.jayvee;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {

	GridView gv;
	ArrayList<Person> list = new ArrayList<Person>();
	GridAdapter adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.gv = (GridView) this.findViewById(R.id.gridView1);
        
        list.add(new Person(R.drawable.img1, "Christine", "BSIT"));
        list.add(new Person(R.drawable.img2, "Joy", "BSIT"));
        list.add(new Person(R.drawable.img3, "Marie", "BSIT"));
        list.add(new Person(R.drawable.img4, "Rena", "BSBA"));
        list.add(new Person(R.drawable.img5, "Nicole", "AB"));
        list.add(new Person(R.drawable.img6, "Riza", "ACT"));
        list.add(new Person(R.drawable.img7, "Mary Mae", "HRM"));
        list.add(new Person(R.drawable.img8, "Veronica", "HRM"));
        list.add(new Person(R.drawable.img9, "Saori", "BEED"));
        list.add(new Person(R.drawable.img10, "Hannah", "BEED"));
        list.add(new Person(R.drawable.img11, "Kate", "BSED"));
        list.add(new Person(R.drawable.img12, "Brexy", "AB"));
        
        this.adapter = new GridAdapter(this, list);
        this.gv.setAdapter(adapter);
        
        this.gv.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		ImageView iv = new ImageView(this);
		TextView tv = new TextView(this);
		
		iv.setImageResource(list.get(arg2).getImage());
		tv.setText(list.get(arg2).getCourse());
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.HORIZONTAL);
		layout.addView(iv);
		layout.addView(tv);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getName());
		builder.setView(layout);
		builder.setNeutralButton("Ok", null);
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
    
}
