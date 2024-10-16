package com.subao.common.f;

import com.subao.common.e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class d {
    public static c a(File file) {
        return new a(file);
    }

    /* loaded from: classes2.dex */
    private static class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final File f6020a;

        a(File file) {
            this.f6020a = file;
        }

        @Override // com.subao.common.f.c
        public String f() {
            return this.f6020a.getAbsolutePath();
        }

        @Override // com.subao.common.f.c
        public boolean a() {
            return this.f6020a.exists();
        }

        @Override // com.subao.common.f.c
        public InputStream b() {
            return new FileInputStream(this.f6020a);
        }

        @Override // com.subao.common.f.c
        public OutputStream c() {
            return new FileOutputStream(this.f6020a);
        }

        @Override // com.subao.common.f.c
        public boolean d() {
            return this.f6020a.delete();
        }

        @Override // com.subao.common.f.c
        public c a(String str) {
            if (!this.f6020a.exists() || !this.f6020a.isDirectory()) {
                this.f6020a.mkdirs();
            }
            return new a(new File(this.f6020a, str));
        }

        @Override // com.subao.common.f.c
        public byte[] e() {
            return a(0);
        }

        @Override // com.subao.common.f.c
        public byte[] a(int i) {
            int length = (int) this.f6020a.length();
            if (i > 0 && length > i) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(this.f6020a);
            try {
                byte[] bArr = new byte[length];
                return fileInputStream.read(bArr) == length ? bArr : null;
            } finally {
                e.a((Closeable) fileInputStream);
            }
        }
    }
}
