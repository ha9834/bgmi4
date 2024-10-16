package com.helpshift.db.conversation.migration;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.db.base.IMigrator;
import com.helpshift.db.conversation.tables.ConversationTable;
import java.util.UUID;

/* loaded from: classes2.dex */
public class ConversationDbMigration_8_to_9 implements IMigrator {
    private final String TAG = "Helpshift_dbMigrate8_9";
    private String ADD_ACID_COLUMN_TO_CONVERSATION_TABLE = "ALTER TABLE issues ADD COLUMN acid TEXT ;";
    private String GET_ALL_CONVERSATION_QUERY = "SELECT _id , server_id , pre_conv_server_id FROM issues ;";

    @Override // com.helpshift.db.base.IMigrator
    public void migrate(SQLiteDatabase sQLiteDatabase) throws Exception {
        migrateTable(sQLiteDatabase);
        migrateData(sQLiteDatabase);
    }

    private void migrateTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.ADD_ACID_COLUMN_TO_CONVERSATION_TABLE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if (r1.moveToNext() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
    
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (r0.hasNext() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        updateAcidValueForConversation((java.lang.Long) r0.next(), r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (r1 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (r1.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        r2 = java.lang.Long.valueOf(r1.getLong(r1.getColumnIndex("_id")));
        r3 = r1.getString(r1.getColumnIndex("server_id"));
        r4 = r1.getString(r1.getColumnIndex(com.helpshift.db.conversation.tables.ConversationTable.Columns.PRE_CONVERSATION_SERVER_ID));
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0038, code lost:
    
        if (com.helpshift.util.StringUtils.isEmpty(r3) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        if (com.helpshift.util.StringUtils.isEmpty(r4) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
    
        r0.add(r2);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void migrateData(android.database.sqlite.SQLiteDatabase r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = r5.GET_ALL_CONVERSATION_QUERY
            r2 = 0
            android.database.Cursor r1 = r6.rawQuery(r1, r2)
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r2 == 0) goto L49
        L12:
            java.lang.String r2 = "_id"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            long r2 = r1.getLong(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r3 = "server_id"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r4 = "pre_conv_server_id"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            boolean r3 = com.helpshift.util.StringUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r3 == 0) goto L43
            boolean r3 = com.helpshift.util.StringUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r3 == 0) goto L43
            r0.add(r2)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
        L43:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            if (r2 != 0) goto L12
        L49:
            if (r1 == 0) goto L5c
        L4b:
            r1.close()
            goto L5c
        L4f:
            r6 = move-exception
            goto L71
        L51:
            r2 = move-exception
            java.lang.String r3 = "Helpshift_dbMigrate8_9"
            java.lang.String r4 = "Failed to read db conversations"
            com.helpshift.util.HSLogger.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L5c
            goto L4b
        L5c:
            java.util.Iterator r0 = r0.iterator()
        L60:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L70
            java.lang.Object r1 = r0.next()
            java.lang.Long r1 = (java.lang.Long) r1
            r5.updateAcidValueForConversation(r1, r6)
            goto L60
        L70:
            return
        L71:
            if (r1 == 0) goto L76
            r1.close()
        L76:
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.migration.ConversationDbMigration_8_to_9.migrateData(android.database.sqlite.SQLiteDatabase):void");
    }

    private void updateAcidValueForConversation(Long l, SQLiteDatabase sQLiteDatabase) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("acid", uuid);
        sQLiteDatabase.update(ConversationTable.TABLE_NAME, contentValues, "_id = ?", new String[]{String.valueOf(l)});
    }
}
