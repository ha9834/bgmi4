package com.tencent.msdk.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class h {
    private static h b;

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, g> f6282a;
    private d c = null;

    private h(Context context) {
        this.f6282a = null;
        this.f6282a = new HashMap(3);
        this.f6282a.put(1, new f(context));
        this.f6282a.put(2, new b(context));
        this.f6282a.put(4, new e(context));
    }

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
    public d a() {
        d dVar = this.c;
        if (dVar == null || !dVar.a()) {
            this.c = a(new ArrayList(Arrays.asList(1, 2, 4)));
        }
        return this.c;
    }

    d a(List<Integer> list) {
        d e;
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                g gVar = this.f6282a.get(it.next());
                if (gVar != null && (e = gVar.e()) != null && e.a()) {
                    return e;
                }
            }
        }
        return new d();
    }

    public void a(d dVar) {
        this.c = dVar;
        Iterator<Map.Entry<Integer, g>> it = this.f6282a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a(dVar);
        }
    }
}
