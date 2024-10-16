package com.tencent.mid.b;

import android.content.Context;
import android.os.Environment;
import com.tencent.mid.util.Util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* loaded from: classes.dex */
public class c extends f {
    @Override // com.tencent.mid.b.f
    public int a() {
        return 2;
    }

    @Override // com.tencent.mid.b.f
    protected void a(a aVar) {
    }

    @Override // com.tencent.mid.b.f
    protected a d() {
        return null;
    }

    public c(Context context, int i) {
        super(context, i);
    }

    @Override // com.tencent.mid.b.f
    protected boolean b() {
        try {
            if (Util.checkPermission(this.c, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                return "mounted".equals(Environment.getExternalStorageState());
            }
            return false;
        } catch (Throwable th) {
            b.b("checkPermission " + th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        com.tencent.mid.b.c.b.b("read mid from InternalStorage:" + r2[1]);
        r0 = r2[1];
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.mid.b.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.String c() {
        /*
            r6 = this;
            monitor-enter(r6)
            com.tencent.mid.util.d r0 = com.tencent.mid.b.c.b     // Catch: java.lang.Throwable -> L5e
            java.lang.String r1 = "read mid from InternalStorage  version code = 4.07"
            r0.b(r1)     // Catch: java.lang.Throwable -> L5e
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.lang.String r3 = r6.f()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.util.List r1 = com.tencent.mid.b.b.a(r1)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
        L1e:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            if (r2 == 0) goto L5c
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.lang.String r3 = ","
            java.lang.String[] r2 = r2.split(r3)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            int r3 = r2.length     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            r4 = 2
            if (r3 != r4) goto L1e
            r3 = 0
            r3 = r2[r3]     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.lang.String r4 = r6.h()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            boolean r3 = r3.equals(r4)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            if (r3 == 0) goto L1e
            com.tencent.mid.util.d r1 = com.tencent.mid.b.c.b     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            r3.<init>()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.lang.String r4 = "read mid from InternalStorage:"
            r3.append(r4)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            r4 = 1
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            r3.append(r5)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            r1.b(r3)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
            r0 = r2[r4]     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L5e
        L5c:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L5e
            return r0
        L5e:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L5e
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mid.b.c.c():java.lang.String");
    }

    @Override // com.tencent.mid.b.f
    protected void a(String str) {
        BufferedWriter bufferedWriter;
        synchronized (this) {
            b.b("write mid to InternalStorage");
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    b.a(Environment.getExternalStorageDirectory() + "/" + e());
                    bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), f())));
                } catch (Exception unused) {
                }
                try {
                    bufferedWriter.write(h() + "," + str);
                    bufferedWriter.write("\n");
                } catch (Throwable unused2) {
                    bufferedWriter2 = bufferedWriter;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        }
    }
}
