package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes2.dex */
public final class zzcjc {

    /* renamed from: a, reason: collision with root package name */
    private final zzcja f3279a;
    private final zzbbl b;

    public zzcjc(zzcja zzcjaVar, zzbbl zzbblVar) {
        this.f3279a = zzcjaVar;
        this.b = zzbblVar;
    }

    public final void zza(zzczc<SQLiteDatabase, Void> zzczcVar) {
        zzbbl zzbblVar = this.b;
        zzcja zzcjaVar = this.f3279a;
        zzcjaVar.getClass();
        zzbar.zza(zzbblVar.submit(ug.a(zzcjaVar)), new uh(this, zzczcVar), this.b);
    }
}
