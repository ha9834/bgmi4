package kotlin;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class InitializedLazyImpl<T> implements Serializable, c<T> {
    private final T value;

    public InitializedLazyImpl(T t) {
        this.value = t;
    }

    @Override // kotlin.c
    public T a() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(a());
    }
}
