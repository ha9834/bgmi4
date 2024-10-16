package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class ac implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private Reader f7048a;

    @Nullable
    public abstract v a();

    public abstract long b();

    public abstract okio.e d();

    public final InputStream c() {
        return d().g();
    }

    public final byte[] e() throws IOException {
        long b = b();
        if (b > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + b);
        }
        okio.e d = d();
        try {
            byte[] s = d.s();
            okhttp3.internal.c.a(d);
            if (b == -1 || b == s.length) {
                return s;
            }
            throw new IOException("Content-Length (" + b + ") and stream length (" + s.length + ") disagree");
        } catch (Throwable th) {
            okhttp3.internal.c.a(d);
            throw th;
        }
    }

    public final Reader f() {
        Reader reader = this.f7048a;
        if (reader != null) {
            return reader;
        }
        a aVar = new a(d(), h());
        this.f7048a = aVar;
        return aVar;
    }

    public final String g() throws IOException {
        okio.e d = d();
        try {
            return d.a(okhttp3.internal.c.a(d, h()));
        } finally {
            okhttp3.internal.c.a(d);
        }
    }

    private Charset h() {
        v a2 = a();
        return a2 != null ? a2.a(okhttp3.internal.c.e) : okhttp3.internal.c.e;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        okhttp3.internal.c.a(d());
    }

    public static ac a(@Nullable v vVar, byte[] bArr) {
        return a(vVar, bArr.length, new okio.c().c(bArr));
    }

    public static ac a(@Nullable final v vVar, final long j, final okio.e eVar) {
        if (eVar == null) {
            throw new NullPointerException("source == null");
        }
        return new ac() { // from class: okhttp3.ac.1
            @Override // okhttp3.ac
            @Nullable
            public v a() {
                return v.this;
            }

            @Override // okhttp3.ac
            public long b() {
                return j;
            }

            @Override // okhttp3.ac
            public okio.e d() {
                return eVar;
            }
        };
    }

    /* loaded from: classes.dex */
    static final class a extends Reader {

        /* renamed from: a, reason: collision with root package name */
        private final okio.e f7050a;
        private final Charset b;
        private boolean c;

        @Nullable
        private Reader d;

        a(okio.e eVar, Charset charset) {
            this.f7050a = eVar;
            this.b = charset;
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            if (this.c) {
                throw new IOException("Stream closed");
            }
            Reader reader = this.d;
            if (reader == null) {
                InputStreamReader inputStreamReader = new InputStreamReader(this.f7050a.g(), okhttp3.internal.c.a(this.f7050a, this.b));
                this.d = inputStreamReader;
                reader = inputStreamReader;
            }
            return reader.read(cArr, i, i2);
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.c = true;
            Reader reader = this.d;
            if (reader != null) {
                reader.close();
            } else {
                this.f7050a.close();
            }
        }
    }
}
