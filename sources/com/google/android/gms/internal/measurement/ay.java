package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ay extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        zzcm.a();
    }
}
