package com.google.android.gms.tagmanager;

import com.adjust.sdk.Constants;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class al extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5075a = com.google.android.gms.internal.gtm.zza.HASH.toString();
    private static final String b = zzb.ARG0.toString();
    private static final String c = zzb.ALGORITHM.toString();
    private static final String d = zzb.INPUT_FORMAT.toString();

    public al() {
        super(f5075a, b);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        byte[] decode;
        zzl zzlVar = map.get(b);
        if (zzlVar == null || zzlVar == zzgj.zzkc()) {
            return zzgj.zzkc();
        }
        String zzc = zzgj.zzc(zzlVar);
        zzl zzlVar2 = map.get(c);
        String zzc2 = zzlVar2 == null ? Constants.MD5 : zzgj.zzc(zzlVar2);
        zzl zzlVar3 = map.get(d);
        String zzc3 = zzlVar3 == null ? "text" : zzgj.zzc(zzlVar3);
        if ("text".equals(zzc3)) {
            decode = zzc.getBytes();
        } else if ("base16".equals(zzc3)) {
            decode = zzo.decode(zzc);
        } else {
            String valueOf = String.valueOf(zzc3);
            zzdi.zzav(valueOf.length() != 0 ? "Hash: unknown input format: ".concat(valueOf) : new String("Hash: unknown input format: "));
            return zzgj.zzkc();
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(zzc2);
            messageDigest.update(decode);
            return zzgj.zzi(zzo.encode(messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            String valueOf2 = String.valueOf(zzc2);
            zzdi.zzav(valueOf2.length() != 0 ? "Hash: unknown algorithm: ".concat(valueOf2) : new String("Hash: unknown algorithm: "));
            return zzgj.zzkc();
        }
    }
}
