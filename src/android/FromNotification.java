/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;



public class FromNotification extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.v("FromNotification", "here");
		super.onCreate(savedInstanceState);
		Context _context = this.getApplicationContext();
		ApplicationInfo ai = null;
		try {
			ai = _context.getPackageManager().getApplicationInfo(_context.getPackageName(),PackageManager.GET_META_DATA);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String MainActivityStr = (String) ai.metaData.get("MainActivity"); 
		try {
			Class<? extends Activity> MainActivity = (Class<? extends Activity>) Class.forName(MainActivityStr);
			Intent LaunchIntent = new Intent(FromNotification.this,
					MainActivity);
			LaunchIntent.putExtra("fromNotification", true);
			startActivity(LaunchIntent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
