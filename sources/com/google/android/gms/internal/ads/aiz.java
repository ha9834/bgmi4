package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aiz extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzeh f1904a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aiz(zzeh zzehVar) {
        this.f1904a = zzehVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f1904a.b();
    }
}
