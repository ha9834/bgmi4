package com.helpshift.db.conversation.smartintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.conversation.smartintent.dto.SISearchModelDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.conversation.smartintent.dto.SmartIntentDTO;
import com.helpshift.db.smartintents.SmartIntentDatabaseContract;
import com.helpshift.db.smartintents.SmartIntentsDBHelper;
import com.helpshift.db.smartintents.tables.SmartIntentModelsTable;
import com.helpshift.db.smartintents.tables.SmartIntentTreeTable;
import com.helpshift.db.smartintents.tables.SmartIntentWordProbabilitiesTable;
import com.helpshift.db.smartintents.tables.SmartIntentsTable;
import com.helpshift.util.DatabaseUtils;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SmartIntentDB {
    private static final String TAG = "Helpshift_SiDB";
    private static SmartIntentDB mInstance;
    private final SmartIntentsDBHelper siDbHelper;

    private SmartIntentDB(Context context) {
        this.siDbHelper = new SmartIntentsDBHelper(context, new SmartIntentDatabaseContract());
    }

    public static synchronized SmartIntentDB getInstance(Context context) {
        SmartIntentDB smartIntentDB;
        synchronized (SmartIntentDB.class) {
            if (mInstance == null) {
                mInstance = new SmartIntentDB(context);
            }
            smartIntentDB = mInstance;
        }
        return smartIntentDB;
    }

    public synchronized boolean insertTree(UserDM userDM, SITreeDTO sITreeDTO) {
        long insert = insert(smartIntentTreeToContentValues(sITreeDTO, userDM), SmartIntentTreeTable.TABLE_NAME);
        if (insert == -1) {
            return false;
        }
        if (!ListUtils.isEmpty(insertSmartIntents(insert, getIntentsFlatList(sITreeDTO.rootIntents)))) {
            return true;
        }
        deleteTreeAndSmartIntents(insert);
        return false;
    }

    public synchronized boolean updateTreeRefreshedAt(UserDM userDM, long j) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_refreshed_at", Long.valueOf(j));
        z = true;
        try {
            this.siDbHelper.getWritableDatabase().update(SmartIntentTreeTable.TABLE_NAME, contentValues, "user_local_id = ? ", new String[]{String.valueOf(userDM.getLocalId())});
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in updating tree refreshedAt", e);
            z = false;
        }
        return z;
    }

    private ContentValues smartIntentTreeToContentValues(SITreeDTO sITreeDTO, UserDM userDM) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_local_id", userDM.getLocalId());
        contentValues.put("server_id", sITreeDTO.serverId);
        contentValues.put(SmartIntentTreeTable.Columns.TREE_VERSION, Integer.valueOf(sITreeDTO.version));
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_ENFORCE_INTENT_SELECTION, Integer.valueOf(sITreeDTO.enforceIntentSelection ? 1 : 0));
        contentValues.put("last_refreshed_at", Long.valueOf(sITreeDTO.lastRefreshedAt));
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_PROMPT_TITLE, sITreeDTO.promptTitle);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_TEXT_INPUT_HINT, sITreeDTO.textInputHint);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_SEARCH_TITLE, sITreeDTO.searchTitle);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_TITLE, sITreeDTO.emptySearchTitle);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_DESCRIPTION, sITreeDTO.emptySearchDescription);
        contentValues.put(SmartIntentTreeTable.Columns.SI_TREE_TOKEN_DELIMITER, HSJSONUtils.listToJsonArray(sITreeDTO.tokenDelimiter).toString());
        return contentValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.Long> insertSmartIntents(long r5, java.util.List<com.helpshift.conversation.smartintent.dto.SmartIntentDTO> r7) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r7 = r7.iterator()
        Le:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L22
            java.lang.Object r2 = r7.next()
            com.helpshift.conversation.smartintent.dto.SmartIntentDTO r2 = (com.helpshift.conversation.smartintent.dto.SmartIntentDTO) r2
            android.content.ContentValues r2 = r4.smartIntentToContentValues(r2, r5)
            r1.add(r2)
            goto Le
        L22:
            r5 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r6 = r4.siDbHelper     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            android.database.sqlite.SQLiteDatabase r6 = r6.getWritableDatabase()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            r6.beginTransaction()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            java.util.Iterator r7 = r1.iterator()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
        L30:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            if (r1 == 0) goto L4a
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            android.content.ContentValues r1 = (android.content.ContentValues) r1     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            java.lang.String r2 = "si_intents_table"
            long r1 = r6.insert(r2, r5, r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            r0.add(r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            goto L30
        L4a:
            r6.setTransactionSuccessful()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L83
            if (r6 == 0) goto L82
            boolean r5 = r6.inTransaction()     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L82
            r6.endTransaction()     // Catch: java.lang.Exception -> L7a
            goto L82
        L59:
            r5 = move-exception
            goto L64
        L5b:
            r6 = move-exception
            r3 = r6
            r6 = r5
            r5 = r3
            goto L84
        L60:
            r6 = move-exception
            r3 = r6
            r6 = r5
            r5 = r3
        L64:
            r0.clear()     // Catch: java.lang.Throwable -> L83
            java.lang.String r7 = "Helpshift_SiDB"
            java.lang.String r1 = "Error in inserting in smart intents table: "
            com.helpshift.util.HSLogger.e(r7, r1, r5)     // Catch: java.lang.Throwable -> L83
            if (r6 == 0) goto L82
            boolean r5 = r6.inTransaction()     // Catch: java.lang.Exception -> L7a
            if (r5 == 0) goto L82
            r6.endTransaction()     // Catch: java.lang.Exception -> L7a
            goto L82
        L7a:
            r5 = move-exception
            java.lang.String r6 = "Helpshift_SiDB"
            java.lang.String r7 = "Error in ending the insert txn in smart intents table: "
            com.helpshift.util.HSLogger.e(r6, r7, r5)
        L82:
            return r0
        L83:
            r5 = move-exception
        L84:
            if (r6 == 0) goto L98
            boolean r7 = r6.inTransaction()     // Catch: java.lang.Exception -> L90
            if (r7 == 0) goto L98
            r6.endTransaction()     // Catch: java.lang.Exception -> L90
            goto L98
        L90:
            r6 = move-exception
            java.lang.String r7 = "Helpshift_SiDB"
            java.lang.String r0 = "Error in ending the insert txn in smart intents table: "
            com.helpshift.util.HSLogger.e(r7, r0, r6)
        L98:
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.insertSmartIntents(long, java.util.List):java.util.List");
    }

    private List<SmartIntentDTO> getIntentsFlatList(List<SmartIntentDTO> list) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList(list);
        if (ListUtils.isEmpty(list)) {
            return arrayList;
        }
        while (!linkedList.isEmpty()) {
            SmartIntentDTO smartIntentDTO = (SmartIntentDTO) linkedList.poll();
            arrayList.add(smartIntentDTO);
            if (ListUtils.isNotEmpty(smartIntentDTO.children)) {
                linkedList.addAll(smartIntentDTO.children);
                smartIntentDTO.children.clear();
            }
        }
        return arrayList;
    }

    private ContentValues smartIntentToContentValues(SmartIntentDTO smartIntentDTO, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tree_local_id", Long.valueOf(j));
        contentValues.put("label", smartIntentDTO.label);
        contentValues.put("server_id", smartIntentDTO.serverId);
        contentValues.put(SmartIntentsTable.Columns.SI_INTENT_PARENT_SERVER_ID, smartIntentDTO.parentServerId);
        return contentValues;
    }

    public synchronized boolean insertModel(long j, SISearchModelDTO sISearchModelDTO) {
        long insert = insert(smartIntentModelToContentValues(j, sISearchModelDTO), SmartIntentModelsTable.TABLE_NAME);
        if (insert == -1) {
            return false;
        }
        if (!ListUtils.isEmpty(insertWordProbabilities(insert, sISearchModelDTO.wordToLeafIntentProbabilitiesMapping))) {
            return true;
        }
        deleteModelAndWordProbabilities(insert);
        return false;
    }

    private ContentValues smartIntentModelToContentValues(long j, SISearchModelDTO sISearchModelDTO) {
        String jSONArray = HSJSONUtils.listToJsonArray(sISearchModelDTO.leafIntentServerIds).toString();
        String jSONArray2 = HSJSONUtils.doubleListToJsonArray(sISearchModelDTO.leafIntentBaseProbabilities).toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("local_id", sISearchModelDTO.localId);
        contentValues.put("tree_local_id", Long.valueOf(j));
        contentValues.put("version", sISearchModelDTO.version);
        contentValues.put("last_refreshed_at", Long.valueOf(sISearchModelDTO.lastRefreshedAt));
        contentValues.put(SmartIntentModelsTable.Columns.CONFIDENCE_THRESHOLD, sISearchModelDTO.confidenceThreshold);
        contentValues.put(SmartIntentModelsTable.Columns.MAX_COMBINED_CONFIDENCE, sISearchModelDTO.maxCombinedConfidence);
        contentValues.put(SmartIntentModelsTable.Columns.LEAF_INTENT_SERVER_IDS, jSONArray);
        contentValues.put(SmartIntentModelsTable.Columns.LEAF_INTENT_BASE_PROBABILITIES, jSONArray2);
        return contentValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.lang.Long> insertWordProbabilities(long r6, java.util.Map<java.lang.String, java.util.List<java.lang.Double>> r8) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L12:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L32
            java.lang.Object r2 = r8.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            android.content.ContentValues r2 = r5.wordProbabilitiesToContentValues(r6, r3, r2)
            r1.add(r2)
            goto L12
        L32:
            r6 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r7 = r5.siDbHelper     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            android.database.sqlite.SQLiteDatabase r7 = r7.getWritableDatabase()     // Catch: java.lang.Throwable -> L6b java.lang.Exception -> L70
            r7.beginTransaction()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            java.util.Iterator r8 = r1.iterator()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
        L40:
            boolean r1 = r8.hasNext()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            if (r1 == 0) goto L5a
            java.lang.Object r1 = r8.next()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            android.content.ContentValues r1 = (android.content.ContentValues) r1     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            java.lang.String r2 = "si_word_probabilities_table"
            long r1 = r7.insert(r2, r6, r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            r0.add(r1)     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            goto L40
        L5a:
            r7.setTransactionSuccessful()     // Catch: java.lang.Exception -> L69 java.lang.Throwable -> L93
            if (r7 == 0) goto L92
            boolean r6 = r7.inTransaction()     // Catch: java.lang.Exception -> L8a
            if (r6 == 0) goto L92
            r7.endTransaction()     // Catch: java.lang.Exception -> L8a
            goto L92
        L69:
            r6 = move-exception
            goto L74
        L6b:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
            goto L94
        L70:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L74:
            r0.clear()     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = "Helpshift_SiDB"
            java.lang.String r1 = "Error in inserting in word probabilities table: "
            com.helpshift.util.HSLogger.e(r8, r1, r6)     // Catch: java.lang.Throwable -> L93
            if (r7 == 0) goto L92
            boolean r6 = r7.inTransaction()     // Catch: java.lang.Exception -> L8a
            if (r6 == 0) goto L92
            r7.endTransaction()     // Catch: java.lang.Exception -> L8a
            goto L92
        L8a:
            r6 = move-exception
            java.lang.String r7 = "Helpshift_SiDB"
            java.lang.String r8 = "Error in ending the insert txn in word probabilities table: "
            com.helpshift.util.HSLogger.e(r7, r8, r6)
        L92:
            return r0
        L93:
            r6 = move-exception
        L94:
            if (r7 == 0) goto La8
            boolean r8 = r7.inTransaction()     // Catch: java.lang.Exception -> La0
            if (r8 == 0) goto La8
            r7.endTransaction()     // Catch: java.lang.Exception -> La0
            goto La8
        La0:
            r7 = move-exception
            java.lang.String r8 = "Helpshift_SiDB"
            java.lang.String r0 = "Error in ending the insert txn in word probabilities table: "
            com.helpshift.util.HSLogger.e(r8, r0, r7)
        La8:
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.insertWordProbabilities(long, java.util.Map):java.util.List");
    }

    private ContentValues wordProbabilitiesToContentValues(long j, String str, List<Double> list) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_MODEL_LOCAL_ID, Long.valueOf(j));
        contentValues.put(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_WORD, str);
        contentValues.put(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_PROBABILITIES, HSJSONUtils.doubleListToJsonArray(list).toString());
        return contentValues;
    }

    private synchronized long insert(ContentValues contentValues, String str) {
        long j;
        j = -1;
        try {
            j = this.siDbHelper.getWritableDatabase().insert(str, null, contentValues);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in inserting in table: " + str, e);
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        if (r11 == null) goto L23;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean deleteTreeAndModel(com.helpshift.account.domainmodel.UserDM r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r3 = "user_local_id = ? "
            r8 = 1
            java.lang.String[] r4 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L5e
            java.lang.Long r11 = r11.getLocalId()     // Catch: java.lang.Throwable -> L5e
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L5e
            r9 = 0
            r4[r9] = r11     // Catch: java.lang.Throwable -> L5e
            r11 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r0 = r10.siDbHelper     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.lang.String r1 = "si_tree_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r0 == 0) goto L43
            java.lang.String r0 = "local_id"
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            long r0 = r11.getLong(r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            boolean r2 = r10.deleteTreeAndSmartIntents(r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            if (r2 == 0) goto L43
            boolean r0 = r10.deleteModel(r0)     // Catch: java.lang.Exception -> L40 java.lang.Throwable -> L49
            if (r0 == 0) goto L43
            r9 = 1
            goto L43
        L40:
            r0 = move-exception
            r9 = r2
            goto L4c
        L43:
            if (r11 == 0) goto L56
        L45:
            r11.close()     // Catch: java.lang.Throwable -> L5e
            goto L56
        L49:
            r0 = move-exception
            goto L58
        L4b:
            r0 = move-exception
        L4c:
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in deleting the tree and model"
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L49
            if (r11 == 0) goto L56
            goto L45
        L56:
            monitor-exit(r10)
            return r9
        L58:
            if (r11 == 0) goto L5d
            r11.close()     // Catch: java.lang.Throwable -> L5e
        L5d:
            throw r0     // Catch: java.lang.Throwable -> L5e
        L5e:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.deleteTreeAndModel(com.helpshift.account.domainmodel.UserDM):boolean");
    }

    private synchronized boolean deleteTreeAndSmartIntents(long j) {
        boolean z;
        z = false;
        String[] strArr = {String.valueOf(j)};
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.siDbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete(SmartIntentsTable.TABLE_NAME, "tree_local_id = ? ", strArr);
                sQLiteDatabase.delete(SmartIntentTreeTable.TABLE_NAME, "local_id = ?", strArr);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e) {
                        HSLogger.e(TAG, "Exception in ending transaction : smartintents table or tree table with " + Arrays.toString(strArr), e);
                    }
                }
                z = true;
            } catch (Exception e2) {
                HSLogger.e(TAG, "Error in delete smart intents table or tree table for selection :tree_local_id = ?   local_id = ?and selectionArgs" + Arrays.toString(strArr), e2);
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e3) {
                    HSLogger.e(TAG, "Exception in ending transaction : smartintents table or tree table with " + Arrays.toString(strArr), e3);
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (r9 == null) goto L17;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean deleteModel(long r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r3 = "tree_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L4d
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L4d
            r10 = 0
            r4[r10] = r9     // Catch: java.lang.Throwable -> L4d
            r9 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r0 = r8.siDbHelper     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.lang.String r1 = "si_models_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            boolean r0 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            if (r0 == 0) goto L32
            java.lang.String r0 = "local_id"
            int r0 = r9.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            long r0 = r9.getLong(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            boolean r10 = r8.deleteModelAndWordProbabilities(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
        L32:
            if (r9 == 0) goto L45
        L34:
            r9.close()     // Catch: java.lang.Throwable -> L4d
            goto L45
        L38:
            r10 = move-exception
            goto L47
        L3a:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in deleting the model table"
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L38
            if (r9 == 0) goto L45
            goto L34
        L45:
            monitor-exit(r8)
            return r10
        L47:
            if (r9 == 0) goto L4c
            r9.close()     // Catch: java.lang.Throwable -> L4d
        L4c:
            throw r10     // Catch: java.lang.Throwable -> L4d
        L4d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.deleteModel(long):boolean");
    }

    private synchronized boolean deleteModelAndWordProbabilities(long j) {
        boolean z;
        z = false;
        String[] strArr = {String.valueOf(j)};
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.siDbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete(SmartIntentWordProbabilitiesTable.TABLE_NAME, "model_local_id = ?", strArr);
                sQLiteDatabase.delete(SmartIntentModelsTable.TABLE_NAME, "local_id = ?", strArr);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    } catch (Exception e) {
                        HSLogger.e(TAG, "Exception in ending transaction : word probabilites table or models table with " + Arrays.toString(strArr), e);
                    }
                }
                z = true;
            } catch (Exception e2) {
                HSLogger.e(TAG, "Error in delete word probabilities table or models table for selection :model_local_id = ?  local_id = ?and selectionArgs" + Arrays.toString(strArr), e2);
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e3) {
                    HSLogger.e(TAG, "Exception in ending transaction : word probabilites table or models table with " + Arrays.toString(strArr), e3);
                }
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
    
        if (r11 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (r11 != null) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.helpshift.conversation.smartintent.dto.SITreeDTO getSmartIntentTree(long r10) {
        /*
            r9 = this;
            java.lang.String r3 = "user_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 0
            r4[r11] = r10
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r11 = r9.siDbHelper     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46
            java.lang.String r1 = "si_tree_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L46
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L53
            if (r0 == 0) goto L39
            java.lang.String r0 = "local_id"
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L53
            long r0 = r11.getLong(r0)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L53
            java.util.List r0 = r9.getSmartIntents(r0)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L53
            java.util.List r0 = r9.buildIntentTree(r0)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L53
            com.helpshift.conversation.smartintent.dto.SITreeDTO r10 = r9.cursorToSmartIntentTree(r11, r0)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L53
        L39:
            if (r11 == 0) goto L52
        L3b:
            r11.close()
            goto L52
        L3f:
            r0 = move-exception
            goto L48
        L41:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L54
        L46:
            r0 = move-exception
            r11 = r10
        L48:
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in reading smart intent tree"
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L53
            if (r11 == 0) goto L52
            goto L3b
        L52:
            return r10
        L53:
            r10 = move-exception
        L54:
            if (r11 == 0) goto L59
            r11.close()
        L59:
            throw r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.getSmartIntentTree(long):com.helpshift.conversation.smartintent.dto.SITreeDTO");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0035, code lost:
    
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r10 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0026, code lost:
    
        if (r10.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0028, code lost:
    
        r9.add(cursorToSmartIntent(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0033, code lost:
    
        if (r10.moveToNext() != false) goto L24;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.helpshift.conversation.smartintent.dto.SmartIntentDTO> getSmartIntents(long r9) {
        /*
            r8 = this;
            java.lang.String r3 = "tree_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r10 = 0
            r4[r10] = r9
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r0 = r8.siDbHelper     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            java.lang.String r1 = "si_intents_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            if (r0 == 0) goto L35
        L28:
            com.helpshift.conversation.smartintent.dto.SmartIntentDTO r0 = r8.cursorToSmartIntent(r10)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            r9.add(r0)     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L38 java.lang.Exception -> L3a
            if (r0 != 0) goto L28
        L35:
            if (r10 == 0) goto L47
            goto L44
        L38:
            r9 = move-exception
            goto L48
        L3a:
            r0 = move-exception
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in reading smart intents from db"
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 == 0) goto L47
        L44:
            r10.close()
        L47:
            return r9
        L48:
            if (r10 == 0) goto L4d
            r10.close()
        L4d:
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.getSmartIntents(long):java.util.List");
    }

    private SmartIntentDTO cursorToSmartIntent(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("local_id"));
        SmartIntentDTO smartIntentDTO = new SmartIntentDTO(cursor.getString(cursor.getColumnIndex("label")), cursor.getString(cursor.getColumnIndex("server_id")), cursor.getString(cursor.getColumnIndex(SmartIntentsTable.Columns.SI_INTENT_PARENT_SERVER_ID)), null);
        smartIntentDTO.localId = Long.valueOf(j);
        return smartIntentDTO;
    }

    private List<SmartIntentDTO> buildIntentTree(List<SmartIntentDTO> list) {
        List<SmartIntentDTO> filterRootIntents = filterRootIntents(list);
        Map<String, List<SmartIntentDTO>> buildIntentIdToChildIntentMap = buildIntentIdToChildIntentMap(list);
        LinkedList linkedList = new LinkedList();
        for (SmartIntentDTO smartIntentDTO : filterRootIntents) {
            List<SmartIntentDTO> list2 = buildIntentIdToChildIntentMap.get(smartIntentDTO.serverId);
            if (ListUtils.isNotEmpty(list2)) {
                smartIntentDTO.children = list2;
                linkedList.addAll(list2);
            }
        }
        while (!linkedList.isEmpty()) {
            SmartIntentDTO smartIntentDTO2 = (SmartIntentDTO) linkedList.poll();
            List<SmartIntentDTO> list3 = buildIntentIdToChildIntentMap.get(smartIntentDTO2.serverId);
            if (ListUtils.isNotEmpty(list3)) {
                smartIntentDTO2.children = list3;
                linkedList.addAll(list3);
            }
        }
        return filterRootIntents;
    }

    private List<SmartIntentDTO> filterRootIntents(List<SmartIntentDTO> list) {
        ArrayList arrayList = new ArrayList();
        for (SmartIntentDTO smartIntentDTO : list) {
            if (StringUtils.isEmpty(smartIntentDTO.parentServerId)) {
                arrayList.add(smartIntentDTO);
            }
        }
        return arrayList;
    }

    private Map<String, List<SmartIntentDTO>> buildIntentIdToChildIntentMap(List<SmartIntentDTO> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (SmartIntentDTO smartIntentDTO : list) {
            if (!StringUtils.isEmpty(smartIntentDTO.parentServerId)) {
                List list2 = (List) linkedHashMap.get(smartIntentDTO.parentServerId);
                if (ListUtils.isEmpty(list2)) {
                    list2 = new LinkedList();
                }
                list2.add(smartIntentDTO);
                linkedHashMap.put(smartIntentDTO.parentServerId, list2);
            }
        }
        return linkedHashMap;
    }

    private SITreeDTO cursorToSmartIntentTree(Cursor cursor, List<SmartIntentDTO> list) {
        long j = cursor.getLong(cursor.getColumnIndex("local_id"));
        String string = cursor.getString(cursor.getColumnIndex("server_id"));
        boolean parseBooleanColumnSafe = DatabaseUtils.parseBooleanColumnSafe(cursor, SmartIntentTreeTable.Columns.SI_TREE_ENFORCE_INTENT_SELECTION, false);
        long j2 = cursor.getLong(cursor.getColumnIndex("last_refreshed_at"));
        SITreeDTO sITreeDTO = new SITreeDTO(string, cursor.getInt(cursor.getColumnIndex(SmartIntentTreeTable.Columns.TREE_VERSION)), cursor.getString(cursor.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_PROMPT_TITLE)), cursor.getString(cursor.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_TEXT_INPUT_HINT)), cursor.getString(cursor.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_SEARCH_TITLE)), cursor.getString(cursor.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_TITLE)), cursor.getString(cursor.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_DESCRIPTION)), parseBooleanColumnSafe, HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex(SmartIntentTreeTable.Columns.SI_TREE_TOKEN_DELIMITER))), list);
        sITreeDTO.lastRefreshedAt = j2;
        sITreeDTO.localId = Long.valueOf(j);
        return sITreeDTO;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r11 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
    
        if (r11 != null) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.helpshift.conversation.smartintent.dto.SISearchModelDTO getModelWithoutWordProbabilities(long r10) {
        /*
            r9 = this;
            java.lang.String r3 = "tree_local_id = ? "
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 0
            r4[r11] = r10
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r11 = r9.siDbHelper     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L34
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L34
            java.lang.String r1 = "si_models_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L34
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L41
            if (r0 == 0) goto L27
            com.helpshift.conversation.smartintent.dto.SISearchModelDTO r10 = r9.cursorToModelWithoutWordProbabilities(r11)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L41
        L27:
            if (r11 == 0) goto L40
        L29:
            r11.close()
            goto L40
        L2d:
            r0 = move-exception
            goto L36
        L2f:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L42
        L34:
            r0 = move-exception
            r11 = r10
        L36:
            java.lang.String r1 = "Helpshift_SiDB"
            java.lang.String r2 = "Error in reading the search model "
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L41
            if (r11 == 0) goto L40
            goto L29
        L40:
            return r10
        L41:
            r10 = move-exception
        L42:
            if (r11 == 0) goto L47
            r11.close()
        L47:
            throw r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.getModelWithoutWordProbabilities(long):com.helpshift.conversation.smartintent.dto.SISearchModelDTO");
    }

    private SISearchModelDTO cursorToModelWithoutWordProbabilities(Cursor cursor) {
        long j = cursor.getLong(cursor.getColumnIndex("local_id"));
        int i = cursor.getInt(cursor.getColumnIndex("version"));
        double d = cursor.getDouble(cursor.getColumnIndex(SmartIntentModelsTable.Columns.CONFIDENCE_THRESHOLD));
        double d2 = cursor.getDouble(cursor.getColumnIndex(SmartIntentModelsTable.Columns.MAX_COMBINED_CONFIDENCE));
        long j2 = cursor.getLong(cursor.getColumnIndex("last_refreshed_at"));
        SISearchModelDTO sISearchModelDTO = new SISearchModelDTO(Integer.valueOf(i), Double.valueOf(d), Double.valueOf(d2), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex(SmartIntentModelsTable.Columns.LEAF_INTENT_SERVER_IDS))), HSJSONUtils.jsonToDoubleArrayList(cursor.getString(cursor.getColumnIndex(SmartIntentModelsTable.Columns.LEAF_INTENT_BASE_PROBABILITIES))), null);
        sISearchModelDTO.localId = Long.valueOf(j);
        sISearchModelDTO.lastRefreshedAt = j2;
        return sISearchModelDTO;
    }

    public synchronized boolean updateModelRefreshedAt(long j, long j2) {
        boolean z;
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_refreshed_at", Long.valueOf(j2));
        z = false;
        try {
            this.siDbHelper.getWritableDatabase().update(SmartIntentModelsTable.TABLE_NAME, contentValues, "tree_local_id = ? ", new String[]{String.valueOf(j)});
            z = true;
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in updating model refreshedAt", e);
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        if (r11 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        if (r11 != null) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<java.lang.Double> getWordToIntentProbabilities(long r10, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r3 = "model_local_id = ? AND word = ?"
            r0 = 2
            java.lang.String[] r4 = new java.lang.String[r0]
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r11 = 0
            r4[r11] = r10
            java.lang.String r10 = java.lang.String.valueOf(r12)
            r11 = 1
            r4[r11] = r10
            r10 = 0
            com.helpshift.db.smartintents.SmartIntentsDBHelper r11 = r9.siDbHelper     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3b
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3b
            java.lang.String r1 = "si_word_probabilities_table"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3b
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L48
            if (r12 == 0) goto L2e
            java.util.List r10 = r9.cursorToWordProbabilities(r11)     // Catch: java.lang.Exception -> L34 java.lang.Throwable -> L48
        L2e:
            if (r11 == 0) goto L47
        L30:
            r11.close()
            goto L47
        L34:
            r12 = move-exception
            goto L3d
        L36:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L49
        L3b:
            r12 = move-exception
            r11 = r10
        L3d:
            java.lang.String r0 = "Helpshift_SiDB"
            java.lang.String r1 = "Error in getting word probabilities "
            com.helpshift.util.HSLogger.e(r0, r1, r12)     // Catch: java.lang.Throwable -> L48
            if (r11 == 0) goto L47
            goto L30
        L47:
            return r10
        L48:
            r10 = move-exception
        L49:
            if (r11 == 0) goto L4e
            r11.close()
        L4e:
            throw r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.smartintent.SmartIntentDB.getWordToIntentProbabilities(long, java.lang.String):java.util.List");
    }

    private List<Double> cursorToWordProbabilities(Cursor cursor) {
        return HSJSONUtils.jsonToDoubleArrayList(cursor.getString(cursor.getColumnIndex(SmartIntentWordProbabilitiesTable.Columns.SI_WORD_PROBABILITIES_PROBABILITIES)));
    }
}
