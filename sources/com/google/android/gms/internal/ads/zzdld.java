package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class zzdld implements zzdky<Mac> {
    @Override // com.google.android.gms.internal.ads.zzdky
    public final /* synthetic */ Mac zzb(String str, Provider provider) throws GeneralSecurityException {
        if (provider == null) {
            return Mac.getInstance(str);
        }
        return Mac.getInstance(str, provider);
    }
}
