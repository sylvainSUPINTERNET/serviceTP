
package fr.sylvain.servicetp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Objects;
import java.util.Random;

public class MusicService extends Service {
    private MusicBinder binder;
    public  MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        binder = new MusicBinder();
        mediaPlayer = MediaPlayer.create(this, R.raw.sound);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    //public play public stop etc et les appeler sur le click


    public void playerOff() {
        mediaPlayer.pause();
    }

    public void playerOn() {
        mediaPlayer.start();
    }




    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }

    }


}
