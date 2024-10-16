package com.shieldtunnel.svpn.common.e;

import android.util.SparseArray;

/* loaded from: classes2.dex */
public class a<E> {

    /* renamed from: a, reason: collision with root package name */
    private int f5800a;
    private final SparseArray<E> b;

    public a(int i) {
        this(i, 0);
    }

    public int a(E e) {
        int i;
        synchronized (this) {
            i = this.f5800a + 1;
            this.f5800a = i;
            this.b.put(i, e);
        }
        return i;
    }

    public a(int i, int i2) {
        this.b = new SparseArray<>(i);
        this.f5800a = i2;
    }

    public E a(int i) {
        E e;
        synchronized (this) {
            int indexOfKey = this.b.indexOfKey(i);
            if (indexOfKey >= 0) {
                e = this.b.valueAt(indexOfKey);
                this.b.removeAt(indexOfKey);
            } else {
                e = null;
            }
        }
        return e;
    }
}
