package com.ssn.let.there.be.flashlight;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    
    public void call_flash(View v)
    {
    	Intent intent = new Intent(this, FlashActivity.class);
    	startActivity(intent);
    }
    public void call_screen(View v)
    {
    	Intent intent = new Intent(this, ScreenActivity.class);
        startActivity(intent);
    }
    
    
    
}
