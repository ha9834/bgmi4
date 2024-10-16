package com.shieldtunnel.svpn;

import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.f.f;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private List<Runnable> f5776a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a() {
        List<Runnable> list;
        synchronized (this) {
            list = this.f5776a;
            this.f5776a = null;
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        Log.d(LogTag.MAIN, String.format(f.b, "There are %d task(s) need run after Master.init()", Integer.valueOf(list.size())));
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        synchronized (this) {
        }
    }
}
