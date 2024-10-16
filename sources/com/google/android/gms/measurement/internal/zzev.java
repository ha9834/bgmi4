package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzev {

    /* renamed from: a, reason: collision with root package name */
    private final String f4937a;
    private final String b;
    private boolean c;
    private String d;
    private final /* synthetic */ cz e;

    public zzev(cz czVar, String str, String str2) {
        this.e = czVar;
        Preconditions.checkNotEmpty(str);
        this.f4937a = str;
        this.b = null;
    }

    public final String zzho() {
        SharedPreferences m;
        if (!this.c) {
            this.c = true;
            m = this.e.m();
            this.d = m.getString(this.f4937a, null);
        }
        return this.d;
    }

    public final void zzau(String str) {
        SharedPreferences m;
        if (zzjs.d(str, this.d)) {
            return;
        }
        m = this.e.m();
        SharedPreferences.Editor edit = m.edit();
        edit.putString(this.f4937a, str);
        edit.apply();
        this.d = str;
    }
}
