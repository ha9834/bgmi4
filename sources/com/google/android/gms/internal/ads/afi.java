package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
final class afi extends afh<Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final boolean a(zzdpk zzdpkVar) {
        return zzdpkVar instanceof zzdob.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final afk<Object> a(Object obj) {
        return ((zzdob.zzc) obj).zzhhj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final afk<Object> b(Object obj) {
        zzdob.zzc zzcVar = (zzdob.zzc) obj;
        if (zzcVar.zzhhj.d()) {
            zzcVar.zzhhj = (afk) zzcVar.zzhhj.clone();
        }
        return zzcVar.zzhhj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final void c(Object obj) {
        a(obj).c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final <UT, UB> UB a(agw agwVar, Object obj, zzdno zzdnoVar, afk<Object> afkVar, UB ub, aho<UT, UB> ahoVar) throws IOException {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final void a(aib aibVar, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final Object a(zzdno zzdnoVar, zzdpk zzdpkVar, int i) {
        return zzdnoVar.zza(zzdpkVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final void a(agw agwVar, Object obj, zzdno zzdnoVar, afk<Object> afkVar) throws IOException {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afh
    public final void a(zzdmr zzdmrVar, Object obj, zzdno zzdnoVar, afk<Object> afkVar) throws IOException {
        throw new NoSuchMethodError();
    }
}
