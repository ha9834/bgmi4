package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcue implements zzcva<zzcud> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3441a;
    private final Bundle b;

    public zzcue(zzbbl zzbblVar, Bundle bundle) {
        this.f3441a = zzbblVar;
        this.b = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcud> zzalm() {
        return this.f3441a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.za

            /* renamed from: a, reason: collision with root package name */
            private final zzcue f2654a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2654a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2654a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcud a() throws Exception {
        return new zzcud(this.b);
    }
}
