package in.abmulani.carinventory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import in.abmulani.carinventory.BaseActivity;
import in.abmulani.carinventory.R;
import in.abmulani.carinventory.utils.Utils;
import in.abmulani.carinventory.widgets.CarInventoryTextView;

/**
 * Aabid Mulani {01-05-2015}
 */
public class CarInventoryDashBoardActivity extends BaseActivity {


    private static final int ADD_CAR_REQUEST = 110;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listView)
    ListView listView;
    @InjectView(R.id.add_car_imageView)
    ImageView addCarImageView;
    @InjectView(R.id.add_car_msg)
    CarInventoryTextView addCarMsg;
    @InjectView(R.id.no_cars_layout)
    LinearLayout noCarsLayout;
    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_screen);
        ButterKnife.inject(this);
//        toolbar.setBackgroundColor(getResources().getColor(R.color.theme_green_dark));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Car Inventory");
        getSupportActionBar().setHomeButtonEnabled(true);
        readAndPopulateCarList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Utils.showToast(activity, "Please click BACK again to exit");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    @OnClick(R.id.add_car_imageView)
    public void onAddClicked() {
        hitAddCarIntent();
    }

    private void hitAddCarIntent() {
        startActivityForResult(new Intent(activity, CarInventoryAddCarActivity.class), ADD_CAR_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == ADD_CAR_REQUEST) {
                // refresh the current list
                readAndPopulateCarList();
            }
        }
    }

    private void readAndPopulateCarList() {

    }
}
