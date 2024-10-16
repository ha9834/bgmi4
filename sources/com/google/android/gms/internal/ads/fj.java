package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes2.dex */
final class fj extends zzawv {

    /* renamed from: a, reason: collision with root package name */
    private Context f2172a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fj(Context context) {
        this.f2172a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.f2172a);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzawz.zzc("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzazx.zzal(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzawz.zzep(sb.toString());
    }
}
