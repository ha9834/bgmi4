package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdky;
import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class zzdkx<T_WRAPPER extends zzdky<T_ENGINE>, T_ENGINE> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f3574a = Logger.getLogger(zzdkx.class.getName());
    private static final List<Provider> b;
    public static final zzdkx<zzdkz, Cipher> zzhap;
    public static final zzdkx<zzdld, Mac> zzhaq;
    public static final zzdkx<zzdlf, Signature> zzhar;
    public static final zzdkx<zzdle, MessageDigest> zzhas;
    public static final zzdkx<zzdla, KeyAgreement> zzhat;
    public static final zzdkx<zzdlc, KeyPairGenerator> zzhau;
    public static final zzdkx<zzdlb, KeyFactory> zzhav;
    private T_WRAPPER c;
    private List<Provider> d = b;
    private boolean e = true;

    private zzdkx(T_WRAPPER t_wrapper) {
        this.c = t_wrapper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final T_ENGINE zzgt(String str) throws GeneralSecurityException {
        for (Provider provider : this.d) {
            if (a(str, provider)) {
                return (T_ENGINE) this.c.zzb(str, provider);
            }
        }
        if (this.e) {
            return (T_ENGINE) this.c.zzb(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }

    private final boolean a(String str, Provider provider) {
        try {
            this.c.zzb(str, provider);
            return true;
        } catch (Exception e) {
            zzdmb.zzg(e);
            return false;
        }
    }

    static {
        if (zzdlv.zzavd()) {
            String[] strArr = {ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    f3574a.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            b = arrayList;
        } else {
            b = new ArrayList();
        }
        zzhap = new zzdkx<>(new zzdkz());
        zzhaq = new zzdkx<>(new zzdld());
        zzhar = new zzdkx<>(new zzdlf());
        zzhas = new zzdkx<>(new zzdle());
        zzhat = new zzdkx<>(new zzdla());
        zzhau = new zzdkx<>(new zzdlc());
        zzhav = new zzdkx<>(new zzdlb());
    }
}
