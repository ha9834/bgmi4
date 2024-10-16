package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aok extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzua f2007a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aok(zzua zzuaVar) {
        this.f2007a = zzuaVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.f2007a.a(3);
    }
}
