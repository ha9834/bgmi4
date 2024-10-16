package okio;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l implements d {

    /* renamed from: a, reason: collision with root package name */
    public final c f7187a = new c();
    public final p b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(p pVar) {
        if (pVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = pVar;
    }

    @Override // okio.d, okio.e
    public c c() {
        return this.f7187a;
    }

    @Override // okio.p
    public void a_(c cVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.a_(cVar, j);
        w();
    }

    @Override // okio.d
    public d b(ByteString byteString) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.b(byteString);
        return w();
    }

    @Override // okio.d
    public d b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.b(str);
        return w();
    }

    @Override // okio.d
    public d c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.c(bArr);
        return w();
    }

    @Override // okio.d
    public d c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.c(bArr, i, i2);
        return w();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int write = this.f7187a.write(byteBuffer);
        w();
        return write;
    }

    @Override // okio.d
    public d i(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.i(i);
        return w();
    }

    @Override // okio.d
    public d h(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.h(i);
        return w();
    }

    @Override // okio.d
    public d g(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.g(i);
        return w();
    }

    @Override // okio.d
    public d m(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.m(j);
        return w();
    }

    @Override // okio.d
    public d l(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f7187a.l(j);
        return w();
    }

    @Override // okio.d
    public d w() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long h = this.f7187a.h();
        if (h > 0) {
            this.b.a_(this.f7187a, h);
        }
        return this;
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.f7187a.b > 0) {
            p pVar = this.b;
            c cVar = this.f7187a;
            pVar.a_(cVar, cVar.b);
        }
        this.b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.p
    public void close() throws IOException {
        if (this.c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f7187a.b > 0) {
                this.b.a_(this.f7187a, this.f7187a.b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            s.a(th);
        }
    }

    @Override // okio.p
    public r a() {
        return this.b.a();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
