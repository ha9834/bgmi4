package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
final class de implements cb {

    /* renamed from: a, reason: collision with root package name */
    private final long f5117a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final Clock f;

    private de(int i, long j) {
        this.e = new Object();
        this.b = 60;
        this.c = this.b;
        this.f5117a = 2000L;
        this.f = DefaultClock.getInstance();
    }

    public de() {
        this(60, 2000L);
    }

    @Override // com.google.android.gms.tagmanager.cb
    public final boolean a() {
        synchronized (this.e) {
            long currentTimeMillis = this.f.currentTimeMillis();
            if (this.c < this.b) {
                double d = currentTimeMillis - this.d;
                double d2 = this.f5117a;
                Double.isNaN(d);
                Double.isNaN(d2);
                double d3 = d / d2;
                if (d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    this.c = Math.min(this.b, this.c + d3);
                }
            }
            this.d = currentTimeMillis;
            if (this.c >= 1.0d) {
                this.c -= 1.0d;
                return true;
            }
            zzdi.zzac("No more tokens available.");
            return false;
        }
    }
}
