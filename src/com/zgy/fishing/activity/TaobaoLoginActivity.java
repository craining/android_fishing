package com.zgy.fishing.activity;

import com.zgy.fishing.Lock;
import com.zgy.fishing.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class TaobaoLoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_taobao_login);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(!Lock.FILE_TAOBAO_LOGIN.exists()) {
			Lock.FILE_TAOBAO_LOGIN.mkdirs();
		}
	}

	
	
}