package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class abt extends zzdbt<zzdbj, zzdhe, zzdhg> {
    public abt() {
        super(zzdbj.class, zzdhe.class, zzdhg.class, "type.googleapis.com/google.crypto.tink.KmsAeadKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void b(zzdhg zzdhgVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int getVersion() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb a() {
        return zzdgr.zzb.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdhg b(zzdmr zzdmrVar) throws zzdok {
        return zzdhg.zzbq(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdhe a(zzdmr zzdmrVar) throws zzdok {
        return zzdhe.zzbp(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdhe d(zzdhg zzdhgVar) throws GeneralSecurityException {
        return (zzdhe) ((zzdob) zzdhe.zzasx().zzb(zzdhgVar).zzex(0).zzaya());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj c(zzdhe zzdheVar) throws GeneralSecurityException {
        String zzasz = zzdheVar.zzasw().zzasz();
        return zzdbx.zzgh(zzasz).zzgg(zzasz);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void a(zzdhe zzdheVar) throws GeneralSecurityException {
        zzdlx.zzu(zzdheVar.getVersion(), 0);
    }
}
