package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes2.dex */
final class fc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2165a;
    private final /* synthetic */ zzbbr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(zzawg zzawgVar, Context context, zzbbr zzbbrVar) {
        this.f2165a = context;
        this.b = zzbbrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.b.set(AdvertisingIdClient.getAdvertisingIdInfo(this.f2165a));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.b.setException(e);
            zzbad.zzc("Exception while getting advertising Id info", e);
        }
    }
}
