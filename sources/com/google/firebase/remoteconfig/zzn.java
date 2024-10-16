package com.google.firebase.remoteconfig;

import com.google.android.gms.internal.firebase_remote_config.zzfd;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzn implements Callable {
    private final zzfd zzka;

    private zzn(zzfd zzfdVar) {
        this.zzka = zzfdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable zza(zzfd zzfdVar) {
        return new zzn(zzfdVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return Boolean.valueOf(this.zzka.zzdf());
    }
}
