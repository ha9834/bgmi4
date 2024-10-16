package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class h extends r {

    /* renamed from: a, reason: collision with root package name */
    private r f7180a;

    public h(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f7180a = rVar;
    }

    public final r a() {
        return this.f7180a;
    }

    public final h a(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f7180a = rVar;
        return this;
    }

    @Override // okio.r
    public r a(long j, TimeUnit timeUnit) {
        return this.f7180a.a(j, timeUnit);
    }

    @Override // okio.r
    public long i_() {
        return this.f7180a.i_();
    }

    @Override // okio.r
    public boolean g_() {
        return this.f7180a.g_();
    }

    @Override // okio.r
    public long d() {
        return this.f7180a.d();
    }

    @Override // okio.r
    public r a(long j) {
        return this.f7180a.a(j);
    }

    @Override // okio.r
    public r h_() {
        return this.f7180a.h_();
    }

    @Override // okio.r
    public r f() {
        return this.f7180a.f();
    }

    @Override // okio.r
    public void g() throws IOException {
        this.f7180a.g();
    }
}
