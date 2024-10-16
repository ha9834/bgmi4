package com.uqm.crashsight.service;

import android.content.Context;
import com.uqm.crashsight.proguard.m;

/* loaded from: classes3.dex */
public final class b {
    private static b b;

    /* renamed from: a, reason: collision with root package name */
    private a f6843a = null;

    public static synchronized void a(Context context, int i, int i2, int i3, boolean z) {
        synchronized (b.class) {
            if (b == null) {
                b bVar = new b();
                b = bVar;
                bVar.f6843a = new a(context, i, i2, i3, z);
            }
        }
    }

    public static b a() {
        return b;
    }

    public final void b() {
        a aVar = this.f6843a;
        if (aVar != null) {
            aVar.a();
        } else {
            m.e("routine start failed, routine is null", new Object[0]);
        }
    }
}
