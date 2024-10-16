package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import kotlin.jvm.KotlinReflectionNotSupportedError;

/* loaded from: classes3.dex */
public abstract class CallableReference implements Serializable, kotlin.e.a {
    public static final Object b = NoReceiver.f6967a;

    /* renamed from: a, reason: collision with root package name */
    private transient kotlin.e.a f6966a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    protected abstract kotlin.e.a a();

    /* loaded from: classes3.dex */
    private static class NoReceiver implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final NoReceiver f6967a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f6967a;
        }
    }

    public CallableReference() {
        this(b);
    }

    protected CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    public Object b() {
        return this.receiver;
    }

    public kotlin.e.a c() {
        kotlin.e.a aVar = this.f6966a;
        if (aVar != null) {
            return aVar;
        }
        kotlin.e.a a2 = a();
        this.f6966a = a2;
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public kotlin.e.a d() {
        kotlin.e.a c = c();
        if (c != this) {
            return c;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    public kotlin.e.c e() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? j.a(cls) : j.b(cls);
    }

    public String f() {
        return this.name;
    }

    public String g() {
        return this.signature;
    }

    @Override // kotlin.e.a
    public Object a(Object... objArr) {
        return d().a(objArr);
    }
}
