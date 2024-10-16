package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcef implements zzdti<zzwj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3202a;
    private final zzdtu<String> b;
    private final zzdtu<zzbai> c;
    private final zzdtu<Integer> d;
    private final zzdtu<String> e;

    private zzcef(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<Integer> zzdtuVar4, zzdtu<String> zzdtuVar5) {
        this.f3202a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzcef zze(zzdtu<Context> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<Integer> zzdtuVar4, zzdtu<String> zzdtuVar5) {
        return new zzcef(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Context context = this.f3202a.get();
        final String str = this.b.get();
        zzbai zzbaiVar = this.c.get();
        final int intValue = this.d.get().intValue();
        final String str2 = this.e.get();
        zzwj zzwjVar = new zzwj(new zzwo(context));
        final zzxo zzxoVar = new zzxo();
        zzxoVar.zzcfo = Integer.valueOf(zzbaiVar.zzdzc);
        zzxoVar.zzcfp = Integer.valueOf(zzbaiVar.zzdzd);
        zzxoVar.zzcfq = Integer.valueOf(zzbaiVar.zzdze ? 0 : 2);
        zzwjVar.zza(new zzwk(intValue, str, zzxoVar, str2) { // from class: com.google.android.gms.internal.ads.so

            /* renamed from: a, reason: collision with root package name */
            private final int f2495a;
            private final String b;
            private final zzxo c;
            private final String d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2495a = intValue;
                this.b = str;
                this.c = zzxoVar;
                this.d = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void zza(zzxn zzxnVar) {
                int i = this.f2495a;
                String str3 = this.b;
                zzxo zzxoVar2 = this.c;
                String str4 = this.d;
                zzxnVar.zzcfl.zzcee = Integer.valueOf(i);
                zzxnVar.zzcfi.zzceu = str3;
                zzxnVar.zzcfi.zzcex = zzxoVar2;
                zzxnVar.zzcfd = str4;
            }
        });
        return (zzwj) zzdto.zza(zzwjVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
