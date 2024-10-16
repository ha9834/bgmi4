package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes2.dex */
public final class zzdkb implements zzdbp {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f3565a = new byte[0];
    private final ECPrivateKey b;
    private final zzdkd c;
    private final String d;
    private final byte[] e;
    private final zzdkv f;
    private final zzdka g;

    public zzdkb(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzdkv zzdkvVar, zzdka zzdkaVar) throws GeneralSecurityException {
        this.b = eCPrivateKey;
        this.c = new zzdkd(eCPrivateKey);
        this.e = bArr;
        this.d = str;
        this.f = zzdkvVar;
        this.g = zzdkaVar;
    }
}
