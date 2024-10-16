package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.ac;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class k extends ac {
    private final Throwable b;
    private final String d;

    public k(Throwable th, String str) {
        this.b = th;
        this.d = str;
    }

    @Override // kotlinx.coroutines.ac
    public ac a() {
        return this;
    }

    @Override // kotlinx.coroutines.i
    public boolean a(kotlin.coroutines.e eVar) {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void a(kotlin.coroutines.e eVar, Runnable runnable) {
        c();
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r1 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Void c() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.b
            if (r0 == 0) goto L39
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.d
            if (r1 == 0) goto L26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L26
            goto L28
        L26:
            java.lang.String r1 = ""
        L28:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.b
            r1.<init>(r0, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L39:
            kotlinx.coroutines.internal.j.a()
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.k.c():java.lang.Void");
    }

    @Override // kotlinx.coroutines.ac, kotlinx.coroutines.i
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.b != null) {
            str = ", cause=" + this.b;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }
}
