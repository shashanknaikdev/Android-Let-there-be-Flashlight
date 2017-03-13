package com.ssn.let.there.be.flashlight;



import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FlashActivity extends Activity {
    private final static String LOG_TAG = "FlashLight";

    private Button mOnBtn;
    private Button mOffBtn;
    private Camera mCamera;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        mOnBtn = (Button) findViewById(R.id.on_btn);
        mOnBtn.setOnClickListener(new OnClickListener() {

           
            public void onClick(View v) {
                processOnClick();
            }
        });

        mOffBtn = (Button) findViewById(R.id.off_btn);
        mOffBtn.setOnClickListener(new OnClickListener() {

            
            public void onClick(View v) {
                processOffClick();
            }
        });
   }

    @Override
    protected void onResume() {
        super.onResume();
        try{
            mCamera = Camera.open();
            mCamera.startPreview();
        } catch( Exception e ){
            Log.e(LOG_TAG, "Error Opening Camera");
        }
    }

    @Override
    protected void onPause() {
        if( mCamera != null ){
            mCamera.release();
            mCamera = null;
        }
        super.onPause();
    }

    private void processOffClick(){
        if( mCamera != null ){
            Parameters params = mCamera.getParameters();
            params.setFlashMode( Parameters.FLASH_MODE_OFF );
            mCamera.setParameters( params );
        }
    }

    private void processOnClick(){
        if( mCamera != null ){
        	boolean check_flash=this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
            if(check_flash==false)
            {
            	Toast.makeText(this, "Flash Not Present", Toast.LENGTH_SHORT).show();
            }

            Parameters params = mCamera.getParameters();
            params.setFlashMode( Parameters.FLASH_MODE_TORCH );
            mCamera.setParameters( params );
            mCamera.startPreview();
        }
    }
}