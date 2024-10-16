package okhttp3;

import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class aa {
    public abstract void a(okio.d dVar) throws IOException;

    @Nullable
    public abstract v b();

    public long c() throws IOException {
        return -1L;
    }

    public static aa a(@Nullable v vVar, String str) {
        Charset charset = okhttp3.internal.c.e;
        if (vVar != null && (charset = vVar.b()) == null) {
            charset = okhttp3.internal.c.e;
            vVar = v.b(vVar + "; charset=utf-8");
        }
        return a(vVar, str.getBytes(charset));
    }

    public static aa a(@Nullable final v vVar, final ByteString byteString) {
        return new aa() { // from class: okhttp3.aa.1
            @Override // okhttp3.aa
            @Nullable
            public v b() {
                return v.this;
            }

            @Override // okhttp3.aa
            public long c() throws IOException {
                return byteString.g();
            }

            @Override // okhttp3.aa
            public void a(okio.d dVar) throws IOException {
                dVar.b(byteString);
            }
        };
    }

    public static aa a(@Nullable v vVar, byte[] bArr) {
        return a(vVar, bArr, 0, bArr.length);
    }

    public static aa a(@Nullable final v vVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        okhttp3.internal.c.a(bArr.length, i, i2);
        return new aa() { // from class: okhttp3.aa.2
            @Override // okhttp3.aa
            @Nullable
            public v b() {
                return v.this;
            }

            @Override // okhttp3.aa
            public long c() {
                return i2;
            }

            @Override // okhttp3.aa
            public void a(okio.d dVar) throws IOException {
                dVar.c(bArr, i, i2);
            }
        };
    }
}
