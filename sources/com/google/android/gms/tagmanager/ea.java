package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes2.dex */
final class ea {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static bs<zzl> a(bs<zzl> bsVar, int... iArr) {
        for (int i : iArr) {
            if (!(zzgj.zzh(bsVar.a()) instanceof String)) {
                zzdi.zzav("Escaping can only be applied to strings.");
            } else if (i == 12) {
                bsVar = a(bsVar);
            } else {
                StringBuilder sb = new StringBuilder(39);
                sb.append("Unsupported Value Escaping: ");
                sb.append(i);
                zzdi.zzav(sb.toString());
            }
        }
        return bsVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static bs<zzl> a(bs<zzl> bsVar) {
        try {
            return new bs<>(zzgj.zzi(a(zzgj.zzc(bsVar.a()))), bsVar.b());
        } catch (UnsupportedEncodingException e) {
            zzdi.zza("Escape URI: unsupported encoding", e);
            return bsVar;
        }
    }
}
