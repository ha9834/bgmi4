package kotlin.jvm.internal;

import kotlin.e.f;

/* loaded from: classes3.dex */
public abstract class PropertyReference1 extends PropertyReference implements kotlin.e.f {
    public PropertyReference1() {
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.e.a a() {
        return j.a(this);
    }

    @Override // kotlin.jvm.a.b
    public Object a(Object obj) {
        return b(obj);
    }

    @Override // kotlin.e.f
    public f.a i() {
        return ((kotlin.e.f) d()).i();
    }
}
