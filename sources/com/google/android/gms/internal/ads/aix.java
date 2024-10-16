package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aix {

    /* renamed from: a, reason: collision with root package name */
    static zzdbq f1902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzdy zzdyVar) throws IllegalAccessException, InvocationTargetException {
        if (f1902a != null) {
            return true;
        }
        String str = (String) zzyt.zzpe().zzd(zzacu.zzcrl);
        if (str == null || str.length() == 0) {
            if (zzdyVar == null) {
                str = null;
            } else {
                Method zzc = zzdyVar.zzc("zu6uZ8u7nNJHsIXbotuBCEBd9hieUh9UBKC94dMPsF422AtJb3FisPSqZI3W+06A", "tm6XtP5M5qvCs+TffoCZhF/AF3Fx7Ow8iqgApPbgXSw=");
                str = zzc == null ? null : (String) zzc.invoke(null, new Object[0]);
            }
            if (str == null) {
                return false;
            }
        }
        try {
            try {
                zzdbu zzl = zzdbz.zzl(zzcg.zza(str, true));
                zzdbl.zza(zzddc.zzgpt);
                zzdcf.zza(new zzddg());
                f1902a = (zzdbq) zzdcf.zza(zzdcf.zza(zzl, (zzdbs) null, zzdbq.class));
                return f1902a != null;
            } catch (GeneralSecurityException unused) {
                return false;
            }
        } catch (IllegalArgumentException unused2) {
            return false;
        }
    }
}
