/**
 *
 * Phonegap PushParse plugin
 *
 * Version 1.0
 *
 * Hazem Hagrass 2013
 *
 */

package com.badrit.PushParse;

import org.json.JSONArray;
import org.json.JSONException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import com.parse.ParsePush;

public class PushParse extends CordovaPlugin {@
	Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("sendPush")) {
			ParsePush push = new ParsePush();
			push.setChannel(args.getString(1));
			push.setMessage(args.getString(0));
			push.sendInBackground();
			callbackContext.success();
			return true;
		}
		callbackContext.error(0);
		return false;
	}

}