package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class as extends ContentObserver {
    /* JADX INFO: Access modifiers changed from: package-private */
    public as(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = zzbz.b;
        atomicBoolean.set(true);
    }
}
