package com.google.android.gms.internal.ads;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzdsz extends zzdtc {

    /* renamed from: a, reason: collision with root package name */
    private Logger f3615a;

    public zzdsz(String str) {
        this.f3615a = Logger.getLogger(str);
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final void zzhc(String str) {
        this.f3615a.logp(Level.FINE, "com.googlecode.mp4parser.util.JuliLogger", "logDebug", str);
    }
}
