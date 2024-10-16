package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
final class aec extends ThreadLocal<SecureRandom> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SecureRandom initialValue() {
        SecureRandom b;
        b = zzdlo.b();
        return b;
    }
}
