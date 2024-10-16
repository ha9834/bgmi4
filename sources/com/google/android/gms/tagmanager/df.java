package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.IntentFilter;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;

/* JADX INFO: Access modifiers changed from: package-private */
@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
public final class df extends zzfm {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f5118a = new Object();
    private static df n;
    private Context b;
    private ar c;
    private volatile an d;
    private zzfq k;
    private bh l;
    private int e = Constants.THIRTY_MINUTES;
    private boolean f = true;
    private boolean g = false;
    private boolean h = true;
    private boolean i = true;
    private as j = new dg(this);
    private boolean m = false;

    public static df a() {
        if (n == null) {
            n = new df();
        }
        return n;
    }

    private df() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a(Context context, an anVar) {
        if (this.b != null) {
            return;
        }
        this.b = context.getApplicationContext();
        if (this.d == null) {
            this.d = anVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized ar b() {
        if (this.c == null) {
            if (this.b == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.c = new bv(this.j, this.b);
        }
        if (this.k == null) {
            this.k = new di(this, null);
            if (this.e > 0) {
                this.k.zzh(this.e);
            }
        }
        this.g = true;
        if (this.f) {
            dispatch();
            this.f = false;
        }
        if (this.l == null && this.i) {
            this.l = new bh(this);
            bh bhVar = this.l;
            Context context = this.b;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION);
            context.registerReceiver(bhVar, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter2.addCategory(context.getPackageName());
            context.registerReceiver(bhVar, intentFilter2);
        }
        return this.c;
    }

    @Override // com.google.android.gms.tagmanager.zzfm
    public final synchronized void dispatch() {
        if (!this.g) {
            zzdi.zzab("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.f = true;
        } else {
            this.d.a(new dh(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final synchronized void a(boolean z, boolean z2) {
        boolean d = d();
        this.m = z;
        this.h = z2;
        if (d() == d) {
            return;
        }
        if (d()) {
            this.k.cancel();
            zzdi.zzab("PowerSaveMode initiated.");
        } else {
            this.k.zzh(this.e);
            zzdi.zzab("PowerSaveMode terminated.");
        }
    }

    @Override // com.google.android.gms.tagmanager.zzfm
    public final synchronized void zzf(boolean z) {
        a(this.m, z);
    }

    @Override // com.google.android.gms.tagmanager.zzfm
    public final synchronized void zzjp() {
        if (!d()) {
            this.k.zzjt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d() {
        return this.m || !this.h || this.e <= 0;
    }
}
