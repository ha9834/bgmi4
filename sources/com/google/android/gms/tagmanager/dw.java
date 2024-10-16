package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.Logger;

/* loaded from: classes2.dex */
final class dw implements Logger {
    @Override // com.google.android.gms.analytics.Logger
    public final void error(String str) {
        zzdi.zzav(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(Exception exc) {
        zzdi.zza("", exc);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void info(String str) {
        zzdi.zzaw(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void verbose(String str) {
        zzdi.zzab(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void warn(String str) {
        zzdi.zzac(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void setLogLevel(int i) {
        zzdi.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    @Override // com.google.android.gms.analytics.Logger
    public final int getLogLevel() {
        switch (zzdi.f5167a) {
            case 2:
                return 0;
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                return 3;
        }
    }
}
