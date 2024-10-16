package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzdjp {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f3564a = Charset.forName("UTF-8");

    public static byte[] decode(String str) {
        byte[] bytes = str.getBytes(f3564a);
        int length = bytes.length;
        adw adwVar = new adw(2, new byte[(length * 3) / 4]);
        if (!adwVar.a(bytes, 0, length, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        if (adwVar.b == adwVar.f1822a.length) {
            return adwVar.f1822a;
        }
        byte[] bArr = new byte[adwVar.b];
        System.arraycopy(adwVar.f1822a, 0, bArr, 0, adwVar.b);
        return bArr;
    }
}
