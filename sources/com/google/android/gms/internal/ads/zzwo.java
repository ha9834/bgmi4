package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzwo {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    zzfx f3768a;

    @VisibleForTesting
    boolean b;

    public final zzws zzg(byte[] bArr) {
        return new zzws(this, bArr);
    }

    public zzwo(Context context, String str, String str2) {
        zzacu.initialize(context);
        try {
            this.f3768a = (zzfx) zzbae.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", apn.f2035a);
            ObjectWrapper.wrap(context);
            this.f3768a.zza(ObjectWrapper.wrap(context), str, null);
            this.b = true;
        } catch (RemoteException | zzbag | NullPointerException unused) {
            zzbad.zzdp("Cannot dynamite load clearcut");
        }
    }

    public zzwo(Context context) {
        zzacu.initialize(context);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue()) {
            try {
                this.f3768a = (zzfx) zzbae.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", apo.f2036a);
                ObjectWrapper.wrap(context);
                this.f3768a.zzb(ObjectWrapper.wrap(context), "GMA_SDK");
                this.b = true;
            } catch (RemoteException | zzbag | NullPointerException unused) {
                zzbad.zzdp("Cannot dynamite load clearcut");
            }
        }
    }

    public zzwo() {
    }
}
