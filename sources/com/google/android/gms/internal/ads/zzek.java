package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzbp;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public final class zzek extends zzfk {
    private final Activity d;
    private final View e;

    public zzek(zzdy zzdyVar, String str, String str2, zzbp.zza.C0092zza c0092zza, int i, int i2, View view, Activity activity) {
        super(zzdyVar, str, str2, c0092zza, i, 62);
        this.e = view;
        this.d = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.e == null) {
            return;
        }
        boolean booleanValue = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcrf)).booleanValue();
        Object[] objArr = (Object[]) this.c.invoke(null, this.e, this.d, Boolean.valueOf(booleanValue));
        synchronized (this.b) {
            this.b.zzbp(((Long) objArr[0]).longValue());
            this.b.zzbq(((Long) objArr[1]).longValue());
            if (booleanValue) {
                this.b.zzae((String) objArr[2]);
            }
        }
    }
}
