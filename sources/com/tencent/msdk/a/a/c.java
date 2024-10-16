package com.tencent.msdk.a.a;

import android.content.Context;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Context f6279a;
    private static volatile c b;

    private c(Context context) {
        f6279a = context.getApplicationContext();
    }

    public static c a(Context context) {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c(context);
                }
            }
        }
        return b;
    }

    public String a() {
        return h.a(f6279a).a().c;
    }
}
