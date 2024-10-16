package com.subao.common.n;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes2.dex */
public class d {

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6134a = new a() { // from class: com.subao.common.n.d.a.1
            @Override // com.subao.common.n.d.a
            public File a(String str) {
                return new File(str);
            }

            @Override // com.subao.common.n.d.a
            public Reader b(String str) {
                return new FileReader(str);
            }

            @Override // com.subao.common.n.d.a
            public InputStream c(String str) {
                return new FileInputStream(str);
            }
        };

        File a(String str);

        Reader b(String str);

        InputStream c(String str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(File file, int i) {
        FileInputStream fileInputStream;
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        int length = (int) file.length();
        if (length > i) {
            throw new IOException("File is too large.");
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                com.subao.common.d.a aVar = new com.subao.common.d.a(length);
                do {
                } while (aVar.a(fileInputStream, length) > 0);
                byte[] a2 = aVar.a();
                com.subao.common.e.a((Closeable) fileInputStream);
                return a2;
            } catch (Throwable th) {
                th = th;
                com.subao.common.e.a((Closeable) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }
}
