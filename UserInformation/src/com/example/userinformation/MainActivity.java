package com.example.userinformation;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {

	EditText txtIdno, txtName;
	Spinner cboCourse;
	RadioGroup rgGender;
	Button btnSubmit;
	String course, gender;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtIdno = (EditText) this.findViewById(R.id.editText1);
        this.txtName = (EditText) this.findViewById(R.id.editText2);
        this.cboCourse = (Spinner) this.findViewById(R.id.spinner1);
        this.rgGender = (RadioGroup) this.findViewById(R.id.radioGroup1);
        this.btnSubmit = (Button) this.findViewById(R.id.button1);
        
        this.btnSubmit.setOnClickListener(this);
        this.cboCourse.setOnItemSelectedListener(this);
    }

	@Override
	public void onClick(View v) {
		String idno = this.txtIdno.getText().toString();
		String name = this.txtName.getText().toString();
		int genderIndex = rgGender.getCheckedRadioButtonId();
		
        RadioButton btnGender = (RadioButton) this.findViewById(genderIndex);
        gender = btnGender.getText().toString();
        
		if(!idno.equals("") && !name.equals("")) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			String message = String.format("Idno: %s\nName: %s\nCourse: %s\nGender: %s", idno, name, course, gender);
			
			builder.setTitle("Student Information");
			builder.setMessage(message);
			builder.setNeutralButton("OK", null);
			
			AlertDialog dialog = builder.create();
			dialog.show();
		} else {
			Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		course = this.cboCourse.getItemAtPosition(arg2).toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
}
