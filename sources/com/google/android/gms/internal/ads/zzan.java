package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class zzan implements zzb {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, cz> f2760a;
    private long b;
    private final File c;
    private final int d;

    public zzan(File file, int i) {
        this.f2760a = new LinkedHashMap(16, 0.75f, true);
        this.b = 0L;
        this.c = file;
        this.d = i;
    }

    public zzan(File file) {
        this(file, 5242880);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized zzc zza(String str) {
        cz czVar = this.f2760a.get(str);
        if (czVar == null) {
            return null;
        }
        File c = c(str);
        try {
            dh dhVar = new dh(new BufferedInputStream(a(c)), c.length());
            try {
                cz a2 = cz.a(dhVar);
                if (!TextUtils.equals(str, a2.b)) {
                    zzag.d("%s: key=%s, found=%s", c.getAbsolutePath(), str, a2.b);
                    d(str);
                    return null;
                }
                byte[] a3 = a(dhVar, dhVar.a());
                zzc zzcVar = new zzc();
                zzcVar.data = a3;
                zzcVar.zza = czVar.c;
                zzcVar.zzb = czVar.d;
                zzcVar.zzc = czVar.e;
                zzcVar.zzd = czVar.f;
                zzcVar.zze = czVar.g;
                List<zzl> list = czVar.h;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzl zzlVar : list) {
                    treeMap.put(zzlVar.getName(), zzlVar.getValue());
                }
                zzcVar.zzf = treeMap;
                zzcVar.zzg = Collections.unmodifiableList(czVar.h);
                return zzcVar;
            } finally {
                dhVar.close();
            }
        } catch (IOException e) {
            zzag.d("%s: %s", c.getAbsolutePath(), e.toString());
            a(str);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized void zza() {
        long length;
        dh dhVar;
        if (!this.c.exists()) {
            if (!this.c.mkdirs()) {
                zzag.e("Unable to create cache dir %s", this.c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                length = file.length();
                dhVar = new dh(new BufferedInputStream(a(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                cz a2 = cz.a(dhVar);
                a2.f2112a = length;
                a(a2.b, a2);
                dhVar.close();
            } catch (Throwable th) {
                dhVar.close();
                throw th;
                break;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized void zza(String str, zzc zzcVar) {
        long j;
        if (this.b + zzcVar.data.length <= this.d || zzcVar.data.length <= this.d * 0.9f) {
            File c = c(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(c));
                cz czVar = new cz(str, zzcVar);
                if (!czVar.a(bufferedOutputStream)) {
                    bufferedOutputStream.close();
                    zzag.d("Failed to write header for %s", c.getAbsolutePath());
                    throw new IOException();
                }
                bufferedOutputStream.write(zzcVar.data);
                bufferedOutputStream.close();
                czVar.f2112a = c.length();
                a(str, czVar);
                if (this.b >= this.d) {
                    if (zzag.DEBUG) {
                        zzag.v("Pruning old cache entries.", new Object[0]);
                    }
                    long j2 = this.b;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    Iterator<Map.Entry<String, cz>> it = this.f2760a.entrySet().iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            j = j2;
                            break;
                        }
                        cz value = it.next().getValue();
                        if (c(value.b).delete()) {
                            j = j2;
                            this.b -= value.f2112a;
                        } else {
                            j = j2;
                            zzag.d("Could not delete cache entry for key=%s, filename=%s", value.b, b(value.b));
                        }
                        it.remove();
                        i++;
                        if (((float) this.b) < this.d * 0.9f) {
                            break;
                        } else {
                            j2 = j;
                        }
                    }
                    if (zzag.DEBUG) {
                        zzag.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.b - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
                    }
                }
            } catch (IOException unused) {
                if (c.delete()) {
                    return;
                }
                zzag.d("Could not clean up file %s", c.getAbsolutePath());
            }
        }
    }

    private final synchronized void a(String str) {
        boolean delete = c(str).delete();
        d(str);
        if (!delete) {
            zzag.d("Could not delete cache entry for key=%s, filename=%s", str, b(str));
        }
    }

    private static String b(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File c(String str) {
        return new File(this.c, b(str));
    }

    private final void a(String str, cz czVar) {
        if (!this.f2760a.containsKey(str)) {
            this.b += czVar.f2112a;
        } else {
            this.b += czVar.f2112a - this.f2760a.get(str).f2112a;
        }
        this.f2760a.put(str, czVar);
    }

    private final void d(String str) {
        cz remove = this.f2760a.remove(str);
        if (remove != null) {
            this.b -= remove.f2112a;
        }
    }

    private static byte[] a(dh dhVar, long j) throws IOException {
        long a2 = dhVar.a();
        if (j >= 0 && j <= a2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(dhVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(a2);
        throw new IOException(sb.toString());
    }

    private static InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int c(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(InputStream inputStream) throws IOException {
        return (c(inputStream) << 24) | c(inputStream) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(InputStream inputStream) throws IOException {
        return (c(inputStream) & 255) | 0 | ((c(inputStream) & 255) << 8) | ((c(inputStream) & 255) << 16) | ((c(inputStream) & 255) << 24) | ((c(inputStream) & 255) << 32) | ((c(inputStream) & 255) << 40) | ((c(inputStream) & 255) << 48) | ((255 & c(inputStream)) << 56);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(dh dhVar) throws IOException {
        return new String(a(dhVar, b((InputStream) dhVar)), "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static List<zzl> b(dh dhVar) throws IOException {
        int a2 = a((InputStream) dhVar);
        if (a2 < 0) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("readHeaderList size=");
            sb.append(a2);
            throw new IOException(sb.toString());
        }
        List<zzl> emptyList = a2 == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i = 0; i < a2; i++) {
            emptyList.add(new zzl(a(dhVar).intern(), a(dhVar).intern()));
        }
        return emptyList;
    }
}
