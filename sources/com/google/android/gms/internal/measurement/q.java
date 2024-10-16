package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q extends zzz.b {
    private final /* synthetic */ String d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ zzz h;
    private final /* synthetic */ int c = 5;
    private final /* synthetic */ Object f = null;
    private final /* synthetic */ Object g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(zzz zzzVar, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.h = zzzVar;
        this.d = str;
        this.e = obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.h.r;
        zzkVar.logHealthData(this.c, this.d, ObjectWrapper.wrap(this.e), ObjectWrapper.wrap(this.f), ObjectWrapper.wrap(this.g));
    }
}
