package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
final class bq extends bp<Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final boolean a(zzsk zzskVar) {
        return zzskVar instanceof zzrc.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final bs<Object> a(Object obj) {
        return ((zzrc.zzc) obj).zzbaq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final bs<Object> b(Object obj) {
        zzrc.zzc zzcVar = (zzrc.zzc) obj;
        if (zzcVar.zzbaq.c()) {
            zzcVar.zzbaq = (bs) zzcVar.zzbaq.clone();
        }
        return zzcVar.zzbaq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final void c(Object obj) {
        a(obj).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final <UT, UB> UB a(cz czVar, Object obj, zzqp zzqpVar, bs<Object> bsVar, UB ub, dr<UT, UB> drVar) throws IOException {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final void a(ed edVar, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final Object a(zzqp zzqpVar, zzsk zzskVar, int i) {
        return zzqpVar.zza(zzskVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final void a(cz czVar, Object obj, zzqp zzqpVar, bs<Object> bsVar) throws IOException {
        throw new NoSuchMethodError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.bp
    public final void a(zzps zzpsVar, Object obj, zzqp zzqpVar, bs<Object> bsVar) throws IOException {
        throw new NoSuchMethodError();
    }
}
