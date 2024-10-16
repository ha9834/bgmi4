package com.tencent.hawk.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.hawk.bridge.ActivityStatusChangedInterface;
import com.tencent.hawk.bridge.CC;
import com.tencent.hawk.bridge.HawkLogger;
import com.tencent.hawk.bridge.HawkNative;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class ReceiverMgr implements ActivityStatusChangedInterface {
    private volatile boolean sIsRegistered = false;
    private List<Semaphore> sNotificationSemaphoreList = new ArrayList();
    private volatile boolean sIsForeground = true;
    private BroadcastReceiver sBroadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.hawk.receiver.ReceiverMgr.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (CC.getStrategy().isCCBatteryEnabled()) {
                    if (ReceiverMgr.this.sIsForeground) {
                        if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                            int intExtra = intent.getIntExtra("status", 0);
                            int intExtra2 = intent.getIntExtra(IntegrityManager.INTEGRITY_TYPE_HEALTH, 0);
                            int intExtra3 = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
                            int intExtra4 = intent.getIntExtra("scale", 0);
                            int intExtra5 = intent.getIntExtra("plugged", 0);
                            int intExtra6 = intent.getIntExtra("voltage", 0);
                            int intExtra7 = intent.getIntExtra("temperature", 0);
                            HawkNative.postBatteryInfo(1, intExtra, intExtra2, intExtra3, intExtra4, intExtra5, intExtra6, intExtra7);
                            HawkLogger.d(String.format("Receivce Battery msg: %d %d %d %d %d %d %d", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Integer.valueOf(intExtra3), Integer.valueOf(intExtra4), Integer.valueOf(intExtra5), Integer.valueOf(intExtra6), Integer.valueOf(intExtra7)).toString());
                            return;
                        }
                        if (action.equals(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION)) {
                            if (context == null) {
                                HawkLogger.e("Context is null, network type changed");
                                return;
                            }
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                                HawkLogger.i("Network is available");
                                synchronized (ReceiverMgr.this.sNotificationSemaphoreList) {
                                    if (ReceiverMgr.this.sNotificationSemaphoreList != null && ReceiverMgr.this.sNotificationSemaphoreList.size() > 0) {
                                        for (Semaphore semaphore : ReceiverMgr.this.sNotificationSemaphoreList) {
                                            if (semaphore != null) {
                                                semaphore.release();
                                            }
                                        }
                                    }
                                }
                                return;
                            }
                            HawkLogger.i("Network is disabled");
                            return;
                        }
                        return;
                    }
                    HawkLogger.d("receive intent, but background");
                    return;
                }
                HawkLogger.e("Battrey receicer disabled by CC");
            } catch (Exception e) {
                HawkLogger.e("Broadcast error: " + e.getMessage());
            }
        }
    };

    public void unregisterStatusReceiver(Context context) {
        if (context == null) {
        }
    }

    public void addNotificationSemaphore(Semaphore semaphore) {
        if (semaphore == null) {
            return;
        }
        synchronized (this.sNotificationSemaphoreList) {
            this.sNotificationSemaphoreList.add(semaphore);
        }
    }

    public void registerStatusReceiver(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (!this.sIsRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION);
                context.registerReceiver(this.sBroadcastReceiver, intentFilter);
                this.sIsRegistered = true;
                HawkLogger.i("register receiver");
            } else {
                HawkLogger.e("receiver already registered");
            }
        } catch (Exception e) {
            HawkLogger.e("Register status receiver failed: " + e.getMessage());
        }
    }

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void backgroud() {
        this.sIsForeground = false;
    }

    @Override // com.tencent.hawk.bridge.ActivityStatusChangedInterface
    public void foreground() {
        this.sIsForeground = true;
    }
}
