package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class aby implements zzdbk<zzdbp> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdbp> zzb(String str, String str2, int i) throws GeneralSecurityException {
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 275448849 && lowerCase.equals("hybriddecrypt")) ? (char) 0 : (char) 65535) == 0) {
            if (str.hashCode() == -80133005 && str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
                c = 0;
            }
            if (c == 0) {
                abw abwVar = new abw();
                if (i <= 0) {
                    return abwVar;
                }
                throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
            }
            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", str));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdbp> zzanp() {
        return new zzdde();
    }
}
