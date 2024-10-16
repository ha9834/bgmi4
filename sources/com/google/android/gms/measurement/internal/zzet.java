package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzet {

    /* renamed from: a, reason: collision with root package name */
    private final String f4935a;
    private final long b;
    private boolean c;
    private long d;
    private final /* synthetic */ cz e;

    public zzet(cz czVar, String str, long j) {
        this.e = czVar;
        Preconditions.checkNotEmpty(str);
        this.f4935a = str;
        this.b = j;
    }

    public final long get() {
        SharedPreferences m;
        if (!this.c) {
            this.c = true;
            m = this.e.m();
            this.d = m.getLong(this.f4935a, this.b);
        }
        return this.d;
    }

    public final void set(long j) {
        SharedPreferences m;
        m = this.e.m();
        SharedPreferences.Editor edit = m.edit();
        edit.putLong(this.f4935a, j);
        edit.apply();
        this.d = j;
    }
}
