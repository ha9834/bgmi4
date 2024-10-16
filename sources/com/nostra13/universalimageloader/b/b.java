package com.nostra13.universalimageloader.b;

import com.google.android.gms.nearby.connection.Connections;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class b {

    /* loaded from: classes2.dex */
    public interface a {
        boolean a(int i, int i2);
    }

    public static boolean a(InputStream inputStream, OutputStream outputStream, a aVar, int i) throws IOException {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i];
        if (a(aVar, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i2 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!a(aVar, i2, available));
        return false;
    }

    private static boolean a(a aVar, int i, int i2) {
        return (aVar == null || aVar.a(i, i2) || (i * 100) / i2 >= 75) ? false : true;
    }

    public static void a(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th) {
                a((Closeable) inputStream);
                throw th;
            }
        } while (inputStream.read(new byte[Connections.MAX_BYTES_DATA_SIZE], 0, Connections.MAX_BYTES_DATA_SIZE) != -1);
        a((Closeable) inputStream);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
