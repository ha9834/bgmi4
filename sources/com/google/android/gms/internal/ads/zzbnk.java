package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* loaded from: classes2.dex */
public class zzbnk {

    /* renamed from: a, reason: collision with root package name */
    private final zzbpb f2951a;
    private final View b;
    private final zzcxn c;
    private final zzbgz d;

    public zzbnk(View view, zzbgz zzbgzVar, zzbpb zzbpbVar, zzcxn zzcxnVar) {
        this.b = view;
        this.d = zzbgzVar;
        this.f2951a = zzbpbVar;
        this.c = zzcxnVar;
    }

    public final zzbgz zzafn() {
        return this.d;
    }

    public final View zzafi() {
        return this.b;
    }

    public final zzbpb zzafo() {
        return this.f2951a;
    }

    public final zzcxn zzafp() {
        return this.c;
    }

    public zzbso zza(Set<zzbuz<zzbsr>> set) {
        return new zzbso(set);
    }
}
