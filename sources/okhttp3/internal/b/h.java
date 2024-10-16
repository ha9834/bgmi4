package okhttp3.internal.b;

import javax.annotation.Nullable;
import okhttp3.ac;
import okhttp3.v;

/* loaded from: classes.dex */
public final class h extends ac {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f7075a;
    private final long b;
    private final okio.e c;

    public h(@Nullable String str, long j, okio.e eVar) {
        this.f7075a = str;
        this.b = j;
        this.c = eVar;
    }

    @Override // okhttp3.ac
    public v a() {
        String str = this.f7075a;
        if (str != null) {
            return v.b(str);
        }
        return null;
    }

    @Override // okhttp3.ac
    public long b() {
        return this.b;
    }

    @Override // okhttp3.ac
    public okio.e d() {
        return this.c;
    }
}
