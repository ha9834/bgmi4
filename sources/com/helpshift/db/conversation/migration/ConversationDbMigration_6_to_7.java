package com.helpshift.db.conversation.migration;

import android.database.sqlite.SQLiteDatabase;
import com.helpshift.db.base.IMigrator;

/* loaded from: classes2.dex */
public class ConversationDbMigration_6_to_7 implements IMigrator {
    private String ADD_HAS_OLDER_MESSAGES_COLUMN_INTO_INBOX_TABLE = "ALTER TABLE conversation_inbox ADD COLUMN has_older_messages INT ;";
    private String ADD_LAST_CONVERSATIONS_REDACTED_TIME_COLUMN_INTO_INBOX_TABLE = "ALTER TABLE conversation_inbox ADD COLUMN last_conv_redaction_time INT ;";
    private String ADD_FULL_PRIVACY_ENABLED_COLUMN_INTO_CONVERSATIONS_TABLE = "ALTER TABLE issues ADD COLUMN full_privacy_enabled INTEGER ;";
    private String ADD_IS_REDACTED_COLUMN_INTO_CONVERSATIONS_TABLE = "ALTER TABLE issues ADD COLUMN is_redacted INTEGER ;";
    private String ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_CONVERSATIONS_TABLE = "ALTER TABLE issues ADD COLUMN epoch_time_created_at INTEGER NOT NULL DEFAULT 0 ;";
    private String ADD_IS_REDACTED_COLUMN_INTO_MESSAGES_TABLE = "ALTER TABLE messages ADD COLUMN is_redacted INTEGER ;";
    private String ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_MESSAGES_TABLE = "ALTER TABLE messages ADD COLUMN epoch_time_created_at INTEGER NOT NULL DEFAULT 0 ;";

    @Override // com.helpshift.db.base.IMigrator
    public void migrate(SQLiteDatabase sQLiteDatabase) {
        migrateTable(sQLiteDatabase);
        migrateData(sQLiteDatabase);
    }

    private void migrateTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.ADD_HAS_OLDER_MESSAGES_COLUMN_INTO_INBOX_TABLE);
        sQLiteDatabase.execSQL(this.ADD_LAST_CONVERSATIONS_REDACTED_TIME_COLUMN_INTO_INBOX_TABLE);
        sQLiteDatabase.execSQL(this.ADD_FULL_PRIVACY_ENABLED_COLUMN_INTO_CONVERSATIONS_TABLE);
        sQLiteDatabase.execSQL(this.ADD_IS_REDACTED_COLUMN_INTO_CONVERSATIONS_TABLE);
        sQLiteDatabase.execSQL(this.ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_MESSAGES_TABLE);
        sQLiteDatabase.execSQL(this.ADD_IS_REDACTED_COLUMN_INTO_MESSAGES_TABLE);
        sQLiteDatabase.execSQL(this.ADD_EPOCH_TIME_CREATE_AT_COLUMN_INTO_CONVERSATIONS_TABLE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0080, code lost:
    
        if (r1.moveToNext() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0082, code lost:
    
        r1.close();
        r1 = new java.util.HashMap();
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0096, code lost:
    
        if (r0.hasNext() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0098, code lost:
    
        r2 = (java.util.Map.Entry) r0.next();
        r1.put(r2.getKey(), java.lang.Long.valueOf(com.helpshift.common.util.HSDateFormatSpec.convertToEpochTime((java.lang.String) r2.getValue())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b4, code lost:
    
        r0 = new java.util.HashMap();
        r2 = r12.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c5, code lost:
    
        if (r2.hasNext() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c7, code lost:
    
        r3 = (java.util.Map.Entry) r2.next();
        r0.put(r3.getKey(), java.lang.Long.valueOf(com.helpshift.common.util.HSDateFormatSpec.convertToEpochTime((java.lang.String) r3.getValue())));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e3, code lost:
    
        r1 = r1.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ef, code lost:
    
        if (r1.hasNext() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00f1, code lost:
    
        r2 = (java.util.Map.Entry) r1.next();
        r3 = (java.lang.Long) r2.getKey();
        r2 = (java.lang.Long) r2.getValue();
        r4 = new android.content.ContentValues();
        r4.put("epoch_time_created_at", r2);
        r14.update(com.helpshift.db.conversation.tables.ConversationTable.TABLE_NAME, r4, "_id = ?", new java.lang.String[]{java.lang.String.valueOf(r3)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x011d, code lost:
    
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0023, code lost:
    
        if (r2.moveToFirst() != false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0129, code lost:
    
        if (r0.hasNext() == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x012b, code lost:
    
        r1 = (java.util.Map.Entry) r0.next();
        r2 = (java.lang.Long) r1.getKey();
        r1 = (java.lang.Long) r1.getValue();
        r3 = new android.content.ContentValues();
        r3.put("epoch_time_created_at", r1);
        r14.update(com.helpshift.db.conversation.tables.MessagesTable.TABLE_NAME, r3, "_id = ?", new java.lang.String[]{java.lang.String.valueOf(r2)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0157, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0025, code lost:
    
        r0.put(java.lang.Long.valueOf(r2.getLong(r2.getColumnIndex("_id"))), r2.getString(r2.getColumnIndex("created_at")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0044, code lost:
    
        if (r2.moveToNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0046, code lost:
    
        r2.close();
        r12 = new java.util.HashMap();
        r1 = r14.query(com.helpshift.db.conversation.tables.MessagesTable.TABLE_NAME, r1, null, null, null, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x005f, code lost:
    
        if (r1.moveToFirst() == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0061, code lost:
    
        r12.put(java.lang.Long.valueOf(r1.getLong(r1.getColumnIndex("_id"))), r1.getString(r1.getColumnIndex("created_at")));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void migrateData(android.database.sqlite.SQLiteDatabase r14) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.db.conversation.migration.ConversationDbMigration_6_to_7.migrateData(android.database.sqlite.SQLiteDatabase):void");
    }
}
