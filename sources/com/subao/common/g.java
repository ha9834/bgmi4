package com.subao.common;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class g<T> {

    /* renamed from: a, reason: collision with root package name */
    private final List<T> f6021a = new ArrayList();

    public boolean a(T t) {
        if (t == null) {
            return false;
        }
        synchronized (this.f6021a) {
            if (this.f6021a.contains(t)) {
                return false;
            }
            return this.f6021a.add(t);
        }
    }

    public boolean b(T t) {
        boolean remove;
        if (t == null) {
            return false;
        }
        synchronized (this.f6021a) {
            remove = this.f6021a.remove(t);
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<T> a() {
        synchronized (this.f6021a) {
            if (this.f6021a.isEmpty()) {
                return null;
            }
            return new ArrayList(this.f6021a);
        }
    }
}
