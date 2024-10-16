package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class aou implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ aot f2017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aou(aot aotVar) {
        this.f2017a = aotVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List list;
        obj = this.f2017a.c;
        synchronized (obj) {
            z = this.f2017a.d;
            if (z) {
                z2 = this.f2017a.e;
                if (z2) {
                    aot.a(this.f2017a, false);
                    zzawz.zzdp("App went background");
                    list = this.f2017a.f;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            ((zzut) it.next()).zzp(false);
                        } catch (Exception e) {
                            zzbad.zzc("", e);
                        }
                    }
                }
            }
            zzawz.zzdp("App is still foreground");
        }
    }
}
