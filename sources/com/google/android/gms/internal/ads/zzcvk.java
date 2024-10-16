package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcvk implements zzcva<zzcvj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3459a;
    private final Context b;

    public zzcvk(zzbbl zzbblVar, Context context) {
        this.f3459a = zzbblVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvj> zzalm() {
        return this.f3459a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zn

            /* renamed from: a, reason: collision with root package name */
            private final zzcvk f2667a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2667a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2667a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcvj a() throws Exception {
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.b.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzk.zzlg();
        int i4 = -1;
        if (zzaxi.zzp(this.b, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.b.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i3 = type;
                i4 = ordinal;
            } else {
                i3 = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                i2 = i4;
                i = i3;
                z = connectivityManager.isActiveNetworkMetered();
            } else {
                i2 = i4;
                i = i3;
                z = false;
            }
        } else {
            i = -2;
            z = false;
            i2 = -1;
        }
        return new zzcvj(networkOperator, i, networkType, phoneType, z, i2);
    }
}
