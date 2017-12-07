package com.example.rodixxi.musicplayer;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {

    MediaPlayer player;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {return null;}

    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int action = intent.getIntExtra(getString(R.string.actionId), 0);
            if (action == 0){
                player.pause();
            }
        }
    };

    @Override
    public void onCreate() {

        super.onCreate();
        registerReceiver(receiver, new IntentFilter(getString(R.string.intentAction)));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        player = MediaPlayer.create(this, R.raw.acceptable_in_the_80s);
        player.setLooping(false); // Set looping
        player.setVolume(100,100);
        player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer)
            {

            }
        });
        player.start();

        String CHANNEL_ID = getString(R.string.channel_id);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_audiotrack_black_24dp)
                        .setContentTitle("MyPlayer")
                        .setContentText("Acceptable in the 80s")
                        .setOngoing(true);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,
                new Intent(getApplicationContext(), MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

        Intent playerIntent = new Intent(getString(R.string.intentAction));
        playerIntent.putExtra(getString(R.string.actionId), 0);
        PendingIntent pendingPlayerIntent = PendingIntent.getBroadcast(this,
                4, playerIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.addAction(R.drawable.ic_stop_black_24dp, "stop", pendingPlayerIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int mNotificationId2 = 235356435;
        mNotificationManager.notify(mNotificationId2, mBuilder.build());

        return Service.START_STICKY;
    }

    public IBinder onUnBind(Intent arg0) {
        return null;
    }
    @Override
    public void onDestroy() {
    }
    @Override
    public void onLowMemory() {
    }
}
