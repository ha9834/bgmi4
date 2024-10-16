package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbgk extends zzbgl {
    public zzbgk(zzbdf zzbdfVar) {
        super(zzbdfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final int a() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgl
    protected final zzhn b(String str) {
        return new zzgl(this.f2870a, Uri.parse(str), null, 2);
    }
}
