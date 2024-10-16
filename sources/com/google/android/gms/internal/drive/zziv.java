package com.google.android.gms.internal.drive;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zziv {

    /* renamed from: a, reason: collision with root package name */
    protected static final Charset f3999a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    private static final Object c = new Object();

    public static void zza(zzir zzirVar, zzir zzirVar2) {
        if (zzirVar.f3996a != null) {
            zzirVar2.f3996a = (zzit) zzirVar.f3996a.clone();
        }
    }
}
