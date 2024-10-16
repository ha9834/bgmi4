package okhttp3.internal.http2;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;

/* loaded from: classes3.dex */
final class h implements Closeable {
    private static final Logger b = Logger.getLogger(c.class.getName());
    private final okio.d c;
    private final boolean d;
    private boolean g;
    private final okio.c e = new okio.c();

    /* renamed from: a, reason: collision with root package name */
    final b.C0232b f7134a = new b.C0232b(this.e);
    private int f = 16384;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(okio.d dVar, boolean z) {
        this.c = dVar;
        this.d = z;
    }

    public synchronized void a() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (this.d) {
            if (b.isLoggable(Level.FINE)) {
                b.fine(okhttp3.internal.c.a(">> CONNECTION %s", c.f7110a.e()));
            }
            this.c.c(c.f7110a.h());
            this.c.flush();
        }
    }

    public synchronized void a(k kVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f = kVar.d(this.f);
        if (kVar.c() != -1) {
            this.f7134a.a(kVar.c());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.c.flush();
    }

    public synchronized void a(int i, int i2, List<a> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f7134a.a(list);
        long b2 = this.e.b();
        int min = (int) Math.min(this.f - 4, b2);
        long j = min;
        a(i, min + 4, (byte) 5, b2 == j ? (byte) 4 : (byte) 0);
        this.c.g(i2 & Integer.MAX_VALUE);
        this.c.a_(this.e, j);
        if (b2 > j) {
            b(i, b2 - j);
        }
    }

    public synchronized void b() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.c.flush();
    }

    public synchronized void a(boolean z, int i, int i2, List<a> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        a(z, i, list);
    }

    public synchronized void a(int i, ErrorCode errorCode) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        }
        a(i, 4, (byte) 3, (byte) 0);
        this.c.g(errorCode.httpCode);
        this.c.flush();
    }

    public int c() {
        return this.f;
    }

    public synchronized void a(boolean z, int i, okio.c cVar, int i2) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        a(i, z ? (byte) 1 : (byte) 0, cVar, i2);
    }

    void a(int i, byte b2, okio.c cVar, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.c.a_(cVar, i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void b(k kVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, kVar.b() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (kVar.a(i)) {
                this.c.h(i == 4 ? 3 : i == 7 ? 4 : i);
                this.c.g(kVar.b(i));
            }
            i++;
        }
        this.c.flush();
    }

    public synchronized void a(boolean z, int i, int i2) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.c.g(i);
        this.c.g(i2);
        this.c.flush();
    }

    public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (errorCode.httpCode == -1) {
            throw c.a("errorCode.httpCode == -1", new Object[0]);
        }
        a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.c.g(i);
        this.c.g(errorCode.httpCode);
        if (bArr.length > 0) {
            this.c.c(bArr);
        }
        this.c.flush();
    }

    public synchronized void a(int i, long j) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
        a(i, 4, (byte) 8, (byte) 0);
        this.c.g((int) j);
        this.c.flush();
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (b.isLoggable(Level.FINE)) {
            b.fine(c.a(false, i, i2, b2, b3));
        }
        int i3 = this.f;
        if (i2 > i3) {
            throw c.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw c.a("reserved bit set: %s", Integer.valueOf(i));
        }
        a(this.c, i2);
        this.c.i(b2 & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        this.c.i(b3 & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        this.c.g(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.g = true;
        this.c.close();
    }

    private static void a(okio.d dVar, int i) throws IOException {
        dVar.i((i >>> 16) & 255);
        dVar.i((i >>> 8) & 255);
        dVar.i(i & 255);
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f, j);
            long j2 = min;
            j -= j2;
            a(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.c.a_(this.e, j2);
        }
    }

    void a(boolean z, int i, List<a> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.f7134a.a(list);
        long b2 = this.e.b();
        int min = (int) Math.min(this.f, b2);
        long j = min;
        byte b3 = b2 == j ? (byte) 4 : (byte) 0;
        if (z) {
            b3 = (byte) (b3 | 1);
        }
        a(i, min, (byte) 1, b3);
        this.c.a_(this.e, j);
        if (b2 > j) {
            b(i, b2 - j);
        }
    }
}
