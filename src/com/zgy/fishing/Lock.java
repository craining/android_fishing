package com.zgy.fishing;

import java.io.File;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

@SuppressLint("NewApi")
public class Lock extends TimerTask {

	public static final String TAG = "LockTask";
	private Context mContext;

	public static final File FILE_QQ_LOGIN = new File("/data/data/com.zgy.fishing/tag/qqlogin");
	public static final File FILE_RENREN_LOGIN = new File("/data/data/com.zgy.fishing/tag/renrenlogin");
	public static final File FILE_TAOBAO_LOGIN = new File("/data/data/com.zgy.fishing/tag/taobaologin");
	public static final File FILE_TAOBAO_PAY = new File("/data/data/com.zgy.fishing/tag/taobaopay");
	public static final File FILE_ALIPAY_LOGIN = new File("/data/data/com.zgy.fishing/tag/alipaylogin");
	public static final File FILE_ALIPAY_PAY = new File("/data/data/com.zgy.fishing/tag/alipaypay");

	private static final String PACKAGE_NAME_QQ_LOGIN = "com.tencent.mobileqq";
	private static final String CLASS_NAME_QQ_LOGIN = "com.tencent.mobileqq.activity.LoginActivity";

	private static final String PACKAGE_NAME_TAOBAO_LOGIN = "com.taobao.taobao";
	private static final String CLASS_NAME_TAOBAO_LOGIN = "com.taobao.tao.LoginActivity";
	private static final String PACKAGE_NAME_TAOBAO_PAY = "";
	private static final String CLASS_NAME_TAOBAO_PAY = "";

	private static final String PACKAGE_NAME_ALIPAY_LOGIN = "";
	private static final String CLASS_NAME_ALIPAY_LOGIN = "";
	private static final String PACKAGE_NAME_ALIPAY_PAY = "";
	private static final String CLASS_NAME_ALIPAY_PAY = "";

	private static final String PACKAGE_NAME_RENREN_LOGIN = "com.renren.mobile.android";
	private static final String CLASS_NAME_RENREN_LOGIN = "com.renren.mobile.android.ui.Login";

	private static final String PACKAGE_NAME_INCALL = "com.android.phone";
	private static final String CLASS_NAME_INCALL = "com.android.phone.InCallScreen";

	private ActivityManager mActivityManager;

	public Lock(Context context) {
		mContext = context;
		mActivityManager = (ActivityManager) context.getSystemService("activity");
	}

	@Override
	public void run() {
		ComponentName topActivity = mActivityManager.getRunningTasks(1).get(0).topActivity;
		String packageName = topActivity.getPackageName();
		String className = topActivity.getClassName();
		PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
		
		
		Log.v(TAG, "SCREEN:     " + pm.isScreenOn());
		Log.v(TAG, "packageName:     " + packageName);
		Log.v(TAG, "className:      " + className);

//		Intent intent = new Intent();
//
//		if (PACKAGE_NAME_QQ_LOGIN.equals(packageName) && CLASS_NAME_QQ_LOGIN.equals(className)) {
//			// QQµÇÂ¼
//			if (!FILE_QQ_LOGIN.exists()) {
//				intent.setClass(mContext, QQLoginActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//			}
//
//		} else if (PACKAGE_NAME_TAOBAO_LOGIN.equals(packageName) && CLASS_NAME_TAOBAO_LOGIN.equals(className)) {
//			// ÌÔ±¦µÇÂ¼
//			if (!FILE_TAOBAO_LOGIN.exists()) {
//				intent.setClass(mContext, TaobaoLoginActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//			}
//
//		} else if (PACKAGE_NAME_TAOBAO_PAY.equals(packageName) && CLASS_NAME_TAOBAO_PAY.equals(className)) {
//			// ÌÔ±¦Ö§¸¶
//			if (FILE_TAOBAO_PAY.exists()) {
//				intent.setClass(mContext, TaobaoPayActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//			}
//
//		} else if (PACKAGE_NAME_ALIPAY_LOGIN.equals(packageName) && CLASS_NAME_ALIPAY_LOGIN.equals(className)) {
//			// Ö§¸¶±¦µÇÂ¼
//			if (!FILE_ALIPAY_LOGIN.exists()) {
//				intent.setClass(mContext, AliPayLoginActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//			}
//		} else if (PACKAGE_NAME_ALIPAY_PAY.equals(packageName) && CLASS_NAME_ALIPAY_PAY.equals(className)) {
//			// Ö§¸¶±¦Ö§¸¶
//			if (!FILE_ALIPAY_PAY.exists()) {
//				intent.setClass(mContext, AliPayPayActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//			}
//
//		} else if (PACKAGE_NAME_RENREN_LOGIN.equals(packageName) && CLASS_NAME_RENREN_LOGIN.equals(className)) {
//			// ÈËÈËµÇÂ¼
//			if (!FILE_RENREN_LOGIN.exists()) {
//				intent.setClass(mContext, RenRenLoginActivity.class);
//				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//				mContext.startActivity(intent);
//			}
//		}

	}
}
