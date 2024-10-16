package com.ihoc.mgpa.n;

import com.ihoc.mgpa.n.k;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f5673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar) {
        this.f5673a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        List list;
        z = this.f5673a.b;
        if (z) {
            z2 = this.f5673a.c;
            if (z2) {
                this.f5673a.b = false;
                m.a("TGPA_ForegroundCallbacks", "went background");
                list = this.f5673a.e;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        ((k.a) it.next()).onBecameBackground();
                    } catch (Exception e) {
                        m.b("TGPA_ForegroundCallbacks", "Listener threw exception!:" + e.toString());
                    }
                }
                return;
            }
        }
        m.a("TGPA_ForegroundCallbacks", "still foreground");
    }
}
