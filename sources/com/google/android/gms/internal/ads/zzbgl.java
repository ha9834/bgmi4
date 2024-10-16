package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class zzbgl extends zzbft {
    private final zzbdk d;
    private boolean e;
    private String f;
    private boolean g;

    public zzbgl(zzbdf zzbdfVar) {
        super(zzbdfVar);
        this.f = null;
        this.d = new zzbdk();
        this.d.zza(new ks(this));
    }

    protected abstract int a();

    protected abstract zzhn b(String str);

    @Override // com.google.android.gms.internal.ads.zzbft, com.google.android.gms.common.api.Releasable
    public void release() {
        this.d.zzyr();
        super.release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final String a(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.a(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e4, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ea, code lost:
    
        java.lang.Thread.sleep(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
    
        throw new java.io.IOException("Interrupted sleep.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ff, code lost:
    
        r0 = java.lang.Long.toString(r20);
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 27);
        r3.append("Timeout reached. Limit: ");
        r3.append(r0);
        r3.append(" ms");
        r2 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x012a, code lost:
    
        throw new java.io.IOException("Timed out while buffering.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0134, code lost:
    
        throw r0;
     */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [long] */
    /* JADX WARN: Type inference failed for: r1v38 */
    @Override // com.google.android.gms.internal.ads.zzbft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzex(java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgl.zzex(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void abort() {
        synchronized (this) {
            this.e = true;
        }
    }

    public final void zzzx() {
        synchronized (this) {
            this.g = true;
            this.d.removeListener();
        }
    }

    public final zzbdk zzzy() {
        return this.d;
    }
}
