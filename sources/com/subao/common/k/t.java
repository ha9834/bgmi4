package com.subao.common.k;

import android.content.Context;
import com.subao.common.k.m;

/* loaded from: classes2.dex */
public class t implements s {

    /* renamed from: a, reason: collision with root package name */
    private final int f6118a;

    @Override // com.subao.common.a
    public void a() {
    }

    public t(int i) {
        this.f6118a = i;
    }

    @Override // com.subao.common.k.l
    public int a(Context context) {
        throw new m.d(this.f6118a);
    }

    public String toString() {
        return String.format(com.subao.common.e.r.f6001a, "[WiFiAccelError #%d]", Integer.valueOf(this.f6118a));
    }
}
