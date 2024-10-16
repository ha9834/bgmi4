package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.helpshift.db.conversation.tables.MessagesTable;

/* loaded from: classes2.dex */
public final class zzeb extends dz {

    /* renamed from: a, reason: collision with root package name */
    private final cr f4929a;
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeb(zzfj zzfjVar) {
        super(zzfjVar);
        this.f4929a = new cr(this, getContext(), "google_app_measurement_local.db");
    }

    @Override // com.google.android.gms.measurement.internal.dz
    protected final boolean a() {
        return false;
    }

    public final void resetAnalyticsData() {
        zzm();
        zzo();
        try {
            int delete = c().delete(MessagesTable.TABLE_NAME, null, null) + 0;
            if (delete > 0) {
                zzab().zzgs().zza("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzab().zzgk().zza("Error resetting local analytics data. error", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean a(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.a(int, byte[]):boolean");
    }

    public final boolean zza(zzai zzaiVar) {
        Parcel obtain = Parcel.obtain();
        zzaiVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            zzab().zzgn().zzao("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return a(0, marshall);
    }

    public final boolean zza(zzjn zzjnVar) {
        Parcel obtain = Parcel.obtain();
        zzjnVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            zzab().zzgn().zzao("User property too long for local database. Sending directly to service");
            return false;
        }
        return a(1, marshall);
    }

    public final boolean zzc(zzq zzqVar) {
        zzz();
        byte[] a2 = zzjs.a((Parcelable) zzqVar);
        if (a2.length > 131072) {
            zzab().zzgn().zzao("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return a(2, a2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(4:64|65|(7:112|113|114|115|117|118|(3:120|121|122)(1:123))(2:67|(6:96|97|98|99|100|(3:102|103|104)(1:105))(2:69|(6:80|81|82|83|84|(3:86|87|88)(1:89))(2:71|(3:77|78|79)(3:73|74|75))))|76)|61|62) */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x01f6, code lost:
    
        r11 = r22;
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0232 A[Catch: all -> 0x028e, TRY_ENTER, TryCatch #30 {all -> 0x028e, blocks: (B:65:0x00df, B:113:0x00ed, B:118:0x0100, B:121:0x0105, B:128:0x011c, B:129:0x011f, B:125:0x0118, B:97:0x0122, B:100:0x0135, B:103:0x014e, B:108:0x0152, B:109:0x0155, B:111:0x0148, B:81:0x0158, B:84:0x016b, B:87:0x0184, B:92:0x0189, B:93:0x018c, B:95:0x017e, B:78:0x018f, B:74:0x019e, B:30:0x0232, B:32:0x0238, B:33:0x023b, B:19:0x0270), top: B:64:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzc(int r25) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.zzc(int):java.util.List");
    }

    public final boolean zzgh() {
        return a(3, new byte[0]);
    }

    public final boolean zzgi() {
        zzo();
        zzm();
        if (this.b || !d()) {
            return false;
        }
        int i = 5;
        for (int i2 = 0; i2 < 5; i2++) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    SQLiteDatabase c = c();
                    if (c == null) {
                        this.b = true;
                        if (c != null) {
                            c.close();
                        }
                        return false;
                    }
                    c.beginTransaction();
                    c.delete(MessagesTable.TABLE_NAME, "type == ?", new String[]{Integer.toString(3)});
                    c.setTransactionSuccessful();
                    c.endTransaction();
                    if (c != null) {
                        c.close();
                    }
                    return true;
                } catch (SQLiteFullException e) {
                    zzab().zzgk().zza("Error deleting app launch break from local database", e);
                    this.b = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            } catch (SQLiteDatabaseLockedException unused) {
                SystemClock.sleep(i);
                i += 20;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            } catch (SQLiteException e2) {
                if (0 != 0) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                }
                zzab().zzgk().zza("Error deleting app launch break from local database", e2);
                this.b = true;
                if (0 != 0) {
                    sQLiteDatabase.close();
                }
            }
        }
        zzab().zzgn().zzao("Error deleting app launch break from local database in reasonable time");
        return false;
    }

    private static long a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(MessagesTable.TABLE_NAME, new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            if (cursor == null) {
                return -1L;
            }
            cursor.close();
            return -1L;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @VisibleForTesting
    private final SQLiteDatabase c() throws SQLiteException {
        if (this.b) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f4929a.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.b = true;
        return null;
    }

    @VisibleForTesting
    private final boolean d() {
        return getContext().getDatabasePath("google_app_measurement_local.db").exists();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.bu, com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.bu
    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
