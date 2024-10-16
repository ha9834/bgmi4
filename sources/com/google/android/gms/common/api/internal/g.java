package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaak f1362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zaak zaakVar) {
        this.f1362a = zaakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        googleApiAvailabilityLight = this.f1362a.d;
        context = this.f1362a.c;
        googleApiAvailabilityLight.cancelAvailabilityErrorNotifications(context);
    }
}
