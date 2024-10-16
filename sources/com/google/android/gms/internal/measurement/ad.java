package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzz;

/* loaded from: classes2.dex */
final class ad extends zzz.b {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ Bundle d;
    private final /* synthetic */ zzz.c e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(zzz.c cVar, Activity activity, Bundle bundle) {
        super(zzz.this);
        this.e = cVar;
        this.c = activity;
        this.d = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = zzz.this.r;
        zzkVar.onActivityCreated(ObjectWrapper.wrap(this.c), this.d, this.b);
    }
}
