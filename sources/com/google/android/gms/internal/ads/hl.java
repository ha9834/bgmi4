package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@zzard
/* loaded from: classes2.dex */
final class hl {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2218a = new Object();
    private final List<Runnable> b = new ArrayList();
    private boolean c = false;

    public final void a(final Runnable runnable, final Executor executor) {
        synchronized (this.f2218a) {
            if (this.c) {
                executor.execute(runnable);
            } else {
                this.b.add(new Runnable(executor, runnable) { // from class: com.google.android.gms.internal.ads.hm

                    /* renamed from: a, reason: collision with root package name */
                    private final Executor f2219a;
                    private final Runnable b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2219a = executor;
                        this.b = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2219a.execute(this.b);
                    }
                });
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f2218a) {
            if (this.c) {
                return;
            }
            arrayList.addAll(this.b);
            this.b.clear();
            this.c = true;
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
    }
}
