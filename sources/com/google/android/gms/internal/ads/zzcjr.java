package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwt;

/* loaded from: classes2.dex */
public final class zzcjr {

    /* renamed from: a, reason: collision with root package name */
    private zzwj f3289a;
    private Context b;
    private zzcjc c;
    private zzbai d;

    public zzcjr(Context context, zzbai zzbaiVar, zzwj zzwjVar, zzcjc zzcjcVar) {
        this.b = context;
        this.d = zzbaiVar;
        this.f3289a = zzwjVar;
        this.c = zzcjcVar;
    }

    public final void zzakp() {
        try {
            this.c.zza(new zzczc(this) { // from class: com.google.android.gms.internal.ads.uk

                /* renamed from: a, reason: collision with root package name */
                private final zzcjr f2542a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2542a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzczc
                public final Object apply(Object obj) {
                    return this.f2542a.a((SQLiteDatabase) obj);
                }
            });
        } catch (Exception e) {
            String valueOf = String.valueOf(e.getMessage());
            zzawz.zzen(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void a(SQLiteDatabase sQLiteDatabase) throws Exception {
        final zzwt.zzi zziVar = (zzwt.zzi) ((zzdob) zzwt.zzi.zzny().zzbq(this.b.getPackageName()).zzbr(Build.MODEL).zzch(zzcjq.zza(sQLiteDatabase, 1)).zzd(zzcjq.zza(sQLiteDatabase)).zzci(zzcjq.zza(sQLiteDatabase, 2)).zzez(zzk.zzln().currentTimeMillis()).zzaya());
        this.f3289a.zza(new zzwk(zziVar) { // from class: com.google.android.gms.internal.ads.ul

            /* renamed from: a, reason: collision with root package name */
            private final zzwt.zzi f2543a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2543a = zziVar;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void zza(zzxn zzxnVar) {
                zzxnVar.zzcfm = this.f2543a;
            }
        });
        final zzxo zzxoVar = new zzxo();
        zzxoVar.zzcfo = Integer.valueOf(this.d.zzdzc);
        zzxoVar.zzcfp = Integer.valueOf(this.d.zzdzd);
        zzxoVar.zzcfq = Integer.valueOf(this.d.zzdze ? 0 : 2);
        this.f3289a.zza(new zzwk(zzxoVar) { // from class: com.google.android.gms.internal.ads.um

            /* renamed from: a, reason: collision with root package name */
            private final zzxo f2544a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2544a = zzxoVar;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void zza(zzxn zzxnVar) {
                zzxnVar.zzcfi.zzcex = this.f2544a;
            }
        });
        this.f3289a.zza(zzwl.zza.zzb.OFFLINE_UPLOAD);
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put("total", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("total", (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
