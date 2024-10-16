package com.nostra13.universalimageloader.a.a.a.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f5713a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
