package com.zgy.fishing;

import java.util.Timer;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServiceListener extends Service {

	private Timer mTimer = new Timer(true);

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		
		Lock a = new Lock(ServiceListener.this);
		mTimer.schedule(a, 1, 500);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		
		if( mTimer!= null) {
			mTimer.cancel();
			mTimer = null;
		}
		
	}
	

}
