package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcxx {

    /* renamed from: a */
    private zzxz f3495a;
    private zzyd b;
    private zzzy c;
    private String d;
    private zzacd e;
    private boolean f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private zzady i;
    private PublisherAdViewOptions j;
    private zzzs k;
    private String l;
    private String m;
    private zzaiy o;
    private int n = 1;
    public final Set<String> zzglj = new HashSet();

    public final zzcxx zzg(zzxz zzxzVar) {
        this.f3495a = zzxzVar;
        return this;
    }

    public final zzxz zzamo() {
        return this.f3495a;
    }

    public final zzcxx zzd(zzyd zzydVar) {
        this.b = zzydVar;
        return this;
    }

    public final zzyd zzpn() {
        return this.b;
    }

    public final zzcxx zzd(zzzy zzzyVar) {
        this.c = zzzyVar;
        return this;
    }

    public final zzcxx zzft(String str) {
        this.d = str;
        return this;
    }

    public final String zzamp() {
        return this.d;
    }

    public final zzcxx zzc(zzacd zzacdVar) {
        this.e = zzacdVar;
        return this;
    }

    public final zzcxx zzbc(boolean z) {
        this.f = z;
        return this;
    }

    public final zzcxx zzdp(int i) {
        this.n = i;
        return this;
    }

    public final zzcxx zzb(ArrayList<String> arrayList) {
        this.g = arrayList;
        return this;
    }

    public final zzcxx zzc(ArrayList<String> arrayList) {
        this.h = arrayList;
        return this;
    }

    public final zzcxx zzb(zzady zzadyVar) {
        this.i = zzadyVar;
        return this;
    }

    public final zzcxx zzb(zzaiy zzaiyVar) {
        this.o = zzaiyVar;
        this.e = new zzacd(false, true, false);
        return this;
    }

    public final zzcxx zzfu(String str) {
        this.l = str;
        return this;
    }

    public final zzcxx zzfv(String str) {
        this.m = str;
        return this;
    }

    public final zzcxx zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.j = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.f = publisherAdViewOptions.getManualImpressionsEnabled();
            this.k = publisherAdViewOptions.zzkt();
        }
        return this;
    }

    public final zzcxv zzamq() {
        Preconditions.checkNotNull(this.d, "ad unit must not be null");
        Preconditions.checkNotNull(this.b, "ad size must not be null");
        Preconditions.checkNotNull(this.f3495a, "ad request must not be null");
        return new zzcxv(this);
    }
}
