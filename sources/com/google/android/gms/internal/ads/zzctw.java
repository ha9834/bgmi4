package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzctw implements zzcva<zzctv> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3435a;
    private final Context b;
    private final Set<String> c;

    public zzctw(zzbbl zzbblVar, Context context, Set<String> set) {
        this.f3435a = zzbblVar;
        this.b = context;
        this.c = set;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzctv> zzalm() {
        return this.f3435a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yx

            /* renamed from: a, reason: collision with root package name */
            private final zzctw f2650a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2650a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2650a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzctv a() throws Exception {
        boolean b;
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
            b = zzctv.b(this.c);
            if (b) {
                return new zzctv(zzk.zzlv().getVersion(this.b));
            }
        }
        return new zzctv(null);
    }
}
