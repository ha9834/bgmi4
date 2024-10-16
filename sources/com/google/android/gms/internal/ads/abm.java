package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abm implements zzdbk<zzdbj> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdbj> zzb(String str, String str2, int i) throws GeneralSecurityException {
        zzdbs<zzdbj> aboVar;
        String lowerCase = str2.toLowerCase();
        char c = 65535;
        if (((lowerCase.hashCode() == 2989895 && lowerCase.equals("aead")) ? (char) 0 : (char) 65535) == 0) {
            switch (str.hashCode()) {
                case 245054116:
                    if (str.equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                        c = 6;
                        break;
                    }
                    break;
                case 360753376:
                    if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1215885937:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1469984853:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1797113348:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1855890991:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2079211877:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aboVar = new abo();
                    break;
                case 1:
                    aboVar = new abq();
                    break;
                case 2:
                    aboVar = new abr();
                    break;
                case 3:
                    aboVar = new abs();
                    break;
                case 4:
                    aboVar = new abt();
                    break;
                case 5:
                    aboVar = new abu();
                    break;
                case 6:
                    aboVar = new abv();
                    break;
                default:
                    throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", str));
            }
            if (aboVar.getVersion() >= i) {
                return aboVar;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i)));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdbj> zzanp() {
        return new zzdck();
    }
}
