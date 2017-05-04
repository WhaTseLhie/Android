package com.example.searchtext;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {

	EditText txtSearch;
	ListView lv;
	ItemAdapter adapter;
	ArrayList<Student> list = new ArrayList<Student>();
	ArrayList<Student> source = new ArrayList<Student>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        source.add(new Student(R.drawable.img1, "emi", "bsit"));
        source.add(new Student(R.drawable.img2, "emil", "bsed"));
        source.add(new Student(R.drawable.img3, "emilio", "bsoa"));
        source.add(new Student(R.drawable.img4, "boni", "act"));
        source.add(new Student(R.drawable.img5, "bonifac", "bscrim"));
        source.add(new Student(R.drawable.img6, "bonifacio", "ab"));
        source.add(new Student(R.drawable.img7, "bonifacio", "ab"));
        source.add(new Student(R.drawable.img8, "jose", "beed"));
        source.add(new Student(R.drawable.img9, "pepe", "hrm"));
        source.add(new Student(R.drawable.img2, "chistine", "bsit"));
        source.add(new Student(R.drawable.img4, "joy", "bsit"));
        
        this.txtSearch = (EditText) this.findViewById(R.id.editText1);
        this.lv = (ListView) this.findViewById(R.id.listView1);
        adapter = new ItemAdapter(this, list);
        this.lv.setAdapter(adapter);

        this.lv.setOnItemClickListener(this);
        this.txtSearch.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				list.clear();

				Pattern p = Pattern.compile(arg0.toString());
				for(int i=0; i<source.size(); i++) {
					Matcher name = p.matcher(source.get(i).getName());
					Matcher course = p.matcher(source.get(i).getCourse());
					
					if(name.find() || course.find()) {
						list.add(source.get(i));
					}
					adapter.notifyDataSetChanged();
				}
				
			}});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		LinearLayout dialoglayout = new LinearLayout(this);
		dialoglayout.setOrientation(LinearLayout.HORIZONTAL);
		ImageView iv = new ImageView(this);
		TextView name_course = new TextView(this);
		
		iv.setImageResource(list.get(arg2).getImage());
		String nameCourse = list.get(arg2).getName() +"\n"+ list.get(arg2).getCourse();
		name_course.setText(nameCourse);
		
		dialoglayout.addView(iv);
		dialoglayout.addView(name_course);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Selected Item");
		builder.setView(dialoglayout);
		builder.setNeutralButton("Ok", null);
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
    
}
