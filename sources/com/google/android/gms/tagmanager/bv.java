package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.helpshift.util.ErrorReportProvider;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class bv implements ar {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5095a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final bx b;
    private volatile aa c;
    private final as d;
    private final Context e;
    private final String f;
    private long g;
    private Clock h;
    private final int i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(as asVar, Context context) {
        this(asVar, context, "gtm_urls.db", 2000);
    }

    @VisibleForTesting
    private bv(as asVar, Context context, String str, int i) {
        this.e = context.getApplicationContext();
        this.f = str;
        this.d = asVar;
        this.h = DefaultClock.getInstance();
        this.b = new bx(this, this.e, this.f);
        this.c = new dl(this.e, new bw(this));
        this.g = 0L;
        this.i = 2000;
    }

    @Override // com.google.android.gms.tagmanager.ar
    public final void a(long j, String str) {
        long currentTimeMillis = this.h.currentTimeMillis();
        if (currentTimeMillis > this.g + ErrorReportProvider.BATCH_TIME) {
            this.g = currentTimeMillis;
            SQLiteDatabase a2 = a("Error opening database for deleteStaleHits.");
            if (a2 != null) {
                a2.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.h.currentTimeMillis() - 2592000000L)});
                this.d.a(c() == 0);
            }
        }
        int c = (c() - this.i) + 1;
        if (c > 0) {
            List<String> a3 = a(c);
            int size = a3.size();
            StringBuilder sb = new StringBuilder(51);
            sb.append("Store full, deleting ");
            sb.append(size);
            sb.append(" hits to make room.");
            zzdi.zzab(sb.toString());
            a((String[]) a3.toArray(new String[0]));
        }
        SQLiteDatabase a4 = a("Error opening database for putHit");
        if (a4 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_time", Long.valueOf(j));
            contentValues.put("hit_url", str);
            contentValues.put("hit_first_send_time", (Integer) 0);
            try {
                a4.insert("gtm_hits", null, contentValues);
                this.d.a(false);
            } catch (SQLiteException unused) {
                zzdi.zzac("Error storing hit");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        if (r1.moveToFirst() != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
    
        r0.add(java.lang.String.valueOf(r1.getLong(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
    
        if (r1.moveToNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        r1.close();
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<java.lang.String> a(int r14) {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r14 > 0) goto Ld
            java.lang.String r14 = "Invalid maxHits specified. Skipping"
            com.google.android.gms.tagmanager.zzdi.zzac(r14)
            return r0
        Ld:
            java.lang.String r1 = "Error opening database for peekHitIds."
            android.database.sqlite.SQLiteDatabase r2 = r13.a(r1)
            if (r2 != 0) goto L16
            return r0
        L16:
            r1 = 0
            java.lang.String r3 = "gtm_hits"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r6 = "hit_id"
            r11 = 0
            r5[r11] = r6     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "%s ASC"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r12 = "hit_id"
            r4[r11] = r12     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r10 = java.lang.String.format(r10, r4)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r14 = java.lang.Integer.toString(r14)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r14
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            boolean r14 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r14 == 0) goto L57
        L46:
            long r2 = r1.getLong(r11)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r14 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r0.add(r14)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            boolean r14 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r14 != 0) goto L46
        L57:
            if (r1 == 0) goto L82
            r1.close()
            goto L82
        L5d:
            r14 = move-exception
            goto L83
        L5f:
            r14 = move-exception
            java.lang.String r2 = "Error in peekHits fetching hitIds: "
            java.lang.String r14 = r14.getMessage()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch: java.lang.Throwable -> L5d
            int r3 = r14.length()     // Catch: java.lang.Throwable -> L5d
            if (r3 == 0) goto L75
            java.lang.String r14 = r2.concat(r14)     // Catch: java.lang.Throwable -> L5d
            goto L7a
        L75:
            java.lang.String r14 = new java.lang.String     // Catch: java.lang.Throwable -> L5d
            r14.<init>(r2)     // Catch: java.lang.Throwable -> L5d
        L7a:
            com.google.android.gms.tagmanager.zzdi.zzac(r14)     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r0
        L83:
            if (r1 == 0) goto L88
            r1.close()
        L88:
            throw r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.bv.a(int):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0049, code lost:
    
        if (r12.moveToFirst() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006b, code lost:
    
        if (r12 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0090, code lost:
    
        r15 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0093, code lost:
    
        r12 = r0.query("gtm_hits", new java.lang.String[]{"hit_id", "hit_url"}, null, null, null, null, java.lang.String.format("%s ASC", "hit_id"), java.lang.Integer.toString(40));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x009b, code lost:
    
        if (r12.moveToFirst() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009d, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a9, code lost:
    
        if (((android.database.sqlite.SQLiteCursor) r12).getWindow().getNumRows() <= 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
    
        ((com.google.android.gms.tagmanager.am) r15.get(r0)).a(r12.getString(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d4, code lost:
    
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00da, code lost:
    
        if (r12.moveToNext() != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b9, code lost:
    
        com.google.android.gms.tagmanager.zzdi.zzac(java.lang.String.format("HitString for hitId %d too large.  Hit will be deleted.", java.lang.Long.valueOf(((com.google.android.gms.tagmanager.am) r15.get(r0)).a())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e1, code lost:
    
        return r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e8, code lost:
    
        r0 = java.lang.String.valueOf(r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f6, code lost:
    
        if (r0.length() != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f8, code lost:
    
        r0 = "Error in peekHits fetching hit url: ".concat(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0102, code lost:
    
        com.google.android.gms.tagmanager.zzdi.zzac(r0);
        r0 = new java.util.ArrayList();
        r11 = r15;
        r1 = r11.size();
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0114, code lost:
    
        r4 = r11.get(r13);
        r13 = r13 + 1;
        r4 = (com.google.android.gms.tagmanager.am) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0124, code lost:
    
        if (android.text.TextUtils.isEmpty(r4.c()) == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0126, code lost:
    
        if (r3 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0128, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0129, code lost:
    
        r0.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012d, code lost:
    
        if (r12 != null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012f, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0132, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00fd, code lost:
    
        r0 = new java.lang.String("Error in peekHits fetching hit url: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0133, code lost:
    
        if (r12 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0135, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0138, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e7, code lost:
    
        r15 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x004b, code lost:
    
        r11.add(new com.google.android.gms.tagmanager.am(r12.getLong(0), r12.getLong(1), r12.getLong(2)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0064, code lost:
    
        if (r12.moveToNext() != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0067, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0068, code lost:
    
        r1 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0140, code lost:
    
        r0 = java.lang.String.valueOf(r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x014e, code lost:
    
        if (r0.length() != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0150, code lost:
    
        r0 = "Error in peekHits fetching hitIds: ".concat(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x015a, code lost:
    
        com.google.android.gms.tagmanager.zzdi.zzac(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x015d, code lost:
    
        if (r12 != null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015f, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0162, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0155, code lost:
    
        r0 = new java.lang.String("Error in peekHits fetching hitIds: ");
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<com.google.android.gms.tagmanager.am> b(int r18) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.bv.b(int):java.util.List");
    }

    private final void a(String[] strArr) {
        SQLiteDatabase a2;
        if (strArr == null || strArr.length == 0 || (a2 = a("Error opening database for deleteHits.")) == null) {
            return;
        }
        boolean z = true;
        try {
            a2.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            as asVar = this.d;
            if (c() != 0) {
                z = false;
            }
            asVar.a(z);
        } catch (SQLiteException unused) {
            zzdi.zzac("Error deleting hits");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j) {
        a(new String[]{String.valueOf(j)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j, long j2) {
        SQLiteDatabase a2 = a("Error opening database for getNumStoredHits.");
        if (a2 == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            a2.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException unused) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("Error setting HIT_FIRST_DISPATCH_TIME for hitId: ");
            sb.append(j);
            zzdi.zzac(sb.toString());
            a(j);
        }
    }

    private final int c() {
        SQLiteDatabase a2 = a("Error opening database for getNumStoredHits.");
        if (a2 == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = a2.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                r1 = cursor.moveToFirst() ? (int) cursor.getLong(0) : 0;
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException unused) {
                zzdi.zzac("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            }
            return r1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final int d() {
        SQLiteDatabase a2 = a("Error opening database for getNumStoredHits.");
        int i = 0;
        if (a2 == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = a2.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
                i = cursor.getCount();
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException unused) {
                zzdi.zzac("Error getting num untried hits");
                if (cursor != null) {
                    cursor.close();
                }
            }
            return i;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.tagmanager.ar
    public final void a() {
        zzdi.zzab("GTM Dispatch running...");
        if (this.c.a()) {
            List<am> b = b(40);
            if (b.isEmpty()) {
                zzdi.zzab("...nothing to dispatch");
                this.d.a(true);
            } else {
                this.c.a(b);
                if (d() > 0) {
                    df.a().dispatch();
                }
            }
        }
    }

    private final SQLiteDatabase a(String str) {
        try {
            return this.b.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }
}
