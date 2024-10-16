package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class zzaba {
    private Date g;
    private String h;
    private Location j;
    private String l;
    private String m;
    private boolean o;
    private String q;

    /* renamed from: a, reason: collision with root package name */
    private final HashSet<String> f2684a = new HashSet<>();
    private final Bundle b = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> c = new HashMap<>();
    private final HashSet<String> d = new HashSet<>();
    private final Bundle e = new Bundle();
    private final HashSet<String> f = new HashSet<>();
    private int i = -1;
    private boolean k = false;
    private int n = -1;
    private int p = -1;

    public final void zzbw(String str) {
        this.f2684a.add(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.c.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.b.putBundle(cls.getName(), bundle);
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.b.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzbx(String str) {
        this.d.add(str);
    }

    public final void zzby(String str) {
        this.d.remove(str);
    }

    @Deprecated
    public final void zza(Date date) {
        this.g = date;
    }

    public final void zzbz(String str) {
        this.h = str;
    }

    @Deprecated
    public final void zzcn(int i) {
        this.i = i;
    }

    public final void zza(Location location) {
        this.j = location;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.k = z;
    }

    public final void zzca(String str) {
        this.l = str;
    }

    public final void zzcb(String str) {
        this.m = str;
    }

    public final void zzt(boolean z) {
        this.n = z ? 1 : 0;
    }

    public final void zze(String str, String str2) {
        this.e.putString(str, str2);
    }

    public final void zzcc(String str) {
        this.f.add(str);
    }

    @Deprecated
    public final void zzu(boolean z) {
        this.o = z;
    }

    public final void zzco(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.p = i;
        }
    }

    public final void zzcd(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.q = str;
        }
    }
}
