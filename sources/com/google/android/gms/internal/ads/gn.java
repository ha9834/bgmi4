package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gn extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzazp f2195a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gn(zzazp zzazpVar) {
        this.f2195a = zzazpVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f2195a.a(context, intent);
    }
}
