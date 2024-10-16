package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;

@zzard
/* loaded from: classes2.dex */
public final class zzavf implements zzue {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2811a;
    private final Object b;
    private String c;
    private boolean d;

    public zzavf(Context context, String str) {
        this.f2811a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.c = str;
        this.d = false;
        this.b = new Object();
    }

    public final void zzag(boolean z) {
        if (zzk.zzme().zzx(this.f2811a)) {
            synchronized (this.b) {
                if (this.d == z) {
                    return;
                }
                this.d = z;
                if (TextUtils.isEmpty(this.c)) {
                    return;
                }
                if (this.d) {
                    zzk.zzme().zzd(this.f2811a, this.c);
                } else {
                    zzk.zzme().zze(this.f2811a, this.c);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final void zza(zzud zzudVar) {
        zzag(zzudVar.zzbtk);
    }

    public final String getAdUnitId() {
        return this.c;
    }
}
