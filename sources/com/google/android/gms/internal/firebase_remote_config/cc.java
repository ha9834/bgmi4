package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cc implements zzah {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzah f4055a;
    private final /* synthetic */ zzab b;
    private final /* synthetic */ zzf c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(zzf zzfVar, zzah zzahVar, zzab zzabVar) {
        this.c = zzfVar;
        this.f4055a = zzahVar;
        this.b = zzabVar;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzah
    public final void zzb(zzac zzacVar) throws IOException {
        zzah zzahVar = this.f4055a;
        if (zzahVar != null) {
            zzahVar.zzb(zzacVar);
        }
        if (!zzacVar.zzad() && this.b.zzab()) {
            throw this.c.a(zzacVar);
        }
    }
}
