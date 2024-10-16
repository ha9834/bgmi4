package com.shieldtunnel.svpn.common.g;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements com.shieldtunnel.svpn.common.g.b {

        /* renamed from: a, reason: collision with root package name */
        private final File f5829a;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class a implements Iterable<com.shieldtunnel.svpn.common.g.b> {

            /* renamed from: a, reason: collision with root package name */
            private final File[] f5830a;

            /* renamed from: com.shieldtunnel.svpn.common.g.c$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            private class C0152a implements Iterator<com.shieldtunnel.svpn.common.g.b> {

                /* renamed from: a, reason: collision with root package name */
                private int f5831a;

                private C0152a() {
                }

                @Override // java.util.Iterator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public com.shieldtunnel.svpn.common.g.b next() {
                    File[] fileArr = a.this.f5830a;
                    int i = this.f5831a;
                    this.f5831a = i + 1;
                    return new b(fileArr[i]);
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.f5831a < a.this.f5830a.length;
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            a(File[] fileArr) {
                this.f5830a = fileArr;
            }

            @Override // java.lang.Iterable
            public Iterator<com.shieldtunnel.svpn.common.g.b> iterator() {
                return new C0152a();
            }
        }

        b(File file) {
            this.f5829a = file;
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public String a() {
            return this.f5829a.getName();
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public boolean b() {
            return this.f5829a.delete();
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public boolean c() {
            return this.f5829a.isFile();
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public boolean d() {
            return this.f5829a.exists();
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public InputStream e() {
            return new FileInputStream(this.f5829a);
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public Iterable<com.shieldtunnel.svpn.common.g.b> f() {
            File[] listFiles = this.f5829a.listFiles();
            if (listFiles == null) {
                return null;
            }
            return new a(listFiles);
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public OutputStream a(boolean z) {
            return new FileOutputStream(this.f5829a, z);
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public com.shieldtunnel.svpn.common.g.b a(String str) {
            if (!this.f5829a.exists() || !this.f5829a.isDirectory()) {
                this.f5829a.mkdirs();
            }
            return new b(new File(this.f5829a, str));
        }

        @Override // com.shieldtunnel.svpn.common.g.b
        public byte[] a(int i) {
            int length = (int) this.f5829a.length();
            if (i > 0 && length > i) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(this.f5829a);
            try {
                byte[] bArr = new byte[length];
                return fileInputStream.read(bArr) == length ? bArr : null;
            } finally {
                com.shieldtunnel.svpn.common.c.a((Closeable) fileInputStream);
            }
        }
    }

    public static com.shieldtunnel.svpn.common.g.b a(File file) {
        return new b(file);
    }
}
