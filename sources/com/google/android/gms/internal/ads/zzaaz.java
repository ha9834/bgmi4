package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzaaz {

    /* renamed from: a, reason: collision with root package name */
    private final Date f2683a;
    private final String b;
    private final int c;
    private final Set<String> d;
    private final Location e;
    private final boolean f;
    private final Bundle g;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> h;
    private final String i;
    private final String j;
    private final SearchAdRequest k;
    private final int l;
    private final Set<String> m;
    private final Bundle n;
    private final Set<String> o;
    private final boolean p;
    private final zzdak q;
    private final int r;
    private final String s;

    public zzaaz(zzaba zzabaVar) {
        this(zzabaVar, null);
    }

    public zzaaz(zzaba zzabaVar, SearchAdRequest searchAdRequest) {
        Date date;
        String str;
        int i;
        HashSet hashSet;
        Location location;
        boolean z;
        Bundle bundle;
        HashMap hashMap;
        String str2;
        String str3;
        int i2;
        HashSet hashSet2;
        Bundle bundle2;
        HashSet hashSet3;
        boolean z2;
        int i3;
        String str4;
        date = zzabaVar.g;
        this.f2683a = date;
        str = zzabaVar.h;
        this.b = str;
        i = zzabaVar.i;
        this.c = i;
        hashSet = zzabaVar.f2684a;
        this.d = Collections.unmodifiableSet(hashSet);
        location = zzabaVar.j;
        this.e = location;
        z = zzabaVar.k;
        this.f = z;
        bundle = zzabaVar.b;
        this.g = bundle;
        hashMap = zzabaVar.c;
        this.h = Collections.unmodifiableMap(hashMap);
        str2 = zzabaVar.l;
        this.i = str2;
        str3 = zzabaVar.m;
        this.j = str3;
        this.k = searchAdRequest;
        i2 = zzabaVar.n;
        this.l = i2;
        hashSet2 = zzabaVar.d;
        this.m = Collections.unmodifiableSet(hashSet2);
        bundle2 = zzabaVar.e;
        this.n = bundle2;
        hashSet3 = zzabaVar.f;
        this.o = Collections.unmodifiableSet(hashSet3);
        z2 = zzabaVar.o;
        this.p = z2;
        this.q = null;
        i3 = zzabaVar.p;
        this.r = i3;
        str4 = zzabaVar.q;
        this.s = str4;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.f2683a;
    }

    public final String getContentUrl() {
        return this.b;
    }

    @Deprecated
    public final int getGender() {
        return this.c;
    }

    public final Set<String> getKeywords() {
        return this.d;
    }

    public final Location getLocation() {
        return this.e;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.f;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.h.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.g.getBundle(cls.getName());
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.g.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final String getPublisherProvidedId() {
        return this.i;
    }

    public final String zzpy() {
        return this.j;
    }

    public final SearchAdRequest zzpz() {
        return this.k;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.m;
        zzyt.zzpa();
        return set.contains(zzazt.zzbe(context));
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqa() {
        return this.h;
    }

    public final Bundle zzqb() {
        return this.g;
    }

    public final int zzqc() {
        return this.l;
    }

    public final Bundle getCustomTargeting() {
        return this.n;
    }

    public final Set<String> zzqd() {
        return this.o;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.p;
    }

    public final int zzqe() {
        return this.r;
    }

    public final String getMaxAdContentRating() {
        return this.s;
    }
}
