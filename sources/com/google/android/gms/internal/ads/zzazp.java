package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzazp {
    private boolean d;
    private Context e;
    private boolean c = false;

    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> b = new WeakHashMap();

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private final BroadcastReceiver f2842a = new gn(this);

    public final synchronized void initialize(Context context) {
        if (this.c) {
            return;
        }
        this.e = context.getApplicationContext();
        if (this.e == null) {
            this.e = context;
        }
        zzacu.initialize(this.e);
        this.d = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcsj)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.e.registerReceiver(this.f2842a, intentFilter);
        this.c = true;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.d) {
            this.b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.d) {
            this.b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(Context context, Intent intent) {
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.b.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                entry.getKey().onReceive(context, intent);
            }
        }
    }
}
