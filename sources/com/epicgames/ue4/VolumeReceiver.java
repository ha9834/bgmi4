package com.epicgames.ue4;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

/* loaded from: classes.dex */
class VolumeReceiver extends BroadcastReceiver {
    private static String STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    private static String STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    private static String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private static IntentFilter filter;
    private static VolumeReceiver receiver;

    private static native void volumeChanged(int i);

    VolumeReceiver() {
    }

    public static void startReceiver(Activity activity) {
        GameActivity.Log.debug("Registering volume receiver");
        if (filter == null) {
            filter = new IntentFilter();
            filter.addAction(VOLUME_CHANGED_ACTION);
        }
        if (receiver == null) {
            receiver = new VolumeReceiver();
        }
        activity.registerReceiver(receiver, filter);
        int i = -1;
        try {
            i = ((AudioManager) activity.getSystemService("audio")).getStreamVolume(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameActivity.Log.debug("startVolumeReceiver: " + i);
        if (i >= 0) {
            volumeChanged(i);
        }
    }

    public static void stopReceiver(Activity activity) {
        GameActivity.Log.debug("Unregistering volume receiver");
        activity.unregisterReceiver(receiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        GameActivity.Log.debug("OnReceive VOLUME_CHANGED_ACTION");
        int i2 = -1;
        try {
            i = ((Integer) intent.getExtras().get(STREAM_TYPE)).intValue();
        } catch (Exception e) {
            e = e;
            i = -1;
        }
        try {
            i2 = ((Integer) intent.getExtras().get(STREAM_VALUE)).intValue();
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (i != 3) {
            }
            GameActivity.Log.debug("skipping volume change from stream " + i);
        }
        if (i != 3 && i2 >= 0) {
            volumeChanged(i2);
            return;
        }
        GameActivity.Log.debug("skipping volume change from stream " + i);
    }
}
