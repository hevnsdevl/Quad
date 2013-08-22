package com.tjaartbester.qaudstation;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import com.esotericsoftware.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WifiComs extends Activity {
	
	public class SomeRequest {
		   public String text;
		}
	
		public class SomeResponse {
		   public String text;
		}
	
	Button connect,send ;
	TextView display,recieved;
	
	//Client myclient = new Client();

		@Override
		protected void onCreate(Bundle TJgenericVAR) {
			// TODO Auto-generated method stub
			super.onCreate(TJgenericVAR);
			setContentView(R.layout.activity_wifi_coms);
			connect = (Button) findViewById(R.id.wifib1);
			display = (TextView) findViewById(R.id.wifitv1);
			recieved = (TextView) findViewById(R.id.wifitv2);
			send = (Button) findViewById(R.id.wifib2);
			
//			Kryo kryo = myclient.getKryo();
//			kryo.register(SomeRequest.class);
//			kryo.register(SomeResponse.class);
			Client myclient = new Client();
			//myclient.start();
			
//			myclient.addListener(new Listener() {
//				   public void received (Connection connection, Object object) {
//				      if (object instanceof SomeResponse) {
//				         SomeResponse response = (SomeResponse)object;
//				         recieved.setText(response.text);
//				      }
//				   }
//				});
//			
//			
//			connect.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View v) 
//				{
//				display.setText("Connecting...");
//				try {
//					myclient.connect(5000, "169.254.221.202", 2000);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					display.setText("Could not connect.");
//				}
//				SomeRequest request = new SomeRequest();
//				request.text = "HELLO";
//				myclient.sendTCP(request);
//				}
//			});
//			
//			send.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View v) 
//				{
//				SomeRequest request = new SomeRequest();
//				request.text = "TEST";
//				myclient.sendTCP(request);
//				}
//			});
	}
}