package com.google.android.gms.internal.gtm;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.HttpUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.helpshift.util.ErrorReportProvider;
import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends zzan implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4367a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id");
    private static final String b = String.format("SELECT MAX(%s) FROM %s WHERE 1;", "hit_time", "hits2");
    private final m c;
    private final ai d;
    private final ai e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(zzap zzapVar) {
        super(zzapVar);
        this.d = new ai(d());
        this.e = new ai(d());
        this.c = new m(this, zzapVar.getContext(), "google_analytics_v4.db");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String y() {
        return "google_analytics_v4.db";
    }

    @Override // com.google.android.gms.internal.gtm.zzan
    protected final void a() {
    }

    public final void b() {
        q();
        v().beginTransaction();
    }

    public final void c() {
        q();
        v().setTransactionSuccessful();
    }

    public final void r() {
        q();
        v().endTransaction();
    }

    public final void a(zzcd zzcdVar) {
        String zzeu;
        Preconditions.checkNotNull(zzcdVar);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        Preconditions.checkNotNull(zzcdVar);
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : zzcdVar.zzdm().entrySet()) {
            String key = entry.getKey();
            if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key)) {
                builder.appendQueryParameter(key, entry.getValue());
            }
        }
        String encodedQuery = builder.build().getEncodedQuery();
        if (encodedQuery == null) {
            encodedQuery = "";
        }
        if (encodedQuery.length() > 8192) {
            f().zza(zzcdVar, "Hit length exceeds the maximum allowed size");
            return;
        }
        int intValue = zzby.zzze.get().intValue();
        long x = x();
        if (x > intValue - 1) {
            List<Long> d = d((x - intValue) + 1);
            zzd("Store full, deleting hits to make room, count", Integer.valueOf(d.size()));
            a(d);
        }
        SQLiteDatabase v = v();
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_string", encodedQuery);
        contentValues.put("hit_time", Long.valueOf(zzcdVar.zzfh()));
        contentValues.put("hit_app_id", Integer.valueOf(zzcdVar.zzff()));
        if (zzcdVar.zzfj()) {
            zzeu = zzbq.zzet();
        } else {
            zzeu = zzbq.zzeu();
        }
        contentValues.put("hit_url", zzeu);
        try {
            long insert = v.insert("hits2", null, contentValues);
            if (insert == -1) {
                zzu("Failed to insert a hit (got -1)");
            } else {
                zzb("Hit saved to database. db-id, hit", Long.valueOf(insert), zzcdVar);
            }
        } catch (SQLiteException e) {
            zze("Error storing a hit", e);
        }
    }

    private final long x() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        return a("SELECT COUNT(*) FROM hits2", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s() {
        return x() == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x004a, code lost:
    
        r9.add(java.lang.Long.valueOf(r10.getLong(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r10.moveToNext() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
    
        if (r10 == null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0048, code lost:
    
        if (r10.moveToFirst() != false) goto L9;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.lang.Long> d(long r14) {
        /*
            r13 = this;
            com.google.android.gms.analytics.zzk.zzav()
            r13.q()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 > 0) goto L11
            java.util.List r14 = java.util.Collections.emptyList()
            return r14
        L11:
            android.database.sqlite.SQLiteDatabase r0 = r13.v()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = 0
            java.lang.String r1 = "hits2"
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.String r4 = "hit_id"
            r11 = 0
            r3[r11] = r4     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r8 = "%s ASC"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.String r12 = "hit_id"
            r2[r11] = r12     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.String r8 = java.lang.String.format(r8, r2)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.String r14 = java.lang.Long.toString(r14)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r14
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            boolean r14 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            if (r14 == 0) goto L5b
        L4a:
            long r14 = r10.getLong(r11)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            r9.add(r14)     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            boolean r14 = r10.moveToNext()     // Catch: java.lang.Throwable -> L61 android.database.sqlite.SQLiteException -> L63
            if (r14 != 0) goto L4a
        L5b:
            if (r10 == 0) goto L6e
            r10.close()
            goto L6e
        L61:
            r14 = move-exception
            goto L6f
        L63:
            r14 = move-exception
            java.lang.String r15 = "Error selecting hit ids"
            r13.zzd(r15, r14)     // Catch: java.lang.Throwable -> L61
            if (r10 == 0) goto L6e
            r10.close()
        L6e:
            return r9
        L6f:
            if (r10 == 0) goto L74
            r10.close()
        L74:
            throw r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.l.d(long):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<zzcd> a(long j) {
        int i;
        int i2;
        int i3;
        Cursor query;
        int i4 = 1;
        Preconditions.checkArgument(j >= 0);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        Cursor cursor = null;
        try {
            try {
                i = 2;
                i2 = 3;
                i3 = 4;
                query = v().query("hits2", new String[]{"hit_id", "hit_time", "hit_string", "hit_url", "hit_app_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Long.toString(j));
            } catch (SQLiteException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (query.moveToFirst()) {
                while (true) {
                    arrayList.add(new zzcd(this, a(query.getString(i)), query.getLong(i4), zzcz.zzaj(query.getString(i2)), query.getLong(0), query.getInt(i3)));
                    if (!query.moveToNext()) {
                        break;
                    }
                    i4 = 1;
                    i2 = 3;
                    i3 = 4;
                    i = 2;
                }
            }
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (SQLiteException e2) {
            e = e2;
            cursor = query;
            zze("Error loading hits from the database", e);
            throw e;
        } catch (Throwable th2) {
            th = th2;
            cursor = query;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(List<Long> list) {
        Preconditions.checkNotNull(list);
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (list.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("hit_id");
        sb.append(" in (");
        for (int i = 0; i < list.size(); i++) {
            Long l = list.get(i);
            if (l == null || l.longValue() == 0) {
                throw new SQLiteException("Invalid hit id");
            }
            if (i > 0) {
                sb.append(",");
            }
            sb.append(l);
        }
        sb.append(")");
        String sb2 = sb.toString();
        try {
            SQLiteDatabase v = v();
            zza("Deleting dispatched hits. count", Integer.valueOf(list.size()));
            int delete = v.delete("hits2", sb2, null);
            if (delete != list.size()) {
                zzb("Deleted fewer hits then expected", Integer.valueOf(list.size()), Integer.valueOf(delete), sb2);
            }
        } catch (SQLiteException e) {
            zze("Error deleting hits", e);
            throw e;
        }
    }

    public final void b(long j) {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Long.valueOf(j));
        zza("Deleting hit, id", Long.valueOf(j));
        a((List<Long>) arrayList);
    }

    public final int t() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        if (!this.d.a(ErrorReportProvider.BATCH_TIME)) {
            return 0;
        }
        this.d.a();
        zzq("Deleting stale hits (if any)");
        int delete = v().delete("hits2", "hit_time < ?", new String[]{Long.toString(d().currentTimeMillis() - 2592000000L)});
        zza("Deleted stale hits, count", Integer.valueOf(delete));
        return delete;
    }

    public final long u() {
        com.google.android.gms.analytics.zzk.zzav();
        q();
        return a(b, (String[]) null, 0L);
    }

    public final long a(long j, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        q();
        com.google.android.gms.analytics.zzk.zzav();
        return a("SELECT hits_count FROM properties WHERE app_uid=? AND cid=? AND tid=?", new String[]{String.valueOf(j), str, str2}, 0L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x006a, code lost:
    
        r6 = r2.getInt(3);
        r24 = b(r2.getString(4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x007b, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0081, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0084, code lost:
    
        r3.add(new com.google.android.gms.internal.gtm.zzas(0, r4, r5, r21, r6, r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a0, code lost:
    
        if (r2.moveToNext() != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0097, code lost:
    
        zzc("Read property with empty client id or tracker id", r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        r21 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a6, code lost:
    
        if (r3.size() < r0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a8, code lost:
    
        zzt("Sending hits to too many properties. Campaign report might be incorrect");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
    
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b2, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0055, code lost:
    
        if (r2.moveToFirst() != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0057, code lost:
    
        r4 = r2.getString(0);
        r5 = r2.getString(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0063, code lost:
    
        if (r2.getInt(2) == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0065, code lost:
    
        r21 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.gtm.zzas> c(long r26) {
        /*
            r25 = this;
            r1 = r25
            r25.q()
            com.google.android.gms.analytics.zzk.zzav()
            android.database.sqlite.SQLiteDatabase r2 = r25.v()
            r0 = 5
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r0 = "cid"
            r12 = 0
            r4[r12] = r0     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r0 = "tid"
            r13 = 1
            r4[r13] = r0     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r0 = "adid"
            r14 = 2
            r4[r14] = r0     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r0 = "hits_count"
            r15 = 3
            r4[r15] = r0     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r0 = "params"
            r10 = 4
            r4[r10] = r0     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            com.google.android.gms.internal.gtm.zzbz<java.lang.Integer> r0 = com.google.android.gms.internal.gtm.zzby.zzzg     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            int r0 = r0.intValue()     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r16 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r5 = "app_uid=?"
            java.lang.String[] r6 = new java.lang.String[r13]     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r3 = "0"
            r6[r12] = r3     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.lang.String r3 = "properties"
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r10 = r16
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lb8 android.database.sqlite.SQLiteException -> Lbb
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            r3.<init>()     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            boolean r4 = r2.moveToFirst()     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            if (r4 == 0) goto La2
        L57:
            java.lang.String r4 = r2.getString(r12)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            java.lang.String r5 = r2.getString(r13)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            int r6 = r2.getInt(r14)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            if (r6 == 0) goto L68
            r21 = 1
            goto L6a
        L68:
            r21 = 0
        L6a:
            int r6 = r2.getInt(r15)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            long r6 = (long) r6     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            java.lang.String r8 = r2.getString(r11)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            java.util.Map r24 = r1.b(r8)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            if (r8 != 0) goto L97
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            if (r8 == 0) goto L84
            goto L97
        L84:
            com.google.android.gms.internal.gtm.zzas r8 = new com.google.android.gms.internal.gtm.zzas     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            r17 = 0
            r16 = r8
            r19 = r4
            r20 = r5
            r22 = r6
            r16.<init>(r17, r19, r20, r21, r22, r24)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            r3.add(r8)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            goto L9c
        L97:
            java.lang.String r6 = "Read property with empty client id or tracker id"
            r1.zzc(r6, r4, r5)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
        L9c:
            boolean r4 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            if (r4 != 0) goto L57
        La2:
            int r4 = r3.size()     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
            if (r4 < r0) goto Lad
            java.lang.String r0 = "Sending hits to too many properties. Campaign report might be incorrect"
            r1.zzt(r0)     // Catch: java.lang.Throwable -> Lb3 android.database.sqlite.SQLiteException -> Lb5
        Lad:
            if (r2 == 0) goto Lb2
            r2.close()
        Lb2:
            return r3
        Lb3:
            r0 = move-exception
            goto Lc5
        Lb5:
            r0 = move-exception
            r11 = r2
            goto Lbd
        Lb8:
            r0 = move-exception
            r2 = 0
            goto Lc5
        Lbb:
            r0 = move-exception
            r11 = 0
        Lbd:
            java.lang.String r2 = "Error loading hits from the database"
            r1.zze(r2, r0)     // Catch: java.lang.Throwable -> Lc3
            throw r0     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r0 = move-exception
            r2 = r11
        Lc5:
            if (r2 == 0) goto Lca
            r2.close()
        Lca:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.l.c(long):java.util.List");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.c.close();
        } catch (SQLiteException e) {
            zze("Sql error closing database", e);
        } catch (IllegalStateException e2) {
            zze("Error closing database", e2);
        }
    }

    private final long a(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = v().rawQuery(str, null);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    if (rawQuery != null) {
                        rawQuery.close();
                    }
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
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
                cursor = v().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    return cursor.getLong(0);
                }
                if (cursor == null) {
                    return 0L;
                }
                cursor.close();
                return 0L;
            } catch (SQLiteException e) {
                zzd("Database error", str, e);
                throw e;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @VisibleForTesting
    private final Map<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            if (!str.startsWith("?")) {
                String valueOf = String.valueOf(str);
                str = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            return HttpUtils.parse(new URI(str), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing hit parameters", e);
            return new HashMap(0);
        }
    }

    @VisibleForTesting
    private final Map<String, String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap(0);
        }
        try {
            String valueOf = String.valueOf(str);
            return HttpUtils.parse(new URI(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")), "UTF-8");
        } catch (URISyntaxException e) {
            zze("Error parsing property parameters", e);
            return new HashMap(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase v() {
        try {
            return this.c.getWritableDatabase();
        } catch (SQLiteException e) {
            zzd("Error opening database", e);
            throw e;
        }
    }
}
