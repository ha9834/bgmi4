package kotlin.random;

import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class b extends kotlin.random.a {
    private final a b = new a();

    /* loaded from: classes3.dex */
    public static final class a extends ThreadLocal<java.util.Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Random initialValue() {
            return new java.util.Random();
        }
    }

    @Override // kotlin.random.a
    public java.util.Random a() {
        java.util.Random random = this.b.get();
        h.a((Object) random, "implStorage.get()");
        return random;
    }
}
