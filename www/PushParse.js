// window.plugins.PushParse

function PushParse() {}

PushParse.prototype.sendPush = function(success, failure, message, channel) {
	cordova.exec(success, failure, "PushParse", "sendPush", [message, channel]);
};

cordova.addConstructor(function() {
	if (!window.plugins) {
		window.plugins = {};
	}

	// shim to work in 1.5 and 1.6
	if (!window.Cordova) {
		window.Cordova = cordova;
	};

	window.plugins.PushParse = new PushParse();
});