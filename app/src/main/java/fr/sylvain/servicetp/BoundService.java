package fr.sylvain.servicetp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Objects;
import java.util.Random;

public class BoundService extends Service {
    private int counter = 1;
    private IncrementBinder binder;

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new IncrementBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class IncrementBinder extends Binder {
        public int getValue(){
            return counter += 1;
        }

    }


}

