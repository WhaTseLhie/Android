package com.example.loveexam;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	ArrayList<Person> list = new ArrayList<Person>();
	ListView lv;
	MyAdapter adapter;
	EditText txtName, txtNum;
	AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        /*list.add(new Person(R.drawable.img1, "LIsa", "093242"));
        list.add(new Person(R.drawable.img1, "Christine", "09354324233423"));
        list.add(new Person(R.drawable.img1, "Veronica", "093242"));
        list.add(new Person(R.drawable.img1, "Riza", "093123423"));
        list.add(new Person(R.drawable.img1, "Saori", "0931231242"));
        list.add(new Person(R.drawable.img1, "Mia", "09342123153"));
        list.add(new Person(R.drawable.img1, "Christine", "09354324233423"));
        list.add(new Person(R.drawable.img1, "Veronica", "093242"));
        list.add(new Person(R.drawable.img1, "Riza", "093123423"));
        list.add(new Person(R.drawable.img1, "Saori", "0931231242"));
        list.add(new Person(R.drawable.img1, "Mia", "09342123153"));*/
               
        this.lv = (ListView) this.findViewById(R.id.listView1);
        this.adapter = new MyAdapter(this, list);
        this.lv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		txtName = new EditText(this);
		txtName.setPadding(10, 10, 10, 10);
		txtName.setHint("Enter Name");
		
		txtNum = new EditText(this);
		txtNum.setPadding(10, 10, 10, 10);
		txtNum.setInputType(InputType.TYPE_CLASS_NUMBER);
		txtNum.setHint("Enter Number");
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.addView(txtName);
		layout.addView(txtNum);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Add Contact");
		builder.setView(layout);
		builder.setPositiveButton("Save", this);
		builder.setNegativeButton("Cancel", this);
		
		dialog = builder.create();
		dialog.show();
		
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		switch(arg1) {
			case DialogInterface.BUTTON_POSITIVE:
				String name = this.txtName.getText().toString();
				String num = this.txtNum.getText().toString();
				
				if(!name.equals("") && !num.equals("")) {
					list.add(new Person(R.drawable.img1, name, num));
					adapter.notifyDataSetChanged();
				} else {
					Toast.makeText(this, "Please enter name and phone number", Toast.LENGTH_SHORT).show();
				}

			break;
			
			case DialogInterface.BUTTON_NEGATIVE:
				dialog.dismiss();
		}
	}
}
