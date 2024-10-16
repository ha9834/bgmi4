package com.nostra13.universalimageloader.a.a.a.a;

import android.graphics.Bitmap;
import com.google.android.gms.nearby.connection.Connections;
import com.nostra13.universalimageloader.a.a.a.a.a;
import com.nostra13.universalimageloader.b.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class b implements com.nostra13.universalimageloader.a.a.a {

    /* renamed from: a, reason: collision with root package name */
    public static final Bitmap.CompressFormat f5710a = Bitmap.CompressFormat.PNG;
    protected a b;
    protected final com.nostra13.universalimageloader.a.a.b.a c;
    protected int d = Connections.MAX_BYTES_DATA_SIZE;
    protected Bitmap.CompressFormat e = f5710a;
    protected int f = 100;
    private File g;

    public b(File file, File file2, com.nostra13.universalimageloader.a.a.b.a aVar, long j, int i) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j2 = j == 0 ? Long.MAX_VALUE : j;
        int i2 = i == 0 ? Integer.MAX_VALUE : i;
        this.g = file2;
        this.c = aVar;
        a(file, file2, j2, i2);
    }

    private void a(File file, File file2, long j, int i) throws IOException {
        try {
            this.b = a.a(file, 1, 1, j, i);
        } catch (IOException e) {
            com.nostra13.universalimageloader.b.c.a(e);
            if (file2 != null) {
                a(file2, null, j, i);
            }
            if (this.b == null) {
                throw e;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e  */
    @Override // com.nostra13.universalimageloader.a.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File a(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            com.nostra13.universalimageloader.a.a.a.a.a r1 = r3.b     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1d
            java.lang.String r4 = r3.b(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1d
            com.nostra13.universalimageloader.a.a.a.a.a$c r4 = r1.a(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L1d
            if (r4 != 0) goto Le
            goto L13
        Le:
            r1 = 0
            java.io.File r0 = r4.a(r1)     // Catch: java.io.IOException -> L19 java.lang.Throwable -> L28
        L13:
            if (r4 == 0) goto L18
            r4.close()
        L18:
            return r0
        L19:
            r1 = move-exception
            goto L1f
        L1b:
            r4 = move-exception
            goto L2c
        L1d:
            r1 = move-exception
            r4 = r0
        L1f:
            com.nostra13.universalimageloader.b.c.a(r1)     // Catch: java.lang.Throwable -> L28
            if (r4 == 0) goto L27
            r4.close()
        L27:
            return r0
        L28:
            r0 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
        L2c:
            if (r0 == 0) goto L31
            r0.close()
        L31:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.a.a.a.a.b.a(java.lang.String):java.io.File");
    }

    @Override // com.nostra13.universalimageloader.a.a.a
    public boolean a(String str, InputStream inputStream, b.a aVar) throws IOException {
        a.C0141a b = this.b.b(b(str));
        if (b == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b.a(0), this.d);
        try {
            boolean a2 = com.nostra13.universalimageloader.b.b.a(inputStream, bufferedOutputStream, aVar, this.d);
            com.nostra13.universalimageloader.b.b.a(bufferedOutputStream);
            if (a2) {
                b.a();
            } else {
                b.b();
            }
            return a2;
        } catch (Throwable th) {
            com.nostra13.universalimageloader.b.b.a(bufferedOutputStream);
            b.b();
            throw th;
        }
    }

    @Override // com.nostra13.universalimageloader.a.a.a
    public boolean a(String str, Bitmap bitmap) throws IOException {
        a.C0141a b = this.b.b(b(str));
        if (b == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b.a(0), this.d);
        try {
            boolean compress = bitmap.compress(this.e, this.f, bufferedOutputStream);
            if (compress) {
                b.a();
            } else {
                b.b();
            }
            return compress;
        } finally {
            com.nostra13.universalimageloader.b.b.a(bufferedOutputStream);
        }
    }

    @Override // com.nostra13.universalimageloader.a.a.a
    public void a() {
        try {
            this.b.d();
        } catch (IOException e) {
            com.nostra13.universalimageloader.b.c.a(e);
        }
        try {
            a(this.b.a(), this.g, this.b.b(), this.b.c());
        } catch (IOException e2) {
            com.nostra13.universalimageloader.b.c.a(e2);
        }
    }

    private String b(String str) {
        return this.c.a(str);
    }
}
