package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.midas.oversea.comm.IabBroadcastReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    private final Context f948a;
    private final am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(Context context, o oVar) {
        this.f948a = context;
        this.b = new am(this, oVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.b.a(this.f948a, new IntentFilter(IabBroadcastReceiver.ACTION));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final o b() {
        return am.a(this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        this.b.a(this.f948a);
    }
}
