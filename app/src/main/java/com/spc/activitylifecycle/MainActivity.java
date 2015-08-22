package com.spc.activitylifecycle;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tToast("onCreate");
        Log.i(TAG, "onCreate()");
        // test comment

        PackageManager manager = this.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
            tToast("PackageName = " + info.packageName + "\nVersionCode = "
                    + info.versionCode + "\nVersionName = "
                    + info.versionName + "\nPermissions = "
                    + info.permissions);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void toastDeviceInfo (View view) {
        String manu = Build.MANUFACTURER;
        String model = Build.MODEL;
        tToast( "DeviceInfo \n" + manu + "\n" + model);
    }

    public void toastAndroidInfo(View view) {
        String release = android.os.Build.VERSION.RELEASE;
        int sdkVersion = android.os.Build.VERSION.SDK_INT;
        tToast("AndroidInfo\n" + sdkVersion + "\n" + release);
    }

    public void onStart() {
        super.onStart();
        tToast("onStart");
        Log.i(TAG, "onStart()");
    }

    public void onRestart() {
        super.onRestart();
        tToast("onRestart");
        Log.i(TAG, "onRestart()");
    }

    public void onResume() {
        super.onResume();
        tToast("onResume");
        Log.i(TAG, "onResume()");
    }

    public void onPause() {
        super.onPause();
        tToast("onPause: bye bye!");
        Log.i(TAG, "onPause()");
    }

    public void onStop() {
        super.onStop();
        tToast("onStop.");
        Log.i(TAG, "onStop()");
    }

    public void onDestroy() {
        super.onDestroy();
        tToast("onDestroy.");
        Log.i(TAG, "onDestroy()");
    }

    private void tToast(String s) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


