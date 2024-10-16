package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ab extends zzz.b {
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ boolean f;
    private final /* synthetic */ zzz g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(zzz zzzVar, String str, String str2, Object obj, boolean z) {
        super(zzzVar);
        this.g = zzzVar;
        this.c = str;
        this.d = str2;
        this.e = obj;
        this.f = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzz.b
    final void a() throws RemoteException {
        zzk zzkVar;
        zzkVar = this.g.r;
        zzkVar.setUserProperty(this.c, this.d, ObjectWrapper.wrap(this.e), this.f, this.f4645a);
    }
}
