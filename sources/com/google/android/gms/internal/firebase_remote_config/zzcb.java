package com.google.android.gms.internal.firebase_remote_config;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzcb extends ByteArrayOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private int f4144a;
    private final int b;
    private boolean c;
    private final Level d;
    private final Logger e;

    public zzcb(Logger logger, Level level, int i) {
        this.e = (Logger) zzdt.checkNotNull(logger);
        this.d = (Level) zzdt.checkNotNull(level);
        if (!(i >= 0)) {
            throw new IllegalArgumentException();
        }
        this.b = i;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        if (!(!this.c)) {
            throw new IllegalArgumentException();
        }
        this.f4144a++;
        if (this.count < this.b) {
            super.write(i);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        if (!(!this.c)) {
            throw new IllegalArgumentException();
        }
        this.f4144a += i2;
        if (this.count < this.b) {
            int i3 = this.count + i2;
            if (i3 > this.b) {
                i2 += this.b - i3;
            }
            super.write(bArr, i, i2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (!this.c) {
            if (this.f4144a != 0) {
                StringBuilder sb = new StringBuilder("Total: ");
                a(sb, this.f4144a);
                if (this.count != 0 && this.count < this.f4144a) {
                    sb.append(" (logging first ");
                    a(sb, this.count);
                    sb.append(")");
                }
                this.e.logp(Level.CONFIG, "com.google.api.client.util.LoggingByteArrayOutputStream", "close", sb.toString());
                if (this.count != 0) {
                    this.e.logp(this.d, "com.google.api.client.util.LoggingByteArrayOutputStream", "close", toString("UTF-8").replaceAll("[\\x00-\\x09\\x0B\\x0C\\x0E-\\x1F\\x7F]", " "));
                }
            }
            this.c = true;
        }
    }

    private static void a(StringBuilder sb, int i) {
        if (i == 1) {
            sb.append("1 byte");
        } else {
            sb.append(NumberFormat.getInstance().format(i));
            sb.append(" bytes");
        }
    }
}
