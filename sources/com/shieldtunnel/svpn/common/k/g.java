package com.shieldtunnel.svpn.common.k;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class g {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] a(ZipInputStream zipInputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(i);
            try {
                int min = Math.min(i, 65536);
                byte[] bArr = new byte[min];
                while (true) {
                    int read = zipInputStream.read(bArr, 0, min);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.shieldtunnel.svpn.common.c.a(byteArrayOutputStream);
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.shieldtunnel.svpn.common.c.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2 = null;
        zipInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                zipInputStream = new ZipInputStream(byteArrayInputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayInputStream = null;
        }
        try {
            byte[] a2 = zipInputStream.getNextEntry() != null ? a(zipInputStream, bArr.length) : null;
            com.shieldtunnel.svpn.common.c.a((Closeable) zipInputStream);
            com.shieldtunnel.svpn.common.c.a((Closeable) byteArrayInputStream);
            return a2;
        } catch (Throwable th3) {
            th = th3;
            zipInputStream2 = zipInputStream;
            com.shieldtunnel.svpn.common.c.a((Closeable) zipInputStream2);
            com.shieldtunnel.svpn.common.c.a((Closeable) byteArrayInputStream);
            throw th;
        }
    }
}
