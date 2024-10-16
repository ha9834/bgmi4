package com.shieldtunnel.svpn.common.f;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class e {
    private boolean a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byteArrayOutputStream.close();
        if (byteArrayOutputStream.size() <= 0) {
            return false;
        }
        a(byteArrayOutputStream.toByteArray());
        return true;
    }

    protected abstract String a();

    protected abstract void a(byte[] bArr);

    public boolean b(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = a(context);
            boolean a2 = a(inputStream);
            com.shieldtunnel.svpn.common.c.a((Closeable) inputStream);
            return a2;
        } catch (IOException | RuntimeException unused) {
            com.shieldtunnel.svpn.common.c.a((Closeable) inputStream);
            return false;
        } catch (Throwable th) {
            com.shieldtunnel.svpn.common.c.a((Closeable) inputStream);
            throw th;
        }
    }

    private Uri b() {
        return Uri.parse(String.format("%s://%s/%s", FirebaseAnalytics.Param.CONTENT, "xy.svpn.settings", a()));
    }

    private InputStream a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            InputStream openInputStream = contentResolver.openInputStream(b());
            if (openInputStream != null) {
                return openInputStream;
            }
            throw new IOException("Open input stream from ContentResolver failed.");
        }
        throw new IOException("Get ContentResolver failed.");
    }
}
