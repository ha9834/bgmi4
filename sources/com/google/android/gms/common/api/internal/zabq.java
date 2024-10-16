package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class zabq extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private Context f1393a;
    private final zabr b;

    public zabq(zabr zabrVar) {
        this.b = zabrVar;
    }

    public final void zac(Context context) {
        this.f1393a = context;
    }

    public final synchronized void unregister() {
        if (this.f1393a != null) {
            this.f1393a.unregisterReceiver(this);
        }
        this.f1393a = null;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.b.zas();
            unregister();
        }
    }
}
