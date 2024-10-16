package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class zzbh extends zzan {

    /* renamed from: a, reason: collision with root package name */
    private volatile String f4396a;
    private Future<String> b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbh(zzap zzapVar) {
        super(zzapVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
    }

    public final String zzeh() {
        String str;
        q();
        synchronized (this) {
            if (this.f4396a == null) {
                this.b = h().zza(new s(this));
            }
            if (this.b != null) {
                try {
                    try {
                        this.f4396a = this.b.get();
                    } catch (ExecutionException e) {
                        zze("Failed to load or generate client id", e);
                        this.f4396a = "0";
                    }
                } catch (InterruptedException e2) {
                    zzd("ClientId loading or generation was interrupted", e2);
                    this.f4396a = "0";
                }
                if (this.f4396a == null) {
                    this.f4396a = "0";
                }
                zza("Loaded clientId", this.f4396a);
                this.b = null;
            }
            str = this.f4396a;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        synchronized (this) {
            this.f4396a = null;
            this.b = h().zza(new t(this));
        }
        return zzeh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final String c() {
        String a2 = a(h().getContext());
        return a2 == null ? r() : a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @VisibleForTesting
    public final String r() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            return !a(h().getContext(), lowerCase) ? "0" : lowerCase;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String a(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r0)
            r0 = 0
            java.lang.String r1 = "gaClientId"
            java.io.FileInputStream r1 = r7.openFileInput(r1)     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L72 java.io.FileNotFoundException -> L99
            r2 = 36
            byte[] r3 = new byte[r2]     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            r4 = 0
            int r2 = r1.read(r3, r4, r2)     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            int r5 = r1.available()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            if (r5 <= 0) goto L35
            java.lang.String r2 = "clientId file seems corrupted, deleting it."
            r6.zzt(r2)     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            r1.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            java.lang.String r2 = "gaClientId"
            r7.deleteFile(r2)     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            if (r1 == 0) goto L34
            r1.close()     // Catch: java.io.IOException -> L2e
            goto L34
        L2e:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        L34:
            return r0
        L35:
            r5 = 14
            if (r2 >= r5) goto L53
            java.lang.String r2 = "clientId file is empty, deleting it."
            r6.zzt(r2)     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            r1.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            java.lang.String r2 = "gaClientId"
            r7.deleteFile(r2)     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.io.IOException -> L4c
            goto L52
        L4c:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        L52:
            return r0
        L53:
            r1.close()     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            java.lang.String r5 = new java.lang.String     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            r5.<init>(r3, r4, r2)     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            java.lang.String r2 = "Read client id from disk"
            r6.zza(r2, r5)     // Catch: java.io.IOException -> L6d java.lang.Throwable -> L8b java.io.FileNotFoundException -> L9a
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.io.IOException -> L66
            goto L6c
        L66:
            r7 = move-exception
            java.lang.String r0 = "Failed to close client id reading stream"
            r6.zze(r0, r7)
        L6c:
            return r5
        L6d:
            r2 = move-exception
            goto L74
        L6f:
            r7 = move-exception
            r1 = r0
            goto L8c
        L72:
            r2 = move-exception
            r1 = r0
        L74:
            java.lang.String r3 = "Error reading client id file, deleting it"
            r6.zze(r3, r2)     // Catch: java.lang.Throwable -> L8b
            java.lang.String r2 = "gaClientId"
            r7.deleteFile(r2)     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L8a
            r1.close()     // Catch: java.io.IOException -> L84
            goto L8a
        L84:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        L8a:
            return r0
        L8b:
            r7 = move-exception
        L8c:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.io.IOException -> L92
            goto L98
        L92:
            r0 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r0)
        L98:
            throw r7
        L99:
            r1 = r0
        L9a:
            if (r1 == 0) goto La6
            r1.close()     // Catch: java.io.IOException -> La0
            goto La6
        La0:
            r7 = move-exception
            java.lang.String r1 = "Failed to close client id reading stream"
            r6.zze(r1, r7)
        La6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbh.a(android.content.Context):java.lang.String");
    }

    private final boolean a(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotMainThread("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                zza("Storing clientId", str);
                fileOutputStream = context.openFileOutput("gaClientId", 0);
                fileOutputStream.write(str.getBytes());
                if (fileOutputStream == null) {
                    return true;
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e) {
                    zze("Failed to close clientId writing stream", e);
                    return true;
                }
            } catch (Throwable th) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        zze("Failed to close clientId writing stream", e2);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            zze("Error creating clientId file", e3);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    zze("Failed to close clientId writing stream", e4);
                }
            }
            return false;
        } catch (IOException e5) {
            zze("Error writing to clientId file", e5);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            return false;
        }
    }
}
