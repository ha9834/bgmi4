package kotlin.coroutines;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.Serializable;
import kotlin.coroutines.e;
import kotlin.jvm.a.m;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;

/* loaded from: classes3.dex */
public final class CombinedContext implements Serializable, e {
    private final e.b element;
    private final e left;

    public CombinedContext(e eVar, e.b bVar) {
        h.b(eVar, ViewHierarchyConstants.DIMENSION_LEFT_KEY);
        h.b(bVar, "element");
        this.left = eVar;
        this.element = bVar;
    }

    @Override // kotlin.coroutines.e
    public e plus(e eVar) {
        h.b(eVar, "context");
        return e.a.a(this, eVar);
    }

    @Override // kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        h.b(cVar, "key");
        e eVar = this;
        do {
            CombinedContext combinedContext = (CombinedContext) eVar;
            E e = (E) combinedContext.element.get(cVar);
            if (e != null) {
                return e;
            }
            eVar = combinedContext.left;
        } while (eVar instanceof CombinedContext);
        return (E) eVar.get(cVar);
    }

    @Override // kotlin.coroutines.e
    public <R> R fold(R r, m<? super R, ? super e.b, ? extends R> mVar) {
        h.b(mVar, "operation");
        return mVar.a((Object) this.left.fold(r, mVar), this.element);
    }

    @Override // kotlin.coroutines.e
    public e minusKey(e.c<?> cVar) {
        h.b(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        e minusKey = this.left.minusKey(cVar);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.f6950a ? this.element : new CombinedContext(minusKey, this.element);
    }

    private final int a() {
        CombinedContext combinedContext = this;
        int i = 2;
        while (true) {
            e eVar = combinedContext.left;
            if (!(eVar instanceof CombinedContext)) {
                eVar = null;
            }
            combinedContext = (CombinedContext) eVar;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final boolean a(e.b bVar) {
        return h.a(get(bVar.getKey()), bVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean a(CombinedContext combinedContext) {
        while (a(combinedContext.element)) {
            e eVar = combinedContext.left;
            if (!(eVar instanceof CombinedContext)) {
                if (eVar != null) {
                    return a((e.b) eVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
            combinedContext = (CombinedContext) eVar;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.a() != a() || !combinedContext.a(this)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", new m<String, e.b, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // kotlin.jvm.a.m
            public final String a(String str, e.b bVar) {
                h.b(str, "acc");
                h.b(bVar, "element");
                if (str.length() == 0) {
                    return bVar.toString();
                }
                return str + ", " + bVar;
            }
        })) + "]";
    }

    private final Object writeReplace() {
        int a2 = a();
        final e[] eVarArr = new e[a2];
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 0;
        fold(k.f6974a, new m<k, e.b, k>() { // from class: kotlin.coroutines.CombinedContext$writeReplace$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.a.m
            public /* bridge */ /* synthetic */ k a(k kVar, e.b bVar) {
                a2(kVar, bVar);
                return k.f6974a;
            }

            /* renamed from: a, reason: avoid collision after fix types in other method */
            public final void a2(k kVar, e.b bVar) {
                h.b(kVar, "<anonymous parameter 0>");
                h.b(bVar, "element");
                e[] eVarArr2 = eVarArr;
                Ref.IntRef intRef2 = intRef;
                int i = intRef2.element;
                intRef2.element = i + 1;
                eVarArr2[i] = bVar;
            }
        });
        if (!(intRef.element == a2)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        return new Serialized(eVarArr);
    }

    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6947a = new a(null);
        private static final long serialVersionUID = 0;
        private final e[] elements;

        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public Serialized(e[] eVarArr) {
            h.b(eVarArr, MessengerShareContentUtility.ELEMENTS);
            this.elements = eVarArr;
        }

        private final Object readResolve() {
            e[] eVarArr = this.elements;
            e eVar = EmptyCoroutineContext.f6950a;
            for (e eVar2 : eVarArr) {
                eVar = eVar.plus(eVar2);
            }
            return eVar;
        }
    }
}
