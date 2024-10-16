package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@zzard
/* loaded from: classes2.dex */
public final class zzawu implements zzut {
    private final zzaxb b;

    @VisibleForTesting
    private final zzawr d;

    /* renamed from: a, reason: collision with root package name */
    private final Object f2819a = new Object();

    @VisibleForTesting
    private final HashSet<zzawj> e = new HashSet<>();

    @VisibleForTesting
    private final HashSet<Object> f = new HashSet<>();
    private final zzawt c = new zzawt();

    public zzawu(String str, zzaxb zzaxbVar) {
        this.d = new zzawr(str, zzaxbVar);
        this.b = zzaxbVar;
    }

    public final void zzb(zzawj zzawjVar) {
        synchronized (this.f2819a) {
            this.e.add(zzawjVar);
        }
    }

    public final void zzb(HashSet<zzawj> hashSet) {
        synchronized (this.f2819a) {
            this.e.addAll(hashSet);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zza(Context context, zzaws zzawsVar) {
        HashSet<zzawj> hashSet = new HashSet<>();
        synchronized (this.f2819a) {
            hashSet.addAll(this.e);
            this.e.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle(Constants.JumpUrlConstants.SRC_TYPE_APP, this.d.zzn(context, this.c.zzvh()));
        Bundle bundle2 = new Bundle();
        Iterator<Object> it = this.f.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<zzawj> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBundle());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzawsVar.zza(hashSet);
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void zzp(boolean z) {
        long currentTimeMillis = zzk.zzln().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.b.zzvs() > ((Long) zzyt.zzpe().zzd(zzacu.zzcoy)).longValue()) {
                this.d.f2817a = -1;
                return;
            } else {
                this.d.f2817a = this.b.zzvt();
                return;
            }
        }
        this.b.zzfc(currentTimeMillis);
        this.b.zzcu(this.d.f2817a);
    }

    public final void zzuk() {
        synchronized (this.f2819a) {
            this.d.zzuk();
        }
    }

    public final void zzuj() {
        synchronized (this.f2819a) {
            this.d.zzuj();
        }
    }

    public final void zza(zzxz zzxzVar, long j) {
        synchronized (this.f2819a) {
            this.d.zza(zzxzVar, j);
        }
    }

    public final zzawj zza(Clock clock, String str) {
        return new zzawj(clock, this, this.c.zzvg(), str);
    }
}
