package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.ab;
import okhttp3.internal.b.g;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;

/* loaded from: classes3.dex */
public final class a implements u {

    /* renamed from: a, reason: collision with root package name */
    public final x f7084a;

    public a(x xVar) {
        this.f7084a = xVar;
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        g gVar = (g) aVar;
        z a2 = gVar.a();
        f f = gVar.f();
        return gVar.a(a2, f, f.a(this.f7084a, aVar, !a2.b().equals("GET")), f.c());
    }
}
