package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;

/* loaded from: classes2.dex */
final class a extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f5052a;
    private final /* synthetic */ ProviderInstaller.ProviderInstallListener b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.f5052a = context;
        this.b = providerInstallListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Integer doInBackground(Void... voidArr) {
        try {
            ProviderInstaller.installIfNeeded(this.f5052a);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e) {
            return Integer.valueOf(e.errorCode);
        } catch (GooglePlayServicesRepairableException e2) {
            return Integer.valueOf(e2.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Integer num) {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Integer num2 = num;
        if (num2.intValue() == 0) {
            this.b.onProviderInstalled();
            return;
        }
        googleApiAvailabilityLight = ProviderInstaller.f5051a;
        this.b.onProviderInstallFailed(num2.intValue(), googleApiAvailabilityLight.getErrorResolutionIntent(this.f5052a, num2.intValue(), "pi"));
    }
}
