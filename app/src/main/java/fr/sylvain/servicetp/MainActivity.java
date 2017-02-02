package fr.sylvain.servicetp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import fr.sylvain.servicetp.BoundService;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MusicService mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //mp = MediaPlayer.create(this, R.raw.sound);

        final TextView displayService = (TextView) findViewById(R.id.displayService);


        //Intent intent = new Intent(this, BoundService.class);
        /*
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                int num = ((BoundService.IncrementBinder) service).getValue();
                displayService.setText(String.valueOf(num));
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);
        */


        Intent intentMusic = new Intent(this, MusicService.class); //intent service
        //for music
        bindService(intentMusic, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                MusicService.MusicBinder binder = (MusicService.MusicBinder) service;
                mService = binder.getService(); //get all methods of service
                mService.onCreate();
                mService.mediaPlayer.start();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        }, BIND_AUTO_CREATE);


    }


    /*
    public void useBoundService(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    */

    public void clickMusicOn(View view) {
        mService.playerOn();

    }

    public void clickMusicOff(View view) {
        mService.playerOff();
    }



}

