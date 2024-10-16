package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class TbsBaseConfig {
    public static final String TAG = "TbsBaseConfig";

    /* renamed from: a, reason: collision with root package name */
    Map<String, String> f6461a;
    private Context b;

    public abstract String getConfigFileName();

    public void init(Context context) {
        this.f6461a = new HashMap();
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
        refreshSyncMap(context);
    }

    private static File a(Context context, String str) {
        j.a();
        File e = j.e(context);
        if (e == null) {
            return null;
        }
        File file = new File(e, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f6461a.clear();
        commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void refreshSyncMap(android.content.Context r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            r7 = 0
            android.content.Context r0 = r6.b     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            java.lang.String r1 = r6.getConfigFileName()     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            java.io.File r0 = a(r0, r1)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            if (r0 != 0) goto L10
            monitor-exit(r6)
            return
        L10:
            java.util.Map<java.lang.String, java.lang.String> r1 = r6.f6461a     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            r1.clear()     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L50 java.lang.Throwable -> L55
            java.util.Properties r7 = new java.util.Properties     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            r7.<init>()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            r7.load(r0)     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            java.util.Set r1 = r7.stringPropertyNames()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
        L2f:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            if (r2 == 0) goto L45
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            java.util.Map<java.lang.String, java.lang.String> r3 = r6.f6461a     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            java.lang.String r4 = r7.getProperty(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            r3.put(r2, r4)     // Catch: java.lang.Throwable -> L4e java.lang.Throwable -> L68
            goto L2f
        L45:
            r0.close()     // Catch: java.lang.Exception -> L49 java.lang.Throwable -> L62
            goto L66
        L49:
            r7 = move-exception
        L4a:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L62
            goto L66
        L4e:
            r7 = move-exception
            goto L59
        L50:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L69
        L55:
            r0 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
        L59:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L68
            if (r0 == 0) goto L66
            r0.close()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L64
            goto L66
        L62:
            r7 = move-exception
            goto L74
        L64:
            r7 = move-exception
            goto L4a
        L66:
            monitor-exit(r6)
            return
        L68:
            r7 = move-exception
        L69:
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L6f
            goto L73
        L6f:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L62
        L73:
            throw r7     // Catch: java.lang.Throwable -> L62
        L74:
            monitor-exit(r6)
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsBaseConfig.refreshSyncMap(android.content.Context):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[Catch: all -> 0x00e1, SYNTHETIC, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:23:0x008d, B:26:0x0095, B:31:0x009a, B:33:0x0092, B:65:0x00ce, B:57:0x00d8, B:62:0x00e0, B:61:0x00dd, B:68:0x00d3, B:47:0x00b7, B:43:0x00c1, B:50:0x00bc), top: B:2:0x0001, inners: #5, #7, #8, #9 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void writeTbsDownloadInfo() {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsBaseConfig.writeTbsDownloadInfo():void");
    }

    public synchronized void commit() {
        writeTbsDownloadInfo();
    }
}
