package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;

/* loaded from: classes2.dex */
public final class zzdla implements zzdky<KeyAgreement> {
    @Override // com.google.android.gms.internal.ads.zzdky
    public final /* synthetic */ KeyAgreement zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return KeyAgreement.getInstance(str);
        }
        return KeyAgreement.getInstance(str, provider);
    }
}
