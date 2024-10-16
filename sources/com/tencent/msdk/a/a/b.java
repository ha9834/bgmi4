package com.tencent.msdk.a.a;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: classes.dex */
class b extends g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        super(context);
    }

    @Override // com.tencent.msdk.a.a.g
    protected void a(String str) {
        synchronized (this) {
            i.a("write mid to InternalStorage");
            a.a(Environment.getExternalStorageDirectory() + "/" + c());
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), d())));
                bufferedWriter.write(f() + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (IOException e) {
                i.a(e);
            }
        }
    }

    @Override // com.tencent.msdk.a.a.g
    protected boolean a() {
        return i.a(this.f6281a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        com.tencent.msdk.a.a.i.a("read mid from InternalStorage:" + r2[1]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        r1 = r2[1];
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.msdk.a.a.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.String b() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "read mid from InternalStorage"
            com.tencent.msdk.a.a.i.a(r0)     // Catch: java.lang.Throwable -> L60
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L60
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Throwable -> L60
            java.lang.String r2 = d()     // Catch: java.lang.Throwable -> L60
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L60
            r1 = 0
            java.util.List r0 = com.tencent.msdk.a.a.a.a(r0)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            java.util.Iterator r0 = r0.iterator()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
        L1c:
            boolean r2 = r0.hasNext()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            if (r2 == 0) goto L5e
            java.lang.Object r2 = r0.next()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            java.lang.String r3 = ","
            java.lang.String[] r2 = r2.split(r3)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            int r3 = r2.length     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            r4 = 2
            if (r3 != r4) goto L1c
            r3 = 0
            r3 = r2[r3]     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            java.lang.String r4 = r5.f()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            boolean r3 = r3.equals(r4)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            if (r3 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            r0.<init>()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            java.lang.String r3 = "read mid from InternalStorage:"
            r0.append(r3)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            r3 = 1
            r4 = r2[r3]     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            r0.append(r4)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            com.tencent.msdk.a.a.i.a(r0)     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            r0 = r2[r3]     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L60
            r1 = r0
            goto L5e
        L5a:
            r0 = move-exception
            com.tencent.msdk.a.a.i.a(r0)     // Catch: java.lang.Throwable -> L60
        L5e:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L60
            return r1
        L60:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L60
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.msdk.a.a.b.b():java.lang.String");
    }
}
