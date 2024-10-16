package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzawt {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private BigInteger f2818a = BigInteger.ONE;

    @GuardedBy("this")
    private String b = "0";

    public final synchronized String zzvg() {
        String bigInteger;
        bigInteger = this.f2818a.toString();
        this.f2818a = this.f2818a.add(BigInteger.ONE);
        this.b = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzvh() {
        return this.b;
    }
}
