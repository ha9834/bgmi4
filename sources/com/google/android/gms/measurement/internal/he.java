package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class he extends gq {
    private static final String[] b = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] c = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] d = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;"};
    private static final String[] e = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] f = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] g = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] h = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] i = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final hf j;
    private final gn k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public he(zzjg zzjgVar) {
        super(zzjgVar);
        this.k = new gn(zzx());
        this.j = new hf(this, getContext(), "google_app_measurement.db");
    }

    @Override // com.google.android.gms.measurement.internal.gq
    protected final boolean a() {
        return false;
    }

    public final void d() {
        c();
        g().beginTransaction();
    }

    public final void e() {
        c();
        g().setTransactionSuccessful();
    }

    public final void f() {
        c();
        g().endTransaction();
    }

    private final long b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = g().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                zzab().zzgk().zza("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long a(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = g().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e2) {
                zzab().zzgk().zza("Database error", str, e2);
                throw e2;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase g() {
        zzo();
        try {
            return this.j.getWritableDatabase();
        } catch (SQLiteException e2) {
            zzab().zzgn().zza("Error opening database", e2);
            throw e2;
        }
    }

    public final c a(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        Cursor query;
        Boolean bool;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        c();
        boolean zze = zzad().zze(str, zzak.zziz);
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"));
        if (zze) {
            arrayList.add("current_session_count");
        }
        try {
            try {
                query = g().query("events", (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                long j = query.getLong(0);
                long j2 = query.getLong(1);
                long j3 = query.getLong(2);
                long j4 = query.isNull(3) ? 0L : query.getLong(3);
                Long valueOf = query.isNull(4) ? null : Long.valueOf(query.getLong(4));
                Long valueOf2 = query.isNull(5) ? null : Long.valueOf(query.getLong(5));
                Long valueOf3 = query.isNull(6) ? null : Long.valueOf(query.getLong(6));
                if (query.isNull(7)) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(query.getLong(7) == 1);
                }
                cursor2 = query;
                try {
                    c cVar = new c(str, str2, j, j2, (!zze || query.isNull(8)) ? 0L : query.getLong(8), j3, j4, valueOf, valueOf2, valueOf3, bool);
                    if (cursor2.moveToNext()) {
                        zzab().zzgk().zza("Got multiple records for event aggregates, expected one. appId", zzef.a(str));
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return cVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzab().zzgk().zza("Error querying events. appId", zzef.a(str), zzy().a(str2), e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor2 = query;
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final void a(c cVar) {
        Preconditions.checkNotNull(cVar);
        zzo();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", cVar.f4775a);
        contentValues.put("name", cVar.b);
        contentValues.put("lifetime_count", Long.valueOf(cVar.c));
        contentValues.put("current_bundle_count", Long.valueOf(cVar.d));
        contentValues.put("last_fire_timestamp", Long.valueOf(cVar.f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(cVar.g));
        contentValues.put("last_bundled_day", cVar.h);
        contentValues.put("last_sampled_complex_event_id", cVar.i);
        contentValues.put("last_sampling_rate", cVar.j);
        if (zzad().zze(cVar.f4775a, zzak.zziz)) {
            contentValues.put("current_session_count", Long.valueOf(cVar.e));
        }
        contentValues.put("last_exempt_from_sampling", (cVar.k == null || !cVar.k.booleanValue()) ? null : 1L);
        try {
            if (g().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update event aggregates (got -1). appId", zzef.a(cVar.f4775a));
            }
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing event aggregates. appId", zzef.a(cVar.f4775a), e2);
        }
    }

    public final void b(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        c();
        try {
            zzab().zzgs().zza("Deleted user attribute rows", Integer.valueOf(g().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error deleting user attribute. appId", zzef.a(str), zzy().c(str2), e2);
        }
    }

    public final boolean a(gv gvVar) {
        Preconditions.checkNotNull(gvVar);
        zzo();
        c();
        if (c(gvVar.f4895a, gvVar.c) == null) {
            if (zzjs.a(gvVar.c)) {
                if (b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{gvVar.f4895a}) >= 25) {
                    return false;
                }
            } else if (zzad().zze(gvVar.f4895a, zzak.zzij)) {
                if (!"_npa".equals(gvVar.c) && b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{gvVar.f4895a, gvVar.b}) >= 25) {
                    return false;
                }
            } else if (b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{gvVar.f4895a, gvVar.b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", gvVar.f4895a);
        contentValues.put("origin", gvVar.b);
        contentValues.put("name", gvVar.c);
        contentValues.put("set_timestamp", Long.valueOf(gvVar.d));
        a(contentValues, "value", gvVar.e);
        try {
            if (g().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update user property (got -1). appId", zzef.a(gvVar.f4895a));
            }
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing user property. appId", zzef.a(gvVar.f4895a), e2);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.gv c(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzo()
            r18.c()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.g()     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r1] = r19     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r14[r2] = r8     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L83 android.database.sqlite.SQLiteException -> L88
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            if (r0 != 0) goto L44
            if (r10 == 0) goto L43
            r10.close()
        L43:
            return r9
        L44:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L7b android.database.sqlite.SQLiteException -> L7f
            r11 = r18
            java.lang.Object r7 = r11.a(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r3 = r10.getString(r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.gv r0 = new com.google.android.gms.measurement.internal.gv     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            if (r1 == 0) goto L73
            com.google.android.gms.measurement.internal.zzef r1 = r18.zzab()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.a(r19)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L79 java.lang.Throwable -> Lab
        L73:
            if (r10 == 0) goto L78
            r10.close()
        L78:
            return r0
        L79:
            r0 = move-exception
            goto L8c
        L7b:
            r0 = move-exception
            r11 = r18
            goto Lac
        L7f:
            r0 = move-exception
            r11 = r18
            goto L8c
        L83:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto Lac
        L88:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L8c:
            com.google.android.gms.measurement.internal.zzef r1 = r18.zzab()     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.a(r19)     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.measurement.internal.zzed r4 = r18.zzy()     // Catch: java.lang.Throwable -> Lab
            java.lang.String r4 = r4.c(r8)     // Catch: java.lang.Throwable -> Lab
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> Lab
            if (r10 == 0) goto Laa
            r10.close()
        Laa:
            return r9
        Lab:
            r0 = move-exception
        Lac:
            if (r10 == 0) goto Lb1
            r10.close()
        Lb1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.c(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.gv");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<gv> a(String str) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        zzo();
        c();
        ArrayList arrayList = new ArrayList();
        try {
            try {
                cursor = g().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", Constants.DEFAULT_UIN);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                }
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String str2 = string2 == null ? "" : string2;
                    long j = cursor.getLong(2);
                    try {
                        Object a2 = a(cursor, 3);
                        if (a2 == null) {
                            zzab().zzgk().zza("Read invalid user property value, ignoring it. appId", zzef.a(str));
                        } else {
                            arrayList.add(new gv(str, str2, string, j, a2));
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        zzab().zzgk().zza("Error querying user properties. appId", zzef.a(str), e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x009a, code lost:
    
        zzab().zzgk().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.gv> a(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.a(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean a(zzq zzqVar) {
        Preconditions.checkNotNull(zzqVar);
        zzo();
        c();
        if (c(zzqVar.packageName, zzqVar.zzdw.name) == null && b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzqVar.packageName}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzqVar.packageName);
        contentValues.put("origin", zzqVar.origin);
        contentValues.put("name", zzqVar.zzdw.name);
        a(contentValues, "value", zzqVar.zzdw.getValue());
        contentValues.put("active", Boolean.valueOf(zzqVar.active));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzqVar.triggerEventName);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzqVar.triggerTimeout));
        zzz();
        contentValues.put("timed_out_event", zzjs.a((Parcelable) zzqVar.zzdx));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzqVar.creationTimestamp));
        zzz();
        contentValues.put("triggered_event", zzjs.a((Parcelable) zzqVar.zzdy));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzqVar.zzdw.zztr));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzqVar.timeToLive));
        zzz();
        contentValues.put("expired_event", zzjs.a((Parcelable) zzqVar.zzdz));
        try {
            if (g().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update conditional user property (got -1)", zzef.a(zzqVar.packageName));
            }
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing conditional user property", zzef.a(zzqVar.packageName), e2);
        }
        return true;
    }

    public final zzq d(String str, String str2) {
        Cursor cursor;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        c();
        try {
            try {
                cursor = g().query("conditional_properties", new String[]{"origin", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                String string = cursor.getString(0);
                try {
                    Object a2 = a(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    zzq zzqVar = new zzq(str, string, new zzjn(str2, cursor.getLong(8), a2, string), cursor.getLong(6), z, cursor.getString(3), (zzai) zzgw().a(cursor.getBlob(5), zzai.CREATOR), cursor.getLong(4), (zzai) zzgw().a(cursor.getBlob(7), zzai.CREATOR), cursor.getLong(9), (zzai) zzgw().a(cursor.getBlob(10), zzai.CREATOR));
                    if (cursor.moveToNext()) {
                        zzab().zzgk().zza("Got multiple records for conditional property, expected one", zzef.a(str), zzy().c(str2));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzqVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    zzab().zzgk().zza("Error querying conditional property", zzef.a(str), zzy().c(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final int e(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        c();
        try {
            return g().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error deleting conditional property", zzef.a(str), zzy().c(str2), e2);
            return 0;
        }
    }

    public final List<zzq> b(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzo();
        c();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return a(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
    
        zzab().zzgk().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0175  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzq> a(java.lang.String r40, java.lang.String[] r41) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.a(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01ec A[Catch: SQLiteException -> 0x024b, all -> 0x0275, TryCatch #1 {all -> 0x0275, blocks: (B:15:0x00e5, B:17:0x0142, B:21:0x014c, B:24:0x0196, B:27:0x01cc, B:29:0x01d7, B:33:0x01e1, B:35:0x01ec, B:37:0x01f3, B:40:0x020e, B:42:0x0219, B:43:0x022b, B:45:0x0234, B:50:0x020a, B:53:0x01c8, B:54:0x0191, B:57:0x025e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0219 A[Catch: SQLiteException -> 0x024b, all -> 0x0275, TryCatch #1 {all -> 0x0275, blocks: (B:15:0x00e5, B:17:0x0142, B:21:0x014c, B:24:0x0196, B:27:0x01cc, B:29:0x01d7, B:33:0x01e1, B:35:0x01ec, B:37:0x01f3, B:40:0x020e, B:42:0x0219, B:43:0x022b, B:45:0x0234, B:50:0x020a, B:53:0x01c8, B:54:0x0191, B:57:0x025e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0234 A[Catch: SQLiteException -> 0x024b, all -> 0x0275, TRY_LEAVE, TryCatch #1 {all -> 0x0275, blocks: (B:15:0x00e5, B:17:0x0142, B:21:0x014c, B:24:0x0196, B:27:0x01cc, B:29:0x01d7, B:33:0x01e1, B:35:0x01ec, B:37:0x01f3, B:40:0x020e, B:42:0x0219, B:43:0x022b, B:45:0x0234, B:50:0x020a, B:53:0x01c8, B:54:0x0191, B:57:0x025e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x020a A[Catch: SQLiteException -> 0x024b, all -> 0x0275, TryCatch #1 {all -> 0x0275, blocks: (B:15:0x00e5, B:17:0x0142, B:21:0x014c, B:24:0x0196, B:27:0x01cc, B:29:0x01d7, B:33:0x01e1, B:35:0x01ec, B:37:0x01f3, B:40:0x020e, B:42:0x0219, B:43:0x022b, B:45:0x0234, B:50:0x020a, B:53:0x01c8, B:54:0x0191, B:57:0x025e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c8 A[Catch: SQLiteException -> 0x024b, all -> 0x0275, TryCatch #1 {all -> 0x0275, blocks: (B:15:0x00e5, B:17:0x0142, B:21:0x014c, B:24:0x0196, B:27:0x01cc, B:29:0x01d7, B:33:0x01e1, B:35:0x01ec, B:37:0x01f3, B:40:0x020e, B:42:0x0219, B:43:0x022b, B:45:0x0234, B:50:0x020a, B:53:0x01c8, B:54:0x0191, B:57:0x025e), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0191 A[Catch: SQLiteException -> 0x024b, all -> 0x0275, TryCatch #1 {all -> 0x0275, blocks: (B:15:0x00e5, B:17:0x0142, B:21:0x014c, B:24:0x0196, B:27:0x01cc, B:29:0x01d7, B:33:0x01e1, B:35:0x01ec, B:37:0x01f3, B:40:0x020e, B:42:0x0219, B:43:0x022b, B:45:0x0234, B:50:0x020a, B:53:0x01c8, B:54:0x0191, B:57:0x025e), top: B:2:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.de b(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.b(java.lang.String):com.google.android.gms.measurement.internal.de");
    }

    public final void a(de deVar) {
        Preconditions.checkNotNull(deVar);
        zzo();
        c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", deVar.b());
        contentValues.put("app_instance_id", deVar.c());
        contentValues.put("gmp_app_id", deVar.d());
        contentValues.put("resettable_device_id_hash", deVar.f());
        contentValues.put("last_bundle_index", Long.valueOf(deVar.q()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(deVar.h()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(deVar.i()));
        contentValues.put("app_version", deVar.j());
        contentValues.put("app_store", deVar.l());
        contentValues.put("gmp_version", Long.valueOf(deVar.m()));
        contentValues.put("dev_cert_hash", Long.valueOf(deVar.n()));
        contentValues.put("measurement_enabled", Boolean.valueOf(deVar.p()));
        contentValues.put("day", Long.valueOf(deVar.u()));
        contentValues.put("daily_public_events_count", Long.valueOf(deVar.v()));
        contentValues.put("daily_events_count", Long.valueOf(deVar.w()));
        contentValues.put("daily_conversions_count", Long.valueOf(deVar.x()));
        contentValues.put("config_fetched_time", Long.valueOf(deVar.r()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(deVar.s()));
        contentValues.put("app_version_int", Long.valueOf(deVar.k()));
        contentValues.put("firebase_instance_id", deVar.g());
        contentValues.put("daily_error_events_count", Long.valueOf(deVar.z()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(deVar.y()));
        contentValues.put("health_monitor_sample", deVar.A());
        contentValues.put("android_id", Long.valueOf(deVar.C()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(deVar.D()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(deVar.E()));
        contentValues.put("admob_app_id", deVar.e());
        contentValues.put("dynamite_version", Long.valueOf(deVar.o()));
        if (deVar.G() != null) {
            if (deVar.G().size() == 0) {
                zzab().zzgn().zza("Safelisted events should not be an empty list. appId", deVar.b());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", deVar.G()));
            }
        }
        try {
            SQLiteDatabase g2 = g();
            if (g2.update("apps", contentValues, "app_id = ?", new String[]{deVar.b()}) == 0 && g2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzab().zzgk().zza("Failed to insert/update app (got -1). appId", zzef.a(deVar.b()));
            }
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing app. appId", zzef.a(deVar.b()), e2);
        }
    }

    public final long c(String str) {
        Preconditions.checkNotEmpty(str);
        zzo();
        c();
        try {
            return g().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzad().zzb(str, zzak.zzgu))))});
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error deleting over the limit events. appId", zzef.a(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzw a(long r19, java.lang.String r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.a(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzw");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] d(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzo()
            r11.c()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.g()     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r2 = "apps"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r5 = "remote_config"
            r9 = 0
            r4[r9] = r5     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            r6[r9] = r12     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            r7 = 0
            r8 = 0
            r10 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5a android.database.sqlite.SQLiteException -> L5d
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            if (r2 != 0) goto L37
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r9)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            if (r3 == 0) goto L52
            com.google.android.gms.measurement.internal.zzef r3 = r11.zzab()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.a(r12)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
            r3.zza(r4, r5)     // Catch: android.database.sqlite.SQLiteException -> L58 java.lang.Throwable -> L76
        L52:
            if (r1 == 0) goto L57
            r1.close()
        L57:
            return r2
        L58:
            r2 = move-exception
            goto L5f
        L5a:
            r12 = move-exception
            r1 = r0
            goto L77
        L5d:
            r2 = move-exception
            r1 = r0
        L5f:
            com.google.android.gms.measurement.internal.zzef r3 = r11.zzab()     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch: java.lang.Throwable -> L76
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.a(r12)     // Catch: java.lang.Throwable -> L76
            r3.zza(r4, r12, r2)     // Catch: java.lang.Throwable -> L76
            if (r1 == 0) goto L75
            r1.close()
        L75:
            return r0
        L76:
            r12 = move-exception
        L77:
            if (r1 == 0) goto L7c
            r1.close()
        L7c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.d(java.lang.String):byte[]");
    }

    public final boolean a(zzbs.zzg zzgVar, boolean z) {
        zzo();
        c();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzag());
        Preconditions.checkState(zzgVar.zzof());
        j();
        long currentTimeMillis = zzx().currentTimeMillis();
        if (zzgVar.zznr() < currentTimeMillis - zzs.zzbs() || zzgVar.zznr() > zzs.zzbs() + currentTimeMillis) {
            zzab().zzgn().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzef.a(zzgVar.zzag()), Long.valueOf(currentTimeMillis), Long.valueOf(zzgVar.zznr()));
        }
        try {
            byte[] c2 = zzgw().c(zzgVar.toByteArray());
            zzab().zzgs().zza("Saving bundle, size", Integer.valueOf(c2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzgVar.zzag());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.zznr()));
            contentValues.put("data", c2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.zzpn()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.zzpo()));
            }
            try {
                if (g().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzab().zzgk().zza("Failed to insert bundle (got -1). appId", zzef.a(zzgVar.zzag()));
                return false;
            } catch (SQLiteException e2) {
                zzab().zzgk().zza("Error storing bundle. appId", zzef.a(zzgVar.zzag()), e2);
                return false;
            }
        } catch (IOException e3) {
            zzab().zzgk().zza("Data loss. Failed to serialize bundle. appId", zzef.a(zzgVar.zzag()), e3);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.g()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L24 android.database.sqlite.SQLiteException -> L29
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r2 == 0) goto L1c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L22 java.lang.Throwable -> L3e
            if (r0 == 0) goto L1b
            r0.close()
        L1b:
            return r1
        L1c:
            if (r0 == 0) goto L21
            r0.close()
        L21:
            return r1
        L22:
            r2 = move-exception
            goto L2b
        L24:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3f
        L29:
            r2 = move-exception
            r0 = r1
        L2b:
            com.google.android.gms.measurement.internal.zzef r3 = r6.zzab()     // Catch: java.lang.Throwable -> L3e
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L3d
            r0.close()
        L3d:
            return r1
        L3e:
            r1 = move-exception
        L3f:
            if (r0 == 0) goto L44
            r0.close()
        L44:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.h():java.lang.String");
    }

    public final boolean i() {
        return b("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<Pair<zzbs.zzg, Long>> a(String str, int i2, int i3) {
        byte[] b2;
        zzo();
        c();
        Preconditions.checkArgument(i2 > 0);
        Preconditions.checkArgument(i3 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = g().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
                if (!query.moveToFirst()) {
                    List<Pair<zzbs.zzg, Long>> emptyList = Collections.emptyList();
                    if (query != null) {
                        query.close();
                    }
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                do {
                    long j = query.getLong(0);
                    try {
                        b2 = zzgw().b(query.getBlob(1));
                    } catch (IOException e2) {
                        zzab().zzgk().zza("Failed to unzip queued bundle. appId", zzef.a(str), e2);
                    }
                    if (!arrayList.isEmpty() && b2.length + i4 > i3) {
                        break;
                    }
                    try {
                        zzbs.zzg.zza zzaVar = (zzbs.zzg.zza) zzbs.zzg.zzpr().zzf(b2, zzel.zztq());
                        if (!query.isNull(2)) {
                            zzaVar.zzw(query.getInt(2));
                        }
                        i4 += b2.length;
                        arrayList.add(Pair.create((zzbs.zzg) ((zzey) zzaVar.zzug()), Long.valueOf(j)));
                    } catch (IOException e3) {
                        zzab().zzgk().zza("Failed to merge queued bundle. appId", zzef.a(str), e3);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i4 <= i3);
                if (query != null) {
                    query.close();
                }
                return arrayList;
            } catch (SQLiteException e4) {
                zzab().zzgk().zza("Error querying bundles. appId", zzef.a(str), e4);
                List<Pair<zzbs.zzg, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j() {
        int delete;
        zzo();
        c();
        if (x()) {
            long j = zzac().f.get();
            long elapsedRealtime = zzx().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzak.zzhd.get(null).longValue()) {
                zzac().f.set(elapsedRealtime);
                zzo();
                c();
                if (!x() || (delete = g().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzx().currentTimeMillis()), String.valueOf(zzs.zzbs())})) <= 0) {
                    return;
                }
                zzab().zzgs().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(List<Long> list) {
        zzo();
        c();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (x()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (b(sb3.toString(), (String[]) null) > 0) {
                zzab().zzgn().zzao("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase g2 = g();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + Notifications.NOTIFICATION_TYPES_ALL);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                g2.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                zzab().zzgk().zza("Error incrementing retry count. error", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(String str, zzbv[] zzbvVarArr) {
        boolean z;
        c();
        zzo();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbvVarArr);
        SQLiteDatabase g2 = g();
        g2.beginTransaction();
        try {
            c();
            zzo();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase g3 = g();
            g3.delete("property_filters", "app_id=?", new String[]{str});
            g3.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbv zzbvVar : zzbvVarArr) {
                c();
                zzo();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzbvVar);
                Preconditions.checkNotNull(zzbvVar.zzzh);
                Preconditions.checkNotNull(zzbvVar.zzzg);
                if (zzbvVar.zzzf == null) {
                    zzab().zzgn().zza("Audience with no ID. appId", zzef.a(str));
                } else {
                    int intValue = zzbvVar.zzzf.intValue();
                    zzbk.zza[] zzaVarArr = zzbvVar.zzzh;
                    int length = zzaVarArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (!zzaVarArr[i2].zzkb()) {
                                zzab().zzgn().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzef.a(str), zzbvVar.zzzf);
                                break;
                            }
                            i2++;
                        } else {
                            zzbk.zzd[] zzdVarArr = zzbvVar.zzzg;
                            int length2 = zzdVarArr.length;
                            int i3 = 0;
                            while (true) {
                                if (i3 < length2) {
                                    if (!zzdVarArr[i3].zzkb()) {
                                        zzab().zzgn().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzef.a(str), zzbvVar.zzzf);
                                        break;
                                    }
                                    i3++;
                                } else {
                                    zzbk.zza[] zzaVarArr2 = zzbvVar.zzzh;
                                    int length3 = zzaVarArr2.length;
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= length3) {
                                            z = true;
                                            break;
                                        } else {
                                            if (!a(str, intValue, zzaVarArr2[i4])) {
                                                z = false;
                                                break;
                                            }
                                            i4++;
                                        }
                                    }
                                    if (z) {
                                        zzbk.zzd[] zzdVarArr2 = zzbvVar.zzzg;
                                        int length4 = zzdVarArr2.length;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 >= length4) {
                                                break;
                                            }
                                            if (!a(str, intValue, zzdVarArr2[i5])) {
                                                z = false;
                                                break;
                                            }
                                            i5++;
                                        }
                                    }
                                    if (!z) {
                                        c();
                                        zzo();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase g4 = g();
                                        g4.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                        g4.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbv zzbvVar2 : zzbvVarArr) {
                arrayList.add(zzbvVar2.zzzf);
            }
            a(str, arrayList);
            g2.setTransactionSuccessful();
        } finally {
            g2.endTransaction();
        }
    }

    private final boolean a(String str, int i2, zzbk.zza zzaVar) {
        c();
        zzo();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaVar);
        if (TextUtils.isEmpty(zzaVar.zzjz())) {
            zzab().zzgn().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzef.a(str), Integer.valueOf(i2), String.valueOf(zzaVar.zzkb() ? Integer.valueOf(zzaVar.getId()) : null));
            return false;
        }
        byte[] byteArray = zzaVar.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", zzaVar.zzkb() ? Integer.valueOf(zzaVar.getId()) : null);
        contentValues.put("event_name", zzaVar.zzjz());
        if (zzad().zze(str, zzak.zziy)) {
            contentValues.put("session_scoped", zzaVar.zzkh() ? Boolean.valueOf(zzaVar.zzki()) : null);
        }
        contentValues.put("data", byteArray);
        try {
            if (g().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzab().zzgk().zza("Failed to insert event filter (got -1). appId", zzef.a(str));
            return true;
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing event filter. appId", zzef.a(str), e2);
            return false;
        }
    }

    private final boolean a(String str, int i2, zzbk.zzd zzdVar) {
        c();
        zzo();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdVar);
        if (TextUtils.isEmpty(zzdVar.getPropertyName())) {
            zzab().zzgn().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzef.a(str), Integer.valueOf(i2), String.valueOf(zzdVar.zzkb() ? Integer.valueOf(zzdVar.getId()) : null));
            return false;
        }
        byte[] byteArray = zzdVar.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", zzdVar.zzkb() ? Integer.valueOf(zzdVar.getId()) : null);
        contentValues.put("property_name", zzdVar.getPropertyName());
        if (zzad().zze(str, zzak.zziy)) {
            contentValues.put("session_scoped", zzdVar.zzkh() ? Boolean.valueOf(zzdVar.zzki()) : null);
        }
        contentValues.put("data", byteArray);
        try {
            if (g().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzab().zzgk().zza("Failed to insert property filter (got -1). appId", zzef.a(str));
            return false;
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing property filter. appId", zzef.a(str), e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbk.zza>> f(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.c()
            r12.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.b.a r0 = new androidx.b.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.g()
            r9 = 0
            java.lang.String r2 = "event_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            java.lang.String r5 = "app_id=? AND event_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            r6[r10] = r13     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            r6[r11] = r14     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r1 != 0) goto L48
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r14 == 0) goto L47
            r14.close()
        L47:
            return r13
        L48:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            com.google.android.gms.internal.measurement.zzel r2 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch: java.io.IOException -> L74 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            com.google.android.gms.internal.measurement.zzbk$zza r1 = com.google.android.gms.internal.measurement.zzbk.zza.zza(r1, r2)     // Catch: java.io.IOException -> L74 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r3 != 0) goto L70
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
        L70:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            goto L86
        L74:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzef r2 = r12.zzab()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.a(r13)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
        L86:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r1 != 0) goto L48
            if (r14 == 0) goto L91
            r14.close()
        L91:
            return r0
        L92:
            r0 = move-exception
            goto L99
        L94:
            r13 = move-exception
            r14 = r9
            goto Lb1
        L97:
            r0 = move-exception
            r14 = r9
        L99:
            com.google.android.gms.measurement.internal.zzef r1 = r12.zzab()     // Catch: java.lang.Throwable -> Lb0
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzef.a(r13)     // Catch: java.lang.Throwable -> Lb0
            r1.zza(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb0
            if (r14 == 0) goto Laf
            r14.close()
        Laf:
            return r9
        Lb0:
            r13 = move-exception
        Lb1:
            if (r14 == 0) goto Lb6
            r14.close()
        Lb6:
            throw r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.f(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbk.zzd>> g(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.c()
            r12.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.b.a r0 = new androidx.b.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.g()
            r9 = 0
            java.lang.String r2 = "property_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            java.lang.String r5 = "app_id=? AND property_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            r6[r10] = r13     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            r6[r11] = r14     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteException -> L97
            boolean r1 = r14.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r1 != 0) goto L48
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r14 == 0) goto L47
            r14.close()
        L47:
            return r13
        L48:
            byte[] r1 = r14.getBlob(r11)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            com.google.android.gms.internal.measurement.zzel r2 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch: java.io.IOException -> L74 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            com.google.android.gms.internal.measurement.zzbk$zzd r1 = com.google.android.gms.internal.measurement.zzbk.zzd.zzb(r1, r2)     // Catch: java.io.IOException -> L74 android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            int r2 = r14.getInt(r10)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.Object r3 = r0.get(r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.util.List r3 = (java.util.List) r3     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r3 != 0) goto L70
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            r3.<init>()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            r0.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
        L70:
            r3.add(r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            goto L86
        L74:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzef r2 = r12.zzab()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.a(r13)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            r2.zza(r3, r4, r1)     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
        L86:
            boolean r1 = r14.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L92 java.lang.Throwable -> Lb0
            if (r1 != 0) goto L48
            if (r14 == 0) goto L91
            r14.close()
        L91:
            return r0
        L92:
            r0 = move-exception
            goto L99
        L94:
            r13 = move-exception
            r14 = r9
            goto Lb1
        L97:
            r0 = move-exception
            r14 = r9
        L99:
            com.google.android.gms.measurement.internal.zzef r1 = r12.zzab()     // Catch: java.lang.Throwable -> Lb0
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzef.a(r13)     // Catch: java.lang.Throwable -> Lb0
            r1.zza(r2, r13, r0)     // Catch: java.lang.Throwable -> Lb0
            if (r14 == 0) goto Laf
            r14.close()
        Laf:
            return r9
        Lb0:
            r13 = move-exception
        Lb1:
            if (r14 == 0) goto Lb6
            r14.close()
        Lb6:
            throw r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.g(java.lang.String, java.lang.String):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> e(java.lang.String r8) {
        /*
            r7 = this;
            r7.c()
            r7.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.b.a r0 = new androidx.b.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.g()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            r5 = 0
            r4[r5] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            r6 = 1
            r4[r6] = r8     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L67 android.database.sqlite.SQLiteException -> L6a
            boolean r3 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r3 != 0) goto L32
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r1 == 0) goto L31
            r1.close()
        L31:
            return r8
        L32:
            int r3 = r1.getInt(r5)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Object r4 = r0.get(r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.util.List r4 = (java.util.List) r4     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r4 != 0) goto L4e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            r4.<init>()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            r0.put(r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
        L4e:
            int r3 = r1.getInt(r6)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            r4.add(r3)     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            boolean r3 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L65 java.lang.Throwable -> L83
            if (r3 != 0) goto L32
            if (r1 == 0) goto L64
            r1.close()
        L64:
            return r0
        L65:
            r0 = move-exception
            goto L6c
        L67:
            r8 = move-exception
            r1 = r2
            goto L84
        L6a:
            r0 = move-exception
            r1 = r2
        L6c:
            com.google.android.gms.measurement.internal.zzef r3 = r7.zzab()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.a(r8)     // Catch: java.lang.Throwable -> L83
            r3.zza(r4, r8, r0)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r2
        L83:
            r8 = move-exception
        L84:
            if (r1 == 0) goto L89
            r1.close()
        L89:
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.e(java.lang.String):java.util.Map");
    }

    private final boolean a(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        c();
        zzo();
        SQLiteDatabase g2 = g();
        try {
            long b2 = b("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzad().zzb(str, zzak.zzhk)));
            if (b2 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return g2.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Database error querying filters. appId", zzef.a(str), e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0096  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzbs.zzi> f(java.lang.String r12) {
        /*
            r11 = this;
            r11.c()
            r11.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.g()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r3 = "audience_id"
            r9 = 0
            r2[r9] = r3     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r3 = "current_results"
            r10 = 1
            r2[r10] = r3     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            java.lang.String r3 = "app_id=?"
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            r4[r9] = r12     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L7a
            boolean r1 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            if (r1 != 0) goto L36
            if (r0 == 0) goto L35
            r0.close()
        L35:
            return r8
        L36:
            androidx.b.a r1 = new androidx.b.a     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            r1.<init>()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
        L3b:
            int r2 = r0.getInt(r9)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            byte[] r3 = r0.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            com.google.android.gms.internal.measurement.zzel r4 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            com.google.android.gms.internal.measurement.zzbs$zzi r3 = com.google.android.gms.internal.measurement.zzbs.zzi.zze(r3, r4)     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            r1.put(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            goto L69
        L53:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzef r4 = r11.zzab()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.a(r12)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            r4.zza(r5, r6, r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
        L69:
            boolean r2 = r0.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L93
            if (r2 != 0) goto L3b
            if (r0 == 0) goto L74
            r0.close()
        L74:
            return r1
        L75:
            r1 = move-exception
            goto L7c
        L77:
            r12 = move-exception
            r0 = r8
            goto L94
        L7a:
            r1 = move-exception
            r0 = r8
        L7c:
            com.google.android.gms.measurement.internal.zzef r2 = r11.zzab()     // Catch: java.lang.Throwable -> L93
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch: java.lang.Throwable -> L93
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.a(r12)     // Catch: java.lang.Throwable -> L93
            r2.zza(r3, r12, r1)     // Catch: java.lang.Throwable -> L93
            if (r0 == 0) goto L92
            r0.close()
        L92:
            return r8
        L93:
            r12 = move-exception
        L94:
            if (r0 == 0) goto L99
            r0.close()
        L99:
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.f(java.lang.String):java.util.Map");
    }

    private static void a(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @VisibleForTesting
    private final Object a(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        switch (type) {
            case 0:
                zzab().zzgk().zzao("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i2));
            case 2:
                return Double.valueOf(cursor.getDouble(i2));
            case 3:
                return cursor.getString(i2);
            case 4:
                zzab().zzgk().zzao("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzab().zzgk().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    public final long k() {
        return a("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final long h(String str, String str2) {
        long j;
        ContentValues contentValues;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzo();
        c();
        SQLiteDatabase g2 = g();
        g2.beginTransaction();
        try {
            try {
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
                sb.append("select ");
                sb.append(str2);
                sb.append(" from app2 where app_id=?");
                j = a(sb.toString(), new String[]{str}, -1L);
                if (j == -1) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("first_open_count", (Integer) 0);
                    contentValues2.put("previous_install_count", (Integer) 0);
                    if (g2.insertWithOnConflict("app2", null, contentValues2, 5) == -1) {
                        zzab().zzgk().zza("Failed to insert column (got -1). appId", zzef.a(str), str2);
                        return -1L;
                    }
                    j = 0;
                }
            } catch (SQLiteException e2) {
                e = e2;
                j = 0;
            }
            try {
                contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put(str2, Long.valueOf(1 + j));
            } catch (SQLiteException e3) {
                e = e3;
                zzab().zzgk().zza("Error inserting column. appId", zzef.a(str), str2, e);
                return j;
            }
            if (g2.update("app2", contentValues, "app_id = ?", new String[]{str}) == 0) {
                zzab().zzgk().zza("Failed to update column (got 0). appId", zzef.a(str), str2);
                return -1L;
            }
            g2.setTransactionSuccessful();
            return j;
        } finally {
            g2.endTransaction();
        }
    }

    public final long l() {
        return a("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    public final long a(zzbs.zzg zzgVar) throws IOException {
        zzo();
        c();
        Preconditions.checkNotNull(zzgVar);
        Preconditions.checkNotEmpty(zzgVar.zzag());
        byte[] byteArray = zzgVar.toByteArray();
        long a2 = zzgw().a(byteArray);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzgVar.zzag());
        contentValues.put("metadata_fingerprint", Long.valueOf(a2));
        contentValues.put("metadata", byteArray);
        try {
            g().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return a2;
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing raw event metadata. appId", zzef.a(zzgVar.zzag()), e2);
            throw e2;
        }
    }

    public final boolean m() {
        return b("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean n() {
        return b("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long g(String str) {
        Preconditions.checkNotEmpty(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String a(long r5) {
        /*
            r4 = this;
            r4.zzo()
            r4.c()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.g()     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L40 android.database.sqlite.SQLiteException -> L43
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r1 != 0) goto L34
            com.google.android.gms.measurement.internal.zzef r6 = r4.zzab()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgs()     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zzao(r1)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L33
            r5.close()
        L33:
            return r0
        L34:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3e java.lang.Throwable -> L58
            if (r5 == 0) goto L3d
            r5.close()
        L3d:
            return r6
        L3e:
            r6 = move-exception
            goto L45
        L40:
            r6 = move-exception
            r5 = r0
            goto L59
        L43:
            r6 = move-exception
            r5 = r0
        L45:
            com.google.android.gms.measurement.internal.zzef r1 = r4.zzab()     // Catch: java.lang.Throwable -> L58
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L57
            r5.close()
        L57:
            return r0
        L58:
            r6 = move-exception
        L59:
            if (r5 == 0) goto L5e
            r5.close()
        L5e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.a(long):java.lang.String");
    }

    public final long o() {
        Cursor cursor = null;
        try {
            try {
                cursor = g().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return -1L;
                }
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            } catch (SQLiteException e2) {
                zzab().zzgk().zza("Error querying raw events", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzbs.zzc, java.lang.Long> a(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzo()
            r7.c()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.g()     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L72
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L72
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L72
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L72
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L72
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6f android.database.sqlite.SQLiteException -> L72
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            if (r2 != 0) goto L37
            com.google.android.gms.measurement.internal.zzef r8 = r7.zzab()     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgs()     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            java.lang.String r9 = "Main event not found"
            r8.zzao(r9)     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            if (r1 == 0) goto L36
            r1.close()
        L36:
            return r0
        L37:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            com.google.android.gms.internal.measurement.zzel r4 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch: java.io.IOException -> L55 android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = com.google.android.gms.internal.measurement.zzbs.zzc.zzc(r2, r4)     // Catch: java.io.IOException -> L55 android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            android.util.Pair r8 = android.util.Pair.create(r8, r3)     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            if (r1 == 0) goto L54
            r1.close()
        L54:
            return r8
        L55:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzef r3 = r7.zzab()     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.a(r8)     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L6d java.lang.Throwable -> L87
            if (r1 == 0) goto L6c
            r1.close()
        L6c:
            return r0
        L6d:
            r8 = move-exception
            goto L74
        L6f:
            r8 = move-exception
            r1 = r0
            goto L88
        L72:
            r8 = move-exception
            r1 = r0
        L74:
            com.google.android.gms.measurement.internal.zzef r9 = r7.zzab()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgk()     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L86
            r1.close()
        L86:
            return r0
        L87:
            r8 = move-exception
        L88:
            if (r1 == 0) goto L8d
            r1.close()
        L8d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.he.a(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean a(String str, Long l, long j, zzbs.zzc zzcVar) {
        zzo();
        c();
        Preconditions.checkNotNull(zzcVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] byteArray = zzcVar.toByteArray();
        zzab().zzgs().zza("Saving complex main event, appId, data size", zzy().a(str), Integer.valueOf(byteArray.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", byteArray);
        try {
            if (g().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzab().zzgk().zza("Failed to insert complex main event (got -1). appId", zzef.a(str));
            return false;
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing complex main event. appId", zzef.a(str), e2);
            return false;
        }
    }

    public final boolean a(zzaf zzafVar, long j, boolean z) {
        zzo();
        c();
        Preconditions.checkNotNull(zzafVar);
        Preconditions.checkNotEmpty(zzafVar.f4924a);
        zzbs.zzc.zza zzah = zzbs.zzc.zzmq().zzah(zzafVar.d);
        Iterator<String> it = zzafVar.e.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzbs.zze.zza zzbz = zzbs.zze.zzng().zzbz(next);
            zzgw().a(zzbz, zzafVar.e.a(next));
            zzah.zza(zzbz);
        }
        byte[] byteArray = ((zzbs.zzc) ((zzey) zzah.zzug())).toByteArray();
        zzab().zzgs().zza("Saving event, name, data size", zzy().a(zzafVar.b), Integer.valueOf(byteArray.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzafVar.f4924a);
        contentValues.put("name", zzafVar.b);
        contentValues.put("timestamp", Long.valueOf(zzafVar.c));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", byteArray);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (g().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzab().zzgk().zza("Failed to insert raw event (got -1). appId", zzef.a(zzafVar.f4924a));
            return false;
        } catch (SQLiteException e2) {
            zzab().zzgk().zza("Error storing raw event. appId", zzef.a(zzafVar.f4924a), e2);
            return false;
        }
    }

    private final boolean x() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }
}
