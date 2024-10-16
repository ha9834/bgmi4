package com.subao.common.k;

import android.content.Context;
import com.subao.common.k.k;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6106a;
    private final l b;
    private final Queue<h> c = new LinkedList();
    private final com.subao.common.m.a d = com.subao.common.m.b.a();

    public j(Context context, l lVar) {
        this.f6106a = context;
        this.b = lVar;
    }

    public void a(h hVar) {
        boolean z;
        synchronized (this.c) {
            this.c.add(hVar);
            z = true;
            if (this.c.size() != 1) {
                z = false;
            }
        }
        if (z) {
            b(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(h hVar) {
        this.d.a(new k(this.f6106a, this.b, hVar, this.d, new k.a() { // from class: com.subao.common.k.j.1
            @Override // com.subao.common.k.k.a
            public void a() {
                h hVar2;
                synchronized (j.this.c) {
                    j.this.c.poll();
                    hVar2 = (h) j.this.c.peek();
                }
                if (hVar2 != null) {
                    j.this.b(hVar2);
                }
            }
        }));
    }
}
