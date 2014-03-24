package com.badrit.PushParse;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class Application extends android.app.Application {

	public Application() {
	}

	@Override
	public void onCreate() {
		super.onCreate();
		try {
			initializeParseApp();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initializeParseApp()throws ClassNotFoundException{
		Context _context = this.getApplicationContext();
		ApplicationInfo ai = null;
		try {
			ai = _context.getPackageManager().getApplicationInfo(_context.getPackageName(),PackageManager.GET_META_DATA);
		} catch (NameNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String appKey = (String) ai.metaData.get("ParseAppKey");
		String appSecret = (String) ai.metaData.get("ParseClientKey");  
		String MainActivityStr = (String) ai.metaData.get("MainActivity"); 
		Class<? extends Activity> MainActivity = (Class<? extends Activity>) Class.forName(MainActivityStr); 
		
	  // Initialize the Parse SDK.
		Parse.initialize(this, appKey, appSecret); 
		
	// Specify an Activity to handle all pushes by default.
		//PushService.setDefaultPushCallback(this, MainActivity);

		// When users indicate they are Giants fans, we subscribe them to that channel.
		PushService.subscribe(this, "test", MainActivity);
	}
}