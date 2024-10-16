package com.google.android.vending.expansion.downloader.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;
import android.util.Log;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5377a = "com.google.android.vending.expansion.downloader.impl.c";
    private static c i;
    private static final String[] j = {"FN", "URI", "ETAG", "TOTALBYTES", "CURRENTBYTES", "LASTMOD", "STATUS", "CONTROL", "FAILCOUNT", "RETRYAFTER", "REDIRECTCOUNT", "FILEIDX"};
    final SQLiteOpenHelper b;
    SQLiteStatement c;
    SQLiteStatement d;
    long e;
    int f;
    int g;
    int h;

    /* loaded from: classes2.dex */
    public static class a implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[][] f5378a = {new String[]{"_id", "INTEGER PRIMARY KEY"}, new String[]{"FILEIDX", "INTEGER UNIQUE"}, new String[]{"URI", "TEXT"}, new String[]{"FN", "TEXT UNIQUE"}, new String[]{"ETAG", "TEXT"}, new String[]{"TOTALBYTES", "INTEGER"}, new String[]{"CURRENTBYTES", "INTEGER"}, new String[]{"LASTMOD", "INTEGER"}, new String[]{"STATUS", "INTEGER"}, new String[]{"CONTROL", "INTEGER"}, new String[]{"FAILCOUNT", "INTEGER"}, new String[]{"RETRYAFTER", "INTEGER"}, new String[]{"REDIRECTCOUNT", "INTEGER"}};
    }

    /* renamed from: com.google.android.vending.expansion.downloader.impl.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0122c implements BaseColumns {

        /* renamed from: a, reason: collision with root package name */
        public static final String[][] f5380a = {new String[]{"_id", "INTEGER PRIMARY KEY"}, new String[]{"APKVERSION", "INTEGER"}, new String[]{"DOWNLOADSTATUS", "INTEGER"}, new String[]{"DOWNLOADFLAGS", "INTEGER"}};
    }

    public static synchronized c a(Context context) {
        synchronized (c.class) {
            if (i == null) {
                return new c(context);
            }
            return i;
        }
    }

    private SQLiteStatement b() {
        if (this.c == null) {
            this.c = this.b.getReadableDatabase().compileStatement("SELECT _id FROM DownloadColumns WHERE FILEIDX = ?");
        }
        return this.c;
    }

    private SQLiteStatement c() {
        if (this.d == null) {
            this.d = this.b.getReadableDatabase().compileStatement("UPDATE DownloadColumns SET CURRENTBYTES = ? WHERE FILEIDX = ?");
        }
        return this.d;
    }

    private c(Context context) {
        this.e = -1L;
        this.f = -1;
        this.g = -1;
        this.b = new b(context);
        Cursor rawQuery = this.b.getReadableDatabase().rawQuery("SELECT APKVERSION,_id,DOWNLOADSTATUS,DOWNLOADFLAGS FROM MetadataColumns LIMIT 1", null);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            this.f = rawQuery.getInt(0);
            this.e = rawQuery.getLong(1);
            this.g = rawQuery.getInt(2);
            this.h = rawQuery.getInt(3);
            rawQuery.close();
        }
        i = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.google.android.vending.expansion.downloader.impl.a a(String str) {
        Cursor cursor = null;
        try {
            Cursor query = this.b.getReadableDatabase().query("DownloadColumns", j, "FN = ?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        com.google.android.vending.expansion.downloader.impl.a a2 = a(query);
                        if (query != null) {
                            query.close();
                        }
                        return a2;
                    }
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public long a(com.google.android.vending.expansion.downloader.impl.a aVar) {
        return a(aVar.b);
    }

    public long a(int i2) {
        SQLiteStatement b2 = b();
        b2.clearBindings();
        b2.bindLong(1, i2);
        try {
            return b2.simpleQueryForLong();
        } catch (SQLiteDoneException unused) {
            return -1L;
        }
    }

    public void b(com.google.android.vending.expansion.downloader.impl.a aVar) {
        SQLiteStatement c = c();
        c.clearBindings();
        c.bindLong(1, aVar.f);
        c.bindLong(2, aVar.b);
        c.execute();
    }

    /* loaded from: classes2.dex */
    protected static class b extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        private static final String[][][] f5379a = {a.f5378a, C0122c.f5380a};
        private static final String[] b = {"DownloadColumns", "MetadataColumns"};

        b(Context context) {
            super(context, "DownloadsDB", (SQLiteDatabase.CursorFactory) null, 7);
        }

        private String a(String str, String[][] strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(str);
            sb.append(" (");
            for (String[] strArr2 : strArr) {
                sb.append(' ');
                sb.append(strArr2[0]);
                sb.append(' ');
                sb.append(strArr2[1]);
                sb.append(',');
            }
            sb.setLength(sb.length() - 1);
            sb.append(");");
            return sb.toString();
        }

        private void a(SQLiteDatabase sQLiteDatabase) {
            for (String str : b) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            int length = f5379a.length;
            for (int i = 0; i < length; i++) {
                try {
                    sQLiteDatabase.execSQL(a(b[i], f5379a[i]));
                } catch (Exception e) {
                    while (true) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.w(b.class.getName(), "Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
            a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public boolean c(com.google.android.vending.expansion.downloader.impl.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("FILEIDX", Integer.valueOf(aVar.b));
        contentValues.put("FN", aVar.c);
        contentValues.put("URI", aVar.f5375a);
        contentValues.put("ETAG", aVar.d);
        contentValues.put("TOTALBYTES", Long.valueOf(aVar.e));
        contentValues.put("CURRENTBYTES", Long.valueOf(aVar.f));
        contentValues.put("LASTMOD", Long.valueOf(aVar.g));
        contentValues.put("STATUS", Integer.valueOf(aVar.h));
        contentValues.put("CONTROL", Integer.valueOf(aVar.i));
        contentValues.put("FAILCOUNT", Integer.valueOf(aVar.j));
        contentValues.put("RETRYAFTER", Integer.valueOf(aVar.k));
        contentValues.put("REDIRECTCOUNT", Integer.valueOf(aVar.l));
        return a(aVar, contentValues);
    }

    public boolean a(com.google.android.vending.expansion.downloader.impl.a aVar, ContentValues contentValues) {
        SQLiteDatabase writableDatabase;
        long a2 = aVar == null ? -1L : a(aVar);
        try {
            writableDatabase = this.b.getWritableDatabase();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (a2 == -1) {
            return -1 != writableDatabase.insert("DownloadColumns", "URI", contentValues);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("DownloadColumns._id = ");
        sb.append(a2);
        return 1 != writableDatabase.update("DownloadColumns", contentValues, sb.toString(), null) ? false : false;
    }

    public boolean b(int i2) {
        if (this.h == i2) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("DOWNLOADFLAGS", Integer.valueOf(i2));
        if (!a(contentValues)) {
            return false;
        }
        this.h = i2;
        return true;
    }

    public boolean c(int i2) {
        if (this.g == i2) {
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("DOWNLOADSTATUS", Integer.valueOf(i2));
        if (!a(contentValues)) {
            return false;
        }
        this.g = i2;
        return true;
    }

    public boolean a(ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.b.getWritableDatabase();
        if (-1 == this.e) {
            long insert = writableDatabase.insert("MetadataColumns", "APKVERSION", contentValues);
            if (-1 == insert) {
                return false;
            }
            this.e = insert;
            return true;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id = ");
        sb.append(this.e);
        return writableDatabase.update("MetadataColumns", contentValues, sb.toString(), null) != 0;
    }

    public boolean a(int i2, int i3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("APKVERSION", Integer.valueOf(i2));
        contentValues.put("DOWNLOADSTATUS", Integer.valueOf(i3));
        if (!a(contentValues)) {
            return false;
        }
        this.f = i2;
        this.g = i3;
        return true;
    }

    public boolean d(com.google.android.vending.expansion.downloader.impl.a aVar) {
        Cursor cursor = null;
        try {
            cursor = this.b.getReadableDatabase().query("DownloadColumns", j, "FN= ?", new String[]{aVar.c}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                a(aVar, cursor);
                return true;
            }
            if (cursor != null) {
                cursor.close();
            }
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void a(com.google.android.vending.expansion.downloader.impl.a aVar, Cursor cursor) {
        aVar.f5375a = cursor.getString(1);
        aVar.d = cursor.getString(2);
        aVar.e = cursor.getLong(3);
        aVar.f = cursor.getLong(4);
        aVar.g = cursor.getLong(5);
        aVar.h = cursor.getInt(6);
        aVar.i = cursor.getInt(7);
        aVar.j = cursor.getInt(8);
        aVar.k = cursor.getInt(9);
        aVar.l = cursor.getInt(10);
    }

    public com.google.android.vending.expansion.downloader.impl.a a(Cursor cursor) {
        com.google.android.vending.expansion.downloader.impl.a aVar = new com.google.android.vending.expansion.downloader.impl.a(cursor.getInt(11), cursor.getString(0), getClass().getPackage().getName());
        a(aVar, cursor);
        return aVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public com.google.android.vending.expansion.downloader.impl.a[] a() {
        Cursor cursor;
        Throwable th;
        try {
            cursor = this.b.getReadableDatabase().query("DownloadColumns", j, null, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        com.google.android.vending.expansion.downloader.impl.a[] aVarArr = new com.google.android.vending.expansion.downloader.impl.a[cursor.getCount()];
                        int i2 = 0;
                        while (true) {
                            int i3 = i2 + 1;
                            aVarArr[i2] = a(cursor);
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            i2 = i3;
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return aVarArr;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
        }
    }
}
