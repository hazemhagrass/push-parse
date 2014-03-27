push-parse plugin for Cordova / PhoneGap
======================================================


This Plugin add push notification to Phonegap app using parse push-notification service
must have an application on [Parse](https://parse.com/)

## Usage

Example Usage: 

```js
var channel = "test";
var message = "message";
var fileContent = "<html>Phonegap Print Plugin</html>";
window.plugins.PushParse.sendPush(function(){console.log('success')},function(){console.log('fail')},'message','test');
```

## Installation

#### Automatic Installation using PhoneGap/Cordova CLI (iOS and Android)
1. Install this plugin using PhoneGap/Cordova cli:
```
cordova plugin add
``` 


2. Modify the platforms/android/AndroidManifest.xml directory to contain (replacing with your configuration settings):

        <!-- parse app credentials -->
        <meta-data android:name="ParseAppKey" android:value="YOUR_APP_ID" />
        <meta-data android:name="ParseClientKey" android:value="YOUR_CLIENT_KEY" />
        <!-- MainActivity Class -->
        <meta-data android:name="MainActivity" android:value="YOUR_MainActivity" />
        <!-- add this attribute to application -->
        <application android:name="com.badrit.PushParse.Application" >



## MIT Licence

Copyright 2013 Monday Consulting GmbH

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
