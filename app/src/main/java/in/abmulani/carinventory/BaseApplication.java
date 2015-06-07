package in.abmulani.carinventory;

import com.orm.SugarApp;

import timber.log.Timber;

/**
 * Aabid Mulani {22-04-2015}
 */
public class BaseApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Timber.e("init");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
