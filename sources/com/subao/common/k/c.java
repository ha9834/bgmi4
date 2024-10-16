package com.subao.common.k;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class c extends com.subao.common.g<a> {

    /* renamed from: a, reason: collision with root package name */
    private static final c f6096a = new c();

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);
    }

    private c() {
    }

    public static c b() {
        return f6096a;
    }

    public void a(int i) {
        List<a> a2 = a();
        if (a2 == null || a2.isEmpty()) {
            return;
        }
        Iterator<a> it = a2.iterator();
        while (it.hasNext()) {
            it.next().a(i);
        }
    }
}
