package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ab extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5068a = com.google.android.gms.internal.gtm.zza.ENCODE.toString();
    private static final String b = zzb.ARG0.toString();
    private static final String c = zzb.NO_PADDING.toString();
    private static final String d = zzb.INPUT_FORMAT.toString();
    private static final String e = zzb.OUTPUT_FORMAT.toString();

    public ab() {
        super(f5068a, b);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        byte[] decode;
        String encodeToString;
        zzl zzlVar = map.get(b);
        if (zzlVar == null || zzlVar == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzlVar);
        zzl zzlVar2 = map.get(d);
        String zzc2 = zzlVar2 == null ? "text" : zzgj.zzc(zzlVar2);
        zzl zzlVar3 = map.get(e);
        String zzc3 = zzlVar3 == null ? "base16" : zzgj.zzc(zzlVar3);
        int i = 2;
        zzl zzlVar4 = map.get(c);
        if (zzlVar4 != null && zzgj.zzg(zzlVar4).booleanValue()) {
            i = 3;
        }
        try {
            if ("text".equals(zzc2)) {
                decode = zzc.getBytes();
            } else if ("base16".equals(zzc2)) {
                decode = zzo.decode(zzc);
            } else if ("base64".equals(zzc2)) {
                decode = Base64.decode(zzc, i);
            } else if ("base64url".equals(zzc2)) {
                decode = Base64.decode(zzc, i | 8);
            } else {
                String valueOf = String.valueOf(zzc2);
                zzdi.zzav(valueOf.length() != 0 ? "Encode: unknown input format: ".concat(valueOf) : new String("Encode: unknown input format: "));
                return zzgj.zzkc();
            }
            if ("base16".equals(zzc3)) {
                encodeToString = zzo.encode(decode);
            } else if ("base64".equals(zzc3)) {
                encodeToString = Base64.encodeToString(decode, i);
            } else if ("base64url".equals(zzc3)) {
                encodeToString = Base64.encodeToString(decode, i | 8);
            } else {
                String valueOf2 = String.valueOf(zzc3);
                zzdi.zzav(valueOf2.length() != 0 ? "Encode: unknown output format: ".concat(valueOf2) : new String("Encode: unknown output format: "));
                return zzgj.zzkc();
            }
            return zzgj.zzi(encodeToString);
        } catch (IllegalArgumentException unused) {
            zzdi.zzav("Encode: invalid input:");
            return zzgj.zzkc();
        }
    }
}
