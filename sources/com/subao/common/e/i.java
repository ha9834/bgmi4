package com.subao.common.e;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class i<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final long f5989a;
    private final List<i<K, V>.a> b = new ArrayList(4);

    public i(long j) {
        this.f5989a = j;
    }

    private static long a() {
        return SystemClock.elapsedRealtime();
    }

    public synchronized V a(K k) {
        int b = b(k);
        if (b < 0) {
            return null;
        }
        i<K, V>.a aVar = this.b.get(b);
        if (a() >= ((a) aVar).d) {
            this.b.remove(b);
            return null;
        }
        return aVar.b;
    }

    public synchronized void a(K k, V v) {
        i<K, V>.a aVar = v == null ? null : new a(k, v, a() + this.f5989a);
        int b = b(k);
        if (b < 0) {
            if (v != null) {
                this.b.add(aVar);
            }
        } else if (v == null) {
            this.b.remove(b);
        } else {
            this.b.set(b, aVar);
        }
    }

    private int b(K k) {
        for (int size = this.b.size() - 1; size >= 0; size--) {
            if (com.subao.common.e.a(k, this.b.get(size).f5990a)) {
                return size;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final K f5990a;
        final V b;
        private final long d;

        private a(K k, V v, long j) {
            this.f5990a = k;
            this.b = v;
            this.d = j;
        }
    }
}
