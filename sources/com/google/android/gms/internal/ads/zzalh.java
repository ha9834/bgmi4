package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzalh implements zzajq, zzalg {

    /* renamed from: a, reason: collision with root package name */
    private final zzalf f2749a;
    private final HashSet<AbstractMap.SimpleEntry<String, zzaho<? super zzalf>>> b = new HashSet<>();

    public zzalh(zzalf zzalfVar) {
        this.f2749a = zzalfVar;
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

    @Override // com.google.android.gms.internal.ads.zzajq, com.google.android.gms.internal.ads.zzakg
    public final void zzco(String str) {
        this.f2749a.zzco(str);
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zza(String str, zzaho<? super zzalf> zzahoVar) {
        this.f2749a.zza(str, zzahoVar);
        this.b.add(new AbstractMap.SimpleEntry<>(str, zzahoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, zzaho<? super zzalf> zzahoVar) {
        this.f2749a.zzb(str, zzahoVar);
        this.b.remove(new AbstractMap.SimpleEntry(str, zzahoVar));
    }

    @Override // com.google.android.gms.internal.ads.zzalg
    public final void zzsb() {
        Iterator<AbstractMap.SimpleEntry<String, zzaho<? super zzalf>>> it = this.b.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzaho<? super zzalf>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzawz.zzds(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.f2749a.zzb(next.getKey(), next.getValue());
        }
        this.b.clear();
    }
}
