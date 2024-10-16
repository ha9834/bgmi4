package com.subao.common.n;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class j {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] a(ZipInputStream zipInputStream, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(i);
            try {
                byte[] bArr = new byte[Math.min(i, 65536)];
                while (true) {
                    int read = zipInputStream.read(bArr, 0, bArr.length);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.subao.common.e.a(byteArrayOutputStream);
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                th = th;
                com.subao.common.e.a(byteArrayOutputStream);
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
            com.subao.common.e.a((Closeable) zipInputStream);
            com.subao.common.e.a((Closeable) byteArrayInputStream);
            return a2;
        } catch (Throwable th3) {
            th = th3;
            zipInputStream2 = zipInputStream;
            com.subao.common.e.a((Closeable) zipInputStream2);
            com.subao.common.e.a((Closeable) byteArrayInputStream);
            throw th;
        }
    }
}
