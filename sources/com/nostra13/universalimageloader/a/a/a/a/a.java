package com.nostra13.universalimageloader.a.a.a.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    static final Pattern f5704a = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final OutputStream r = new OutputStream() { // from class: com.nostra13.universalimageloader.a.a.a.a.a.2
        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
        }
    };
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    private int i;
    private final int j;
    private Writer m;
    private int o;
    private long k = 0;
    private int l = 0;
    private final LinkedHashMap<String, b> n = new LinkedHashMap<>(0, 0.75f, true);
    private long p = 0;
    final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> q = new Callable<Void>() { // from class: com.nostra13.universalimageloader.a.a.a.a.a.1
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.m == null) {
                    return null;
                }
                a.this.k();
                a.this.l();
                if (a.this.i()) {
                    a.this.h();
                    a.this.o = 0;
                }
                return null;
            }
        }
    };

    private a(File file, int i, int i2, long j, int i3) {
        this.c = file;
        this.g = i;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.j = i2;
        this.h = j;
        this.i = i3;
    }

    public static a a(File file, int i, int i2, long j, int i3) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        a aVar = new a(file, i, i2, j, i3);
        if (aVar.d.exists()) {
            try {
                aVar.f();
                aVar.g();
                aVar.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.d, true), d.f5713a));
                return aVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aVar.d();
            }
        }
        file.mkdirs();
        a aVar2 = new a(file, i, i2, j, i3);
        aVar2.h();
        return aVar2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void f() throws IOException {
        com.nostra13.universalimageloader.a.a.a.a.c cVar = new com.nostra13.universalimageloader.a.a.a.a.c(new FileInputStream(this.d), d.f5713a);
        try {
            String a2 = cVar.a();
            String a3 = cVar.a();
            String a4 = cVar.a();
            String a5 = cVar.a();
            String a6 = cVar.a();
            if (!"libcore.io.DiskLruCache".equals(a2) || !"1".equals(a3) || !Integer.toString(this.g).equals(a4) || !Integer.toString(this.j).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    d(cVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.o = i - this.n.size();
                    d.a(cVar);
                    return;
                }
            }
        } catch (Throwable th) {
            d.a(cVar);
            throw th;
        }
    }

    private void d(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.n.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        b bVar = this.n.get(substring);
        if (bVar == null) {
            bVar = new b(substring);
            this.n.put(substring, bVar);
        }
        if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            bVar.d = true;
            bVar.e = null;
            bVar.a(split);
            return;
        }
        if (indexOf2 != -1 || indexOf != 5 || !str.startsWith("DIRTY")) {
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        bVar.e = new C0141a(bVar);
    }

    private void g() throws IOException {
        a(this.e);
        Iterator<b> it = this.n.values().iterator();
        while (it.hasNext()) {
            b next = it.next();
            int i = 0;
            if (next.e == null) {
                while (i < this.j) {
                    this.k += next.c[i];
                    this.l++;
                    i++;
                }
            } else {
                next.e = null;
                while (i < this.j) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void h() throws IOException {
        if (this.m != null) {
            this.m.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), d.f5713a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.j));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (b bVar : this.n.values()) {
                if (bVar.e != null) {
                    bufferedWriter.write("DIRTY " + bVar.b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + bVar.b + bVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.m = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), d.f5713a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized c a(String str) throws IOException {
        j();
        e(str);
        b bVar = this.n.get(str);
        if (bVar == null) {
            return null;
        }
        if (!bVar.d) {
            return null;
        }
        File[] fileArr = new File[this.j];
        InputStream[] inputStreamArr = new InputStream[this.j];
        for (int i = 0; i < this.j; i++) {
            try {
                File a2 = bVar.a(i);
                fileArr[i] = a2;
                inputStreamArr[i] = new FileInputStream(a2);
            } catch (FileNotFoundException unused) {
                for (int i2 = 0; i2 < this.j && inputStreamArr[i2] != null; i2++) {
                    d.a(inputStreamArr[i2]);
                }
                return null;
            }
        }
        this.o++;
        this.m.append((CharSequence) ("READ " + str + '\n'));
        if (i()) {
            this.b.submit(this.q);
        }
        return new c(str, bVar.f, fileArr, inputStreamArr, bVar.c);
    }

    public C0141a b(String str) throws IOException {
        return a(str, -1L);
    }

    private synchronized C0141a a(String str, long j) throws IOException {
        j();
        e(str);
        b bVar = this.n.get(str);
        if (j != -1 && (bVar == null || bVar.f != j)) {
            return null;
        }
        if (bVar == null) {
            bVar = new b(str);
            this.n.put(str, bVar);
        } else if (bVar.e != null) {
            return null;
        }
        C0141a c0141a = new C0141a(bVar);
        bVar.e = c0141a;
        this.m.write("DIRTY " + str + '\n');
        this.m.flush();
        return c0141a;
    }

    public File a() {
        return this.c;
    }

    public synchronized long b() {
        return this.h;
    }

    public synchronized int c() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void a(C0141a c0141a, boolean z) throws IOException {
        b bVar = c0141a.b;
        if (bVar.e != c0141a) {
            throw new IllegalStateException();
        }
        if (z && !bVar.d) {
            for (int i = 0; i < this.j; i++) {
                if (!c0141a.c[i]) {
                    c0141a.b();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                }
                if (!bVar.b(i).exists()) {
                    c0141a.b();
                    return;
                }
            }
        }
        for (int i2 = 0; i2 < this.j; i2++) {
            File b2 = bVar.b(i2);
            if (z) {
                if (b2.exists()) {
                    File a2 = bVar.a(i2);
                    b2.renameTo(a2);
                    long j = bVar.c[i2];
                    long length = a2.length();
                    bVar.c[i2] = length;
                    this.k = (this.k - j) + length;
                    this.l++;
                }
            } else {
                a(b2);
            }
        }
        this.o++;
        bVar.e = null;
        if (bVar.d | z) {
            bVar.d = true;
            this.m.write("CLEAN " + bVar.b + bVar.a() + '\n');
            if (z) {
                long j2 = this.p;
                this.p = 1 + j2;
                bVar.f = j2;
            }
        } else {
            this.n.remove(bVar.b);
            this.m.write("REMOVE " + bVar.b + '\n');
        }
        this.m.flush();
        if (this.k > this.h || this.l > this.i || i()) {
            this.b.submit(this.q);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        int i = this.o;
        return i >= 2000 && i >= this.n.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean c(String str) throws IOException {
        j();
        e(str);
        b bVar = this.n.get(str);
        if (bVar != null && bVar.e == null) {
            for (int i = 0; i < this.j; i++) {
                File a2 = bVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.k -= bVar.c[i];
                this.l--;
                bVar.c[i] = 0;
            }
            this.o++;
            this.m.append((CharSequence) ("REMOVE " + str + '\n'));
            this.n.remove(str);
            if (i()) {
                this.b.submit(this.q);
            }
            return true;
        }
        return false;
    }

    private void j() {
        if (this.m == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.m == null) {
            return;
        }
        Iterator it = new ArrayList(this.n.values()).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.e != null) {
                bVar.e.b();
            }
        }
        k();
        l();
        this.m.close();
        this.m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() throws IOException {
        while (this.k > this.h) {
            c(this.n.entrySet().iterator().next().getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() throws IOException {
        while (this.l > this.i) {
            c(this.n.entrySet().iterator().next().getKey());
        }
    }

    public void d() throws IOException {
        close();
        d.a(this.c);
    }

    private void e(String str) {
        if (f5704a.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
    }

    /* loaded from: classes2.dex */
    public final class c implements Closeable {
        private final String b;
        private final long c;
        private File[] d;
        private final InputStream[] e;
        private final long[] f;

        private c(String str, long j, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = fileArr;
            this.e = inputStreamArr;
            this.f = jArr;
        }

        public File a(int i) {
            return this.d[i];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (InputStream inputStream : this.e) {
                d.a(inputStream);
            }
        }
    }

    /* renamed from: com.nostra13.universalimageloader.a.a.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0141a {
        private final b b;
        private final boolean[] c;
        private boolean d;
        private boolean e;

        private C0141a(b bVar) {
            this.b = bVar;
            this.c = bVar.d ? null : new boolean[a.this.j];
        }

        public OutputStream a(int i) throws IOException {
            FileOutputStream fileOutputStream;
            C0142a c0142a;
            synchronized (a.this) {
                if (this.b.e != this) {
                    throw new IllegalStateException();
                }
                if (!this.b.d) {
                    this.c[i] = true;
                }
                File b = this.b.b(i);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException unused) {
                    a.this.c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException unused2) {
                        return a.r;
                    }
                }
                c0142a = new C0142a(fileOutputStream);
            }
            return c0142a;
        }

        public void a() throws IOException {
            if (this.d) {
                a.this.a(this, false);
                a.this.c(this.b.b);
            } else {
                a.this.a(this, true);
            }
            this.e = true;
        }

        public void b() throws IOException {
            a.this.a(this, false);
        }

        /* renamed from: com.nostra13.universalimageloader.a.a.a.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        private class C0142a extends FilterOutputStream {
            private C0142a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    C0141a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    C0141a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    C0141a.this.d = true;
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    C0141a.this.d = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class b {
        private final String b;
        private final long[] c;
        private boolean d;
        private C0141a e;
        private long f;

        private b(String str) {
            this.b = str;
            this.c = new long[a.this.j];
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.c) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void a(String[] strArr) throws IOException {
            if (strArr.length != a.this.j) {
                throw b(strArr);
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.c[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    throw b(strArr);
                }
            }
        }

        private IOException b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return new File(a.this.c, this.b + "." + i);
        }

        public File b(int i) {
            return new File(a.this.c, this.b + "." + i + ".tmp");
        }
    }
}
