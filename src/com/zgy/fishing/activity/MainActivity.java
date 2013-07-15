package com.zgy.fishing.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zgy.fishing.R;
import com.zgy.fishing.ServiceListener;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startService(new Intent(MainActivity.this, ServiceListener.class));
//		startActivity(new Intent(MainActivity.this, QQLoginActivity.class));

		finish();
		
		
	}

}
