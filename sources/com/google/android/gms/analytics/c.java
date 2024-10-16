package com.google.android.gms.analytics;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzg f1198a;
    private final /* synthetic */ zzk b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzk zzkVar, zzg zzgVar) {
        this.b = zzkVar;
        this.f1198a = zzgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        this.f1198a.b().a(this.f1198a);
        list = this.b.c;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzn) it.next()).zza(this.f1198a);
        }
        zzk zzkVar = this.b;
        zzk.b(this.f1198a);
    }
}
