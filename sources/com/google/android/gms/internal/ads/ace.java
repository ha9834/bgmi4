package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
final class ace extends zzdbt<zzdby, zzdgl, zzdgn> {
    public ace() {
        super(zzdby.class, zzdgl.class, zzdgn.class, "type.googleapis.com/google.crypto.tink.HmacKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb a() {
        return zzdgr.zzb.SYMMETRIC;
    }

    private static void a(zzdgp zzdgpVar) throws GeneralSecurityException {
        if (zzdgpVar.zzarq() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (zzdgpVar.zzarp()) {
            case SHA1:
                if (zzdgpVar.zzarq() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA256:
                if (zzdgpVar.zzarq() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case SHA512:
                if (zzdgpVar.zzarq() > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdgn b(zzdmr zzdmrVar) throws zzdok {
        return zzdgn.zzbm(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdgl a(zzdmr zzdmrVar) throws zzdok {
        return zzdgl.zzbk(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdgl d(zzdgn zzdgnVar) throws GeneralSecurityException {
        zzdgn zzdgnVar2 = zzdgnVar;
        return (zzdgl) ((zzdob) zzdgl.zzark().zzem(0).zzc(zzdgnVar2.zzarj()).zzbl(zzdmr.zzz(zzdlo.zzff(zzdgnVar2.getKeySize()))).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdby c(zzdgl zzdglVar) throws GeneralSecurityException {
        zzdgl zzdglVar2 = zzdglVar;
        zzdgj zzarp = zzdglVar2.zzarj().zzarp();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdglVar2.zzaoi().toByteArray(), "HMAC");
        int zzarq = zzdglVar2.zzarj().zzarq();
        switch (zzarp) {
            case SHA1:
                return new zzdll("HMACSHA1", secretKeySpec, zzarq);
            case SHA256:
                return new zzdll("HMACSHA256", secretKeySpec, zzarq);
            case SHA512:
                return new zzdll("HMACSHA512", secretKeySpec, zzarq);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void b(zzdgn zzdgnVar) throws GeneralSecurityException {
        zzdgn zzdgnVar2 = zzdgnVar;
        if (zzdgnVar2.getKeySize() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        a(zzdgnVar2.zzarj());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdgl zzdglVar) throws GeneralSecurityException {
        zzdgl zzdglVar2 = zzdglVar;
        zzdlx.zzu(zzdglVar2.getVersion(), 0);
        if (zzdglVar2.zzaoi().size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        a(zzdglVar2.zzarj());
    }
}
