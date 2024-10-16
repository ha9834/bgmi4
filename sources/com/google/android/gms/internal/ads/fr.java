package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
final class fr extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxi f2178a;

    private fr(zzaxi zzaxiVar) {
        this.f2178a = zzaxiVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            zzaxi.a(this.f2178a, true);
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            zzaxi.a(this.f2178a, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ fr(zzaxi zzaxiVar, fn fnVar) {
        this(zzaxiVar);
    }
}
