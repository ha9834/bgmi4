package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ui implements zzban<Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcjm f2540a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ui(zzcjm zzcjmVar, boolean z) {
        this.f2540a = zzcjmVar;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        zzawz.zzen("Failed to get signals bundle");
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void zzk(Bundle bundle) {
        final ArrayList c;
        final zzwt.zzi.zzc b;
        final zzwt.zzg a2;
        zzcjc zzcjcVar;
        Bundle bundle2 = bundle;
        zzcjm zzcjmVar = this.f2540a;
        c = zzcjm.c(bundle2);
        zzcjm zzcjmVar2 = this.f2540a;
        b = zzcjm.b(bundle2);
        a2 = this.f2540a.a(bundle2);
        zzcjcVar = this.f2540a.e;
        final boolean z = this.b;
        zzcjcVar.zza(new zzczc(this, z, c, a2, b) { // from class: com.google.android.gms.internal.ads.uj

            /* renamed from: a, reason: collision with root package name */
            private final ui f2541a;
            private final boolean b;
            private final ArrayList c;
            private final zzwt.zzg d;
            private final zzwt.zzi.zzc e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2541a = this;
                this.b = z;
                this.c = c;
                this.d = a2;
                this.e = b;
            }

            @Override // com.google.android.gms.internal.ads.zzczc
            public final Object apply(Object obj) {
                byte[] a3;
                ui uiVar = this.f2541a;
                boolean z2 = this.b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                a3 = uiVar.f2540a.a(z2, this.c, this.d, this.e);
                ContentValues contentValues = new ContentValues();
                contentValues.put("timestamp", Long.valueOf(zzk.zzln().currentTimeMillis()));
                contentValues.put("serialized_proto_data", a3);
                sQLiteDatabase.insert("offline_signal_contents", null, contentValues);
                sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET total = total+1 WHERE statistic_name = '%s'", "total_requests"));
                if (!z2) {
                    sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET total = total+1 WHERE statistic_name = '%s'", "failed_requests"));
                }
                return null;
            }
        });
    }
}
