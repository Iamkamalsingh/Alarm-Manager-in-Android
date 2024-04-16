package com.singhkamal.alarmmanager;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.os.Handler;
import android.provider.Settings;

public class myReceiver extends BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {

        mp=MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI );
        mp.setLooping( true );
        mp.start();
    }
}
