package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsp implements zzcva<ym> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3415a;
    private final zzbbl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsp(Context context, zzbbl zzbblVar) {
        this.f3415a = context;
        this.b = zzbblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<ym> zzalm() {
        return this.b.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yk

            /* renamed from: a, reason: collision with root package name */
            private final zzcsp f2638a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2638a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2638a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ym a() throws Exception {
        zzk.zzlg();
        String zzav = zzaxi.zzav(this.f3415a);
        zzk.zzlg();
        return new ym(zzav, zzaxi.zzaw(this.f3415a));
    }
}
