package com.google.android.gms.internal.firebase_remote_config;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class er {

    /* renamed from: a, reason: collision with root package name */
    final zzbn f4095a;
    final StringBuilder b;
    final zzbr c;
    final List<Type> d;

    public er(zzw zzwVar, StringBuilder sb) {
        Class<?> cls = zzwVar.getClass();
        this.d = Arrays.asList(cls);
        this.c = zzbr.zza(cls, true);
        this.b = sb;
        this.f4095a = new zzbn(zzwVar);
    }
}
