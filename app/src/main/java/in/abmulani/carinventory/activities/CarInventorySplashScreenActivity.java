package in.abmulani.carinventory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import butterknife.ButterKnife;
import in.abmulani.carinventory.BaseActivity;
import in.abmulani.carinventory.R;


/**
 * Aabid Mulani {22-04-2015}
 */
public class CarInventorySplashScreenActivity extends BaseActivity {

    private boolean isBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.inject(this);
        isBackPressed = false;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (!isBackPressed) {
                    startActivity(new Intent(activity, CarInventoryDashBoardActivity.class));
                    finish();
                }
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable, 2000);
    }
}
