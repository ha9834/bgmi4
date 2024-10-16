package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abo extends zzdbt<zzdbj, zzddr, zzddt> {
    public abo() throws GeneralSecurityException {
        super(zzdbj.class, zzddr.class, zzddt.class, "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzdcf.zza(new abp());
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb a() {
        return zzdgr.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzddt b(zzdmr zzdmrVar) throws zzdok {
        return zzddt.zzv(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzddr a(zzdmr zzdmrVar) throws zzdok {
        return zzddr.zzu(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzddr d(zzddt zzddtVar) throws GeneralSecurityException {
        zzddt zzddtVar2 = zzddtVar;
        zzdeb zzdebVar = (zzdeb) zzdcf.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", zzddtVar2.zzaoe());
        return (zzddr) ((zzdob) zzddr.zzaoc().zzb(zzdebVar).zzb((zzdgl) zzdcf.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzddtVar2.zzaof())).zzdu(0).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj c(zzddr zzddrVar) throws GeneralSecurityException {
        zzddr zzddrVar2 = zzddrVar;
        return new zzdkw((zzdlk) zzdcf.zza("type.googleapis.com/google.crypto.tink.AesCtrKey", zzddrVar2.zzaoa(), zzdlk.class), (zzdby) zzdcf.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzddrVar2.zzaob(), zzdby.class), zzddrVar2.zzaob().zzarj().zzarq());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void b(zzddt zzddtVar) throws GeneralSecurityException {
        zzdlx.zzfg(zzddtVar.zzaoe().getKeySize());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzddr zzddrVar) throws GeneralSecurityException {
        zzdlx.zzu(zzddrVar.getVersion(), 0);
    }
}
