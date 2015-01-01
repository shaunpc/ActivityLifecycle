package com.spc.activitylifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tToast("onCreate");
        Log.i(TAG, "onCreate()");
        // test comment
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
        super.onStop();
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


