package com.google.android.gms.internal.ads;

import com.tencent.mid.api.MidEntity;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class acg implements zzdbk<zzdby> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdby> zzb(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 107855 && lowerCase.equals(MidEntity.TAG_MAC)) ? (char) 0 : (char) 65535) == 0) {
            if (str.hashCode() == 836622442 && str.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                c = 0;
            }
            if (c == 0) {
                ace aceVar = new ace();
                if (i <= 0) {
                    return aceVar;
                }
                throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
            }
            throw new GeneralSecurityException(String.format("No support for primitive 'Mac' with key type '%s'.", str));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdby> zzanp() {
        return new zzddp();
    }
}
