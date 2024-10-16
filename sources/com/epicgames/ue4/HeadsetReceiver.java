package com.epicgames.ue4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
class HeadsetReceiver extends BroadcastReceiver {
    public static IntentFilter filter;
    public static HeadsetReceiver receiver;

    private static native void stateChanged(int i);

    HeadsetReceiver() {
    }

    public static void startReceiver(Activity activity) {
        GameActivity.Log.debug("Registering headset receiver");
        if (filter == null) {
            filter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        }
        if (receiver == null) {
            receiver = new HeadsetReceiver();
        }
        activity.registerReceiver(receiver, filter);
        int intExtra = activity.getIntent().getIntExtra("state", 0);
        GameActivity.Log.debug("startHeadsetReceiver: " + intExtra);
        stateChanged(intExtra);
    }

    public static void stopReceiver(Activity activity) {
        GameActivity.Log.debug("Unregistering headset receiver");
        activity.unregisterReceiver(receiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        GameActivity.Log.debug("headsetReceiver::onReceive");
        if (intent.hasExtra("state")) {
            stateChanged(intent.getIntExtra("state", 0));
        }
    }
}
