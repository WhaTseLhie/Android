package com.example.io;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText txtName;
	Button btnOk, btnCancel;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.txtName = (EditText) this.findViewById(R.id.editText1);
        this.btnOk = (Button) this.findViewById(R.id.button1);
        this.btnCancel = (Button) this.findViewById(R.id.button2);
        
        this.btnOk.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		switch(id) {
			case R.id.button1:
				String name = this.txtName.getText().toString();
				Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
				break;
			case R.id.button2:
				this.txtName.setText("");
				this.txtName.requestFocus();
		}
	}
    
}
