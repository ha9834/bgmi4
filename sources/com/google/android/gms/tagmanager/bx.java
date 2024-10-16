package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class bx extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5097a;
    private long b;
    private final /* synthetic */ bv c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(bv bvVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.c = bvVar;
        this.b = 0L;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private static boolean a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean moveToFirst = cursor.moveToFirst();
                if (cursor != null) {
                    cursor.close();
                }
                return moveToFirst;
            } catch (SQLiteException unused) {
                String valueOf = String.valueOf(str);
                zzdi.zzac(valueOf.length() != 0 ? "Error querying for table ".concat(valueOf) : new String("Error querying for table "));
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        Clock clock;
        Context context;
        String str;
        Clock clock2;
        if (this.f5097a) {
            long j = this.b + 3600000;
            clock2 = this.c.h;
            if (j > clock2.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
        }
        SQLiteDatabase sQLiteDatabase = null;
        this.f5097a = true;
        clock = this.c.h;
        this.b = clock.currentTimeMillis();
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            context = this.c.e;
            str = this.c.f;
            context.getDatabasePath(str).delete();
        }
        if (sQLiteDatabase == null) {
            sQLiteDatabase = super.getWritableDatabase();
        }
        this.f5097a = false;
        return sQLiteDatabase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        String str;
        if (Build.VERSION.SDK_INT < 15) {
            try {
                sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null).moveToFirst();
            } finally {
            }
        }
        if (a("gtm_hits", sQLiteDatabase)) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str2 : rawQuery.getColumnNames()) {
                    hashSet.add(str2);
                }
                rawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
                return;
            } finally {
            }
        }
        str = bv.f5095a;
        sQLiteDatabase.execSQL(str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ah.a(sQLiteDatabase.getPath());
    }
}
