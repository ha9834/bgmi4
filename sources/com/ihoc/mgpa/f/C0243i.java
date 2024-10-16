package com.ihoc.mgpa.f;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.ihoc.mgpa.f.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0243i {

    /* renamed from: a, reason: collision with root package name */
    private static volatile C0243i f5533a;
    private Context b = com.ihoc.mgpa.n.a.a();
    Properties c = new Properties();

    private C0243i() {
    }

    public static C0243i a() {
        if (f5533a == null) {
            synchronized (C0243i.class) {
                if (f5533a == null) {
                    f5533a = new C0243i();
                }
            }
        }
        return f5533a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(6:2|3|4|5|6|7)|(7:9|(1:11)|(2:22|23)|(1:21)|14|15|16)|26|27|28|29|(2:30|(1:32)(1:33))|34|35|(0)|(0)|14|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0049, code lost:
    
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005d, code lost:
    
        if (r1 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
    
        if (r0 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0046, code lost:
    
        r8 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0047, code lost:
    
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x004f, code lost:
    
        if (r1 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0056, code lost:
    
        if (r0 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0058, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x005b, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0051, code lost:
    
        r1.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.io.File r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = r7.b     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L5c
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L5c
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L5c
            java.lang.String r2 = "TGPA/TGPAConfig.ini"
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L5c
            boolean r2 = r8.exists()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L4b
            if (r2 == 0) goto L24
            long r2 = r8.length()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L4b
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L3c
            goto L24
        L22:
            r8 = move-exception
            goto L4f
        L24:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L4b
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L4b
            r8 = 1024(0x400, float:1.435E-42)
            byte[] r8 = new byte[r8]     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
        L2d:
            int r0 = r1.read(r8)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
            if (r0 <= 0) goto L38
            r3 = 0
            r2.write(r8, r3, r0)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
            goto L2d
        L38:
            r2.flush()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
            r0 = r2
        L3c:
            if (r1 == 0) goto L43
            r1.close()     // Catch: java.io.IOException -> L42
            goto L43
        L42:
        L43:
            if (r0 == 0) goto L69
            goto L66
        L46:
            r8 = move-exception
            r0 = r2
            goto L4f
        L49:
            r0 = r2
            goto L5d
        L4b:
            goto L5d
        L4d:
            r8 = move-exception
            r1 = r0
        L4f:
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L55
            goto L56
        L55:
        L56:
            if (r0 == 0) goto L5b
            r0.close()     // Catch: java.io.IOException -> L5b
        L5b:
            throw r8
        L5c:
            r1 = r0
        L5d:
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.io.IOException -> L63
            goto L64
        L63:
        L64:
            if (r0 == 0) goto L69
        L66:
            r0.close()     // Catch: java.io.IOException -> L69
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.f.C0243i.a(java.io.File):void");
    }

    private void b(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                this.c.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
        }
    }

    public boolean a(String str) {
        String property = this.c.getProperty(str);
        return "1".equals(property) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(property);
    }

    public String b(String str) {
        return this.c.getProperty(str);
    }

    public void b() {
        com.ihoc.mgpa.n.a.e();
        File file = new File(com.ihoc.mgpa.n.a.b() + File.separator + "TGPA/TGPAConfig.ini");
        if (!file.exists()) {
            a(file);
        }
        b(file);
    }
}
