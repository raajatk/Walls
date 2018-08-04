package com.nodejscafe.walls;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class ServiceAgent extends Service {

    public int counter=0;
    Context thisCtx;

    public ServiceAgent(Context applicationContext) {
        super();
        thisCtx = applicationContext;
        Log.i("HERE", "here I am!");
    }

    public ServiceAgent() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        startTimer();
//      startForeground(43,new Notification());
        //
        Intent myIntent = new Intent(getApplicationContext(), MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(alarmManager.RTC_WAKEUP, System.currentTimeMillis() + (5000), pendingIntent);
        //

        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("EXIT", "ondestroy!");
//        stoptimertask();
//
//        Intent myIntent = new Intent(getApplicationContext(), Restarter.class);
//
//
//        getApplicationContext().startService(new Intent(getApplicationContext(), ServiceAgent.class));
//        Intent broadcastIntent = new Intent(getApplicationContext(),Restarter.class);
//        sendBroadcast(broadcastIntent);

    }

    private Timer timer;
    private TimerTask timerTask;
    long oldTime=0;
    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, to wake up every 1 second
        timer.schedule(timerTask, 1000, 1000); //
    }

    /**
     * it sets the timer to print the counter every x seconds
     */
    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                Log.w("in timer", "in timer ++++  "+ (counter++));
                stoptimertask();
                stopSelf();
            }
        };
    }

    /**
     * not needed
     */
    public void stoptimertask() {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.i("ClearFromRecentService", "END");
        //Code here


    }
}
