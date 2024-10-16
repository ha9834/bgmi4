package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgy;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzdbl {
    public static zzdgy zza(String str, String str2, String str3, int i, boolean z) {
        zzdgy.zza zzgn = zzdgy.zzasf().zzgn(str2);
        String valueOf = String.valueOf(str3);
        return (zzdgy) ((zzdob) zzgn.zzgo(valueOf.length() != 0 ? "type.googleapis.com/google.crypto.tink.".concat(valueOf) : new String("type.googleapis.com/google.crypto.tink.")).zzeq(0).zzbe(true).zzgp(str).zzaya());
    }

    public static void zza(zzdho zzdhoVar) throws GeneralSecurityException {
        for (zzdgy zzdgyVar : zzdhoVar.zzatj()) {
            if (zzdgyVar.zzart().isEmpty()) {
                throw new GeneralSecurityException("Missing type_url.");
            }
            if (zzdgyVar.zzasb().isEmpty()) {
                throw new GeneralSecurityException("Missing primitive_name.");
            }
            if (zzdgyVar.zzase().isEmpty()) {
                throw new GeneralSecurityException("Missing catalogue_name.");
            }
            zzdbk<?> zzgi = zzdcf.zzgi(zzdgyVar.zzase());
            zzdcf.zza(zzgi.zzanp());
            zzdcf.zza(zzgi.zzb(zzdgyVar.zzart(), zzdgyVar.zzasb(), zzdgyVar.zzasc()), zzdgyVar.zzasd());
        }
    }
}
