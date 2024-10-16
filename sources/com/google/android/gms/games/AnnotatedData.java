package com.google.android.gms.games;

/* loaded from: classes.dex */
public class AnnotatedData<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T f1597a;
    private final boolean b;

    public AnnotatedData(T t, boolean z) {
        this.f1597a = t;
        this.b = z;
    }

    public T get() {
        return this.f1597a;
    }

    public boolean isStale() {
        return this.b;
    }
}
