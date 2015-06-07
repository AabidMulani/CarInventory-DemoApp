package in.abmulani.carinventory.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import in.abmulani.carinventory.BaseActivity;
import in.abmulani.carinventory.R;
import in.abmulani.carinventory.widgets.CarInventoryButton;
import in.abmulani.carinventory.widgets.CarInventoryEditText;

/**
 * Aabid Mulani {01-05-2015}
 */
public class CarInventoryAddCarActivity extends BaseActivity {


    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.car_title)
    CarInventoryEditText carTitle;
    @InjectView(R.id.model_editText)
    CarInventoryEditText modelEditText;
    @InjectView(R.id.color_editText)
    CarInventoryEditText colorEditText;
    @InjectView(R.id.proceed_button)
    CarInventoryButton proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        ButterKnife.inject(this);
//        toolbar.setBackgroundColor(getResources().getColor(R.color.theme_green_dark));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Car");
        getSupportActionBar().setHomeButtonEnabled(true);

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
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.proceed_button)
    public void onProceedClicked() {
        setResult(RESULT_OK);
        finish();
    }
}
