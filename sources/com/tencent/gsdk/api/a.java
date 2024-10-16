package com.tencent.gsdk.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f6229a = 0;
    private static int b = -1;

    public static void a(Context context) {
        if (context == null) {
            com.tencent.gsdk.utils.g.b("startBatteryListener context is null");
            return;
        }
        try {
            context.registerReceiver(new BroadcastReceiver() { // from class: com.tencent.gsdk.api.a.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    int unused = a.f6229a = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                    int intExtra = intent.getIntExtra("status", 1);
                    if (intExtra == 2 || intExtra == 5) {
                        a.a(1);
                    }
                }
            }, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Exception e) {
            com.tencent.gsdk.utils.g.d("BatteryListener startBatteryListener: " + e.getMessage());
        }
    }

    public static int a() {
        return f6229a;
    }

    public static int b() {
        return b;
    }

    public static void a(int i) {
        b = i;
    }
}
