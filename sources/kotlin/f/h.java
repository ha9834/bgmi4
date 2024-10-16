package kotlin.f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class h extends g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Iterable<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f6962a;

        public a(b bVar) {
            this.f6962a = bVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f6962a.a();
        }
    }

    public static final <T, C extends Collection<? super T>> C a(b<? extends T> bVar, C c) {
        kotlin.jvm.internal.h.b(bVar, "$this$toCollection");
        kotlin.jvm.internal.h.b(c, "destination");
        Iterator<? extends T> a2 = bVar.a();
        while (a2.hasNext()) {
            c.add(a2.next());
        }
        return c;
    }

    public static final <T> List<T> b(b<? extends T> bVar) {
        kotlin.jvm.internal.h.b(bVar, "$this$toList");
        return j.b(c.c(bVar));
    }

    public static final <T> List<T> c(b<? extends T> bVar) {
        kotlin.jvm.internal.h.b(bVar, "$this$toMutableList");
        return (List) c.a(bVar, new ArrayList());
    }

    public static final <T, R> b<R> a(b<? extends T> bVar, kotlin.jvm.a.b<? super T, ? extends R> bVar2) {
        kotlin.jvm.internal.h.b(bVar, "$this$map");
        kotlin.jvm.internal.h.b(bVar2, "transform");
        return new i(bVar, bVar2);
    }

    public static final <T> Iterable<T> d(b<? extends T> bVar) {
        kotlin.jvm.internal.h.b(bVar, "$this$asIterable");
        return new a(bVar);
    }
}
