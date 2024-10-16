package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzes {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private final String f4934a;
    private final String b;
    private final String c;
    private final long d;
    private final /* synthetic */ cz e;

    private zzes(cz czVar, String str, long j) {
        this.e = czVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.f4934a = String.valueOf(str).concat(":start");
        this.b = String.valueOf(str).concat(":count");
        this.c = String.valueOf(str).concat(":value");
        this.d = j;
    }

    private final void a() {
        SharedPreferences m;
        this.e.zzo();
        long currentTimeMillis = this.e.zzx().currentTimeMillis();
        m = this.e.m();
        SharedPreferences.Editor edit = m.edit();
        edit.remove(this.b);
        edit.remove(this.c);
        edit.putLong(this.f4934a, currentTimeMillis);
        edit.apply();
    }

    public final void zzc(String str, long j) {
        SharedPreferences m;
        SharedPreferences m2;
        SharedPreferences m3;
        this.e.zzo();
        if (b() == 0) {
            a();
        }
        if (str == null) {
            str = "";
        }
        m = this.e.m();
        long j2 = m.getLong(this.b, 0L);
        if (j2 <= 0) {
            m3 = this.e.m();
            SharedPreferences.Editor edit = m3.edit();
            edit.putString(this.c, str);
            edit.putLong(this.b, 1L);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.e.zzz().c().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        m2 = this.e.m();
        SharedPreferences.Editor edit2 = m2.edit();
        if (z) {
            edit2.putString(this.c, str);
        }
        edit2.putLong(this.b, j3);
        edit2.apply();
    }

    public final Pair<String, Long> zzhl() {
        long abs;
        SharedPreferences m;
        SharedPreferences m2;
        this.e.zzo();
        this.e.zzo();
        long b = b();
        if (b == 0) {
            a();
            abs = 0;
        } else {
            abs = Math.abs(b - this.e.zzx().currentTimeMillis());
        }
        long j = this.d;
        if (abs < j) {
            return null;
        }
        if (abs > (j << 1)) {
            a();
            return null;
        }
        m = this.e.m();
        String string = m.getString(this.c, null);
        m2 = this.e.m();
        long j2 = m2.getLong(this.b, 0L);
        a();
        if (string == null || j2 <= 0) {
            return cz.f4797a;
        }
        return new Pair<>(string, Long.valueOf(j2));
    }

    private final long b() {
        SharedPreferences m;
        m = this.e.m();
        return m.getLong(this.f4934a, 0L);
    }
}
