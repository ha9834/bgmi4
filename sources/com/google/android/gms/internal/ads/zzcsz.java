package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsz implements zzcva<zzcsy> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3421a;
    private final zzcxv b;

    public zzcsz(zzbbl zzbblVar, zzcxv zzcxvVar) {
        this.f3421a = zzbblVar;
        this.b = zzcxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsy> zzalm() {
        return this.f3421a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yp

            /* renamed from: a, reason: collision with root package name */
            private final zzcsz f2642a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2642a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2642a.a();
            }
        });
    }

    private static int a(zzzy zzzyVar) {
        long value;
        if (zzzyVar != null) {
            try {
                value = zzzyVar.getValue();
            } catch (RemoteException unused) {
                zzawz.zzep("Cannot get correlation id, default to 0.");
            }
            return (int) value;
        }
        value = 0;
        return (int) value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcsy a() throws Exception {
        return new zzcsy(a(this.b.zzgkz), this.b.zzghg);
    }
}
