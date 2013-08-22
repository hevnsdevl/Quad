package com.tjaartbester.qaudstation;


import java.io.File;
import java.io.PrintWriter;
import java.net.Socket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class startpoint extends Activity {

	int count;
	File file = null;
	EditText saveFile;
	Button comms,settings,planner,test;

	TextView textview1;
	
	static final String SERVER_IP = "1.2.3.4";
	static final int SERVER_PORT = 2000;
	Handler handler = new Handler();
	Socket testsock;
	static Socket socket;
	PrintWriter printWriter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startpoint);
		count = 0;
		settings = (Button) findViewById(R.id.button1);
		comms = (Button) findViewById(R.id.button2);
		planner= (Button) findViewById(R.id.button3);
		test = (Button) findViewById(R.id.button4);
		
		//settings.setEnabled(false);
		//fly.setEnabled(false);

		testsock = new Socket();
		
		textview1= (TextView) findViewById(R.id.textView3);
		
		
		settings.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
			
				textview1.setText("NO FUNCTION");
				comms.setEnabled(true);
			}
		});

		comms.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent openComms = new Intent("com.tjaartbester.qaudstation.COMMS");
				startActivity(openComms);
				//planner.setEnabled(true);
				
			}
		});	
		
		planner.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				
				Intent openPlanner = new Intent("com.tjaartbester.qaudstation.PLANNER");
				startActivity(openPlanner);
			}
		});
		
		test.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent openStartpoint = new Intent("com.tjaartbester.qaudstation.ACCEL");
				startActivity(openStartpoint);
			}
		});
		
	}
}


