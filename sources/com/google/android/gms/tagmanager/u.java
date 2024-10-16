package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class u extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ q f5153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(q qVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f5153a = qVar;
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
        Context context;
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = super.getWritableDatabase();
        } catch (SQLiteException unused) {
            context = this.f5153a.c;
            context.getDatabasePath("google_tagmanager.db").delete();
            sQLiteDatabase = null;
        }
        return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
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
        if (a("datalayer", sQLiteDatabase)) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str2 : rawQuery.getColumnNames()) {
                    hashSet.add(str2);
                }
                rawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
                return;
            } finally {
            }
        }
        str = q.f5149a;
        sQLiteDatabase.execSQL(str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ah.a(sQLiteDatabase.getPath());
    }
}
