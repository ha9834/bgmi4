package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes.dex */
public final class zzex {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, zzex> f4165a = new HashMap();
    private final Context b;
    private final String c;

    private zzex(Context context, String str) {
        this.b = context;
        this.c = str;
    }

    public final synchronized Void zzf(zzep zzepVar) throws IOException {
        FileOutputStream openFileOutput = this.b.openFileOutput(this.c, 0);
        Throwable th = null;
        try {
            try {
                openFileOutput.write(zzepVar.toString().getBytes("UTF-8"));
            } finally {
            }
        } finally {
            if (openFileOutput != null) {
                a(th, openFileOutput);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0037 A[Catch: all -> 0x003b, FileNotFoundException | JSONException -> 0x003e, FileNotFoundException | JSONException -> 0x003e, TRY_ENTER, TryCatch #2 {FileNotFoundException | JSONException -> 0x003e, blocks: (B:4:0x0002, B:8:0x0027, B:8:0x0027, B:20:0x0037, B:20:0x0037, B:21:0x003a, B:21:0x003a), top: B:3:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[Catch: all -> 0x003b, FileNotFoundException | JSONException -> 0x003e, FileNotFoundException | JSONException -> 0x003e, SYNTHETIC, TRY_LEAVE, TryCatch #2 {FileNotFoundException | JSONException -> 0x003e, blocks: (B:4:0x0002, B:8:0x0027, B:8:0x0027, B:20:0x0037, B:20:0x0037, B:21:0x003a, B:21:0x003a), top: B:3:0x0002 }] */
    @javax.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.google.android.gms.internal.firebase_remote_config.zzep zzdc() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            android.content.Context r1 = r6.b     // Catch: java.lang.Throwable -> L3b java.lang.Throwable -> L3e
            java.lang.String r2 = r6.c     // Catch: java.lang.Throwable -> L3b java.lang.Throwable -> L3e
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L3b java.lang.Throwable -> L3e
            int r2 = r1.available()     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            byte[] r2 = new byte[r2]     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            r3 = 0
            int r4 = r2.length     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            r1.read(r2, r3, r4)     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            java.lang.String r4 = "UTF-8"
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            com.google.android.gms.internal.firebase_remote_config.zzep r2 = com.google.android.gms.internal.firebase_remote_config.zzep.a(r2)     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L2f
            if (r1 == 0) goto L2a
            a(r0, r1)     // Catch: java.lang.Throwable -> L3b java.lang.Throwable -> L3e java.lang.Throwable -> L3e
        L2a:
            monitor-exit(r6)
            return r2
        L2c:
            r2 = move-exception
            r3 = r0
            goto L35
        L2f:
            r2 = move-exception
            throw r2     // Catch: java.lang.Throwable -> L31
        L31:
            r3 = move-exception
            r5 = r3
            r3 = r2
            r2 = r5
        L35:
            if (r1 == 0) goto L3a
            a(r3, r1)     // Catch: java.lang.Throwable -> L3b java.lang.Throwable -> L3e java.lang.Throwable -> L3e
        L3a:
            throw r2     // Catch: java.lang.Throwable -> L3b java.lang.Throwable -> L3e java.lang.Throwable -> L3e
        L3b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        L3e:
            monitor-exit(r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzex.zzdc():com.google.android.gms.internal.firebase_remote_config.zzep");
    }

    public final synchronized Void zzdd() {
        this.b.deleteFile(this.c);
        return null;
    }

    public static synchronized zzex zzb(Context context, String str) {
        zzex zzexVar;
        synchronized (zzex.class) {
            if (!f4165a.containsKey(str)) {
                f4165a.put(str, new zzex(context, str));
            }
            zzexVar = f4165a.get(str);
        }
        return zzexVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.c;
    }

    private static /* synthetic */ void a(Throwable th, FileOutputStream fileOutputStream) {
        if (th == null) {
            fileOutputStream.close();
            return;
        }
        try {
            fileOutputStream.close();
        } catch (Throwable th2) {
            zzea.zza(th, th2);
        }
    }

    private static /* synthetic */ void a(Throwable th, FileInputStream fileInputStream) {
        if (th == null) {
            fileInputStream.close();
            return;
        }
        try {
            fileInputStream.close();
        } catch (Throwable th2) {
            zzea.zza(th, th2);
        }
    }
}
