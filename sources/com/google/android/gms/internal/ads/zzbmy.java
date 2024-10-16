package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbmy implements zzue {

    /* renamed from: a, reason: collision with root package name */
    private zzbgz f2945a;
    private final Executor b;
    private final zzbml c;
    private final Clock d;
    private boolean e = false;
    private boolean f = false;
    private zzbmp g = new zzbmp();

    public zzbmy(Executor executor, zzbml zzbmlVar, Clock clock) {
        this.b = executor;
        this.c = zzbmlVar;
        this.d = clock;
    }

    private final void a() {
        try {
            final JSONObject zzj = this.c.zzj(this.g);
            if (this.f2945a != null) {
                this.b.execute(new Runnable(this, zzj) { // from class: com.google.android.gms.internal.ads.nf

                    /* renamed from: a, reason: collision with root package name */
                    private final zzbmy f2367a;
                    private final JSONObject b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2367a = this;
                        this.b = zzj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2367a.a(this.b);
                    }
                });
            }
        } catch (JSONException e) {
            zzawz.zza("Failed to call video active view js", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void zza(zzud zzudVar) {
        this.g.zzbtk = this.f ? false : zzudVar.zzbtk;
        this.g.timestamp = this.d.elapsedRealtime();
        this.g.zzfge = zzudVar;
        if (this.e) {
            a();
        }
    }

    public final void zzg(zzbgz zzbgzVar) {
        this.f2945a = zzbgzVar;
    }

    public final void disable() {
        this.e = false;
    }

    public final void enable() {
        this.e = true;
        a();
    }

    public final void zzax(boolean z) {
        this.f = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(JSONObject jSONObject) {
        this.f2945a.zzb("AFMA_updateActiveView", jSONObject);
    }
}
