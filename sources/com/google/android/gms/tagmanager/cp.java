package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzop;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzoz;
import com.google.android.gms.internal.gtm.zzuv;
import com.google.android.gms.internal.gtm.zzuw;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cp implements h {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5106a;
    private final String b;
    private final ExecutorService c = zzdf.zzgp().zzr(com.google.android.gms.internal.gtm.zzdi.zzadg);
    private bc<zzop> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(Context context, String str) {
        this.f5106a = context;
        this.b = str;
    }

    @Override // com.google.android.gms.tagmanager.h
    public final void a(bc<zzop> bcVar) {
        this.d = bcVar;
    }

    @Override // com.google.android.gms.tagmanager.h
    public final void a() {
        this.c.execute(new cq(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (r0 == com.google.android.gms.tagmanager.zzeh.zza.CONTAINER_DEBUG) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r3 = this;
            com.google.android.gms.tagmanager.bc<com.google.android.gms.internal.gtm.zzop> r0 = r3.d
            if (r0 == 0) goto Lc6
            r0.a()
            java.lang.String r0 = "Attempting to load resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzab(r0)
            com.google.android.gms.tagmanager.zzeh r0 = com.google.android.gms.tagmanager.zzeh.a()
            com.google.android.gms.tagmanager.zzeh$zza r0 = r0.b()
            com.google.android.gms.tagmanager.zzeh$zza r1 = com.google.android.gms.tagmanager.zzeh.zza.CONTAINER
            if (r0 == r1) goto L24
            com.google.android.gms.tagmanager.zzeh r0 = com.google.android.gms.tagmanager.zzeh.a()
            com.google.android.gms.tagmanager.zzeh$zza r0 = r0.b()
            com.google.android.gms.tagmanager.zzeh$zza r1 = com.google.android.gms.tagmanager.zzeh.zza.CONTAINER_DEBUG
            if (r0 != r1) goto L3c
        L24:
            java.lang.String r0 = r3.b
            com.google.android.gms.tagmanager.zzeh r1 = com.google.android.gms.tagmanager.zzeh.a()
            java.lang.String r1 = r1.d()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L3c
            com.google.android.gms.tagmanager.bc<com.google.android.gms.internal.gtm.zzop> r0 = r3.d
            int r1 = com.google.android.gms.tagmanager.zzcz.zzaht
            r0.a(r1)
            return
        L3c:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> Lb9
            java.io.File r1 = r3.c()     // Catch: java.io.FileNotFoundException -> Lb9
            r0.<init>(r1)     // Catch: java.io.FileNotFoundException -> Lb9
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            r1.<init>()     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            com.google.android.gms.internal.gtm.zzor.zza(r0, r1)     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            byte[] r1 = r1.toByteArray()     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            com.google.android.gms.internal.gtm.zzop r2 = new com.google.android.gms.internal.gtm.zzop     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            r2.<init>()     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            com.google.android.gms.internal.gtm.zzuw r1 = com.google.android.gms.internal.gtm.zzuw.zza(r2, r1)     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            com.google.android.gms.internal.gtm.zzop r1 = (com.google.android.gms.internal.gtm.zzop) r1     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            com.google.android.gms.internal.gtm.zzi r2 = r1.zzqk     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            if (r2 != 0) goto L6d
            com.google.android.gms.internal.gtm.zzk r2 = r1.zzauy     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            if (r2 == 0) goto L65
            goto L6d
        L65:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            java.lang.String r2 = "Resource and SupplementedResource are NULL."
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            throw r1     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
        L6d:
            com.google.android.gms.tagmanager.bc<com.google.android.gms.internal.gtm.zzop> r2 = r3.d     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            r2.a(r1)     // Catch: java.lang.Throwable -> L7c java.lang.IllegalArgumentException -> L7e java.io.IOException -> L94
            r0.close()     // Catch: java.io.IOException -> L76
            goto La9
        L76:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzac(r0)
            goto La9
        L7c:
            r1 = move-exception
            goto Laf
        L7e:
            com.google.android.gms.tagmanager.bc<com.google.android.gms.internal.gtm.zzop> r1 = r3.d     // Catch: java.lang.Throwable -> L7c
            int r2 = com.google.android.gms.tagmanager.zzcz.zzahu     // Catch: java.lang.Throwable -> L7c
            r1.a(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = "Failed to read the resource from disk. The resource is inconsistent"
            com.google.android.gms.tagmanager.zzdi.zzac(r1)     // Catch: java.lang.Throwable -> L7c
            r0.close()     // Catch: java.io.IOException -> L8e
            goto La9
        L8e:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzac(r0)
            goto La9
        L94:
            com.google.android.gms.tagmanager.bc<com.google.android.gms.internal.gtm.zzop> r1 = r3.d     // Catch: java.lang.Throwable -> L7c
            int r2 = com.google.android.gms.tagmanager.zzcz.zzahu     // Catch: java.lang.Throwable -> L7c
            r1.a(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r1 = "Failed to read the resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzac(r1)     // Catch: java.lang.Throwable -> L7c
            r0.close()     // Catch: java.io.IOException -> La4
            goto La9
        La4:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzac(r0)
        La9:
            java.lang.String r0 = "The Disk resource was successfully read."
            com.google.android.gms.tagmanager.zzdi.zzab(r0)
            return
        Laf:
            r0.close()     // Catch: java.io.IOException -> Lb3
            goto Lb8
        Lb3:
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzac(r0)
        Lb8:
            throw r1
        Lb9:
            java.lang.String r0 = "Failed to find the resource in the disk"
            com.google.android.gms.tagmanager.zzdi.zzax(r0)
            com.google.android.gms.tagmanager.bc<com.google.android.gms.internal.gtm.zzop> r0 = r3.d
            int r1 = com.google.android.gms.tagmanager.zzcz.zzaht
            r0.a(r1)
            return
        Lc6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Callback must be set before execute"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.cp.b():void");
    }

    @Override // com.google.android.gms.tagmanager.h
    public final void a(zzop zzopVar) {
        this.c.execute(new cr(this, zzopVar));
    }

    @Override // com.google.android.gms.tagmanager.h
    public final zzov a(int i) {
        try {
            InputStream openRawResource = this.f5106a.getResources().openRawResource(i);
            String resourceName = this.f5106a.getResources().getResourceName(i);
            StringBuilder sb = new StringBuilder(String.valueOf(resourceName).length() + 66);
            sb.append("Attempting to load a container from the resource ID ");
            sb.append(i);
            sb.append(" (");
            sb.append(resourceName);
            sb.append(")");
            zzdi.zzab(sb.toString());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzor.zza(openRawResource, byteArrayOutputStream);
                zzov a2 = a(byteArrayOutputStream);
                if (a2 != null) {
                    zzdi.zzab("The container was successfully loaded from the resource (using JSON file format)");
                    return a2;
                }
                return a(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
                String resourceName2 = this.f5106a.getResources().getResourceName(i);
                StringBuilder sb2 = new StringBuilder(String.valueOf(resourceName2).length() + 67);
                sb2.append("Error reading the default container with resource ID ");
                sb2.append(i);
                sb2.append(" (");
                sb2.append(resourceName2);
                sb2.append(")");
                zzdi.zzac(sb2.toString());
                return null;
            }
        } catch (Resources.NotFoundException unused2) {
            StringBuilder sb3 = new StringBuilder(98);
            sb3.append("Failed to load the container. No default container resource found with the resource ID ");
            sb3.append(i);
            zzdi.zzac(sb3.toString());
            return null;
        }
    }

    private static zzov a(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return aw.a(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            zzdi.zzax("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException unused2) {
            zzdi.zzac("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private static zzov a(byte[] bArr) {
        try {
            zzov zza = zzor.zza((zzi) zzuw.zza(new zzi(), bArr));
            if (zza != null) {
                zzdi.zzab("The container was successfully loaded from the resource (using binary file)");
            }
            return zza;
        } catch (zzoz unused) {
            zzdi.zzac("The resource file is invalid. The container from the binary file is invalid");
            return null;
        } catch (zzuv unused2) {
            zzdi.zzav("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        this.c.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean b(zzop zzopVar) {
        FileOutputStream fileOutputStream;
        File c = c();
        try {
            try {
                fileOutputStream = new FileOutputStream(c);
                try {
                    byte[] bArr = new byte[zzopVar.zzpe()];
                    zzuw.zza(zzopVar, bArr, 0, bArr.length);
                    fileOutputStream.write(bArr);
                    try {
                        fileOutputStream.close();
                        return true;
                    } catch (IOException unused) {
                        zzdi.zzac("error closing stream for writing resource to disk");
                        return true;
                    }
                } catch (IOException unused2) {
                    zzdi.zzac("Error writing resource to disk. Removing resource from disk.");
                    c.delete();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzdi.zzac("error closing stream for writing resource to disk");
                    }
                    return false;
                }
            } catch (FileNotFoundException unused4) {
                zzdi.zzav("Error opening resource file for writing");
                return false;
            }
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (IOException unused5) {
                zzdi.zzac("error closing stream for writing resource to disk");
            }
            throw th;
        }
    }

    @VisibleForTesting
    private final File c() {
        String valueOf = String.valueOf("resource_");
        String valueOf2 = String.valueOf(this.b);
        return new File(this.f5106a.getDir("google_tagmanager", 0), valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }
}
