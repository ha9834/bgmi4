package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

/* loaded from: classes2.dex */
public final class zzj extends zzbgl {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    private int f5035a;

    @Deprecated
    private ClientAppContext b;
    private int c;

    public zzj(int i) {
        this(1, null, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(int i, ClientAppContext clientAppContext, int i2) {
        this.f5035a = i;
        this.b = clientAppContext;
        this.c = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5035a);
        zzbgo.zza(parcel, 2, this.b, i, false);
        zzbgo.zzc(parcel, 3, this.c);
        zzbgo.zzai(parcel, zze);
    }
}
