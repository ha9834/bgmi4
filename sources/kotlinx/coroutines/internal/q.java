package kotlinx.coroutines.internal;

import kotlin.coroutines.e;
import kotlinx.coroutines.ad;

/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private static final m f7018a = new m("ZERO");
    private static final kotlin.jvm.a.m<Object, e.b, Object> b = new kotlin.jvm.a.m<Object, e.b, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.a.m
        public final Object a(Object obj, e.b bVar) {
            if (!(bVar instanceof ad)) {
                return obj;
            }
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    };
    private static final kotlin.jvm.a.m<ad<?>, e.b, ad<?>> c = new kotlin.jvm.a.m<ad<?>, e.b, ad<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.a.m
        public final ad<?> a(ad<?> adVar, e.b bVar) {
            if (adVar != null) {
                return adVar;
            }
            if (!(bVar instanceof ad)) {
                bVar = null;
            }
            return (ad) bVar;
        }
    };
    private static final kotlin.jvm.a.m<t, e.b, t> d = new kotlin.jvm.a.m<t, e.b, t>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.a.m
        public final t a(t tVar, e.b bVar) {
            if (bVar instanceof ad) {
                tVar.a(((ad) bVar).b(tVar.c()));
            }
            return tVar;
        }
    };
    private static final kotlin.jvm.a.m<t, e.b, t> e = new kotlin.jvm.a.m<t, e.b, t>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$restoreState$1
        @Override // kotlin.jvm.a.m
        public final t a(t tVar, e.b bVar) {
            if (bVar instanceof ad) {
                ((ad) bVar).a(tVar.c(), tVar.a());
            }
            return tVar;
        }
    };

    public static final Object a(kotlin.coroutines.e eVar) {
        Object fold = eVar.fold(0, b);
        kotlin.jvm.internal.h.a(fold);
        return fold;
    }

    public static final Object a(kotlin.coroutines.e eVar, Object obj) {
        if (obj == null) {
            obj = a(eVar);
        }
        if (obj == 0) {
            return f7018a;
        }
        if (obj instanceof Integer) {
            return eVar.fold(new t(eVar, ((Number) obj).intValue()), d);
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        return ((ad) obj).b(eVar);
    }

    public static final void b(kotlin.coroutines.e eVar, Object obj) {
        if (obj == f7018a) {
            return;
        }
        if (obj instanceof t) {
            ((t) obj).b();
            eVar.fold(obj, e);
        } else {
            Object fold = eVar.fold(null, c);
            if (fold == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            ((ad) fold).a(eVar, obj);
        }
    }
}
