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
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class q implements DataLayer.c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5149a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Executor b;
    private final Context c;
    private u d;
    private Clock e;
    private int f;

    public q(Context context) {
        this(context, DefaultClock.getInstance(), "google_tagmanager.db", 2000, zzdf.zzgp().zzr(com.google.android.gms.internal.gtm.zzdi.zzadg));
    }

    @VisibleForTesting
    private q(Context context, Clock clock, String str, int i, Executor executor) {
        this.c = context;
        this.e = clock;
        this.f = 2000;
        this.b = executor;
        this.d = new u(this, this.c, str);
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(List<DataLayer.a> list, long j) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.a aVar : list) {
            arrayList.add(new v(aVar.f5065a, a(aVar.b)));
        }
        this.b.execute(new r(this, arrayList, j));
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(zzaq zzaqVar) {
        this.b.execute(new s(this, zzaqVar));
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.c
    public final void a(String str) {
        this.b.execute(new t(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<DataLayer.a> b() {
        try {
            a(this.e.currentTimeMillis());
            List<v> c = c();
            ArrayList arrayList = new ArrayList();
            for (v vVar : c) {
                arrayList.add(new DataLayer.a(vVar.f5154a, a(vVar.b)));
            }
            return arrayList;
        } finally {
            e();
        }
    }

    private static Object a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectInputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException unused) {
                }
                return readObject;
            } catch (IOException unused2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused3) {
                        return null;
                    }
                }
                byteArrayInputStream.close();
                return null;
            } catch (ClassNotFoundException unused4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException unused5) {
                        return null;
                    }
                }
                byteArrayInputStream.close();
                return null;
            } catch (Throwable th) {
                th = th;
                objectInputStream2 = objectInputStream;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException unused7) {
            objectInputStream = null;
        } catch (ClassNotFoundException unused8) {
            objectInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static byte[] a(Object obj) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return byteArray;
            } catch (IOException unused2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                        return null;
                    }
                }
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException unused5) {
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void b(List<v> list, long j) {
        SQLiteDatabase c;
        try {
            long currentTimeMillis = this.e.currentTimeMillis();
            a(currentTimeMillis);
            int d = (d() - this.f) + list.size();
            if (d > 0) {
                List<String> a2 = a(d);
                int size = a2.size();
                StringBuilder sb = new StringBuilder(64);
                sb.append("DataLayer store full, deleting ");
                sb.append(size);
                sb.append(" entries to make room.");
                zzdi.zzaw(sb.toString());
                String[] strArr = (String[]) a2.toArray(new String[0]);
                if (strArr != null && strArr.length != 0 && (c = c("Error opening database for deleteEntries.")) != null) {
                    try {
                        c.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
                    } catch (SQLiteException unused) {
                        String valueOf = String.valueOf(Arrays.toString(strArr));
                        zzdi.zzac(valueOf.length() != 0 ? "Error deleting entries ".concat(valueOf) : new String("Error deleting entries "));
                    }
                }
            }
            long j2 = currentTimeMillis + j;
            SQLiteDatabase c2 = c("Error opening database for writeEntryToDatabase.");
            if (c2 != null) {
                for (v vVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("expires", Long.valueOf(j2));
                    contentValues.put("key", vVar.f5154a);
                    contentValues.put("value", vVar.b);
                    c2.insert("datalayer", null, contentValues);
                }
            }
        } finally {
            e();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final List<v> c() {
        SQLiteDatabase c = c("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (c == null) {
            return arrayList;
        }
        Cursor query = c.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new v(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        SQLiteDatabase c = c("Error opening database for clearKeysWithPrefix.");
        try {
            if (c == null) {
                return;
            }
            int delete = c.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, String.valueOf(str).concat(".%")});
            StringBuilder sb = new StringBuilder(25);
            sb.append("Cleared ");
            sb.append(delete);
            sb.append(" items");
            zzdi.zzab(sb.toString());
        } catch (SQLiteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 44 + String.valueOf(valueOf).length());
            sb2.append("Error deleting entries with key prefix: ");
            sb2.append(str);
            sb2.append(" (");
            sb2.append(valueOf);
            sb2.append(").");
            zzdi.zzac(sb2.toString());
        } finally {
            e();
        }
    }

    private final void a(long j) {
        SQLiteDatabase c = c("Error opening database for deleteOlderThan.");
        if (c == null) {
            return;
        }
        try {
            int delete = c.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)});
            StringBuilder sb = new StringBuilder(33);
            sb.append("Deleted ");
            sb.append(delete);
            sb.append(" expired items");
            zzdi.zzab(sb.toString());
        } catch (SQLiteException unused) {
            zzdi.zzac("Error deleting old entries.");
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
            java.lang.String r14 = "Invalid maxEntries specified. Skipping."
            com.google.android.gms.tagmanager.zzdi.zzac(r14)
            return r0
        Ld:
            java.lang.String r1 = "Error opening database for peekEntryIds."
            android.database.sqlite.SQLiteDatabase r2 = r13.c(r1)
            if (r2 != 0) goto L16
            return r0
        L16:
            r1 = 0
            java.lang.String r3 = "datalayer"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r6 = "ID"
            r11 = 0
            r5[r11] = r6     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r10 = "%s ASC"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r12 = "ID"
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
            java.lang.String r2 = "Error in peekEntries fetching entryIds: "
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.q.a(int):java.util.List");
    }

    private final int d() {
        SQLiteDatabase c = c("Error opening database for getNumStoredEntries.");
        if (c == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = c.rawQuery("SELECT COUNT(*) from datalayer", null);
                r1 = cursor.moveToFirst() ? (int) cursor.getLong(0) : 0;
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException unused) {
                zzdi.zzac("Error getting numStoredEntries");
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

    private final SQLiteDatabase c(String str) {
        try {
            return this.d.getWritableDatabase();
        } catch (SQLiteException unused) {
            zzdi.zzac(str);
            return null;
        }
    }

    private final void e() {
        try {
            this.d.close();
        } catch (SQLiteException unused) {
        }
    }
}
