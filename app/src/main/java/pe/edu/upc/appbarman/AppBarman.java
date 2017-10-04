package pe.edu.upc.appbarman;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

/**
 * Created by Manuel on 4/10/2017.
 */

public class AppBarman extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
    }
}
