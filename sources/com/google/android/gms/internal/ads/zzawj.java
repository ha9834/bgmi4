package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzawj {

    /* renamed from: a, reason: collision with root package name */
    private final Clock f2814a;
    private final zzawu b;
    private final String e;
    private final String f;
    private final Object d = new Object();

    @GuardedBy("lock")
    private long g = -1;

    @GuardedBy("lock")
    private long h = -1;

    @GuardedBy("lock")
    private boolean i = false;

    @GuardedBy("lock")
    private long j = -1;

    @GuardedBy("lock")
    private long k = 0;

    @GuardedBy("lock")
    private long l = -1;

    @GuardedBy("lock")
    private long m = -1;

    @GuardedBy("lock")
    private final LinkedList<fd> c = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawj(Clock clock, zzawu zzawuVar, String str, String str2) {
        this.f2814a = clock;
        this.b = zzawuVar;
        this.e = str;
        this.f = str2;
    }

    public final void zze(zzxz zzxzVar) {
        synchronized (this.d) {
            this.l = this.f2814a.elapsedRealtime();
            this.b.zza(zzxzVar, this.l);
        }
    }

    public final void zzfb(long j) {
        synchronized (this.d) {
            this.m = j;
            if (this.m != -1) {
                this.b.zzb(this);
            }
        }
    }

    public final void zzuj() {
        synchronized (this.d) {
            if (this.m != -1 && this.h == -1) {
                this.h = this.f2814a.elapsedRealtime();
                this.b.zzb(this);
            }
            this.b.zzuj();
        }
    }

    public final void zzuk() {
        synchronized (this.d) {
            if (this.m != -1) {
                fd fdVar = new fd(this);
                fdVar.c();
                this.c.add(fdVar);
                this.k++;
                this.b.zzuk();
                this.b.zzb(this);
            }
        }
    }

    public final void zzul() {
        synchronized (this.d) {
            if (this.m != -1 && !this.c.isEmpty()) {
                fd last = this.c.getLast();
                if (last.a() == -1) {
                    last.b();
                    this.b.zzb(this);
                }
            }
        }
    }

    public final void zzah(boolean z) {
        synchronized (this.d) {
            if (this.m != -1) {
                this.j = this.f2814a.elapsedRealtime();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.d) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.e);
            bundle.putString("slotid", this.f);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.l);
            bundle.putLong("tresponse", this.m);
            bundle.putLong("timp", this.h);
            bundle.putLong("tload", this.j);
            bundle.putLong("pcc", this.k);
            bundle.putLong("tfetch", this.g);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<fd> it = this.c.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().d());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzum() {
        return this.e;
    }
}
