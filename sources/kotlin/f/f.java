package kotlin.f;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f extends e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes3.dex */
    public static final class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f6961a;

        public a(Iterator it) {
            this.f6961a = it;
        }

        @Override // kotlin.f.b
        public Iterator<T> a() {
            return this.f6961a;
        }
    }

    public static final <T> b<T> a(Iterator<? extends T> it) {
        kotlin.jvm.internal.h.b(it, "$this$asSequence");
        return c.a(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> a(b<? extends T> bVar) {
        kotlin.jvm.internal.h.b(bVar, "$this$constrainOnce");
        return bVar instanceof kotlin.f.a ? bVar : new kotlin.f.a(bVar);
    }
}
