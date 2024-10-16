package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class zzbtv {

    /* renamed from: a, reason: collision with root package name */
    private final Set<zzbuz<zzxr>> f3044a;
    private final Set<zzbuz<zzbrl>> b;
    private final Set<zzbuz<zzbrw>> c;
    private final Set<zzbuz<zzbsr>> d;
    private final Set<zzbuz<zzbro>> e;
    private final Set<zzbuz<zzbrs>> f;
    private final Set<zzbuz<AdMetadataListener>> g;
    private final Set<zzbuz<AppEventListener>> h;
    private zzbrm i;
    private zzcmu j;

    private zzbtv(zza zzaVar) {
        this.f3044a = zzaVar.f3045a;
        this.c = zzaVar.c;
        this.b = zzaVar.b;
        this.d = zzaVar.d;
        this.e = zzaVar.e;
        this.f = zzaVar.h;
        this.g = zzaVar.f;
        this.h = zzaVar.g;
    }

    /* loaded from: classes2.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private Set<zzbuz<zzxr>> f3045a = new HashSet();
        private Set<zzbuz<zzbrl>> b = new HashSet();
        private Set<zzbuz<zzbrw>> c = new HashSet();
        private Set<zzbuz<zzbsr>> d = new HashSet();
        private Set<zzbuz<zzbro>> e = new HashSet();
        private Set<zzbuz<AdMetadataListener>> f = new HashSet();
        private Set<zzbuz<AppEventListener>> g = new HashSet();
        private Set<zzbuz<zzbrs>> h = new HashSet();

        public final zza zza(zzbrl zzbrlVar, Executor executor) {
            this.b.add(new zzbuz<>(zzbrlVar, executor));
            return this;
        }

        public final zza zza(zzbsr zzbsrVar, Executor executor) {
            this.d.add(new zzbuz<>(zzbsrVar, executor));
            return this;
        }

        public final zza zza(zzbro zzbroVar, Executor executor) {
            this.e.add(new zzbuz<>(zzbroVar, executor));
            return this;
        }

        public final zza zza(zzbrs zzbrsVar, Executor executor) {
            this.h.add(new zzbuz<>(zzbrsVar, executor));
            return this;
        }

        public final zza zza(AdMetadataListener adMetadataListener, Executor executor) {
            this.f.add(new zzbuz<>(adMetadataListener, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.g.add(new zzbuz<>(appEventListener, executor));
            return this;
        }

        public final zza zza(zzzs zzzsVar, Executor executor) {
            if (this.g != null) {
                zzcpy zzcpyVar = new zzcpy();
                zzcpyVar.zzb(zzzsVar);
                this.g.add(new zzbuz<>(zzcpyVar, executor));
            }
            return this;
        }

        public final zza zza(zzxr zzxrVar, Executor executor) {
            this.f3045a.add(new zzbuz<>(zzxrVar, executor));
            return this;
        }

        public final zza zza(zzbrw zzbrwVar, Executor executor) {
            this.c.add(new zzbuz<>(zzbrwVar, executor));
            return this;
        }

        public final zzbtv zzagt() {
            return new zzbtv(this);
        }
    }

    public final Set<zzbuz<zzbrl>> zzagl() {
        return this.b;
    }

    public final Set<zzbuz<zzbsr>> zzagm() {
        return this.d;
    }

    public final Set<zzbuz<zzbro>> zzagn() {
        return this.e;
    }

    public final Set<zzbuz<zzbrs>> zzago() {
        return this.f;
    }

    public final Set<zzbuz<AdMetadataListener>> zzagp() {
        return this.g;
    }

    public final Set<zzbuz<AppEventListener>> zzagq() {
        return this.h;
    }

    public final Set<zzbuz<zzxr>> zzagr() {
        return this.f3044a;
    }

    public final Set<zzbuz<zzbrw>> zzags() {
        return this.c;
    }

    public final zzbrm zzc(Set<zzbuz<zzbro>> set) {
        if (this.i == null) {
            this.i = new zzbrm(set);
        }
        return this.i;
    }

    public final zzcmu zza(Clock clock) {
        if (this.j == null) {
            this.j = new zzcmu(clock);
        }
        return this.j;
    }
}
