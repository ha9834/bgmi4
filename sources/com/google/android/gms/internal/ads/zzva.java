package com.google.android.gms.internal.ads;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzva {
    private static MessageDigest b;

    /* renamed from: a, reason: collision with root package name */
    protected Object f3757a = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzbl(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final MessageDigest a() {
        synchronized (this.f3757a) {
            if (b != null) {
                return b;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    b = MessageDigest.getInstance(Constants.MD5);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return b;
        }
    }
}
