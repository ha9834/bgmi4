package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes2.dex */
final class uh implements zzban<SQLiteDatabase> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzczc f2539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public uh(zzcjc zzcjcVar, zzczc zzczcVar) {
        this.f2539a = zzczcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzawz.zzen(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f2539a.apply(sQLiteDatabase);
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzawz.zzen(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }
}
