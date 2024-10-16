package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdke {

    /* renamed from: a, reason: collision with root package name */
    private ECPublicKey f3568a;

    public zzdke(ECPublicKey eCPublicKey) {
        this.f3568a = eCPublicKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzdkf zza(String str, byte[] bArr, byte[] bArr2, int i, zzdkv zzdkvVar) throws GeneralSecurityException {
        byte[] bArr3;
        KeyPair zza = zzdkr.zza(this.f3568a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) zza.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) zza.getPrivate();
        ECPublicKey eCPublicKey2 = this.f3568a;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
            byte[] zza2 = zzdkr.zza(eCPrivateKey, eCPublicKey2.getW());
            EllipticCurve curve = eCPublicKey.getParams().getCurve();
            ECPoint w = eCPublicKey.getW();
            zzdkr.a(w, curve);
            int zzb = zzdkr.zzb(curve);
            int i2 = 1;
            switch (zzdkvVar) {
                case UNCOMPRESSED:
                    int i3 = (zzb * 2) + 1;
                    bArr3 = new byte[i3];
                    byte[] byteArray = w.getAffineX().toByteArray();
                    byte[] byteArray2 = w.getAffineY().toByteArray();
                    System.arraycopy(byteArray2, 0, bArr3, i3 - byteArray2.length, byteArray2.length);
                    System.arraycopy(byteArray, 0, bArr3, (zzb + 1) - byteArray.length, byteArray.length);
                    bArr3[0] = 4;
                    break;
                case DO_NOT_USE_CRUNCHY_UNCOMPRESSED:
                    int i4 = zzb * 2;
                    bArr3 = new byte[i4];
                    byte[] byteArray3 = w.getAffineX().toByteArray();
                    if (byteArray3.length > zzb) {
                        byteArray3 = Arrays.copyOfRange(byteArray3, byteArray3.length - zzb, byteArray3.length);
                    }
                    byte[] byteArray4 = w.getAffineY().toByteArray();
                    if (byteArray4.length > zzb) {
                        byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - zzb, byteArray4.length);
                    }
                    System.arraycopy(byteArray4, 0, bArr3, i4 - byteArray4.length, byteArray4.length);
                    System.arraycopy(byteArray3, 0, bArr3, zzb - byteArray3.length, byteArray3.length);
                    break;
                case COMPRESSED:
                    int i5 = zzb + 1;
                    byte[] bArr4 = new byte[i5];
                    byte[] byteArray5 = w.getAffineX().toByteArray();
                    System.arraycopy(byteArray5, 0, bArr4, i5 - byteArray5.length, byteArray5.length);
                    bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                    bArr3 = bArr4;
                    break;
                default:
                    String valueOf = String.valueOf(zzdkvVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                    sb.append("invalid format:");
                    sb.append(valueOf);
                    throw new GeneralSecurityException(sb.toString());
            }
            byte[] zza3 = zzdjs.zza(bArr3, zza2);
            Mac zzgt = zzdkx.zzhaq.zzgt(str);
            if (i > zzgt.getMacLength() * 255) {
                throw new GeneralSecurityException("size too large");
            }
            if (bArr == null || bArr.length == 0) {
                zzgt.init(new SecretKeySpec(new byte[zzgt.getMacLength()], str));
            } else {
                zzgt.init(new SecretKeySpec(bArr, str));
            }
            byte[] doFinal = zzgt.doFinal(zza3);
            byte[] bArr5 = new byte[i];
            zzgt.init(new SecretKeySpec(doFinal, str));
            byte[] bArr6 = new byte[0];
            int i6 = 0;
            while (true) {
                zzgt.update(bArr6);
                zzgt.update(bArr2);
                zzgt.update((byte) i2);
                bArr6 = zzgt.doFinal();
                if (bArr6.length + i6 < i) {
                    System.arraycopy(bArr6, 0, bArr5, i6, bArr6.length);
                    i6 += bArr6.length;
                    i2++;
                } else {
                    System.arraycopy(bArr6, 0, bArr5, i6, i - i6);
                    return new zzdkf(bArr3, bArr5);
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new GeneralSecurityException(e.toString());
        }
    }
}
