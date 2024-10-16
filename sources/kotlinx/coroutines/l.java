package kotlinx.coroutines;

import kotlin.coroutines.e;
import kotlinx.coroutines.ad;

/* loaded from: classes3.dex */
public final class l extends kotlin.coroutines.a implements ad<String> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7022a = new a(null);
    private final long b;

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof l) && this.b == ((l) obj).b;
        }
        return true;
    }

    public int hashCode() {
        long j = this.b;
        return (int) (j ^ (j >>> 32));
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public <R> R fold(R r, kotlin.jvm.a.m<? super R, ? super e.b, ? extends R> mVar) {
        return (R) ad.a.a(this, r, mVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e.b, kotlin.coroutines.e
    public <E extends e.b> E get(e.c<E> cVar) {
        return (E) ad.a.a(this, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public kotlin.coroutines.e minusKey(e.c<?> cVar) {
        return ad.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.e
    public kotlin.coroutines.e plus(kotlin.coroutines.e eVar) {
        return ad.a.a(this, eVar);
    }

    /* loaded from: classes3.dex */
    public static final class a implements e.c<l> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public String toString() {
        return "CoroutineId(" + this.b + ')';
    }

    @Override // kotlinx.coroutines.ad
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String b(kotlin.coroutines.e eVar) {
        String str;
        m mVar = (m) eVar.get(m.f7023a);
        if (mVar == null || (str = mVar.a()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int b = kotlin.text.l.b((CharSequence) name, " @", 0, false, 6, (Object) null);
        if (b < 0) {
            b = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + b + 10);
        if (name != null) {
            String substring = name.substring(0, b);
            kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(this.b);
            kotlin.k kVar = kotlin.k.f6974a;
            String sb2 = sb.toString();
            kotlin.jvm.internal.h.a((Object) sb2, "StringBuilder(capacity).…builderAction).toString()");
            currentThread.setName(sb2);
            return name;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // kotlinx.coroutines.ad
    public void a(kotlin.coroutines.e eVar, String str) {
        Thread.currentThread().setName(str);
    }
}
