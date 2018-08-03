package com.nodejscafe.walls;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Restarter extends BroadcastReceiver {

    Intent mServiceIntent;
    ServiceAgent mSensorService;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.w(Restarter.class.getSimpleName(), "Service Stops! Oooooooooooooppppssssss!!!!");
//        mSensorService = new ServiceAgent(context);
//        context.startService(new Intent(context, ServiceAgent.class));
    }

}
