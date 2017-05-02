package com.example.userlogin;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	// declare variables
	EditText txtUser, pwdPass;
	Button btnLogin, btnCancel;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // instantiate
        this.txtUser = (EditText) this.findViewById(R.id.editText1);
        this.pwdPass = (EditText) this.findViewById(R.id.editText2);
        this.btnLogin = (Button) this.findViewById(R.id.button1);
        this.btnCancel = (Button) this.findViewById(R.id.button2);
        
        // let button listen for a click event
        this.btnLogin.setOnClickListener(this);
        this.btnCancel.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		int id = v.getId();
		
		switch(id) {
			case R.id.button1:
				String user = this.txtUser.getText().toString();
				String pass = this.pwdPass.getText().toString();
				
				if(user.equals("admin") && pass.equals("ccs1234")) {
					Toast.makeText(this, "LOGIN ACCEPTED!!!", Toast.LENGTH_SHORT).show();
				} else {
					// build and alert dialog
					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					
					builder.setTitle("ERROR");
					builder.setMessage("Invalid User!!!");
					builder.setNeutralButton("OK", null);
					
					// show the dialog
					AlertDialog dialog = builder.create();
					dialog.show();
				}

			break;
				
			case R.id.button2:
				this.finish();
		}
	}
}
