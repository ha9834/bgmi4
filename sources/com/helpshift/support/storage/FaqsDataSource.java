package com.helpshift.support.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.helpshift.support.Faq;
import com.helpshift.support.FaqTagFilter;
import com.helpshift.support.db.faq.FaqsDBHelper;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FaqsDataSource implements FaqDAO {
    private static final String TAG = "HelpShiftDebug";
    private final FaqsDBHelper dbHelper;

    private FaqsDataSource() {
        this.dbHelper = FaqsDBHelper.getInstance();
    }

    public static void addFaqsUnsafe(SQLiteDatabase sQLiteDatabase, String str, JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                sQLiteDatabase.insert("faqs", null, faqToContentValues(str, jSONArray.getJSONObject(i)));
            } catch (JSONException e) {
                HSLogger.d("HelpShiftDebug", "addFaqsUnsafe", e);
                return;
            }
        }
    }

    private static Faq cursorToFaq(Cursor cursor) {
        return new Faq(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("question_id")), cursor.getString(cursor.getColumnIndex("publish_id")), cursor.getString(cursor.getColumnIndex("language")), cursor.getString(cursor.getColumnIndex("section_id")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("body")), cursor.getInt(cursor.getColumnIndex("helpful")), Boolean.valueOf(cursor.getInt(cursor.getColumnIndex("rtl")) == 1), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("tags"))), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("c_tags"))));
    }

    private static ContentValues faqToContentValues(Faq faq) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("question_id", faq.getId());
        contentValues.put("publish_id", faq.publish_id);
        contentValues.put("language", faq.language);
        contentValues.put("section_id", faq.section_publish_id);
        contentValues.put("title", faq.title);
        contentValues.put("body", faq.body);
        contentValues.put("helpful", Integer.valueOf(faq.is_helpful));
        contentValues.put("rtl", faq.is_rtl);
        contentValues.put("tags", String.valueOf(new JSONArray((Collection) faq.getTags())));
        contentValues.put("c_tags", String.valueOf(new JSONArray((Collection) faq.getCategoryTags())));
        return contentValues;
    }

    private static ContentValues faqToContentValues(String str, JSONObject jSONObject) throws JSONException {
        ContentValues contentValues = new ContentValues();
        contentValues.put("question_id", jSONObject.getString("id"));
        contentValues.put("publish_id", jSONObject.getString("publish_id"));
        contentValues.put("language", jSONObject.getString("language"));
        contentValues.put("section_id", str);
        contentValues.put("title", jSONObject.getString("title"));
        contentValues.put("body", jSONObject.getString("body"));
        contentValues.put("helpful", (Integer) 0);
        contentValues.put("rtl", Boolean.valueOf(jSONObject.getString("is_rtl").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)));
        contentValues.put("tags", jSONObject.has("stags") ? jSONObject.optJSONArray("stags").toString() : new JSONArray().toString());
        contentValues.put("c_tags", jSONObject.has("issue_tags") ? jSONObject.optJSONArray("issue_tags").toString() : new JSONArray().toString());
        return contentValues;
    }

    public static FaqsDataSource getInstance() {
        return LazyHolder.INSTANCE;
    }

    public synchronized void clearDB() {
        this.dbHelper.dropAndCreateAllTables(this.dbHelper.getWritableDatabase());
    }

    @Override // com.helpshift.support.storage.FaqDAO
    public synchronized void addFaq(Faq faq) {
        ContentValues faqToContentValues = faqToContentValues(faq);
        String[] strArr = {faq.getId()};
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            if (!DatabaseUtils.exists(writableDatabase, "faqs", "question_id=?", strArr)) {
                writableDatabase.insert("faqs", null, faqToContentValues);
            } else {
                writableDatabase.update("faqs", faqToContentValues, "question_id=?", strArr);
            }
        } catch (Exception e) {
            HSLogger.e("HelpShiftDebug", "Error in addFaq", e);
        }
    }

    @Override // com.helpshift.support.storage.FaqDAO
    public synchronized void removeFaq(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.dbHelper.getWritableDatabase().delete("faqs", "publish_id=?", new String[]{str});
            } catch (Exception e) {
                HSLogger.e("HelpShiftDebug", "Error in removeFaq", e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r11 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003f, code lost:
    
        if (r11 == null) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.storage.FaqDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.helpshift.support.Faq getFaq(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L4c
            r1 = 0
            if (r0 == 0) goto La
            monitor-exit(r10)
            return r1
        La:
            com.helpshift.support.db.faq.FaqsDBHelper r0 = r10.dbHelper     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            android.database.sqlite.SQLiteDatabase r2 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.lang.String r3 = "faqs"
            r4 = 0
            java.lang.String r5 = "publish_id = ?"
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r0 = 0
            r6[r0] = r11     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L44
            if (r0 == 0) goto L2c
            com.helpshift.support.Faq r1 = cursorToFaq(r11)     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L44
        L2c:
            if (r11 == 0) goto L42
        L2e:
            r11.close()     // Catch: java.lang.Throwable -> L4c
            goto L42
        L32:
            r0 = move-exception
            goto L38
        L34:
            r0 = move-exception
            goto L46
        L36:
            r0 = move-exception
            r11 = r1
        L38:
            java.lang.String r2 = "HelpShiftDebug"
            java.lang.String r3 = "Error in getFaq"
            com.helpshift.util.HSLogger.e(r2, r3, r0)     // Catch: java.lang.Throwable -> L44
            if (r11 == 0) goto L42
            goto L2e
        L42:
            monitor-exit(r10)
            return r1
        L44:
            r0 = move-exception
            r1 = r11
        L46:
            if (r1 == 0) goto L4b
            r1.close()     // Catch: java.lang.Throwable -> L4c
        L4b:
            throw r0     // Catch: java.lang.Throwable -> L4c
        L4c:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getFaq(java.lang.String):com.helpshift.support.Faq");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r11 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0047, code lost:
    
        if (r11 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050 A[Catch: all -> 0x0056, TRY_ENTER, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0008, B:15:0x0036, B:26:0x0050, B:27:0x0053), top: B:2:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.storage.FaqDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.helpshift.support.Faq getFaq(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L56
            r1 = 0
            if (r0 != 0) goto L54
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto Lf
            goto L54
        Lf:
            com.helpshift.support.db.faq.FaqsDBHelper r0 = r10.dbHelper     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.database.sqlite.SQLiteDatabase r2 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = "faqs"
            r4 = 0
            java.lang.String r5 = "publish_id = ? AND language = ?"
            r0 = 2
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r0 = 0
            r6[r0] = r11     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r11 = 1
            r6[r11] = r12     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4c
            if (r12 == 0) goto L34
            com.helpshift.support.Faq r1 = cursorToFaq(r11)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4c
        L34:
            if (r11 == 0) goto L4a
        L36:
            r11.close()     // Catch: java.lang.Throwable -> L56
            goto L4a
        L3a:
            r12 = move-exception
            goto L40
        L3c:
            r12 = move-exception
            goto L4e
        L3e:
            r12 = move-exception
            r11 = r1
        L40:
            java.lang.String r0 = "HelpShiftDebug"
            java.lang.String r2 = "Error in getFaq"
            com.helpshift.util.HSLogger.e(r0, r2, r12)     // Catch: java.lang.Throwable -> L4c
            if (r11 == 0) goto L4a
            goto L36
        L4a:
            monitor-exit(r10)
            return r1
        L4c:
            r12 = move-exception
            r1 = r11
        L4e:
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.lang.Throwable -> L56
        L53:
            throw r12     // Catch: java.lang.Throwable -> L56
        L54:
            monitor-exit(r10)
            return r1
        L56:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getFaq(java.lang.String, java.lang.String):com.helpshift.support.Faq");
    }

    @Override // com.helpshift.support.storage.FaqDAO
    public List<Faq> getFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        if (faqTagFilter == null) {
            return list;
        }
        String operator = faqTagFilter.getOperator();
        char c = 65535;
        int hashCode = operator.hashCode();
        if (hashCode != -1038130864) {
            if (hashCode != 3555) {
                if (hashCode != 96727) {
                    if (hashCode == 109267 && operator.equals(FaqTagFilter.Operator.NOT)) {
                        c = 2;
                    }
                } else if (operator.equals(FaqTagFilter.Operator.AND)) {
                    c = 0;
                }
            } else if (operator.equals(FaqTagFilter.Operator.OR)) {
                c = 1;
            }
        } else if (operator.equals(FaqTagFilter.Operator.UNDEFINED)) {
            c = 3;
        }
        switch (c) {
            case 0:
                return getANDFilteredFaqs(list, faqTagFilter);
            case 1:
                return getORFilteredFaqs(list, faqTagFilter);
            case 2:
                return getNOTFilteredFaqs(list, faqTagFilter);
            case 3:
                return list;
            default:
                return list;
        }
    }

    @Override // com.helpshift.support.storage.FaqDAO
    public List<Faq> getFaqsForSection(String str, FaqTagFilter faqTagFilter) {
        return getFilteredFaqs(getFaqsDataForSection(str), faqTagFilter);
    }

    @Override // com.helpshift.support.storage.FaqDAO
    public synchronized int setIsHelpful(String str, Boolean bool) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("helpful", Integer.valueOf(bool.booleanValue() ? 1 : -1));
        try {
            i = this.dbHelper.getWritableDatabase().update("faqs", contentValues, "question_id = ?", new String[]{str});
        } catch (Exception e) {
            HSLogger.e("HelpShiftDebug", "Error in setIsHelpful", e);
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        if (r1 == null) goto L25;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.storage.FaqDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.helpshift.support.Faq> getFaqsDataForSection(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L5e
            if (r0 == 0) goto Le
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5e
            r12.<init>()     // Catch: java.lang.Throwable -> L5e
            monitor-exit(r11)
            return r12
        Le:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5e
            r0.<init>()     // Catch: java.lang.Throwable -> L5e
            r1 = 0
            com.helpshift.support.db.faq.FaqsDBHelper r2 = r11.dbHelper     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.String r4 = "faqs"
            r5 = 0
            java.lang.String r6 = "section_id = ?"
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r2 = 0
            r7[r2] = r12     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r12 == 0) goto L43
        L32:
            boolean r12 = r1.isAfterLast()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r12 != 0) goto L43
            com.helpshift.support.Faq r12 = cursorToFaq(r1)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r0.add(r12)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r1.moveToNext()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            goto L32
        L43:
            if (r1 == 0) goto L56
        L45:
            r1.close()     // Catch: java.lang.Throwable -> L5e
            goto L56
        L49:
            r12 = move-exception
            goto L58
        L4b:
            r12 = move-exception
            java.lang.String r2 = "HelpShiftDebug"
            java.lang.String r3 = "Error in getFaqsDataForSection"
            com.helpshift.util.HSLogger.e(r2, r3, r12)     // Catch: java.lang.Throwable -> L49
            if (r1 == 0) goto L56
            goto L45
        L56:
            monitor-exit(r11)
            return r0
        L58:
            if (r1 == 0) goto L5d
            r1.close()     // Catch: java.lang.Throwable -> L5e
        L5d:
            throw r12     // Catch: java.lang.Throwable -> L5e
        L5e:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getFaqsDataForSection(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.support.storage.FaqDAO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<java.lang.String> getAllFaqPublishIds() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L58
            r0.<init>()     // Catch: java.lang.Throwable -> L58
            r1 = 0
            r2 = 1
            java.lang.String[] r5 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r2 = 0
            java.lang.String r3 = "publish_id"
            r5[r2] = r3     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            com.helpshift.support.db.faq.FaqsDBHelper r2 = r11.dbHelper     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r4 = "faqs"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r2 == 0) goto L3d
        L26:
            boolean r2 = r1.isAfterLast()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            if (r2 != 0) goto L3d
            java.lang.String r2 = "publish_id"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r0.add(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r1.moveToNext()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            goto L26
        L3d:
            if (r1 == 0) goto L50
        L3f:
            r1.close()     // Catch: java.lang.Throwable -> L58
            goto L50
        L43:
            r0 = move-exception
            goto L52
        L45:
            r2 = move-exception
            java.lang.String r3 = "HelpShiftDebug"
            java.lang.String r4 = "Error in getFaqsDataForSection"
            com.helpshift.util.HSLogger.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L43
            if (r1 == 0) goto L50
            goto L3f
        L50:
            monitor-exit(r11)
            return r0
        L52:
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.lang.Throwable -> L58
        L57:
            throw r0     // Catch: java.lang.Throwable -> L58
        L58:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.support.storage.FaqsDataSource.getAllFaqPublishIds():java.util.List");
    }

    private List<Faq> getANDFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        ArrayList arrayList = new ArrayList();
        for (Faq faq : list) {
            ArrayList arrayList2 = new ArrayList(Arrays.asList(faqTagFilter.getTags()));
            arrayList2.removeAll(faq.getCategoryTags());
            if (arrayList2.isEmpty()) {
                arrayList.add(faq);
            }
        }
        return arrayList;
    }

    private List<Faq> getORFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        ArrayList arrayList = new ArrayList();
        for (Faq faq : list) {
            if (new ArrayList(Arrays.asList(faqTagFilter.getTags())).removeAll(faq.getCategoryTags())) {
                arrayList.add(faq);
            }
        }
        return arrayList;
    }

    private List<Faq> getNOTFilteredFaqs(List<Faq> list, FaqTagFilter faqTagFilter) {
        ArrayList arrayList = new ArrayList();
        for (Faq faq : list) {
            if (!new ArrayList(Arrays.asList(faqTagFilter.getTags())).removeAll(faq.getCategoryTags())) {
                arrayList.add(faq);
            }
        }
        return arrayList;
    }

    /* loaded from: classes2.dex */
    private static final class LazyHolder {
        static final FaqsDataSource INSTANCE = new FaqsDataSource();

        private LazyHolder() {
        }
    }
}
