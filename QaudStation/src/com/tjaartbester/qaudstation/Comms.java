package com.tjaartbester.qaudstation;



import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;

import android.os.Bundle;
import android.os.Message;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;



public class Comms extends Activity {

	Button fly,connect;
	TextView output;
	static final String SERVER_IP = "1.2.3.4";
	static final int SERVER_PORT = 2000;
	private Handler handler=new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comms);
		output = (TextView) findViewById(R.id.COMMStv);
		connect = (Button) findViewById(R.id.Flybutton1);
		fly = (Button) findViewById(R.id.Flybutton2);
		fly.setEnabled(false);
		
				
			connect.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
				/////////////////////////////////
					fly.setEnabled(true);
					String text;

					
					try{
						ClientThread client = new ClientThread();
						
						Thread clientThread = new Thread(new ClientThread());
						clientThread.start();
					} catch(Exception e){
						output.setText(e.toString());
					}
				}
			});
			
			fly.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) 
				{
				///////////////////////////////////	
				}
			});
			
		}
	
	

	public class ClientThread implements Runnable {
		
		static final String SERVER_IP = "169.254.221.202";
		static final int SERVER_PORT = 2000;
		
		Socket socket;
		PrintWriter printWriter;
		
		
		
		public void run() {
			try {
				InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
//				
//				output.setText("Connecting to server") ;
				handler.post(new Runnable() {
					@Override
					public void run() {
					output.setText(output.getText() + "\n" +
					"Connecting to server");
					}
					});
				
				
				socket = new Socket(serverAddr, SERVER_PORT);
				
				socket.isConnected();
				
				try {
					printWriter = new PrintWriter(
							new BufferedWriter(
									new OutputStreamWriter(
											socket.getOutputStream())
									));

					
					
					//---get an InputStream object to read from the server---
					BufferedReader br = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					try {
						//---read all incoming data terminated with a \n
						// char---
						String line = null;
						while ((line = br.readLine()) != null) {
							final String strReceived = line;
//									output.setText(strReceived) ;
							handler.post(new Runnable() {
								@Override
								public void run() {
								output.setText(output.getText() + "\n" +
								strReceived);
								}
								});
						}
						
//								output.setText("Client DIsconnected") ;
						handler.post(new Runnable() {
							@Override
							public void run() {
							output.setText(output.getText() + "\n" +
							"Disconnected");
							}
							});
						
						
					} catch (Exception e) {
						final String error = e.getLocalizedMessage();
//								output.setText(error) ;
						handler.post(new Runnable() {
							@Override
							public void run() {
							output.setText(output.getText() + "\n" +
							"ERROR:		"+error);
							}
							});
					}
				} catch (Exception e) {
					final String error = e.getLocalizedMessage();
//					output.setText(error) ;
					handler.post(new Runnable() {
						@Override
						public void run() {
						output.setText(output.getText() + "\n" +
						"ERROR:		"+error);
						}
						});
				}
//						output.setText("COnnection closed") ;
				handler.post(new Runnable() {
					@Override
					public void run() {
					output.setText(output.getText() + "\n" +
					"Connection Closed");
					}
					});
				
			} catch (Exception e) {
//				output.setText(e.toString());
				final String error = e.getLocalizedMessage();
				
				handler.post(new Runnable() {
					@Override
					public void run() {
					output.setText(output.getText() + "\n" +
					"ERROR:		"+error);
					}
					});
			}
		}
	}
	
	}
