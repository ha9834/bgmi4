package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzf;

/* loaded from: classes2.dex */
final class dc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzf f4800a;
    private final /* synthetic */ ServiceConnection b;
    private final /* synthetic */ zzex c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(zzex zzexVar, zzf zzfVar, ServiceConnection serviceConnection) {
        this.c = zzexVar;
        this.f4800a = zzfVar;
        this.b = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzeu zzeuVar = this.c.f4938a;
        str = this.c.b;
        zzf zzfVar = this.f4800a;
        ServiceConnection serviceConnection = this.b;
        Bundle a2 = zzeuVar.a(str, zzfVar);
        zzeuVar.f4936a.zzaa().zzo();
        if (a2 != null) {
            long j = a2.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzeuVar.f4936a.zzab().zzgk().zzao("Service response is missing Install Referrer install timestamp");
            } else {
                String string = a2.getString(Constants.INSTALL_REFERRER);
                if (string == null || string.isEmpty()) {
                    zzeuVar.f4936a.zzab().zzgk().zzao("No referrer defined in install referrer response");
                } else {
                    zzeuVar.f4936a.zzab().zzgs().zza("InstallReferrer API result", string);
                    zzjs zzz = zzeuVar.f4936a.zzz();
                    String valueOf = String.valueOf(string);
                    Bundle a3 = zzz.a(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (a3 == null) {
                        zzeuVar.f4936a.zzab().zzgk().zzao("No campaign params defined in install referrer result");
                    } else {
                        String string2 = a3.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = a2.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzeuVar.f4936a.zzab().zzgk().zzao("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                a3.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzeuVar.f4936a.zzac().i.get()) {
                            zzeuVar.f4936a.zzae();
                            zzeuVar.f4936a.zzab().zzgs().zzao("Campaign has already been logged");
                        } else {
                            zzeuVar.f4936a.zzac().i.set(j);
                            zzeuVar.f4936a.zzae();
                            zzeuVar.f4936a.zzab().zzgs().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            a3.putString("_cis", "referrer API");
                            zzeuVar.f4936a.zzq().logEvent("auto", "_cmp", a3);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzeuVar.f4936a.getContext(), serviceConnection);
        }
    }
}
