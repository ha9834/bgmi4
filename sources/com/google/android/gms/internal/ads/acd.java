package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class acd implements zzdka {

    /* renamed from: a, reason: collision with root package name */
    private final String f1787a;
    private final int b;
    private zzdet c;
    private zzddr d;
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public acd(zzdgw zzdgwVar) throws GeneralSecurityException {
        this.f1787a = zzdgwVar.zzart();
        if (this.f1787a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdev zzal = zzdev.zzal(zzdgwVar.zzaru());
                this.c = (zzdet) zzdcf.zzb(zzdgwVar);
                this.b = zzal.getKeySize();
                return;
            } catch (zzdok e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (this.f1787a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzddt zzv = zzddt.zzv(zzdgwVar.zzaru());
                this.d = (zzddr) zzdcf.zzb(zzdgwVar);
                this.e = zzv.zzaoe().getKeySize();
                this.b = this.e + zzv.zzaof().getKeySize();
                return;
            } catch (zzdok e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        }
        String valueOf = String.valueOf(this.f1787a);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
    }

    @Override // com.google.android.gms.internal.ads.zzdka
    public final int zzanz() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzdka
    public final zzdbj zzm(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.f1787a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (zzdbj) zzdcf.zza(this.f1787a, (zzdet) ((zzdob) zzdet.zzapn().a(this.c).zzak(zzdmr.zzi(bArr, 0, this.b)).zzaya()), zzdbj.class);
        }
        if (this.f1787a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.e);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.e, this.b);
            zzdeb zzdebVar = (zzdeb) ((zzdob) zzdeb.zzaot().a(this.d.zzaoa()).zzab(zzdmr.zzz(copyOfRange)).zzaya());
            return (zzdbj) zzdcf.zza(this.f1787a, (zzddr) ((zzdob) zzddr.zzaoc().zzdu(this.d.getVersion()).zzb(zzdebVar).zzb((zzdgl) ((zzdob) zzdgl.zzark().a(this.d.zzaob()).zzbl(zzdmr.zzz(copyOfRange2)).zzaya())).zzaya()), zzdbj.class);
        }
        throw new GeneralSecurityException("unknown DEM key type");
    }
}
