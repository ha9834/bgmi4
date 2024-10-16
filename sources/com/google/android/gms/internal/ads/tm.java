package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class tm implements zzban<zzcxu> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzchl f2520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tm(zzchl zzchlVar) {
        this.f2520a = zzchlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        Pattern pattern;
        zzcji zzcjiVar;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue()) {
            pattern = zzchl.f;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzcjiVar = this.f2520a.e;
                zzcjiVar.zzdo(Integer.parseInt(group));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(zzcxu zzcxuVar) {
        zzcji zzcjiVar;
        zzcji zzcjiVar2;
        zzcxu zzcxuVar2 = zzcxuVar;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue()) {
            zzcjiVar = this.f2520a.e;
            zzcjiVar.zzdo(zzcxuVar2.zzgky.zzgku.responseCode);
            zzcjiVar2 = this.f2520a.e;
            zzcjiVar2.zzeu(zzcxuVar2.zzgky.zzgku.zzfyb);
        }
    }
}
