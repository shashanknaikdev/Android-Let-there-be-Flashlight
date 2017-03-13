package com.ssn.let.there.be.flashlight;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class ScreenActivity extends Activity {
	protected PowerManager.WakeLock mWakeLock;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // hide statusbar of Android
        // could also be done later
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.activity_screen);
        final PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        this.mWakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
        this.mWakeLock.acquire();
        
        //added new for autobrightness
       android.provider.Settings.System.putInt(this.getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
      // android.provider.Settings.System.putInt(this.getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS,255);
        
        //till here autobrightness settings
        final WindowManager.LayoutParams window_params=getWindow().getAttributes();
        window_params.screenBrightness=1f;
        getWindow().setAttributes(window_params);
        
      

    }

    @Override
    public void onDestroy() {
        this.mWakeLock.release();
        
        super.onDestroy();
    }

}
