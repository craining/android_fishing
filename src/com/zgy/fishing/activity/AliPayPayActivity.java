package com.zgy.fishing.activity;

import com.zgy.fishing.Lock;
import com.zgy.fishing.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


public class AliPayPayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_alipay_pay);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(!Lock.FILE_ALIPAY_PAY.exists()) {
			Lock.FILE_ALIPAY_PAY.mkdirs();
		}
	}

	
	
}