package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzajy implements zzajq, zzajw {

    /* renamed from: a, reason: collision with root package name */
    private final zzbgz f2743a;
    private final Context b;

    public zzajy(Context context, zzbai zzbaiVar, zzdh zzdhVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzbhj {
        this.b = context;
        zzk.zzlh();
        this.f2743a = zzbhf.zza(context, zzbin.zzabu(), "", false, false, zzdhVar, zzbaiVar, null, null, null, zzwj.zznl());
        this.f2743a.getView().setWillNotDraw(true);
    }

    @Override // com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, Map map) {
        zzajr.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzaji
    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajq
    public final void zzi(String str, String str2) {
        zzajr.zza(this, str, str2);
    }

    private static void a(Runnable runnable) {
        zzyt.zzpa();
        if (zzazt.zzwy()) {
            runnable.run();
        } else {
            zzaxi.zzdvv.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final void zzco(final String str) {
        a(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.bb

            /* renamed from: a, reason: collision with root package name */
            private final zzajy f2066a;
            private final String b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2066a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2066a.a(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzcl(String str) {
        a(new be(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzcm(String str) {
        a(new bf(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zzcn(String str) {
        a(new bg(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zza(String str, zzaho<? super zzalf> zzahoVar) {
        this.f2743a.zza(str, new bh(this, zzahoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, final zzaho<? super zzalf> zzahoVar) {
        this.f2743a.zza(str, new Predicate(zzahoVar) { // from class: com.google.android.gms.internal.ads.bc

            /* renamed from: a, reason: collision with root package name */
            private final zzaho f2067a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2067a = zzahoVar;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzaho zzahoVar2;
                zzaho zzahoVar3 = this.f2067a;
                zzaho zzahoVar4 = (zzaho) obj;
                if (!(zzahoVar4 instanceof bh)) {
                    return false;
                }
                zzahoVar2 = ((bh) zzahoVar4).f2072a;
                return zzahoVar2.equals(zzahoVar3);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void zza(zzajx zzajxVar) {
        zzbii zzaai = this.f2743a.zzaai();
        zzajxVar.getClass();
        zzaai.zza(bd.a(zzajxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final zzalg zzru() {
        return new zzalh(this);
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final void destroy() {
        this.f2743a.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    public final boolean isDestroyed() {
        return this.f2743a.isDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        this.f2743a.zzco(str);
    }
}
