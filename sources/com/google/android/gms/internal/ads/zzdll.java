package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class zzdll implements zzdby {

    /* renamed from: a, reason: collision with root package name */
    private Mac f3577a;
    private final int b;
    private final String c;
    private final Key d;

    public zzdll(String str, Key key, int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1823053428) {
            if (hashCode != 392315118) {
                if (hashCode == 392317873 && str.equals("HMACSHA512")) {
                    c = 2;
                }
            } else if (str.equals("HMACSHA256")) {
                c = 1;
            }
        } else if (str.equals("HMACSHA1")) {
            c = 0;
        }
        switch (c) {
            case 0:
                if (i > 20) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 1:
                if (i > 32) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            case 2:
                if (i > 64) {
                    throw new InvalidAlgorithmParameterException("tag size too big");
                }
                break;
            default:
                String valueOf = String.valueOf(str);
                throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
        }
        this.c = str;
        this.b = i;
        this.d = key;
        this.f3577a = zzdkx.zzhaq.zzgt(str);
        this.f3577a.init(key);
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
        Mac zzgt;
        try {
            zzgt = (Mac) this.f3577a.clone();
        } catch (CloneNotSupportedException unused) {
            zzgt = zzdkx.zzhaq.zzgt(this.c);
            zzgt.init(this.d);
        }
        zzgt.update(bArr);
        byte[] bArr2 = new byte[this.b];
        System.arraycopy(zzgt.doFinal(), 0, bArr2, 0, this.b);
        return bArr2;
    }
}
