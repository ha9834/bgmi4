package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class df implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzfj f4803a;
    private final /* synthetic */ long b;
    private final /* synthetic */ Bundle c;
    private final /* synthetic */ Context d;
    private final /* synthetic */ zzef e;
    private final /* synthetic */ BroadcastReceiver.PendingResult f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(zzez zzezVar, zzfj zzfjVar, long j, Bundle bundle, Context context, zzef zzefVar, BroadcastReceiver.PendingResult pendingResult) {
        this.f4803a = zzfjVar;
        this.b = j;
        this.c = bundle;
        this.d = context;
        this.e = zzefVar;
        this.f = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j = this.f4803a.zzac().h.get();
        long j2 = this.b;
        if (j > 0 && (j2 >= j || j2 <= 0)) {
            j2 = j - 1;
        }
        if (j2 > 0) {
            this.c.putLong("click_timestamp", j2);
        }
        this.c.putString("_cis", "referrer broadcast");
        zzfj.zza(this.d, null).zzq().logEvent("auto", "_cmp", this.c);
        this.e.zzgs().zzao("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.f;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
