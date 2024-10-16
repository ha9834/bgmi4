package com.subao.common.h;

import com.subao.common.e.b;
import java.util.List;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static List<b> f6025a;

    public static synchronized List<b> a() {
        List<b> list;
        synchronized (a.class) {
            list = f6025a;
        }
        return list;
    }

    public static synchronized void a(List<b> list) {
        synchronized (a.class) {
            f6025a = list;
        }
    }
}
