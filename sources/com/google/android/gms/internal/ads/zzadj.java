package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzadj extends zzadm {

    /* renamed from: a, reason: collision with root package name */
    private final zzf f2707a;
    private final String b;
    private final String c;

    public zzadj(zzf zzfVar, String str, String str2) {
        this.f2707a = zzfVar;
        this.b = str;
        this.c = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String zzqz() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String getContent() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.f2707a.zzg((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordClick() {
        this.f2707a.zzky();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordImpression() {
        this.f2707a.zzkz();
    }
}
