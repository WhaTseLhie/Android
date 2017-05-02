package com.example.picgrid;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.GridView;

public class MainActivity extends Activity implements OnClickListener {

	GridView gv;
	ArrayList<Person> list = new ArrayList<Person>();
	GridAdapter adapter;
	AdapterView.AdapterContextMenuInfo info;
	AlertDialog dialog;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.gv = (GridView) this.findViewById(R.id.gridView1);
        this.adapter = new GridAdapter(this, list);
        this.gv.setAdapter(adapter);
        
        this.registerForContextMenu(gv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this, UpdatePersonActivity.class);
		this.startActivityForResult(intent, 1);
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
		getMenuInflater().inflate(R.menu.contextmenu, menu);
		info = (AdapterContextMenuInfo) menuInfo;
		menu.setHeaderTitle(list.get(info.position).getName());
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode == RESULT_OK) {
			if(requestCode == 1) {
				Bundle b = data.getExtras();
				Uri image = b.getParcelable("image");
				String name = b.getString("name");
				
				Person p = new Person(image, name);
				list.add(p);
				this.adapter.notifyDataSetChanged();
			}
		}
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		int select = item.getItemId();
		
		switch(select) {
			case R.id.delete:
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Confirmation");
				builder.setMessage(String.format("Do you really want to delete %s?", list.get(info.position).getName()));
				builder.setPositiveButton("Yes", this);
				builder.setNegativeButton("No", this);
				
				dialog = builder.create();
				dialog.show();
				
			break;
			
			case R.id.details:
				ImageView image = new ImageView(this);
				image.setImageURI(list.get(info.position).getImageUri());
				
				TextView name = new TextView(this);
				name.setPadding(10, 10, 10, 10);
				name.setGravity(Gravity.CENTER_HORIZONTAL);
				name.setText(list.get(info.position).getName());
				
				LinearLayout layout = new LinearLayout(this);
				layout.setOrientation(LinearLayout.VERTICAL);
				layout.setGravity(Gravity.CENTER_HORIZONTAL);
				layout.addView(image);
				layout.addView(name);
				
				AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
				builder2.setTitle(String.format("Details of %s", list.get(info.position).getName()));
				builder2.setView(layout);
				builder2.setNeutralButton("Ok", null);
				
				dialog = builder2.create();
				dialog.show();
				break;
		}
		
		return super.onContextItemSelected(item);
	}

	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		switch(arg1) {
			case DialogInterface.BUTTON_POSITIVE:
				list.remove(info.position);
				Toast.makeText(this, "Remove Successfully", Toast.LENGTH_SHORT).show();
				this.adapter.notifyDataSetChanged();
			break;
			case DialogInterface.BUTTON_NEGATIVE:
				dialog.dismiss();
		}
	}
}
