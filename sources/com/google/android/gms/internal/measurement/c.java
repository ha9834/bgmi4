package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c extends zzz.b {
    private final /* synthetic */ Activity c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;
    private final /* synthetic */ zzz f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(zzz zzzVar, Activity activity, String str, String str2) {
        super(zzzVar);
        this.f = zzzVar;
        this.c = activity;
        this.d = str;
        this.e = str2;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.f.r;
        zzkVar.setCurrentScreen(ObjectWrapper.wrap(this.c), this.d, this.e, this.f4645a);
    }
}
