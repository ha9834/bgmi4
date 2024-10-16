package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzcuh implements zzcva<zzcuz<Bundle>> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3443a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcuh(Context context, @Nullable String str) {
        this.f3443a = context;
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> zzalm() {
        return zzbar.zzm(this.b == null ? null : new zzcuz(this) { // from class: com.google.android.gms.internal.ads.zb

            /* renamed from: a, reason: collision with root package name */
            private final zzcuh f2655a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2655a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzcuz
            public final void zzt(Object obj) {
                this.f2655a.a((Bundle) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.f3443a.getPackageName());
    }
}
