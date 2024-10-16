package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzayu {

    /* renamed from: a, reason: collision with root package name */
    private static zzv f2833a;
    private static final Object b = new Object();

    @Deprecated
    private static final zzayy<Void> c = new ge();

    public zzayu(Context context) {
        a(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    public static zzbbh<zzp> zzeg(String str) {
        zzbbr zzbbrVar = new zzbbr();
        f2833a.zze(new zzaza(str, zzbbrVar));
        return zzbbrVar;
    }

    public final zzbbh<String> zza(int i, String str, Map<String, String> map, byte[] bArr) {
        gh ghVar = new gh(null);
        gf gfVar = new gf(this, str, ghVar);
        zzazx zzazxVar = new zzazx(null);
        gg ggVar = new gg(this, i, str, ghVar, gfVar, bArr, map, zzazxVar);
        if (zzazx.isEnabled()) {
            try {
                zzazxVar.zza(str, "GET", ggVar.getHeaders(), ggVar.zzg());
            } catch (zza e) {
                zzawz.zzep(e.getMessage());
            }
        }
        f2833a.zze(ggVar);
        return ghVar;
    }

    public final zzbbh<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, null);
    }

    @VisibleForTesting
    private static zzv a(Context context) {
        zzv zzvVar;
        zzv zzvVar2;
        synchronized (b) {
            if (f2833a == null) {
                zzacu.initialize(context);
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzctv)).booleanValue()) {
                    zzvVar2 = zzayl.zzbc(context);
                } else {
                    zzvVar2 = new zzv(new zzan(new File(context.getCacheDir(), "volley")), new zzak((zzaj) new zzat()));
                    zzvVar2.start();
                }
                f2833a = zzvVar2;
            }
            zzvVar = f2833a;
        }
        return zzvVar;
    }
}
