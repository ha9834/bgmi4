package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abz implements zzdbk<zzdbq> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdbq> zzb(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 1420614889 && lowerCase.equals("hybridencrypt")) ? (char) 0 : (char) 65535) == 0) {
            if (str.hashCode() == 396454335 && str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                c = 0;
            }
            if (c == 0) {
                abx abxVar = new abx();
                if (i <= 0) {
                    return abxVar;
                }
                throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
            }
            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", str));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdbq> zzanp() {
        return new zzddg();
    }
}
