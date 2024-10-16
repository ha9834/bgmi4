package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrr;
import java.io.IOException;

/* loaded from: classes2.dex */
public class zzdrr<M extends zzdrr<M>> extends zzdrw {

    /* renamed from: a, reason: collision with root package name */
    protected zzdrt f3603a;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrw
    public int a() {
        if (this.f3603a != null) {
            for (int i = 0; i < this.f3603a.a(); i++) {
                this.f3603a.a(i).a();
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    public void zza(zzdrp zzdrpVar) throws IOException {
        if (this.f3603a == null) {
            return;
        }
        for (int i = 0; i < this.f3603a.a(); i++) {
            this.f3603a.a(i).a(zzdrpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    /* renamed from: zzbal */
    public final /* synthetic */ zzdrw clone() throws CloneNotSupportedException {
        return (zzdrr) clone();
    }

    @Override // com.google.android.gms.internal.ads.zzdrw
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzdrr zzdrrVar = (zzdrr) super.clone();
        zzdrv.zza(this, zzdrrVar);
        return zzdrrVar;
    }
}
