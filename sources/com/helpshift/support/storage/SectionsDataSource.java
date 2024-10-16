package com.helpshift.support.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.Section;
import com.helpshift.support.db.faq.FaqsDBHelper;
import com.helpshift.util.HSLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SectionsDataSource implements SectionDAO {
    private static final String TAG = "HelpShiftDebug";
    private final FaqsDBHelper dbHelper;
    private FaqDAO faqDAO;

    private SectionsDataSource() {
        this.dbHelper = FaqsDBHelper.getInstance();
        this.faqDAO = FaqsDataSource.getInstance();
    }

    private static Section cursorToSection(Cursor cursor) {
        return new Section(cursor.getLong(0), cursor.getString(1), cursor.getString(3), cursor.getString(2));
    }

    private static ContentValues sectionToContentValues(JSONObject jSONObject) throws JSONException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", jSONObject.getString("title"));
        contentValues.put("publish_id", jSONObject.getString("publish_id"));
        contentValues.put("section_id", jSONObject.getString("id"));
        return contentValues;
    }

    public static SectionsDataSource getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.storage.SectionDAO
    public synchronized void storeSections(JSONArray jSONArray) {
        String str;
        String str2;
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        try {
            try {
                writableDatabase.beginTransaction();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    writableDatabase.insert("sections", null, sectionToContentValues(jSONObject));
                    JSONArray optJSONArray = jSONObject.optJSONArray("faqs");
                    if (optJSONArray != null) {
                        FaqsDataSource.addFaqsUnsafe(writableDatabase, jSONObject.getString("publish_id"), optJSONArray);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    try {
                        if (writableDatabase.inTransaction()) {
                            writableDatabase.endTransaction();
                        }
                    } catch (Exception e) {
                        e = e;
                        str = "HelpShiftDebug";
                        str2 = "Error in storeSections inside finally block";
                        HSLogger.e(str, str2, e);
                    }
                }
            } catch (JSONException e2) {
                HSLogger.e("HelpShiftDebug", "Error in storeSections", e2);
                if (writableDatabase != null) {
                    try {
                        if (writableDatabase.inTransaction()) {
                            writableDatabase.endTransaction();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = "HelpShiftDebug";
                        str2 = "Error in storeSections inside finally block";
                        HSLogger.e(str, str2, e);
                    }
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r12 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
    
        if (r12 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0050 A[Catch: all -> 0x005b, TRY_ENTER, TryCatch #4 {, blocks: (B:8:0x0003, B:19:0x0034, B:29:0x0050, B:30:0x0053, B:3:0x0054), top: B:7:0x0003 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.storage.SectionDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.helpshift.support.Section getSection(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto L54
            java.lang.String r0 = ""
            boolean r0 = r12.equals(r0)     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto Lc
            goto L54
        Lc:
            r0 = 0
            com.helpshift.support.db.faq.FaqsDBHelper r1 = r11.dbHelper     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            java.lang.String r3 = "sections"
            r4 = 0
            java.lang.String r5 = "publish_id = ?"
            r1 = 1
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r1 = 0
            r6[r1] = r12     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3c
            r12.moveToFirst()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L4a
            boolean r1 = r12.isAfterLast()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L4a
            if (r1 != 0) goto L32
            com.helpshift.support.Section r0 = cursorToSection(r12)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L4a
        L32:
            if (r12 == 0) goto L48
        L34:
            r12.close()     // Catch: java.lang.Throwable -> L5b
            goto L48
        L38:
            r1 = move-exception
            goto L3e
        L3a:
            r12 = move-exception
            goto L4e
        L3c:
            r1 = move-exception
            r12 = r0
        L3e:
            java.lang.String r2 = "HelpShiftDebug"
            java.lang.String r3 = "Error in getSection"
            com.helpshift.util.HSLogger.e(r2, r3, r1)     // Catch: java.lang.Throwable -> L4a
            if (r12 == 0) goto L48
            goto L34
        L48:
            monitor-exit(r11)
            return r0
        L4a:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        L4e:
            if (r0 == 0) goto L53
            r0.close()     // Catch: java.lang.Throwable -> L5b
        L53:
            throw r12     // Catch: java.lang.Throwable -> L5b
        L54:
            com.helpshift.support.Section r12 = new com.helpshift.support.Section     // Catch: java.lang.Throwable -> L5b
            r12.<init>()     // Catch: java.lang.Throwable -> L5b
            monitor-exit(r11)
            return r12
        L5b:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.SectionsDataSource.getSection(java.lang.String):com.helpshift.support.Section");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        if (r1 == null) goto L19;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.storage.SectionDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.helpshift.support.Section> getAllSections() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L48
            r0.<init>()     // Catch: java.lang.Throwable -> L48
            r1 = 0
            com.helpshift.support.db.faq.FaqsDBHelper r2 = r11.dbHelper     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.String r4 = "sections"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
        L1c:
            boolean r2 = r1.isAfterLast()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r2 != 0) goto L2d
            com.helpshift.support.Section r2 = cursorToSection(r1)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r0.add(r2)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r1.moveToNext()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            goto L1c
        L2d:
            if (r1 == 0) goto L40
        L2f:
            r1.close()     // Catch: java.lang.Throwable -> L48
            goto L40
        L33:
            r0 = move-exception
            goto L42
        L35:
            r2 = move-exception
            java.lang.String r3 = "HelpShiftDebug"
            java.lang.String r4 = "Error in getAllSections"
            com.helpshift.util.HSLogger.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L40
            goto L2f
        L40:
            monitor-exit(r11)
            return r0
        L42:
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.lang.Throwable -> L48
        L47:
            throw r0     // Catch: java.lang.Throwable -> L48
        L48:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.SectionsDataSource.getAllSections():java.util.List");
    }

    @Override // com.helpshift.support.storage.SectionDAO
    public List<Section> getAllSections(FaqTagFilter faqTagFilter) {
        List<Section> allSections = getAllSections();
        if (faqTagFilter == null) {
            return allSections;
        }
        ArrayList arrayList = new ArrayList();
        for (Section section : allSections) {
            if (!this.faqDAO.getFaqsForSection(section.getPublishId(), faqTagFilter).isEmpty()) {
                arrayList.add(section);
            }
        }
        return arrayList;
    }

    @Override // com.helpshift.support.storage.SectionDAO
    public synchronized void clearSectionsData() {
        this.dbHelper.dropAndCreateAllTables(this.dbHelper.getWritableDatabase());
    }

    /* loaded from: classes2.dex */
    private static final class LazyHolder {
        static final SectionsDataSource INSTANCE = new SectionsDataSource();

        private LazyHolder() {
        }
    }
}
