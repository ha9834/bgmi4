package okhttp3.internal.http2;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.b;
import okio.ByteString;
import okio.q;
import okio.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class f implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f7128a = Logger.getLogger(c.class.getName());
    final b.a b;
    private final okio.e c;
    private final a d;
    private final boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void a(int i, int i2, int i3, boolean z);

        void a(int i, int i2, List<okhttp3.internal.http2.a> list) throws IOException;

        void a(int i, long j);

        void a(int i, ErrorCode errorCode);

        void a(int i, ErrorCode errorCode, ByteString byteString);

        void a(boolean z, int i, int i2);

        void a(boolean z, int i, int i2, List<okhttp3.internal.http2.a> list);

        void a(boolean z, int i, okio.e eVar, int i2) throws IOException;

        void a(boolean z, k kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(okio.e eVar, boolean z) {
        this.c = eVar;
        this.e = z;
        this.d = new a(this.c);
        this.b = new b.a(4096, this.d);
    }

    public void a(b bVar) throws IOException {
        if (this.e) {
            if (!a(true, bVar)) {
                throw c.b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString d = this.c.d(c.f7110a.g());
        if (f7128a.isLoggable(Level.FINE)) {
            f7128a.fine(okhttp3.internal.c.a("<< CONNECTION %s", d.e()));
        }
        if (!c.f7110a.equals(d)) {
            throw c.b("Expected a connection header but was %s", d.a());
        }
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.c.a(9L);
            int a2 = a(this.c);
            if (a2 < 0 || a2 > 16384) {
                throw c.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
            }
            byte i = (byte) (this.c.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (z && i != 4) {
                throw c.b("Expected a SETTINGS frame but was %s", Byte.valueOf(i));
            }
            byte i2 = (byte) (this.c.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            int k = this.c.k() & Integer.MAX_VALUE;
            if (f7128a.isLoggable(Level.FINE)) {
                f7128a.fine(c.a(true, k, a2, i, i2));
            }
            switch (i) {
                case 0:
                    b(bVar, a2, i2, k);
                    return true;
                case 1:
                    a(bVar, a2, i2, k);
                    return true;
                case 2:
                    c(bVar, a2, i2, k);
                    return true;
                case 3:
                    d(bVar, a2, i2, k);
                    return true;
                case 4:
                    e(bVar, a2, i2, k);
                    return true;
                case 5:
                    f(bVar, a2, i2, k);
                    return true;
                case 6:
                    g(bVar, a2, i2, k);
                    return true;
                case 7:
                    h(bVar, a2, i2, k);
                    return true;
                case 8:
                    i(bVar, a2, i2, k);
                    return true;
                default:
                    this.c.i(a2);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    private void a(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw c.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        short i3 = (b2 & 8) != 0 ? (short) (this.c.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i2);
            i -= 5;
        }
        bVar.a(z, i2, -1, a(a(i, b2, i3), i3, b2, i2));
    }

    private List<okhttp3.internal.http2.a> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.d;
        aVar.d = i;
        aVar.f7129a = i;
        aVar.e = s;
        aVar.b = b2;
        aVar.c = i2;
        this.b.a();
        return this.b.b();
    }

    private void b(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw c.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            throw c.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short i3 = (b2 & 8) != 0 ? (short) (this.c.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) : (short) 0;
        bVar.a(z, i2, this.c, a(i, b2, i3));
        this.c.i(i3);
    }

    private void c(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            throw c.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw c.b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        a(bVar, i2);
    }

    private void a(b bVar, int i) throws IOException {
        int k = this.c.k();
        bVar.a(i, k & Integer.MAX_VALUE, (this.c.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + 1, (Integer.MIN_VALUE & k) != 0);
    }

    private void d(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw c.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw c.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int k = this.c.k();
        ErrorCode a2 = ErrorCode.a(k);
        if (a2 == null) {
            throw c.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(k));
        }
        bVar.a(i2, a2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void e(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            throw c.b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b2 & 1) != 0) {
            if (i != 0) {
                throw c.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            bVar.a();
            return;
        }
        if (i % 6 != 0) {
            throw c.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        k kVar = new k();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int j = this.c.j() & ISelectionInterface.HELD_NOTHING;
            int k = this.c.k();
            switch (j) {
                case 2:
                    if (k != 0 && k != 1) {
                        throw c.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;
                case 3:
                    j = 4;
                    break;
                case 4:
                    j = 7;
                    if (k < 0) {
                        throw c.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    break;
                case 5:
                    if (k < 16384 || k > 16777215) {
                        throw c.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(k));
                    }
                    break;
                    break;
            }
            kVar.a(j, k);
        }
        bVar.a(false, kVar);
    }

    private void f(b bVar, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            throw c.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short i3 = (b2 & 8) != 0 ? (short) (this.c.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) : (short) 0;
        bVar.a(i2, this.c.k() & Integer.MAX_VALUE, a(a(i - 4, b2, i3), i3, b2, i2));
    }

    private void g(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            throw c.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw c.b("TYPE_PING streamId != 0", new Object[0]);
        }
        bVar.a((b2 & 1) != 0, this.c.k(), this.c.k());
    }

    private void h(b bVar, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            throw c.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw c.b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int k = this.c.k();
        int k2 = this.c.k();
        int i3 = i - 8;
        ErrorCode a2 = ErrorCode.a(k2);
        if (a2 == null) {
            throw c.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(k2));
        }
        ByteString byteString = ByteString.b;
        if (i3 > 0) {
            byteString = this.c.d(i3);
        }
        bVar.a(k, a2, byteString);
    }

    private void i(b bVar, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            throw c.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long k = this.c.k() & 2147483647L;
        if (k == 0) {
            throw c.b("windowSizeIncrement was 0", Long.valueOf(k));
        }
        bVar.a(i2, k);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a implements q {

        /* renamed from: a, reason: collision with root package name */
        int f7129a;
        byte b;
        int c;
        int d;
        short e;
        private final okio.e f;

        @Override // okio.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        a(okio.e eVar) {
            this.f = eVar;
        }

        @Override // okio.q
        public long a(okio.c cVar, long j) throws IOException {
            while (true) {
                int i = this.d;
                if (i == 0) {
                    this.f.i(this.e);
                    this.e = (short) 0;
                    if ((this.b & 4) != 0) {
                        return -1L;
                    }
                    b();
                } else {
                    long a2 = this.f.a(cVar, Math.min(j, i));
                    if (a2 == -1) {
                        return -1L;
                    }
                    this.d = (int) (this.d - a2);
                    return a2;
                }
            }
        }

        @Override // okio.q
        public r a() {
            return this.f.a();
        }

        private void b() throws IOException {
            int i = this.c;
            int a2 = f.a(this.f);
            this.d = a2;
            this.f7129a = a2;
            byte i2 = (byte) (this.f.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            this.b = (byte) (this.f.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
            if (f.f7128a.isLoggable(Level.FINE)) {
                f.f7128a.fine(c.a(true, this.c, this.f7129a, i2, this.b));
            }
            this.c = this.f.k() & Integer.MAX_VALUE;
            if (i2 != 9) {
                throw c.b("%s != TYPE_CONTINUATION", Byte.valueOf(i2));
            }
            if (this.c != i) {
                throw c.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    static int a(okio.e eVar) throws IOException {
        return (eVar.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) | ((eVar.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 16) | ((eVar.i() & DeviceInfos.NETWORK_TYPE_UNCONNECTED) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw c.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }
}
