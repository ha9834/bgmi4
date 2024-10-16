package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x implements zzd {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zza f5156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(zza zzaVar) {
        this.f5156a = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzd
    public final AdvertisingIdClient.Info zzgv() {
        Context context;
        try {
            context = this.f5156a.g;
            return AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (GooglePlayServicesNotAvailableException e) {
            this.f5156a.close();
            zzdi.zzb("GooglePlayServicesNotAvailableException getting Advertising Id Info", e);
            return null;
        } catch (GooglePlayServicesRepairableException e2) {
            zzdi.zzb("GooglePlayServicesRepairableException getting Advertising Id Info", e2);
            return null;
        } catch (IOException e3) {
            zzdi.zzb("IOException getting Ad Id Info", e3);
            return null;
        } catch (IllegalStateException e4) {
            zzdi.zzb("IllegalStateException getting Advertising Id Info", e4);
            return null;
        } catch (Exception e5) {
            zzdi.zzb("Unknown exception. Could not get the Advertising Id Info.", e5);
            return null;
        }
    }
}
