package com.google.android.gms.internal.ads;

import android.os.RemoteException;

@zzard
/* loaded from: classes2.dex */
public final class zzabj extends zzaal {

    /* renamed from: a, reason: collision with root package name */
    private final String f2688a;
    private final String b;

    public zzabj(String str, String str2) {
        this.f2688a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final String getDescription() throws RemoteException {
        return this.f2688a;
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final String zzpt() throws RemoteException {
        return this.b;
    }
}
