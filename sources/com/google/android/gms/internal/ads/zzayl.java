package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

@zzard
/* loaded from: classes2.dex */
public final class zzayl extends zzak {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2829a;

    public static zzv zzbc(Context context) {
        zzv zzvVar = new zzv(new zzan(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzayl(context, new zzat()));
        zzvVar.start();
        return zzvVar;
    }

    private zzayl(Context context, zzas zzasVar) {
        super(zzasVar);
        this.f2829a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzak, com.google.android.gms.internal.ads.zzm
    public final zzp zzc(zzr<?> zzrVar) throws zzaf {
        if (zzrVar.zzh() && zzrVar.getMethod() == 0) {
            if (Pattern.matches((String) zzyt.zzpe().zzd(zzacu.zzctw), zzrVar.getUrl())) {
                zzyt.zzpa();
                if (zzazt.zzc(this.f2829a, 13400000)) {
                    zzp zzc = new zzaii(this.f2829a).zzc(zzrVar);
                    if (zzc != null) {
                        String valueOf = String.valueOf(zzrVar.getUrl());
                        zzawz.zzds(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zzc;
                    }
                    String valueOf2 = String.valueOf(zzrVar.getUrl());
                    zzawz.zzds(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzrVar);
    }
}
