package com.nostra13.universalimageloader.a.a.a;

import android.graphics.Bitmap;
import com.google.android.gms.nearby.connection.Connections;
import com.nostra13.universalimageloader.b.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class a implements com.nostra13.universalimageloader.a.a.a {

    /* renamed from: a, reason: collision with root package name */
    public static final Bitmap.CompressFormat f5703a = Bitmap.CompressFormat.PNG;
    protected final File b;
    protected final File c;
    protected final com.nostra13.universalimageloader.a.a.b.a d;
    protected int e;
    protected Bitmap.CompressFormat f;
    protected int g;

    public a(File file) {
        this(file, null);
    }

    public a(File file, File file2) {
        this(file, file2, com.nostra13.universalimageloader.core.a.b());
    }

    public a(File file, File file2, com.nostra13.universalimageloader.a.a.b.a aVar) {
        this.e = Connections.MAX_BYTES_DATA_SIZE;
        this.f = f5703a;
        this.g = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        this.b = file;
        this.c = file2;
        this.d = aVar;
    }

    @Override // com.nostra13.universalimageloader.a.a.a
    public File a(String str) {
        return b(str);
    }

    @Override // com.nostra13.universalimageloader.a.a.a
    public boolean a(String str, InputStream inputStream, b.a aVar) throws IOException {
        boolean z;
        File b = b(str);
        File file = new File(b.getAbsolutePath() + ".tmp");
        try {
            try {
                z = com.nostra13.universalimageloader.b.b.a(inputStream, new BufferedOutputStream(new FileOutputStream(file), this.e), aVar, this.e);
                try {
                    if (z && !file.renameTo(b)) {
                        z = false;
                    }
                    if (!z) {
                        file.delete();
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    if (z && !file.renameTo(b)) {
                        z = false;
                    }
                    if (!z) {
                        file.delete();
                    }
                    throw th;
                }
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    @Override // com.nostra13.universalimageloader.a.a.a
    public boolean a(String str, Bitmap bitmap) throws IOException {
        File b = b(str);
        File file = new File(b.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.e);
        try {
            boolean compress = bitmap.compress(this.f, this.g, bufferedOutputStream);
            com.nostra13.universalimageloader.b.b.a(bufferedOutputStream);
            if (compress && !file.renameTo(b)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            com.nostra13.universalimageloader.b.b.a(bufferedOutputStream);
            file.delete();
            throw th;
        }
    }

    @Override // com.nostra13.universalimageloader.a.a.a
    public void a() {
        File[] listFiles = this.b.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    protected File b(String str) {
        File file;
        String a2 = this.d.a(str);
        File file2 = this.b;
        if (!file2.exists() && !this.b.mkdirs() && (file = this.c) != null && (file.exists() || this.c.mkdirs())) {
            file2 = this.c;
        }
        return new File(file2, a2);
    }
}
