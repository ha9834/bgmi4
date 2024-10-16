package com.ihoc.mgpa.e.a;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f5514a;

    public static d a(Context context) {
        if (f5514a == null) {
            synchronized (d.class) {
                if (f5514a == null) {
                    f5514a = new com.ihoc.mgpa.e.b.a(context);
                }
            }
        }
        return f5514a;
    }

    public abstract int a(String str);

    public abstract void a();

    public abstract void a(int i, int i2, int i3);

    public abstract void a(String str, int i, int i2, int i3, int i4);

    public abstract void b(String str, int i, int i2, int i3, int i4);
}
