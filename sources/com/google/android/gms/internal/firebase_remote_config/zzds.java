package com.google.android.gms.internal.firebase_remote_config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzds {

    /* renamed from: a, reason: collision with root package name */
    private final zzdj f4154a;
    private final boolean b;
    private final ag c;
    private final int d;

    private zzds(ag agVar) {
        this(agVar, false, z.f4112a, Integer.MAX_VALUE);
    }

    private zzds(ag agVar, boolean z, zzdj zzdjVar, int i) {
        this.c = agVar;
        this.b = false;
        this.f4154a = zzdjVar;
        this.d = Integer.MAX_VALUE;
    }

    public static zzds zza(zzdj zzdjVar) {
        zzdt.checkNotNull(zzdjVar);
        return new zzds(new af(zzdjVar));
    }

    public final List<String> zza(CharSequence charSequence) {
        zzdt.checkNotNull(charSequence);
        Iterator<String> a2 = this.c.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (a2.hasNext()) {
            arrayList.add(a2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
