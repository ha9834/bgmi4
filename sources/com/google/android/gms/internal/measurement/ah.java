package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzz;

/* loaded from: classes2.dex */
final class ah extends zzz.b {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ zzz.c d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(zzz.c cVar, Activity activity) {
        super(zzz.this);
        this.d = cVar;
        this.c = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = zzz.this.r;
        zzkVar.onActivityStopped(ObjectWrapper.wrap(this.c), this.b);
    }
}
