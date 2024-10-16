package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcvy implements zzcva<zzcvx> {

    /* renamed from: a, reason: collision with root package name */
    private final zzasc f3467a;
    private final Context b;
    private final String c;
    private final zzbbl d;

    public zzcvy(@Nullable zzasc zzascVar, Context context, String str, zzbbl zzbblVar) {
        this.f3467a = zzascVar;
        this.b = context;
        this.c = str;
        this.d = zzbblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvx> zzalm() {
        return this.d.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zs

            /* renamed from: a, reason: collision with root package name */
            private final zzcvy f2672a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2672a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2672a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcvx a() throws Exception {
        JSONObject jSONObject = new JSONObject();
        zzasc zzascVar = this.f3467a;
        if (zzascVar != null) {
            zzascVar.zza(this.b, this.c, jSONObject);
        }
        return new zzcvx(jSONObject);
    }
}
