package com.tjaartbester.qaudstation;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.Math;

public class Accel extends Activity implements SensorEventListener{

	TextView tv1,tv2,tv3,tv4,tv5;

	double angleX,angleY,sensorX,sensorY,sensorZ;
	
	SensorManager sm;
	Sensor PhoneAccel,PhoneGyro,PhoneTemp,PhoneOr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.accel);
		tv1= (TextView) findViewById(R.id.textView2);
		tv2= (TextView) findViewById(R.id.textView3);
		tv3= (TextView) findViewById(R.id.textView4);
		tv4= (TextView) findViewById(R.id.textView5);
		tv5= (TextView) findViewById(R.id.textView6);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		PhoneAccel = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
		//PhoneGyro = sm.getSensorList(Sensor.TYPE_GYROSCOPE).get(0);
		sm.registerListener(this, PhoneAccel, SensorManager.SENSOR_DELAY_NORMAL);
	
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent TJaccel) {
		// TODO Auto-generated method stub
		/*try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		for (int i = 0; i < 8; i++) {
			sensorX += TJaccel.values[0]/10;
			sensorY += TJaccel.values[1]/10;
			sensorZ += TJaccel.values[2]/10;
		}
		sensorX = sensorX/8;
		sensorY = sensorY/8; 
		sensorZ = sensorZ/8; 
		angleX = Math.atan(sensorX/Math.sqrt(sensorY*sensorY+sensorZ*sensorZ))*(180/Math.PI);
		angleY = Math.atan(sensorY/Math.sqrt(sensorX*sensorX+sensorZ*sensorZ))*(180/Math.PI);
		tv1.setText("X axis    " +((String.format("%.01f", sensorX))));
		tv2.setText("Y axis    " +((String.format("%.01f", sensorY))));
		tv3.setText("Z axis    " +((String.format("%.01f", sensorZ))));
		tv4.setText("X angle    " +((String.format("%.01f", angleX))));
		tv5.setText("Y angle    " +((String.format("%.01f", angleY))));	
	}
	
	@Override
	protected void onResume()
	{
	super.onResume();
	sm.registerListener(this, PhoneAccel, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onPause()
	{
	super.onPause();
	sm.unregisterListener(this);
	}
}
