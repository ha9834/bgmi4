package com.helpshift.support.search.storage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.helpshift.support.db.search.SearchDBHelper;
import com.helpshift.support.db.search.SearchDatabaseContract;
import com.helpshift.support.db.search.tables.SearchTable;
import com.helpshift.support.search.SearchTokenDao;
import com.helpshift.support.search.SearchTokenDto;
import com.helpshift.util.HSLogger;
import com.helpshift.util.HelpshiftContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SearchTokenDaoImpl implements SearchTokenDao {
    private static final String TAG = "Helpshift_SearchToknDao";
    private final char scoreMapStringSeparator = '$';
    private final char scoreMapKeyValueStringSeparator = ':';
    private final SQLiteOpenHelper dbHelper = new SearchDBHelper(HelpshiftContext.getApplicationContext(), new SearchDatabaseContract());

    SearchTokenDaoImpl() {
    }

    public static SearchTokenDao getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.search.SearchTokenDao
    public void save(List<SearchTokenDto> list) {
        SQLiteDatabase sQLiteDatabase;
        String str;
        String str2;
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SearchTokenDto searchTokenDto : list) {
            String convertScoreMapToScoreString = convertScoreMapToScoreString(searchTokenDto.scoreMap);
            ContentValues contentValues = new ContentValues();
            contentValues.put("token", searchTokenDto.wordValue);
            contentValues.put("type", Integer.valueOf(searchTokenDto.wordType));
            contentValues.put("score", convertScoreMapToScoreString);
            arrayList.add(contentValues);
        }
        synchronized (this.dbHelper) {
            SQLiteDatabase sQLiteDatabase2 = null;
            try {
                try {
                    sQLiteDatabase = this.dbHelper.getWritableDatabase();
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = sQLiteDatabase2;
            }
            try {
                sQLiteDatabase.beginTransaction();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.insert(SearchTable.TABLE_NAME, null, (ContentValues) it.next());
                }
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = TAG;
                        str2 = "Error occurred when calling save method inside finally block";
                        HSLogger.e(str, str2, e);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                sQLiteDatabase2 = sQLiteDatabase;
                HSLogger.e(TAG, "Error occurred when calling save method", e);
                if (sQLiteDatabase2 != null) {
                    try {
                        if (sQLiteDatabase2.inTransaction()) {
                            sQLiteDatabase2.endTransaction();
                        }
                    } catch (Exception e4) {
                        e = e4;
                        str = TAG;
                        str2 = "Error occurred when calling save method inside finally block";
                        HSLogger.e(str, str2, e);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (sQLiteDatabase != null) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e5) {
                        HSLogger.e(TAG, "Error occurred when calling save method inside finally block", e5);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0060, code lost:
    
        if (r13 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        if (r13 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:13:0x0062, B:14:0x0079, B:23:0x007e, B:24:0x0081), top: B:4:0x0004 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.search.SearchTokenDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.helpshift.support.search.SearchTokenDto get(java.lang.String r13) {
        /*
            r12 = this;
            android.database.sqlite.SQLiteOpenHelper r0 = r12.dbHelper
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteOpenHelper r2 = r12.dbHelper     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            r2 = 3
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            java.lang.String r2 = "token"
            r4 = 0
            r5[r4] = r2     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            java.lang.String r2 = "type"
            r6 = 1
            r5[r6] = r2     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            r2 = 2
            java.lang.String r7 = "score"
            r5[r2] = r7     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            java.lang.String r2 = "search_token_table"
            java.lang.String r7 = "token=?"
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            r8[r4] = r13     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            r13 = 0
            r9 = 0
            r10 = 0
            r4 = r2
            r6 = r7
            r7 = r8
            r8 = r13
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6d
            int r2 = r13.getCount()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            if (r2 <= 0) goto L60
            r13.moveToFirst()     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            java.lang.String r2 = "token"
            int r2 = r13.getColumnIndexOrThrow(r2)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            java.lang.String r2 = r13.getString(r2)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            java.lang.String r3 = "type"
            int r3 = r13.getColumnIndexOrThrow(r3)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            int r3 = r13.getInt(r3)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            java.lang.String r4 = "score"
            int r4 = r13.getColumnIndexOrThrow(r4)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            java.lang.String r4 = r13.getString(r4)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            java.util.Map r4 = r12.convertScoreStringToScoreMap(r4)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            com.helpshift.support.search.SearchTokenDto r5 = new com.helpshift.support.search.SearchTokenDto     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            r5.<init>(r2, r3, r4)     // Catch: java.lang.Exception -> L66 java.lang.Throwable -> L7b
            r1 = r5
        L60:
            if (r13 == 0) goto L79
        L62:
            r13.close()     // Catch: java.lang.Throwable -> L82
            goto L79
        L66:
            r2 = move-exception
            goto L6f
        L68:
            r13 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L7c
        L6d:
            r2 = move-exception
            r13 = r1
        L6f:
            java.lang.String r3 = "Helpshift_SearchToknDao"
            java.lang.String r4 = "Error occurred when calling get method"
            com.helpshift.util.HSLogger.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L7b
            if (r13 == 0) goto L79
            goto L62
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            return r1
        L7b:
            r1 = move-exception
        L7c:
            if (r13 == 0) goto L81
            r13.close()     // Catch: java.lang.Throwable -> L82
        L81:
            throw r1     // Catch: java.lang.Throwable -> L82
        L82:
            r13 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L82
            throw r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.search.storage.SearchTokenDaoImpl.get(java.lang.String):com.helpshift.support.search.SearchTokenDto");
    }

    @Override // com.helpshift.support.search.SearchTokenDao
    public void clear() {
        synchronized (this.dbHelper) {
            try {
                this.dbHelper.getWritableDatabase().delete(SearchTable.TABLE_NAME, null, null);
            } catch (Exception e) {
                HSLogger.e(TAG, "Error occurred when calling clear method", e);
            }
        }
    }

    private String convertScoreMapToScoreString(Map<Integer, Double> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append('$');
            }
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private Map<Integer, Double> convertScoreStringToScoreMap(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        if (str == null) {
            return hashMap;
        }
        for (String str2 : str.split("[$]")) {
            if (str2 != null && str2.length() > 0 && (split = str2.split("[:]")) != null && split.length == 2) {
                hashMap.put(Integer.valueOf(Integer.valueOf(split[0]).intValue()), Double.valueOf(Double.valueOf(split[1]).doubleValue()));
            }
        }
        return hashMap;
    }

    /* loaded from: classes2.dex */
    private static class LazyHolder {
        static final SearchTokenDao INSTANCE = new SearchTokenDaoImpl();

        private LazyHolder() {
        }
    }
}
