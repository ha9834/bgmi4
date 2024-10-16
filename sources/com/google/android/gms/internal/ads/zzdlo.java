package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public final class zzdlo {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<SecureRandom> f3578a = new aec();

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom b() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzff(int i) {
        byte[] bArr = new byte[i];
        f3578a.get().nextBytes(bArr);
        return bArr;
    }
}
