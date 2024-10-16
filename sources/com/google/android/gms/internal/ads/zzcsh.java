package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsh implements zzcva<zzcsg> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3409a;
    private final Context b;

    public zzcsh(zzbbl zzbblVar, Context context) {
        this.f3409a = zzbblVar;
        this.b = context;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsg> zzalm() {
        return this.f3409a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.yi

            /* renamed from: a, reason: collision with root package name */
            private final zzcsh f2636a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2636a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2636a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcsg a() throws Exception {
        double d;
        Intent registerReceiver = this.b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            double intExtra3 = registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzcsg(d, z);
    }
}
