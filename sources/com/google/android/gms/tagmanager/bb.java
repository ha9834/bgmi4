package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class bb implements cb {
    private long e;
    private final String g;
    private final Clock h;
    private final Object f = new Object();
    private final int c = 5;
    private double d = Math.min(1, 5);

    /* renamed from: a, reason: collision with root package name */
    private final long f5088a = 900000;
    private final long b = 5000;

    public bb(int i, int i2, long j, long j2, String str, Clock clock) {
        this.g = str;
        this.h = clock;
    }

    @Override // com.google.android.gms.tagmanager.cb
    public final boolean a() {
        synchronized (this.f) {
            long currentTimeMillis = this.h.currentTimeMillis();
            if (currentTimeMillis - this.e < this.b) {
                String str = this.g;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Excessive ");
                sb.append(str);
                sb.append(" detected; call ignored.");
                zzdi.zzac(sb.toString());
                return false;
            }
            if (this.d < this.c) {
                double d = currentTimeMillis - this.e;
                double d2 = this.f5088a;
                Double.isNaN(d);
                Double.isNaN(d2);
                double d3 = d / d2;
                if (d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    this.d = Math.min(this.c, this.d + d3);
                }
            }
            this.e = currentTimeMillis;
            if (this.d >= 1.0d) {
                this.d -= 1.0d;
                return true;
            }
            String str2 = this.g;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 34);
            sb2.append("Excessive ");
            sb2.append(str2);
            sb2.append(" detected; call ignored.");
            zzdi.zzac(sb2.toString());
            return false;
        }
    }
}
