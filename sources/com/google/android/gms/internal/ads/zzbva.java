package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzbva extends zzbts<zzue> implements zzue {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    private Map<View, zzua> f3067a;
    private final Context b;
    private final zzcxm c;

    public zzbva(Context context, Set<zzbuz<zzue>> set, zzcxm zzcxmVar) {
        super(set);
        this.f3067a = new WeakHashMap(1);
        this.b = context;
        this.c = zzcxmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final synchronized void zza(final zzud zzudVar) {
        a(new zzbtu(zzudVar) { // from class: com.google.android.gms.internal.ads.pj

            /* renamed from: a, reason: collision with root package name */
            private final zzud f2415a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2415a = zzudVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void zzr(Object obj) {
                ((zzue) obj).zza(this.f2415a);
            }
        });
    }

    public final synchronized void zzq(View view) {
        zzua zzuaVar = this.f3067a.get(view);
        if (zzuaVar == null) {
            zzuaVar = new zzua(this.b, view);
            zzuaVar.zza(this);
            this.f3067a.put(view, zzuaVar);
        }
        if (this.c != null && this.c.zzdol) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqk)).booleanValue()) {
                zzuaVar.zzes(((Long) zzyt.zzpe().zzd(zzacu.zzcqj)).longValue());
                return;
            }
        }
        zzuaVar.zzmk();
    }

    public final synchronized void zzr(View view) {
        if (this.f3067a.containsKey(view)) {
            this.f3067a.get(view).zzb(this);
            this.f3067a.remove(view);
        }
    }
}
