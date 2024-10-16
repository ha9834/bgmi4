package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzcg {

    /* renamed from: a, reason: collision with root package name */
    private final long f4405a;
    private final int b;
    private double c;
    private long d;
    private final Object e;
    private final String f;
    private final Clock g;

    private zzcg(int i, long j, String str, Clock clock) {
        this.e = new Object();
        this.b = 60;
        this.c = this.b;
        this.f4405a = 2000L;
        this.f = str;
        this.g = clock;
    }

    public zzcg(String str, Clock clock) {
        this(60, 2000L, str, clock);
    }

    public final boolean zzfm() {
        synchronized (this.e) {
            long currentTimeMillis = this.g.currentTimeMillis();
            if (this.c < this.b) {
                double d = currentTimeMillis - this.d;
                double d2 = this.f4405a;
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
            String str = this.f;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
            sb.append("Excessive ");
            sb.append(str);
            sb.append(" detected; call ignored.");
            zzch.zzac(sb.toString());
            return false;
        }
    }
}
