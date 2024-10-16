package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzazi extends zzawv {

    /* renamed from: a, reason: collision with root package name */
    private final zzbah f2838a;
    private final String b;

    public zzazi(Context context, String str, String str2) {
        this(str2, zzk.zzlg().zzq(context, str));
    }

    private zzazi(String str, String str2) {
        this.f2838a = new zzbah(str2);
        this.b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        this.f2838a.zzed(this.b);
    }
}
