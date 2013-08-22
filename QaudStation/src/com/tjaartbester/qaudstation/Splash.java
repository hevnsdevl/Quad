package com.tjaartbester.qaudstation;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class Splash extends Activity {
	MediaPlayer ourSound;
	@Override
	protected void onCreate(Bundle TJgenericVAR) {
		// TODO Auto-generated method stub
		super.onCreate(TJgenericVAR);
		setContentView(R.layout.splash);
		
		ourSound = MediaPlayer.create(Splash.this, R.raw.heli);
		//ourSound.start();
		
		Thread  timer = new Thread(){
			public void run(){
				try {
					sleep(100);					
				} catch (InterruptedException e){
					e.printStackTrace();
				} finally{
					Intent openStartpoint = new Intent("com.tjaartbester.qaudstation.STARTPOINT");
					startActivity(openStartpoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSound.release();
		finish();
	}
	
		
}
