package in.abmulani.carinventory;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import in.abmulani.carinventory.utils.AppConstants;
import in.abmulani.carinventory.utils.Utils;
import timber.log.Timber;

/**
 * Aabid Mulani {22-04-2015}
 */
public class BaseActivity extends ActionBarActivity {
    public static String RUPEE = "₹ ";
    protected Activity activity;
    protected BaseApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        application = ((BaseApplication) getApplication());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.i("onPause");
    }

}
