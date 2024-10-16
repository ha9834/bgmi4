package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.coroutines.e;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;

/* loaded from: classes3.dex */
public final class a extends b {
    private volatile a _immediate;
    private final a b;
    private final Handler d;
    private final String e;
    private final boolean f;

    private a(Handler handler, String str, boolean z) {
        super(null);
        this.d = handler;
        this.e = str;
        this.f = z;
        this._immediate = this.f ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(this.d, this.e, true);
            this._immediate = aVar;
            k kVar = k.f6974a;
        }
        this.b = aVar;
    }

    public /* synthetic */ a(Handler handler, String str, int i, f fVar) {
        this(handler, (i & 2) != 0 ? (String) null : str);
    }

    public a(Handler handler, String str) {
        this(handler, str, false);
    }

    @Override // kotlinx.coroutines.ac
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a a() {
        return this.b;
    }

    @Override // kotlinx.coroutines.i
    public boolean a(e eVar) {
        return !this.f || (h.a(Looper.myLooper(), this.d.getLooper()) ^ true);
    }

    @Override // kotlinx.coroutines.i
    public void a(e eVar, Runnable runnable) {
        this.d.post(runnable);
    }

    @Override // kotlinx.coroutines.ac, kotlinx.coroutines.i
    public String toString() {
        String b = b();
        if (b != null) {
            return b;
        }
        a aVar = this;
        String str = aVar.e;
        if (str == null) {
            str = aVar.d.toString();
        }
        if (!aVar.f) {
            return str;
        }
        return str + ".immediate";
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).d == this.d;
    }

    public int hashCode() {
        return System.identityHashCode(this.d);
    }
}
