package com.google.android.gms.analytics;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class zzj<T extends zzj> {

    /* renamed from: a, reason: collision with root package name */
    protected final zzg f1207a;
    private final zzk b;
    private final List<zzh> c;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public zzj(zzk zzkVar, Clock clock) {
        Preconditions.checkNotNull(zzkVar);
        this.b = zzkVar;
        this.c = new ArrayList();
        zzg zzgVar = new zzg(this, clock);
        zzgVar.d();
        this.f1207a = zzgVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzg zzgVar) {
    }

    public zzg zzac() {
        zzg zzai = this.f1207a.zzai();
        b(zzai);
        return zzai;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(zzg zzgVar) {
        Iterator<zzh> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().zza(this, zzgVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzk b() {
        return this.b;
    }
}
