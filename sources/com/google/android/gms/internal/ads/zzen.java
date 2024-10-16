package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public final class zzen extends zzfk {
    private static final zzfl<zzch> d = new zzfl<>();
    private final Context e;
    private zzbk.zza f;

    public zzen(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2, Context context, zzbk.zza zzaVar) {
        super(zzdyVar, str, str2, c0092zza, i, 27);
        this.f = null;
        this.e = context;
        this.f = zzaVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039 A[Catch: all -> 0x011d, TryCatch #1 {, blocks: (B:4:0x000d, B:6:0x0017, B:8:0x001f, B:10:0x0029, B:15:0x0039, B:17:0x0045, B:18:0x0082, B:21:0x0091, B:23:0x00b7, B:25:0x00e6, B:26:0x00c1, B:27:0x00c9, B:29:0x00cd, B:31:0x00d7, B:32:0x00da, B:33:0x0048, B:36:0x0056, B:38:0x005c, B:41:0x006b, B:43:0x0075, B:45:0x007d, B:46:0x0080, B:48:0x00e9, B:49:0x00ef), top: B:3:0x000d }] */
    @Override // com.google.android.gms.internal.ads.zzfk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void a() throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzen.a():void");
    }

    private static String a(zzbk.zza zzaVar) {
        if (zzaVar == null || !zzaVar.zzw() || zzef.zzaq(zzaVar.zzx().zzae())) {
            return null;
        }
        return zzaVar.zzx().zzae();
    }

    private final String b() {
        try {
            if (this.f3634a.zzcq() != null) {
                this.f3634a.zzcq().get();
            }
            zzbp.zza zzcp = this.f3634a.zzcp();
            if (zzcp == null || !zzcp.zzai()) {
                return null;
            }
            return zzcp.zzae();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }
}
