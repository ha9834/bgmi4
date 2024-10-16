package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzalu<I, O> implements zzalj<I, O> {

    /* renamed from: a, reason: collision with root package name */
    private final zzall<O> f2753a;
    private final zzalm<I> b;
    private final zzakh c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalu(zzakh zzakhVar, String str, zzalm<I> zzalmVar, zzall<O> zzallVar) {
        this.c = zzakhVar;
        this.d = str;
        this.b = zzalmVar;
        this.f2753a = zzallVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final zzbbh<O> zzi(I i) {
        zzbbr zzbbrVar = new zzbbr();
        zzakw zzb = this.c.zzb(null);
        zzb.zza(new cg(this, zzb, i, zzbbrVar), new ch(this, zzbbrVar, zzb));
        return zzbbrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzakw zzakwVar, zzalf zzalfVar, I i, zzbbr<O> zzbbrVar) {
        try {
            zzk.zzlg();
            String zzwb = zzaxi.zzwb();
            zzagz.zzdae.zza(zzwb, new ci(this, zzakwVar, zzbbrVar));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzwb);
            jSONObject.put("args", this.b.zzj(i));
            zzalfVar.zzb(this.d, jSONObject);
        } catch (Exception e) {
            try {
                zzbbrVar.setException(e);
                zzawz.zzc("Unable to invokeJavascript", e);
            } finally {
                zzakwVar.release();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh<O> zzf(@Nullable I i) throws Exception {
        return zzi(i);
    }
}
