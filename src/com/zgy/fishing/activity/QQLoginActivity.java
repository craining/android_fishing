package com.zgy.fishing.activity;

import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zgy.fishing.Lock;
import com.zgy.fishing.R;

public class QQLoginActivity extends Activity implements OnClickListener {

	private ImageView imgCheckRemPwd;
	private ImageView imgCheckHideLog;
	private ImageView imgCheckSlightLog;
	private ImageView imgCheckBothLog;
	private ImageView imgCheckRecGroupMsg;

	private LinearLayout layoutRemPwd;
	private LinearLayout layoutHideLog;
	private LinearLayout layoutSlightLog;
	private LinearLayout layoutBothLog;
	private LinearLayout layoutRecGroupMsg;

	private EditText editNum;
	private EditText editPwd;

	private Button btnLog;
	private Button btnReg;

	private RelativeLayout layoutShowMore;
	private LinearLayout layoutMoreView;
	private ImageView imgMoreArrow;

	private boolean bRemPwd = true;
	private boolean bHideLog = false;
	private boolean bSlightLog = false;
	private boolean bBothLog = true;
	private boolean bRecGroupMsg = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_qq_login);

		initViews();
		imgCheckRemPwd.setOnClickListener(this);
		imgCheckHideLog.setOnClickListener(this);
		imgCheckSlightLog.setOnClickListener(this);
		imgCheckBothLog.setOnClickListener(this);
		imgCheckRecGroupMsg.setOnClickListener(this);

		layoutRemPwd.setOnClickListener(this);
		layoutHideLog.setOnClickListener(this);
		layoutSlightLog.setOnClickListener(this);
		layoutBothLog.setOnClickListener(this);
		layoutRecGroupMsg.setOnClickListener(this);

		btnLog.setOnClickListener(this);
		btnReg.setOnClickListener(this);

		layoutShowMore.setOnClickListener(this);
	}

	private void initViews() {

		layoutRemPwd = (LinearLayout) findViewById(R.id.layout_qq_check_rememberpwd);
		layoutHideLog = (LinearLayout) findViewById(R.id.layout_qq_check_hidelogin);
		layoutSlightLog = (LinearLayout) findViewById(R.id.layout_qq_check_slightlogin);
		layoutBothLog = (LinearLayout) findViewById(R.id.layout_qq_check_bothlogin);
		layoutRecGroupMsg = (LinearLayout) findViewById(R.id.layout_qq_check_recgroupmsg);

		imgCheckRemPwd = (ImageView) findViewById(R.id.img_qq_check_rememberpwd);
		imgCheckHideLog = (ImageView) findViewById(R.id.img_qq_check_hidelogin);
		imgCheckSlightLog = (ImageView) findViewById(R.id.img_qq_check_slightlogin);
		imgCheckBothLog = (ImageView) findViewById(R.id.img_qq_check_bothlogin);
		imgCheckRecGroupMsg = (ImageView) findViewById(R.id.img_qq_check_recgroupmsg);

		editNum = (EditText) findViewById(R.id.edit_qq_num);
		editPwd = (EditText) findViewById(R.id.edit_qq_pwd);

		btnLog = (Button) findViewById(R.id.btn_qq_login);
		btnReg = (Button) findViewById(R.id.btn_qq_regnewaccount);

		layoutShowMore = (RelativeLayout) findViewById(R.id.layout_qq_showmore);
		layoutMoreView = (LinearLayout) findViewById(R.id.layout_qq_more_views);
		imgMoreArrow = (ImageView) findViewById(R.id.img_qq_morearrow);

		setCheckBoxImg();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_qq_check_rememberpwd:
			bRemPwd = !bRemPwd;
			setCheckBoxImg();
			break;
		case R.id.layout_qq_check_hidelogin:
			bHideLog = !bHideLog;
			setCheckBoxImg();
			break;
		case R.id.layout_qq_check_slightlogin:
			bSlightLog = !bSlightLog;
			setCheckBoxImg();
			break;
		case R.id.layout_qq_check_bothlogin:
			bBothLog = !bBothLog;
			setCheckBoxImg();
			break;
		case R.id.layout_qq_check_recgroupmsg:
			bRecGroupMsg = !bRecGroupMsg;
			setCheckBoxImg();
			break;
			
		case R.id.img_qq_check_rememberpwd:
			Log.e("111", "clicked");
			bRemPwd = !bRemPwd;
			setCheckBoxImg();
			break;
		case R.id.img_qq_check_hidelogin:
			bHideLog = !bHideLog;
			setCheckBoxImg();
			break;
		case R.id.img_qq_check_slightlogin:
			bSlightLog = !bSlightLog;
			setCheckBoxImg();
			break;
		case R.id.img_qq_check_bothlogin:
			bBothLog = !bBothLog;
			setCheckBoxImg();
			break;
		case R.id.img_qq_check_recgroupmsg:
			bRecGroupMsg = !bRecGroupMsg;
			setCheckBoxImg();
			break;
			
		case R.id.btn_qq_login:

			break;
		case R.id.btn_qq_regnewaccount:
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);
			Uri content_uri_browsers = Uri.parse("http://zc.qq.com/chs/index.html");
			intent.setData(content_uri_browsers);
			intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
			startActivity(intent);

			break;
		case R.id.layout_qq_showmore:
			if (layoutMoreView.isShown()) {
				layoutMoreView.setVisibility(View.GONE);
				imgMoreArrow.setImageResource(R.drawable.qq_login_more_up);
			} else {
				layoutMoreView.setVisibility(View.VISIBLE);
				imgMoreArrow.setImageResource(R.drawable.qq_login_more_down);
			}
			break;

		default:
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (!Lock.FILE_QQ_LOGIN.exists()) {
			Lock.FILE_QQ_LOGIN.mkdirs();
		}

	}

	private void setCheckBoxImg() {
		if (bRemPwd) {
			imgCheckRemPwd.setImageResource(R.drawable.qq_login_ic_check);
		} else {
			imgCheckRemPwd.setImageResource(R.drawable.qq_login_ic_uncheck);
		}
		if (bHideLog) {
			imgCheckHideLog.setImageResource(R.drawable.qq_login_ic_check);
		} else {
			imgCheckHideLog.setImageResource(R.drawable.qq_login_ic_uncheck);
		}
		if (bSlightLog) {
			imgCheckSlightLog.setImageResource(R.drawable.qq_login_ic_check);
		} else {
			imgCheckSlightLog.setImageResource(R.drawable.qq_login_ic_uncheck);
		}
		if (bBothLog) {
			imgCheckBothLog.setImageResource(R.drawable.qq_login_ic_check);
		} else {
			imgCheckBothLog.setImageResource(R.drawable.qq_login_ic_uncheck);
		}
		if (bRecGroupMsg) {
			imgCheckRecGroupMsg.setImageResource(R.drawable.qq_login_ic_check);
		} else {
			imgCheckRecGroupMsg.setImageResource(R.drawable.qq_login_ic_uncheck);
		}
	}

}
