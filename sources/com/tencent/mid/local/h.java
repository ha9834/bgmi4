package com.tencent.mid.local;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class h {
    private static h b;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, g> f6267a;

    private h(Context context) {
        this.f6267a = null;
        this.f6267a = new HashMap(3);
        this.f6267a.put(1, new f(context));
        this.f6267a.put(2, new b(context));
        this.f6267a.put(4, new d(context));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized h a(Context context) {
        h hVar;
        synchronized (h.class) {
            if (b == null) {
                b = new h(context);
            }
            hVar = b;
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c a() {
        return a(new ArrayList(Arrays.asList(1, 2, 4)));
    }

    c a(List<Integer> list) {
        c d;
        if (list != null && list.size() >= 0) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                g gVar = this.f6267a.get(it.next());
                if (gVar != null && (d = gVar.d()) != null && d.a()) {
                    return d;
                }
            }
        }
        return new c();
    }
}
