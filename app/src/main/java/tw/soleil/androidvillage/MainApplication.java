package tw.soleil.androidvillage;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by bryan on 2014/11/22.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "TnnxaVz3JMIsCw9BPAGtzTD1CkXGhlvr9S0RI4w6", "42PMT7wha44wjXJ3m5khbZZFWpeTWRXjfSGdQSWh");
    }
}
