package com.google.android.gms.internal.ads;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
final class un implements Runnable {
    private un() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            tr.a(MessageDigest.getInstance(Constants.MD5));
        } catch (NoSuchAlgorithmException unused) {
        } finally {
            tr.f2525a.countDown();
        }
    }
}
