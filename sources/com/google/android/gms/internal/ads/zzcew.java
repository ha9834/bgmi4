package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcew implements zzdti<Set<zzbuz<zzczz>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<String> f3218a;
    private final zzdtu<Context> b;
    private final zzdtu<Executor> c;
    private final zzdtu<Map<zzczs, zzcez>> d;

    public zzcew(zzdtu<String> zzdtuVar, zzdtu<Context> zzdtuVar2, zzdtu<Executor> zzdtuVar3, zzdtu<Map<zzczs, zzcez>> zzdtuVar4) {
        this.f3218a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set emptySet;
        final String str = this.f3218a.get();
        Context context = this.b.get();
        Executor executor = this.c.get();
        Map<zzczs, zzcez> map = this.d.get();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue()) {
            zzwj zzwjVar = new zzwj(new zzwo(context));
            zzwjVar.zza(new zzwk(str) { // from class: com.google.android.gms.internal.ads.sq

                /* renamed from: a, reason: collision with root package name */
                private final String f2497a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2497a = str;
                }

                @Override // com.google.android.gms.internal.ads.zzwk
                public final void zza(zzxn zzxnVar) {
                    zzxnVar.zzcfd = this.f2497a;
                }
            });
            emptySet = Collections.singleton(new zzbuz(new zzcex(zzwjVar, map), executor));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzdto.zza(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
