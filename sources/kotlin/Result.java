package kotlin;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class Result<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6935a = new a(null);
    private final Object value;

    public static boolean a(Object obj, Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.h.a(obj, ((Result) obj2).a());
    }

    public static Object e(Object obj) {
        return obj;
    }

    public static int f(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final /* synthetic */ Object a() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return a(this.value, obj);
    }

    public int hashCode() {
        return f(this.value);
    }

    public String toString() {
        return d(this.value);
    }

    public static final boolean a(Object obj) {
        return !(obj instanceof Failure);
    }

    public static final boolean b(Object obj) {
        return obj instanceof Failure;
    }

    public static final Throwable c(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public static String d(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            kotlin.jvm.internal.h.b(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && kotlin.jvm.internal.h.a(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }
}
