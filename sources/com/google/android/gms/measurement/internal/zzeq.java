package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzeq {

    /* renamed from: a, reason: collision with root package name */
    private final String f4933a;
    private final boolean b;
    private boolean c;
    private boolean d;
    private final /* synthetic */ cz e;

    public zzeq(cz czVar, String str, boolean z) {
        this.e = czVar;
        Preconditions.checkNotEmpty(str);
        this.f4933a = str;
        this.b = z;
    }

    public final boolean get() {
        SharedPreferences m;
        if (!this.c) {
            this.c = true;
            m = this.e.m();
            this.d = m.getBoolean(this.f4933a, this.b);
        }
        return this.d;
    }

    public final void set(boolean z) {
        SharedPreferences m;
        m = this.e.m();
        SharedPreferences.Editor edit = m.edit();
        edit.putBoolean(this.f4933a, z);
        edit.apply();
        this.d = z;
    }
}
