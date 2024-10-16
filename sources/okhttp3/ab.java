package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;
import okhttp3.s;

/* loaded from: classes.dex */
public final class ab implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    final z f7046a;
    final Protocol b;
    final int c;
    final String d;

    @Nullable
    final r e;
    final s f;

    @Nullable
    final ac g;

    @Nullable
    final ab h;

    @Nullable
    final ab i;

    @Nullable
    final ab j;
    final long k;
    final long l;

    @Nullable
    private volatile d m;

    ab(a aVar) {
        this.f7046a = aVar.f7047a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    public z a() {
        return this.f7046a;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public String d() {
        return this.d;
    }

    @Nullable
    public r e() {
        return this.e;
    }

    @Nullable
    public String a(String str) {
        return a(str, null);
    }

    @Nullable
    public String a(String str, @Nullable String str2) {
        String a2 = this.f.a(str);
        return a2 != null ? a2 : str2;
    }

    public s f() {
        return this.f;
    }

    @Nullable
    public ac g() {
        return this.g;
    }

    public a h() {
        return new a(this);
    }

    @Nullable
    public ab i() {
        return this.j;
    }

    public d j() {
        d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f);
        this.m = a2;
        return a2;
    }

    public long k() {
        return this.k;
    }

    public long l() {
        return this.l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ac acVar = this.g;
        if (acVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        acVar.close();
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.f7046a.a() + '}';
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        z f7047a;

        @Nullable
        Protocol b;
        int c;
        String d;

        @Nullable
        r e;
        s.a f;

        @Nullable
        ac g;

        @Nullable
        ab h;

        @Nullable
        ab i;

        @Nullable
        ab j;
        long k;
        long l;

        public a() {
            this.c = -1;
            this.f = new s.a();
        }

        a(ab abVar) {
            this.c = -1;
            this.f7047a = abVar.f7046a;
            this.b = abVar.b;
            this.c = abVar.c;
            this.d = abVar.d;
            this.e = abVar.e;
            this.f = abVar.f.b();
            this.g = abVar.g;
            this.h = abVar.h;
            this.i = abVar.i;
            this.j = abVar.j;
            this.k = abVar.k;
            this.l = abVar.l;
        }

        public a a(z zVar) {
            this.f7047a = zVar;
            return this;
        }

        public a a(Protocol protocol) {
            this.b = protocol;
            return this;
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(@Nullable r rVar) {
            this.e = rVar;
            return this;
        }

        public a a(String str, String str2) {
            this.f.d(str, str2);
            return this;
        }

        public a b(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public a a(s sVar) {
            this.f = sVar.b();
            return this;
        }

        public a a(@Nullable ac acVar) {
            this.g = acVar;
            return this;
        }

        public a a(@Nullable ab abVar) {
            if (abVar != null) {
                a("networkResponse", abVar);
            }
            this.h = abVar;
            return this;
        }

        public a b(@Nullable ab abVar) {
            if (abVar != null) {
                a("cacheResponse", abVar);
            }
            this.i = abVar;
            return this;
        }

        private void a(String str, ab abVar) {
            if (abVar.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (abVar.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (abVar.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (abVar.j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a c(@Nullable ab abVar) {
            if (abVar != null) {
                d(abVar);
            }
            this.j = abVar;
            return this;
        }

        private void d(ab abVar) {
            if (abVar.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(long j) {
            this.k = j;
            return this;
        }

        public a b(long j) {
            this.l = j;
            return this;
        }

        public ab a() {
            if (this.f7047a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            }
            if (this.d == null) {
                throw new IllegalStateException("message == null");
            }
            return new ab(this);
        }
    }
}
