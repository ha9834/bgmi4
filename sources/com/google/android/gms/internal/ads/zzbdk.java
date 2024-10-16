package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@TargetApi(16)
/* loaded from: classes.dex */
public final class zzbdk {

    /* renamed from: a */
    @VisibleForTesting
    private static int f2861a;

    @VisibleForTesting
    private static int b;
    private zzge c;
    private zzhd d;
    private zzgn e;
    private zzbdo f;
    private final is g = new is(this);
    private final it h = new it(this);
    private final ir i = new ir(this);

    public zzbdk() {
        Preconditions.checkMainThread("ExoPlayer must be created on the main UI thread.");
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
            sb.append("AdExoPlayerHelper initialize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
        f2861a++;
        this.c = zzgg.zzn(2);
        this.c.zza(this.g);
    }

    public static int zzyp() {
        return f2861a;
    }

    public static int zzyq() {
        return b;
    }

    public final boolean zza(zzhn zzhnVar) {
        if (this.c == null) {
            return false;
        }
        this.d = new zzhd(zzhnVar, 1, 0L, zzaxi.zzdvv, this.h, -1);
        this.e = new zzgn(zzhnVar, zzaxi.zzdvv, this.i);
        this.c.zza(this.d, this.e);
        b++;
        return true;
    }

    public final void zzyr() {
        zzge zzgeVar = this.c;
        if (zzgeVar != null) {
            zzgeVar.release();
            this.c = null;
            b--;
        }
    }

    public final synchronized void zza(zzbdo zzbdoVar) {
        this.f = zzbdoVar;
    }

    public final synchronized void removeListener() {
        this.f = null;
    }

    public final synchronized void a(String str, String str2) {
        if (this.f != null) {
            this.f.zzl(str, str2);
        }
    }

    public final zzge zzys() {
        return this.c;
    }

    public final zzhd zzyt() {
        return this.d;
    }

    public final zzgn zzyu() {
        return this.e;
    }

    public final void zza(zzgh zzghVar, zzhh zzhhVar, zzgq zzgqVar) {
        this.g.a(zzghVar);
        this.h.a(zzhhVar);
        this.i.a(zzgqVar);
    }

    public final void finalize() throws Throwable {
        f2861a--;
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("AdExoPlayerHelper finalize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
    }
}
