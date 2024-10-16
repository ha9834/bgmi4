package androidx.activity.result.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class a<I, O> {
    public abstract Intent a(Context context, @SuppressLint({"UnknownNullness"}) I i);

    @SuppressLint({"UnknownNullness"})
    public abstract O a(int i, Intent intent);

    public C0022a<O> b(Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    /* renamed from: androidx.activity.result.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0022a<T> {

        /* renamed from: a, reason: collision with root package name */
        @SuppressLint({"UnknownNullness"})
        private final T f131a;

        public C0022a(@SuppressLint({"UnknownNullness"}) T t) {
            this.f131a = t;
        }

        @SuppressLint({"UnknownNullness"})
        public T a() {
            return this.f131a;
        }
    }
}
