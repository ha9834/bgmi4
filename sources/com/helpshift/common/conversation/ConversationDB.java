package com.helpshift.common.conversation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.common.dao.DAOResult;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.AutoRetriableMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.ImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.activeconversation.message.input.TextInput;
import com.helpshift.conversation.activeconversation.model.Action;
import com.helpshift.conversation.activeconversation.model.ActionCard;
import com.helpshift.conversation.activeconversation.model.ActionType;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.dto.dao.ConversationInboxRecord;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.db.conversation.ConversationDBHelper;
import com.helpshift.db.conversation.ConversationDatabaseContract;
import com.helpshift.db.conversation.tables.ActionCardTable;
import com.helpshift.db.conversation.tables.ActionTable;
import com.helpshift.db.conversation.tables.ConversationInboxTable;
import com.helpshift.db.conversation.tables.ConversationTable;
import com.helpshift.db.conversation.tables.MessagesTable;
import com.helpshift.support.Faq;
import com.helpshift.support.constants.FaqsTable;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.tencent.smtt.sdk.TbsReaderView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ConversationDB {
    private static final String TAG = "Helpshift_ConverDB";
    private static ConversationDB instance;
    private final ConversationDBHelper dbHelper;
    private final String KEY_CSAT_RATING = "csat_rating";
    private final String KEY_CSAT_STATE = "csat_state";
    private final String KEY_CSAT_FEEDBACK = "csat_feedback";
    private final String KEY_INCREMENT_MESSAGE_COUNT = "increment_message_count";
    private final String KEY_CONVERSATION_ENDED_DELEGATE_SENT = "ended_delegate_sent";
    private final String KEY_IMAGE_ATTACHMENT_DRAFT_ORIGINAL_NAME = "image_draft_orig_name";
    private final String KEY_IMAGE_ATTACHMENT_DRAFT_ORIGINAL_SIZE = "image_draft_orig_size";
    private final String KEY_IMAGE_ATTACHMENT_DRAFT_FILE_PATH = "image_draft_file_path";
    private final String KEY_IMAGE_ATTACHMENT_COMPRESSION_COPYING_DONE = "image_copy_done";
    private final String KEY_IMAGE_ATTACHMENT_TYPE = "attachment_type";
    private final String KEY_IS_AUTO_FILLED_PREISSUE = "is_autofilled_preissue";
    private final String KEY_SMART_INTENT_IDs = "smart_intent_ids";
    private final String KEY_SMART_INTENT_TREE_ID = "smart_intent_tree_id";
    private final String KEY_SMART_INTENT_USER_QUERY = "smart_intent_user_query";
    private final String KEY_REFERRED_MESSAGE_ID = "referredMessageId";
    private final String KEY_FOLLOW_UP_REJECTED_REASON = "rejected_reason";
    private final String KEY_FOLLOW_UP_REJECTED_OPEN_CONVERSATION = "rejected_conv_id";
    private final String KEY_IS_ANSWERED = "is_answered";
    private final String KEY_CONTENT_TYPE = FirebaseAnalytics.Param.CONTENT_TYPE;
    private final String KEY_FILE_NAME = "file_name";
    private final String KEY_URL = "url";
    private final String KEY_SIZE = "size";
    private final String KEY_THUMBNAIL_URL = "thumbnail_url";
    private final String KEY_THUMBNAIL_FILE_PATH = "thumbnailFilePath";
    private final String KEY_FILE_PATH = TbsReaderView.KEY_FILE_PATH;
    private final String KEY_SEEN_AT_MESSAGE_CURSOR = "seen_cursor";
    private final String KEY_SEEN_SYNC_STATUS = "seen_sync_status";
    private final String KEY_READ_AT = "read_at";
    private final String KEY_INPUT_KEYBOARD = "input_keyboard";
    private final String KEY_INPUT_REQUIRED = "input_required";
    private final String KEY_INPUT_SKIP_LABEL = "input_skip_label";
    private final String KEY_INPUT_PLACEHOLDER = "input_placeholder";
    private final String KEY_INPUT_LABEL = "input_label";
    private final String KEY_INPUT_OPTIONS = "input_options";
    private final String KEY_OPTION_TYPE = "option_type";
    private final String KEY_OPTION_TITLE = "option_title";
    private final String KEY_OPTION_DATA = "option_data";
    private final String KEY_CHATBOT_INFO = "chatbot_info";
    private final String KEY_HAS_NEXT_BOT = "has_next_bot";
    private final String KEY_FAQS = "faqs";
    private final String KEY_FAQS_SOURCE = "faq_source";
    private final String KEY_FAQ_TITLE = "faq_title";
    private final String KEY_FAQ_PUBLISH_ID = "faq_publish_id";
    private final String KEY_FAQ_LANGUAGE = "faq_language";
    private final String KEY_IS_RESPONSE_SKIPPED = "is_response_skipped";
    private final String KEY_SELECTED_OPTION_DATA = "selected_option_data";
    private final String KEY_REFERRED_MESSAGE_TYPE = "referred_message_type";
    private final String KEY_BOT_ACTION_TYPE = "bot_action_type";
    private final String KEY_BOT_ENDED_REASON = "bot_ended_reason";
    private final String KEY_MESSAGE_SYNC_STATUS = "message_sync_status";
    private final String KEY_SECURE_ATTACHMENT = "is_secure";
    private final String KEY_IS_USER_ATTACHMENT_ZIPPED = "is_user_attachment_zipped";
    private final String KEY_IS_USER_ATTACHMENT_REJECTED = "is_user_attachment_rejected";
    private final String KEY_IS_MESSAGE_EMPTY = "is_message_empty";
    private final String KEY_IS_SUGGESTION_READ_EVENT_SENT = "is_suggestion_read_event_sent";
    private final String KEY_SUGGESTION_READ_FAQ_PUBLISH_ID = "suggestion_read_faq_publish_id";
    private final String KEY_DATE_TIME = "dt";
    private final String KEY_TIMEZONE_ID = "timezone_id";
    private final String KEY_ATTACHMENT_COUNT = "attachment_count";
    private final String KEY_ORIGINAL_MESSAGE_ID = "original_message_server_id";
    private final String KEY_SMART_INTENT_LABELS = "intent_labels";

    private ConversationDB(Context context) {
        this.dbHelper = new ConversationDBHelper(context, new ConversationDatabaseContract());
    }

    public static synchronized ConversationDB getInstance(Context context) {
        ConversationDB conversationDB;
        synchronized (ConversationDB.class) {
            if (instance == null) {
                instance = new ConversationDB(context);
            }
            conversationDB = instance;
        }
        return conversationDB;
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        if (r11 != null) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r11 == null) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003a A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #4 {, blocks: (B:12:0x0020, B:22:0x003a, B:23:0x003d), top: B:3:0x0002 }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private synchronized com.helpshift.conversation.activeconversation.model.Conversation readConversation(java.lang.String r11, java.lang.String[] r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            com.helpshift.db.conversation.ConversationDBHelper r1 = r10.dbHelper     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            java.lang.String r3 = "issues"
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r5 = r11
            r6 = r12
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L29
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L37
            if (r12 == 0) goto L1e
            com.helpshift.conversation.activeconversation.model.Conversation r0 = r10.cursorToReadableConversation(r11)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L37
        L1e:
            if (r11 == 0) goto L35
        L20:
            r11.close()     // Catch: java.lang.Throwable -> L3e
            goto L35
        L24:
            r12 = move-exception
            goto L2b
        L26:
            r12 = move-exception
            r11 = r0
            goto L38
        L29:
            r12 = move-exception
            r11 = r0
        L2b:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in read conversations with localId"
            com.helpshift.util.HSLogger.e(r1, r2, r12)     // Catch: java.lang.Throwable -> L37
            if (r11 == 0) goto L35
            goto L20
        L35:
            monitor-exit(r10)
            return r0
        L37:
            r12 = move-exception
        L38:
            if (r11 == 0) goto L3d
            r11.close()     // Catch: java.lang.Throwable -> L3e
        L3d:
            throw r12     // Catch: java.lang.Throwable -> L3e
        L3e:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readConversation(java.lang.String, java.lang.String[]):com.helpshift.conversation.activeconversation.model.Conversation");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r1 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0027, code lost:
    
        if (r1.moveToFirst() != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0029, code lost:
    
        r0.add(cursorToReadableConversation(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r1.moveToNext() != false) goto L32;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.helpshift.common.dao.DAOResult<java.util.List<com.helpshift.conversation.activeconversation.model.Conversation>> readConversationsWithLocalId(long r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5e
            r0.<init>()     // Catch: java.lang.Throwable -> L5e
            r1 = 0
            java.lang.String r5 = "user_local_id = ?"
            r10 = 1
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch: java.lang.Throwable -> L5e
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L5e
            r13 = 0
            r6[r13] = r12     // Catch: java.lang.Throwable -> L5e
            com.helpshift.db.conversation.ConversationDBHelper r12 = r11.dbHelper     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            android.database.sqlite.SQLiteDatabase r2 = r12.getReadableDatabase()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.lang.String r3 = "issues"
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            if (r12 == 0) goto L36
        L29:
            com.helpshift.conversation.activeconversation.model.Conversation r12 = r11.cursorToReadableConversation(r1)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r0.add(r12)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            if (r12 != 0) goto L29
        L36:
            if (r1 == 0) goto L3b
            r1.close()     // Catch: java.lang.Throwable -> L5e
        L3b:
            com.helpshift.common.dao.DAOResult r12 = new com.helpshift.common.dao.DAOResult     // Catch: java.lang.Throwable -> L5e
            r12.<init>(r10, r0)     // Catch: java.lang.Throwable -> L5e
            monitor-exit(r11)
            return r12
        L42:
            r12 = move-exception
            goto L58
        L44:
            r12 = move-exception
            java.lang.String r2 = "Helpshift_ConverDB"
            java.lang.String r3 = "Error in read conversations with localId"
            com.helpshift.util.HSLogger.e(r2, r3, r12)     // Catch: java.lang.Throwable -> L42
            com.helpshift.common.dao.DAOResult r12 = new com.helpshift.common.dao.DAOResult     // Catch: java.lang.Throwable -> L42
            r12.<init>(r13, r0)     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.lang.Throwable -> L5e
        L56:
            monitor-exit(r11)
            return r12
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
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readConversationsWithLocalId(long):com.helpshift.common.dao.DAOResult");
    }

    public synchronized Conversation readConversationWithLocalId(Long l) {
        return readConversation("_id = ?", new String[]{String.valueOf(l)});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void deleteConversationWithLocalId(long j) {
        String str;
        String str2;
        String[] strArr = {String.valueOf(j)};
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.dbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.delete(ConversationTable.TABLE_NAME, "_id = ?", strArr);
                sQLiteDatabase.delete(MessagesTable.TABLE_NAME, "conversation_id = ?", strArr);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        e = e;
                        str = TAG;
                        str2 = "Exception in ending transaction deleteConversationWithLocalId : " + j;
                        HSLogger.e(str, str2, e);
                    }
                }
            } catch (Exception e2) {
                HSLogger.e(TAG, "Error in delete conversation with localId", e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        e = e3;
                        str = TAG;
                        str2 = "Exception in ending transaction deleteConversationWithLocalId : " + j;
                        HSLogger.e(str, str2, e);
                    }
                }
            }
        } finally {
        }
    }

    public synchronized Conversation readConversationWithServerId(String str) {
        return readConversation("server_id = ?", new String[]{String.valueOf(str)});
    }

    public synchronized Conversation readPreConversationWithServerId(String str) {
        return readConversation("pre_conv_server_id = ?", new String[]{String.valueOf(str)});
    }

    public synchronized long insertConversation(Conversation conversation) {
        long j;
        j = -1;
        try {
            j = this.dbHelper.getWritableDatabase().insert(ConversationTable.TABLE_NAME, null, readableConversationToContentValues(conversation));
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in insert conversation", e);
        }
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized DAOResult<List<Long>> insertConversations(List<Conversation> list) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        if (list.size() == 0) {
            return new DAOResult<>(true, null);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Conversation> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(readableConversationToContentValues(it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                sQLiteDatabase = this.dbHelper.getWritableDatabase();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = null;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            sQLiteDatabase.beginTransaction();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Long.valueOf(sQLiteDatabase.insert(ConversationTable.TABLE_NAME, null, (ContentValues) it2.next())));
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e2) {
                    HSLogger.e(TAG, "Error in insert conversations inside finally block", e2);
                }
            }
            return new DAOResult<>(true, arrayList2);
        } catch (Exception e3) {
            e = e3;
            sQLiteDatabase2 = sQLiteDatabase;
            HSLogger.e(TAG, "Error in insert conversations", e);
            DAOResult<List<Long>> dAOResult = new DAOResult<>(false, arrayList2);
            if (sQLiteDatabase2 != null) {
                try {
                    sQLiteDatabase2.endTransaction();
                } catch (Exception e4) {
                    HSLogger.e(TAG, "Error in insert conversations inside finally block", e4);
                }
            }
            return dAOResult;
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e5) {
                    HSLogger.e(TAG, "Error in insert conversations inside finally block", e5);
                }
            }
            throw th;
        }
    }

    public synchronized void updateConversation(Conversation conversation) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(conversation);
        updateConversations(arrayList);
    }

    public synchronized void updateLastUserActivityTimeInConversation(Long l, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConversationTable.Columns.LAST_USER_ACTIVITY_TIME, Long.valueOf(j));
        try {
            this.dbHelper.getWritableDatabase().update(ConversationTable.TABLE_NAME, contentValues, "_id = ?", new String[]{String.valueOf(l)});
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in updateLastUserActivityTimeInConversation", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean updateConversations(List<Conversation> list) {
        if (list.size() == 0) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Conversation conversation : list) {
            arrayList.add(readableConversationToContentValues(conversation));
            arrayList2.add(new String[]{String.valueOf(conversation.localId)});
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.dbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                for (int i = 0; i < list.size(); i++) {
                    sQLiteDatabase.update(ConversationTable.TABLE_NAME, (ContentValues) arrayList.get(i), "_id = ?", (String[]) arrayList2.get(i));
                }
                sQLiteDatabase.setTransactionSuccessful();
                return true;
            } finally {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        HSLogger.e(TAG, "Error in update conversations inside finally block", e);
                    }
                }
            }
        } catch (Exception e2) {
            HSLogger.e(TAG, "Error in update conversations", e2);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    HSLogger.e(TAG, "Error in update conversations inside finally block", e3);
                }
            }
            return false;
        }
    }

    public synchronized ConversationInboxRecord storeConversationInboxRecord(ConversationInboxRecord conversationInboxRecord) {
        String[] strArr = {String.valueOf(conversationInboxRecord.userLocalId)};
        ContentValues conversationInboxRecordToContentValues = conversationInboxRecordToContentValues(conversationInboxRecord);
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            if (exists(writableDatabase, ConversationInboxTable.TABLE_NAME, "user_local_id = ?", strArr)) {
                writableDatabase.update(ConversationInboxTable.TABLE_NAME, conversationInboxRecordToContentValues, "user_local_id = ?", strArr);
            } else {
                writableDatabase.insert(ConversationInboxTable.TABLE_NAME, null, conversationInboxRecordToContentValues);
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in store conversation inbox record", e);
        }
        return conversationInboxRecord;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r11 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if (r11 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[Catch: all -> 0x004a, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:13:0x002a, B:23:0x0046, B:24:0x0049), top: B:2:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.helpshift.conversation.dto.dao.ConversationInboxRecord readConversationInboxRecord(long r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r3 = "user_local_id = ?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L4a
            r0 = 0
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L4a
            r4[r0] = r10     // Catch: java.lang.Throwable -> L4a
            r10 = 0
            com.helpshift.db.conversation.ConversationDBHelper r11 = r9.dbHelper     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            android.database.sqlite.SQLiteDatabase r0 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            java.lang.String r1 = "conversation_inbox"
            r2 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            boolean r0 = r11.moveToFirst()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
            if (r0 == 0) goto L28
            com.helpshift.conversation.dto.dao.ConversationInboxRecord r10 = r9.cursorToConversationInboxRecord(r11)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L43
        L28:
            if (r11 == 0) goto L41
        L2a:
            r11.close()     // Catch: java.lang.Throwable -> L4a
            goto L41
        L2e:
            r0 = move-exception
            goto L37
        L30:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L44
        L35:
            r0 = move-exception
            r11 = r10
        L37:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in read conversation inbox record"
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L43
            if (r11 == 0) goto L41
            goto L2a
        L41:
            monitor-exit(r9)
            return r10
        L43:
            r10 = move-exception
        L44:
            if (r11 == 0) goto L49
            r11.close()     // Catch: java.lang.Throwable -> L4a
        L49:
            throw r10     // Catch: java.lang.Throwable -> L4a
        L4a:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readConversationInboxRecord(long):com.helpshift.conversation.dto.dao.ConversationInboxRecord");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized long insertMessage(MessageDM messageDM) {
        long j;
        String str;
        String str2;
        j = -1;
        ContentValues readableMessageToContentValues = readableMessageToContentValues(messageDM);
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.dbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                j = insertMessageInternal(sQLiteDatabase, messageDM, readableMessageToContentValues);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        e = e;
                        str = TAG;
                        str2 = "Error in insert message inside finally block";
                        HSLogger.e(str, str2, e);
                        return j;
                    }
                }
            } catch (Exception e2) {
                HSLogger.e(TAG, "Error in insert message", e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        e = e3;
                        str = TAG;
                        str2 = "Error in insert message inside finally block";
                        HSLogger.e(str, str2, e);
                        return j;
                    }
                }
            }
        } finally {
        }
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized DAOResult<List<Long>> insertMessages(List<MessageDM> list) {
        SQLiteDatabase sQLiteDatabase = null;
        if (list.isEmpty()) {
            return new DAOResult<>(true, null);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<MessageDM> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(readableMessageToContentValues(it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            try {
                sQLiteDatabase = this.dbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(Long.valueOf(insertMessageInternal(sQLiteDatabase, list.get(i), (ContentValues) arrayList.get(i))));
                }
                sQLiteDatabase.setTransactionSuccessful();
                return new DAOResult<>(true, arrayList2);
            } finally {
                if (0 != 0) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        HSLogger.e(TAG, "Error in insert messages inside finally block", e);
                    }
                }
            }
        } catch (Exception e2) {
            HSLogger.e(TAG, "Error in insert messages", e2);
            DAOResult<List<Long>> dAOResult = new DAOResult<>(false, arrayList2);
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    HSLogger.e(TAG, "Error in insert messages inside finally block", e3);
                }
            }
            return dAOResult;
        }
    }

    private long insertMessageInternal(SQLiteDatabase sQLiteDatabase, MessageDM messageDM, ContentValues contentValues) {
        long insert = sQLiteDatabase.insert(MessagesTable.TABLE_NAME, null, contentValues);
        if (messageDM.messageType == MessageType.ADMIN_ACTION_CARD) {
            insertActionCard(sQLiteDatabase, (AdminActionCardMessageDM) messageDM);
        }
        return insert;
    }

    private void insertActionCard(SQLiteDatabase sQLiteDatabase, AdminActionCardMessageDM adminActionCardMessageDM) {
        try {
            long insert = sQLiteDatabase.insert(ActionCardTable.TABLE_NAME, null, actionCardToContentValues(adminActionCardMessageDM.actionCard, adminActionCardMessageDM.serverId));
            adminActionCardMessageDM.actionCard.actionCardLocalId = Long.valueOf(insert);
            long insert2 = sQLiteDatabase.insert(ActionTable.TABLE_NAME, null, actionToContentValues(adminActionCardMessageDM.actionCard.action, insert));
            adminActionCardMessageDM.actionCard.action.actionLocalId = Long.valueOf(insert2);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in insert action card", e);
        }
    }

    private ContentValues actionCardToContentValues(ActionCard actionCard, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ActionCardTable.Columns.MESSAGE_ID, str);
        contentValues.put("title", actionCard.title);
        contentValues.put("image_url", actionCard.imageUrl);
        contentValues.put(ActionCardTable.Columns.IS_IMAGE_SECURE, Integer.valueOf(actionCard.isSecure ? 1 : 0));
        contentValues.put(ActionCardTable.Columns.FILE_PATH, actionCard.filePath);
        return contentValues;
    }

    private ContentValues actionToContentValues(Action action, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ActionTable.Columns.ACTION_CARD_ID, Long.valueOf(j));
        contentValues.put(ActionTable.Columns.ACTION_SHA, action.actionSHA);
        contentValues.put(ActionTable.Columns.TITLE, action.actionTitle);
        contentValues.put("action_type", action.actionType.getValue());
        contentValues.put(ActionTable.Columns.DATA, new JSONObject(action.actionData).toString());
        return contentValues;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a9, code lost:
    
        if (r2 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009d, code lost:
    
        if (r2 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e1, code lost:
    
        if (r1 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d7, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00d5, code lost:
    
        if (r1 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0100, code lost:
    
        if (r2 == null) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> readMessagesForConversations(java.util.Collection<java.lang.Long> r13) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readMessagesForConversations(java.util.Collection):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x012e, code lost:
    
        if (r2 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0124, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0122, code lost:
    
        if (r2 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0165, code lost:
    
        if (r15 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015b, code lost:
    
        r15.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0159, code lost:
    
        if (r15 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0183, code lost:
    
        if (r2 == null) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x016f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.Map<java.lang.Long, java.lang.Integer> getMessagesCountForConversations(java.util.List<java.lang.Long> r14, java.lang.String[] r15) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getMessagesCountForConversations(java.util.List, java.lang.String[]):java.util.Map");
    }

    public synchronized DAOResult<List<MessageDM>> readMessages(long j) {
        return readMessages("conversation_id = ?", new String[]{String.valueOf(j)});
    }

    public synchronized List<MessageDM> readMessages(long j, MessageType messageType) {
        return readMessages("conversation_id = ? AND type = ?", new String[]{String.valueOf(j), messageType.getValue()}).getData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        if (r1 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
    
        return new com.helpshift.common.dao.DAOResult<>(true, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001c, code lost:
    
        if (r1.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001e, code lost:
    
        r12 = cursorToMessageDM(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (r12 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0024, code lost:
    
        r0.add(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        if (r1.moveToNext() != false) goto L29;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.helpshift.common.dao.DAOResult<java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM>> readMessages(java.lang.String r12, java.lang.String[] r13) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            com.helpshift.db.conversation.ConversationDBHelper r2 = r11.dbHelper     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            android.database.sqlite.SQLiteDatabase r3 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            java.lang.String r4 = "messages"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r12
            r7 = r13
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            boolean r12 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            if (r12 == 0) goto L2d
        L1e:
            com.helpshift.conversation.activeconversation.message.MessageDM r12 = r11.cursorToMessageDM(r1)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            if (r12 == 0) goto L27
            r0.add(r12)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
        L27:
            boolean r12 = r1.moveToNext()     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            if (r12 != 0) goto L1e
        L2d:
            if (r1 == 0) goto L32
            r1.close()
        L32:
            com.helpshift.common.dao.DAOResult r12 = new com.helpshift.common.dao.DAOResult
            r13 = 1
            r12.<init>(r13, r0)
            return r12
        L39:
            r12 = move-exception
            goto L4f
        L3b:
            r12 = move-exception
            java.lang.String r13 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in read messages"
            com.helpshift.util.HSLogger.e(r13, r2, r12)     // Catch: java.lang.Throwable -> L39
            com.helpshift.common.dao.DAOResult r12 = new com.helpshift.common.dao.DAOResult     // Catch: java.lang.Throwable -> L39
            r13 = 0
            r12.<init>(r13, r0)     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L4e
            r1.close()
        L4e:
            return r12
        L4f:
            if (r1 == 0) goto L54
            r1.close()
        L54:
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.readMessages(java.lang.String, java.lang.String[]):com.helpshift.common.dao.DAOResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void updateMessage(MessageDM messageDM) {
        String str;
        String str2;
        String[] strArr = {String.valueOf(messageDM.localId)};
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.dbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                updateMessageInternal(sQLiteDatabase, messageDM, "_id = ?", strArr);
                sQLiteDatabase.setTransactionSuccessful();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e) {
                        e = e;
                        str = TAG;
                        str2 = "Error in update message inside finally block";
                        HSLogger.e(str, str2, e);
                    }
                }
            } catch (Exception e2) {
                HSLogger.e(TAG, "Error in update message", e2);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        e = e3;
                        str = TAG;
                        str2 = "Error in update message inside finally block";
                        HSLogger.e(str, str2, e);
                    }
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean updateMessages(List<MessageDM> list) {
        if (list.size() == 0) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabase = this.dbHelper.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                for (MessageDM messageDM : list) {
                    updateMessageInternal(sQLiteDatabase, messageDM, "_id = ?", new String[]{String.valueOf(messageDM.localId)});
                }
                sQLiteDatabase.setTransactionSuccessful();
                return true;
            } catch (Exception e) {
                HSLogger.e(TAG, "Error in update messages", e);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        HSLogger.e(TAG, "Error in update messages", e2);
                    }
                }
                return false;
            }
        } finally {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Exception e3) {
                    HSLogger.e(TAG, "Error in update messages", e3);
                }
            }
        }
    }

    private void updateMessageInternal(SQLiteDatabase sQLiteDatabase, MessageDM messageDM, String str, String[] strArr) {
        sQLiteDatabase.update(MessagesTable.TABLE_NAME, readableMessageToContentValues(messageDM), str, strArr);
        if (messageDM.messageType == MessageType.ADMIN_ACTION_CARD) {
            updateActionCard(sQLiteDatabase, (AdminActionCardMessageDM) messageDM);
        }
    }

    private void updateActionCard(SQLiteDatabase sQLiteDatabase, AdminActionCardMessageDM adminActionCardMessageDM) {
        if (adminActionCardMessageDM.actionCard.actionCardLocalId == null) {
            insertActionCard(sQLiteDatabase, adminActionCardMessageDM);
            return;
        }
        try {
            sQLiteDatabase.update(ActionCardTable.TABLE_NAME, actionCardToContentValues(adminActionCardMessageDM.actionCard, adminActionCardMessageDM.serverId), "_id = ?", new String[]{String.valueOf(adminActionCardMessageDM.actionCard.actionCardLocalId)});
            sQLiteDatabase.update(ActionTable.TABLE_NAME, actionToContentValues(adminActionCardMessageDM.actionCard.action, adminActionCardMessageDM.actionCard.actionCardLocalId.longValue()), "_id = ?", new String[]{String.valueOf(adminActionCardMessageDM.actionCard.action.actionLocalId)});
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in update action card", e);
        }
    }

    public synchronized boolean deleteMessagesForConversation(long j) {
        try {
            this.dbHelper.getWritableDatabase().delete(MessagesTable.TABLE_NAME, "conversation_id= ? ", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            HSLogger.e(TAG, "Error deleting messages for : " + j, e);
            return false;
        }
        return true;
    }

    private boolean exists(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM ");
        sb.append(str);
        sb.append(" WHERE ");
        sb.append(str2);
        sb.append(" LIMIT 1");
        return DatabaseUtils.longForQuery(sQLiteDatabase, sb.toString(), strArr) > 0;
    }

    private ConversationInboxRecord cursorToConversationInboxRecord(Cursor cursor) {
        return new ConversationInboxRecord(cursor.getLong(cursor.getColumnIndex("user_local_id")), cursor.getString(cursor.getColumnIndex(ConversationInboxTable.Columns.FORM_NAME)), cursor.getString(cursor.getColumnIndex(ConversationInboxTable.Columns.FORM_EMAIL)), cursor.getString(cursor.getColumnIndex(ConversationInboxTable.Columns.DESCRIPTION_DRAFT)), cursor.getLong(cursor.getColumnIndex(ConversationInboxTable.Columns.DESCRIPTION_DRAFT_TIMESTAMP)), parseAndGetImageAttachmentDraft(cursor.getString(cursor.getColumnIndex(ConversationInboxTable.Columns.ATTACHMENT_DRAFT))), cursor.getInt(cursor.getColumnIndex(ConversationInboxTable.Columns.DESCRIPTION_TYPE)), cursor.getString(cursor.getColumnIndex(ConversationInboxTable.Columns.ARCHIVAL_TEXT)), cursor.getString(cursor.getColumnIndex(ConversationInboxTable.Columns.REPLY_TEXT)), cursor.getInt(cursor.getColumnIndex(ConversationInboxTable.Columns.PERSIST_MESSAGE_BOX)) == 1, cursor.getString(cursor.getColumnIndex(ConversationInboxTable.Columns.LAST_SYNC_TIMESTAMP)), com.helpshift.util.DatabaseUtils.parseBooleanColumnSafe(cursor, "has_older_messages"), (Long) com.helpshift.util.DatabaseUtils.parseColumnSafe(cursor, "last_conv_redaction_time", Long.class));
    }

    private ContentValues conversationInboxRecordToContentValues(ConversationInboxRecord conversationInboxRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_local_id", Long.valueOf(conversationInboxRecord.userLocalId));
        contentValues.put(ConversationInboxTable.Columns.FORM_NAME, conversationInboxRecord.formName);
        contentValues.put(ConversationInboxTable.Columns.FORM_EMAIL, conversationInboxRecord.formEmail);
        contentValues.put(ConversationInboxTable.Columns.DESCRIPTION_DRAFT, conversationInboxRecord.description);
        contentValues.put(ConversationInboxTable.Columns.DESCRIPTION_DRAFT_TIMESTAMP, Long.valueOf(conversationInboxRecord.descriptionTimeStamp));
        contentValues.put(ConversationInboxTable.Columns.DESCRIPTION_TYPE, Integer.valueOf(conversationInboxRecord.descriptionType));
        contentValues.put(ConversationInboxTable.Columns.ARCHIVAL_TEXT, conversationInboxRecord.archivalText);
        contentValues.put(ConversationInboxTable.Columns.REPLY_TEXT, conversationInboxRecord.replyText);
        contentValues.put(ConversationInboxTable.Columns.PERSIST_MESSAGE_BOX, Integer.valueOf(conversationInboxRecord.persistMessageBox ? 1 : 0));
        contentValues.put(ConversationInboxTable.Columns.LAST_SYNC_TIMESTAMP, conversationInboxRecord.lastSyncTimestamp);
        if (conversationInboxRecord.hasOlderMessages != null) {
            contentValues.put("has_older_messages", Integer.valueOf(conversationInboxRecord.hasOlderMessages.booleanValue() ? 1 : 0));
        }
        contentValues.put("last_conv_redaction_time", conversationInboxRecord.lastConversationsRedactionTime);
        try {
            contentValues.put(ConversationInboxTable.Columns.ATTACHMENT_DRAFT, getImageAttachmentDraftMeta(conversationInboxRecord.imageAttachmentDraft));
        } catch (JSONException e) {
            HSLogger.e(TAG, "Error in generating meta string for image attachment", e);
        }
        return contentValues;
    }

    private ContentValues readableConversationToContentValues(Conversation conversation) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_local_id", Long.valueOf(conversation.userLocalId));
        contentValues.put("server_id", conversation.serverId);
        contentValues.put(ConversationTable.Columns.PRE_CONVERSATION_SERVER_ID, conversation.preConversationServerId);
        contentValues.put("publish_id", conversation.publishId);
        contentValues.put(ConversationTable.Columns.LOCAL_UUID, conversation.localUUID);
        contentValues.put("title", conversation.title);
        contentValues.put(ConversationTable.Columns.MESSAGE_CURSOR, conversation.messageCursor);
        contentValues.put(ConversationTable.Columns.IS_START_NEW_CONVERSATION_CLICKED, Integer.valueOf(conversation.isStartNewConversationClicked ? 1 : 0));
        contentValues.put("created_at", conversation.getCreatedAt());
        contentValues.put(ConversationTable.Columns.UPDATED_AT, conversation.updatedAt);
        contentValues.put("epoch_time_created_at", Long.valueOf(conversation.getEpochCreatedAtTime()));
        contentValues.put(ConversationTable.Columns.LAST_USER_ACTIVITY_TIME, Long.valueOf(conversation.lastUserActivityTime));
        contentValues.put(ConversationTable.Columns.ISSUE_TYPE, conversation.issueType);
        contentValues.put(ConversationTable.Columns.FULL_PRIVACY_ENABLED, Integer.valueOf(conversation.wasFullPrivacyEnabledAtCreation ? 1 : 0));
        contentValues.put("state", Integer.valueOf(conversation.state == null ? -1 : conversation.state.getValue()));
        contentValues.put("is_redacted", Integer.valueOf(conversation.isRedacted ? 1 : 0));
        contentValues.put("acid", conversation.acid);
        contentValues.put(ConversationTable.Columns.RESOLUTION_EXPIRY_AT, conversation.resolutionExpiryAt);
        contentValues.put(ConversationTable.Columns.CSAT_EXPIRY_AT, conversation.csatExpiryAt);
        try {
            contentValues.put("meta", getConversationMeta(conversation));
        } catch (JSONException e) {
            HSLogger.e(TAG, "Error in generating meta string for conversation", e);
        }
        return contentValues;
    }

    private String getImageAttachmentDraftMeta(AttachmentPickerFile attachmentPickerFile) throws JSONException {
        if (attachmentPickerFile == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("image_draft_orig_name", attachmentPickerFile.originalFileName);
        jSONObject.put("image_draft_orig_size", attachmentPickerFile.originalFileSize);
        jSONObject.put("image_draft_file_path", attachmentPickerFile.filePath);
        jSONObject.put("attachment_type", attachmentPickerFile.attachmentType);
        jSONObject.put("image_copy_done", attachmentPickerFile.isFileCompressionAndCopyingDone);
        return jSONObject.toString();
    }

    private String getConversationMeta(Conversation conversation) throws JSONException {
        ConversationCSATState conversationCSATState = conversation.csatState;
        JSONObject jSONObject = new JSONObject();
        String str = conversation.csatFeedback;
        int i = conversation.csatRating;
        jSONObject.put("csat_feedback", str);
        jSONObject.put("csat_rating", i);
        jSONObject.put("csat_state", conversationCSATState.getValue());
        jSONObject.put("increment_message_count", conversation.shouldIncrementMessageCount);
        jSONObject.put("ended_delegate_sent", conversation.isConversationEndedDelegateSent);
        jSONObject.put("is_autofilled_preissue", conversation.isAutoFilledPreIssue);
        if (StringUtils.isNotEmpty(conversation.smartIntentTreeId)) {
            jSONObject.put("smart_intent_tree_id", conversation.smartIntentTreeId);
        }
        if (StringUtils.isNotEmpty(conversation.smartIntentUserQuery)) {
            jSONObject.put("smart_intent_user_query", conversation.smartIntentUserQuery);
        }
        JSONArray listToJsonArray = HSJSONUtils.listToJsonArray(conversation.smartIntentIds);
        String jSONArray = listToJsonArray != null ? listToJsonArray.toString() : null;
        if (StringUtils.isNotEmpty(jSONArray)) {
            jSONObject.put("smart_intent_ids", jSONArray);
        }
        return jSONObject.toString();
    }

    private Conversation cursorToReadableConversation(Cursor cursor) {
        Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id")));
        long j = cursor.getLong(cursor.getColumnIndex("user_local_id"));
        String string = cursor.getString(cursor.getColumnIndex("server_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("publish_id"));
        String string3 = cursor.getString(cursor.getColumnIndex(ConversationTable.Columns.LOCAL_UUID));
        String string4 = cursor.getString(cursor.getColumnIndex("title"));
        String string5 = cursor.getString(cursor.getColumnIndex(ConversationTable.Columns.MESSAGE_CURSOR));
        boolean z = cursor.getInt(cursor.getColumnIndex(ConversationTable.Columns.IS_START_NEW_CONVERSATION_CLICKED)) == 1;
        String string6 = cursor.getString(cursor.getColumnIndex("meta"));
        String string7 = cursor.getString(cursor.getColumnIndex("created_at"));
        long j2 = cursor.getLong(cursor.getColumnIndex("epoch_time_created_at"));
        String string8 = cursor.getString(cursor.getColumnIndex(ConversationTable.Columns.UPDATED_AT));
        String string9 = cursor.getString(cursor.getColumnIndex(ConversationTable.Columns.PRE_CONVERSATION_SERVER_ID));
        long j3 = cursor.getLong(cursor.getColumnIndex(ConversationTable.Columns.LAST_USER_ACTIVITY_TIME));
        String string10 = cursor.getString(cursor.getColumnIndex(ConversationTable.Columns.ISSUE_TYPE));
        boolean parseBooleanColumnSafe = com.helpshift.util.DatabaseUtils.parseBooleanColumnSafe(cursor, ConversationTable.Columns.FULL_PRIVACY_ENABLED, false);
        IssueState fromInt = IssueState.fromInt(cursor.getInt(cursor.getColumnIndex("state")));
        boolean parseBooleanColumnSafe2 = com.helpshift.util.DatabaseUtils.parseBooleanColumnSafe(cursor, "is_redacted", false);
        String string11 = cursor.getString(cursor.getColumnIndex("acid"));
        Long l = (Long) com.helpshift.util.DatabaseUtils.parseColumnSafe(cursor, ConversationTable.Columns.RESOLUTION_EXPIRY_AT, Long.class);
        Long l2 = (Long) com.helpshift.util.DatabaseUtils.parseColumnSafe(cursor, ConversationTable.Columns.CSAT_EXPIRY_AT, Long.class);
        Conversation conversation = new Conversation(string4, fromInt, string7, j2, string8, string2, string5, string10, string11);
        conversation.serverId = string;
        conversation.preConversationServerId = string9;
        conversation.setLocalId(valueOf.longValue());
        conversation.localUUID = string3;
        conversation.state = fromInt;
        conversation.userLocalId = j;
        conversation.isStartNewConversationClicked = z;
        conversation.lastUserActivityTime = j3;
        conversation.wasFullPrivacyEnabledAtCreation = parseBooleanColumnSafe;
        conversation.isRedacted = parseBooleanColumnSafe2;
        conversation.acid = string11;
        conversation.resolutionExpiryAt = l;
        conversation.csatExpiryAt = l2;
        parseAndSetMetaData(conversation, string6);
        return conversation;
    }

    private ContentValues readableMessageToContentValues(MessageDM messageDM) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("server_id", messageDM.serverId);
        contentValues.put(MessagesTable.Columns.CONVERSATION_ID, messageDM.conversationLocalId);
        contentValues.put("body", messageDM.body);
        contentValues.put("created_at", messageDM.getCreatedAt());
        contentValues.put("epoch_time_created_at", Long.valueOf(messageDM.getEpochCreatedAtTime()));
        contentValues.put("type", messageDM.messageType.getValue());
        contentValues.put(MessagesTable.Columns.DELIVERY_STATE, Integer.valueOf(messageDM.deliveryState));
        contentValues.put("is_redacted", Integer.valueOf(messageDM.isRedacted ? 1 : 0));
        Author author = messageDM.author;
        contentValues.put(MessagesTable.Columns.AUTHOR_NAME, author.authorName);
        contentValues.put(MessagesTable.Columns.AUTHOR_ID, author.authorId);
        contentValues.put(MessagesTable.Columns.AUTHOR_ROLE, author.role != null ? author.role.getValue() : null);
        contentValues.put(MessagesTable.Columns.AVATAR_IMAGE_LOCAL_PATH, author.localAvatarImagePath);
        try {
            contentValues.put("meta", getMessageMeta(messageDM));
        } catch (JSONException e) {
            HSLogger.e(TAG, "Error in generating meta string for message", e);
        }
        return contentValues;
    }

    private void parseAndSetMetaData(Conversation conversation, String str) {
        if (str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("csat_rating", 0);
            int optInt2 = jSONObject.optInt("csat_state", ConversationCSATState.NONE.getValue());
            ArrayList<String> arrayList = null;
            String optString = jSONObject.optString("csat_feedback", null);
            conversation.csatRating = optInt;
            conversation.csatState = ConversationCSATState.fromInt(optInt2);
            conversation.csatFeedback = optString;
            conversation.shouldIncrementMessageCount = jSONObject.optBoolean("increment_message_count", false);
            conversation.isConversationEndedDelegateSent = jSONObject.optBoolean("ended_delegate_sent", false);
            conversation.isAutoFilledPreIssue = jSONObject.optBoolean("is_autofilled_preissue", false);
            conversation.smartIntentTreeId = jSONObject.optString("smart_intent_tree_id", null);
            conversation.smartIntentUserQuery = jSONObject.optString("smart_intent_user_query", null);
            if (!jSONObject.isNull("smart_intent_ids")) {
                arrayList = HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString("smart_intent_ids"));
            }
            conversation.smartIntentIds = arrayList;
        } catch (JSONException e) {
            HSLogger.e(TAG, "Error in parseAndSetMetaData", e);
        }
    }

    private AttachmentPickerFile parseAndGetImageAttachmentDraft(String str) {
        AttachmentPickerFile attachmentPickerFile;
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("image_draft_orig_name", null);
            Long valueOf = Long.valueOf(jSONObject.optLong("image_draft_orig_size", -1L));
            String optString2 = jSONObject.optString("image_draft_file_path", null);
            int optInt = jSONObject.optInt("attachment_type");
            boolean optBoolean = jSONObject.optBoolean("image_copy_done", false);
            if (valueOf.longValue() == -1) {
                valueOf = null;
            }
            attachmentPickerFile = new AttachmentPickerFile(optString2, optString, valueOf);
            try {
                attachmentPickerFile.isFileCompressionAndCopyingDone = optBoolean;
                attachmentPickerFile.attachmentType = optInt;
            } catch (JSONException e) {
                e = e;
                HSLogger.e(TAG, "Error in parseAndGetImageAttachmentDraft", e);
                return attachmentPickerFile;
            }
        } catch (JSONException e2) {
            e = e2;
            attachmentPickerFile = null;
        }
        return attachmentPickerFile;
    }

    private Author getAuthor(String str, String str2, String str3, String str4, boolean z) {
        Author.AuthorRole authorRole;
        if (z) {
            authorRole = Author.AuthorRole.LOCAL_USER;
        } else {
            authorRole = Author.AuthorRole.getEnum(str3);
        }
        Author author = new Author(str, str2, authorRole);
        author.localAvatarImagePath = str4;
        return author;
    }

    private MessageDM cursorToMessageDM(Cursor cursor) {
        long j;
        long j2;
        JSONObject jSONObject;
        boolean z;
        int i;
        MessageDM messageDM;
        long j3 = cursor.getLong(cursor.getColumnIndex("_id"));
        long j4 = cursor.getLong(cursor.getColumnIndex(MessagesTable.Columns.CONVERSATION_ID));
        String string = cursor.getString(cursor.getColumnIndex("server_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("body"));
        String string3 = cursor.getString(cursor.getColumnIndex("meta"));
        String string4 = cursor.getString(cursor.getColumnIndex("type"));
        String string5 = cursor.getString(cursor.getColumnIndex("created_at"));
        String string6 = cursor.getString(cursor.getColumnIndex(MessagesTable.Columns.AUTHOR_NAME));
        String string7 = cursor.getString(cursor.getColumnIndex(MessagesTable.Columns.AUTHOR_ROLE));
        String string8 = cursor.getString(cursor.getColumnIndex(MessagesTable.Columns.AUTHOR_ID));
        String string9 = cursor.getString(cursor.getColumnIndex(MessagesTable.Columns.AVATAR_IMAGE_LOCAL_PATH));
        int columnIndex = cursor.getColumnIndex("epoch_time_created_at");
        long j5 = cursor.isNull(columnIndex) ? 0L : cursor.getLong(columnIndex);
        if (j5 <= 0) {
            j5 = HSDateFormatSpec.convertToEpochTime(string5);
        }
        long j6 = j5;
        int i2 = cursor.getInt(cursor.getColumnIndex(MessagesTable.Columns.DELIVERY_STATE));
        boolean parseBooleanColumnSafe = com.helpshift.util.DatabaseUtils.parseBooleanColumnSafe(cursor, "is_redacted", false);
        MessageType fromValue = MessageType.fromValue(string4);
        JSONObject jsonify = jsonify(string3);
        switch (fromValue) {
            case USER_TEXT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM userMessageDM = new UserMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true));
                userMessageDM.serverId = string;
                messageDM = userMessageDM;
                break;
            case USER_RESP_FOR_TEXT_INPUT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                UserResponseMessageForTextInputDM userResponseMessageForTextInputDM = new UserResponseMessageForTextInputDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseInputKeyboardFromMeta(jSONObject), parseBotInfoFromMeta(jSONObject), parseIsResponseSkippedFromMeta(jSONObject), parseReferredMessageIdFromMeta(jSONObject), parseIsMessageEmptyFromMeta(jSONObject));
                userResponseMessageForTextInputDM.serverId = string;
                userResponseMessageForTextInputDM.dateInMillis = parseDateTimeFromMeta(jSONObject);
                userResponseMessageForTextInputDM.timeZoneId = parseTimeZoneIdFromMeta(jSONObject);
                messageDM = userResponseMessageForTextInputDM;
                break;
            case USER_RESP_FOR_OPTION_INPUT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM userResponseMessageForOptionInput = new UserResponseMessageForOptionInput(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseBotInfoFromMeta(jSONObject), parseIsResponseSkippedFromMeta(jSONObject), parseSelectedOptionDataFromMeta(jSONObject), parseReferredMessageIdFromMeta(jSONObject), parseReferredMessageTypeFromMeta(jSONObject));
                userResponseMessageForOptionInput.serverId = string;
                messageDM = userResponseMessageForOptionInput;
                break;
            case USER_SMART_INTENT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM userSmartIntentMessageDM = new UserSmartIntentMessageDM(parseIntentLabelFromMeta(jSONObject), string5, j6, getAuthor(string6, string8, string7, string9, true));
                userSmartIntentMessageDM.body = string2;
                userSmartIntentMessageDM.serverId = string;
                messageDM = userSmartIntentMessageDM;
                break;
            case ADMIN_TEXT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                messageDM = new AdminMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false));
                break;
            case ADMIN_TEXT_WITH_TEXT_INPUT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                messageDM = new AdminMessageWithTextInputDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseBotInfoFromMeta(jSONObject), parseInputPlaceholderFromMeta(jSONObject), parseInputRequiredFromMeta(jSONObject), parseInputLabelFromMeta(jSONObject), parseInputSkipLabelFromMeta(jSONObject), parseInputKeyboardFromMeta(jSONObject), parseIsMessageEmptyFromMeta(jSONObject));
                break;
            case ADMIN_TEXT_WITH_OPTION_INPUT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                List<OptionInput.Option> parseInputOptionsFromMeta = parseInputOptionsFromMeta(jSONObject);
                AdminMessageWithOptionInputDM adminMessageWithOptionInputDM = new AdminMessageWithOptionInputDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseBotInfoFromMeta(jSONObject), parseInputRequiredFromMeta(jSONObject), parseInputLabelFromMeta(jSONObject), parseInputSkipLabelFromMeta(jSONObject), parseInputOptionsFromMeta, parseInputOptionTypeFromMeta(jSONObject, parseInputOptionsFromMeta.size()));
                adminMessageWithOptionInputDM.attachmentCount = parseAttachmentCountFromMeta(jSONObject);
                messageDM = adminMessageWithOptionInputDM;
                break;
            case FAQ_LIST:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                messageDM = new FAQListMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseFAQListFromMeta(jSONObject), parseFAQListSourceFromMeta(jSONObject), parseIsSuggestionsReadEventSent(jSONObject), parseSuggestionReadFAQPublishId(jSONObject));
                break;
            case FAQ_LIST_WITH_OPTION_INPUT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                messageDM = new FAQListMessageWithOptionInputDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseFAQListFromMeta(jSONObject), parseFAQListSourceFromMeta(jSONObject), parseBotInfoFromMeta(jSONObject), parseInputRequiredFromMeta(jSONObject), parseInputLabelFromMeta(jSONObject), parseInputSkipLabelFromMeta(jSONObject), parseInputOptionsFromMeta(jSONObject), parseIsSuggestionsReadEventSent(jSONObject), parseSuggestionReadFAQPublishId(jSONObject));
                break;
            case ACCEPTED_APP_REVIEW:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM acceptedAppReviewMessageDM = new AcceptedAppReviewMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseReferredMessageIdFromMeta(jSONObject), parseAndGetMessageSyncState(string, jSONObject));
                acceptedAppReviewMessageDM.serverId = string;
                messageDM = acceptedAppReviewMessageDM;
                break;
            case REQUESTED_APP_REVIEW:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                messageDM = new RequestAppReviewMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseIsAnsweredFromMeta(jSONObject));
                break;
            case FOLLOWUP_ACCEPTED:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM followupAcceptedMessageDM = new FollowupAcceptedMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseReferredMessageIdFromMeta(jSONObject), parseAndGetMessageSyncState(string, jSONObject));
                followupAcceptedMessageDM.serverId = string;
                messageDM = followupAcceptedMessageDM;
                break;
            case FOLLOWUP_REJECTED:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM followupRejectedMessageDM = new FollowupRejectedMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseReferredMessageIdFromMeta(jSONObject), parseAndGetMessageSyncState(string, jSONObject));
                followupRejectedMessageDM.serverId = string;
                parseAndSetFollowUpRejectedDataFromMeta((FollowupRejectedMessageDM) followupRejectedMessageDM, jSONObject);
                messageDM = followupRejectedMessageDM;
                break;
            case CONFIRMATION_ACCEPTED:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM confirmationAcceptedMessageDM = new ConfirmationAcceptedMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseAndGetMessageSyncState(string, jSONObject));
                confirmationAcceptedMessageDM.serverId = string;
                messageDM = confirmationAcceptedMessageDM;
                break;
            case CONFIRMATION_REJECTED:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                MessageDM confirmationRejectedMessageDM = new ConfirmationRejectedMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseAndGetMessageSyncState(string, jSONObject));
                confirmationRejectedMessageDM.serverId = string;
                messageDM = confirmationRejectedMessageDM;
                break;
            case SCREENSHOT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                ImageAttachmentInfo parseImageAttachmentInfoFromMeta = parseImageAttachmentInfoFromMeta(jSONObject);
                ScreenshotMessageDM screenshotMessageDM = new ScreenshotMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseImageAttachmentInfoFromMeta.contentType, parseImageAttachmentInfoFromMeta.thumbnailUrl, parseImageAttachmentInfoFromMeta.fileName, parseImageAttachmentInfoFromMeta.url, parseImageAttachmentInfoFromMeta.size, parseImageAttachmentInfoFromMeta.isSecure);
                screenshotMessageDM.filePath = parseImageAttachmentInfoFromMeta.filePath;
                screenshotMessageDM.serverId = string;
                screenshotMessageDM.setRefersMessageId(parseReferredMessageIdFromMeta(jSONObject));
                screenshotMessageDM.isZipped = parseImageAttachmentInfoFromMeta.isZipped;
                screenshotMessageDM.isRejected = parseImageAttachmentInfoFromMeta.isRejected;
                messageDM = screenshotMessageDM;
                break;
            case USER_ATTACHMENT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                AttachmentInfo parseAttachmentInfoFromMeta = parseAttachmentInfoFromMeta(jSONObject);
                UserAttachmentMessageDM userAttachmentMessageDM = new UserAttachmentMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseAttachmentInfoFromMeta.size, parseAttachmentInfoFromMeta.contentType, parseAttachmentInfoFromMeta.url, parseAttachmentInfoFromMeta.fileName, parseAttachmentInfoFromMeta.isSecure);
                userAttachmentMessageDM.filePath = parseAttachmentInfoFromMeta.filePath;
                userAttachmentMessageDM.serverId = string;
                userAttachmentMessageDM.isZipped = parseAttachmentInfoFromMeta.isZipped;
                userAttachmentMessageDM.isRejected = parseAttachmentInfoFromMeta.isRejected;
                messageDM = userAttachmentMessageDM;
                break;
            case REQUESTED_SCREENSHOT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                messageDM = new RequestScreenshotMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseIsAnsweredFromMeta(jSONObject));
                break;
            case ADMIN_ATTACHMENT:
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                z = parseBooleanColumnSafe;
                i = i2;
                AttachmentInfo parseAttachmentInfoFromMeta2 = parseAttachmentInfoFromMeta(jSONObject);
                AdminAttachmentMessageDM adminAttachmentMessageDM = new AdminAttachmentMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseAttachmentInfoFromMeta2.size, parseAttachmentInfoFromMeta2.contentType, parseAttachmentInfoFromMeta2.url, parseAttachmentInfoFromMeta2.fileName, parseAttachmentInfoFromMeta2.isSecure);
                adminAttachmentMessageDM.filePath = parseAttachmentInfoFromMeta2.filePath;
                adminAttachmentMessageDM.updateState();
                messageDM = adminAttachmentMessageDM;
                break;
            case ADMIN_IMAGE_ATTACHMENT:
                i = i2;
                ImageAttachmentInfo parseImageAttachmentInfoFromMeta2 = parseImageAttachmentInfoFromMeta(jsonify);
                j = j3;
                z = parseBooleanColumnSafe;
                j2 = j4;
                jSONObject = jsonify;
                AdminImageAttachmentMessageDM adminImageAttachmentMessageDM = new AdminImageAttachmentMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseImageAttachmentInfoFromMeta2.url, parseImageAttachmentInfoFromMeta2.fileName, parseImageAttachmentInfoFromMeta2.thumbnailUrl, parseImageAttachmentInfoFromMeta2.contentType, parseImageAttachmentInfoFromMeta2.isSecure, parseImageAttachmentInfoFromMeta2.size);
                adminImageAttachmentMessageDM.filePath = parseImageAttachmentInfoFromMeta2.filePath;
                adminImageAttachmentMessageDM.thumbnailFilePath = parseImageAttachmentInfoFromMeta2.thumbnailFilePath;
                adminImageAttachmentMessageDM.updateState();
                messageDM = adminImageAttachmentMessageDM;
                break;
            case REQUEST_FOR_REOPEN:
                i = i2;
                RequestForReopenMessageDM requestForReopenMessageDM = new RequestForReopenMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false));
                requestForReopenMessageDM.setAnswered(parseIsAnsweredFromMeta(jsonify));
                z = parseBooleanColumnSafe;
                j = j3;
                j2 = j4;
                messageDM = requestForReopenMessageDM;
                jSONObject = jsonify;
                break;
            case ADMIN_BOT_CONTROL:
                i = i2;
                String parseBotActionTypeFromMeta = parseBotActionTypeFromMeta(jsonify);
                String parseBotInfoFromMeta = parseBotInfoFromMeta(jsonify);
                Boolean parseHasNextBotFromMeta = parseHasNextBotFromMeta(jsonify);
                AdminBotControlMessageDM adminBotControlMessageDM = new AdminBotControlMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), parseBotActionTypeFromMeta, parseBotInfoFromMeta);
                adminBotControlMessageDM.hasNextBot = parseHasNextBotFromMeta.booleanValue();
                z = parseBooleanColumnSafe;
                j = j3;
                j2 = j4;
                messageDM = adminBotControlMessageDM;
                jSONObject = jsonify;
                break;
            case USER_BOT_CONTROL:
                i = i2;
                MessageDM userBotControlMessageDM = new UserBotControlMessageDM(string2, string5, j6, getAuthor(string6, string8, string7, string9, true), parseBotActionTypeFromMeta(jsonify), parseBotEndedReasonFromMeta(jsonify), parseBotInfoFromMeta(jsonify), parseReferredMessageIdFromMeta(jsonify), parseAndGetMessageSyncState(string, jsonify));
                userBotControlMessageDM.serverId = string;
                z = parseBooleanColumnSafe;
                j = j3;
                j2 = j4;
                jSONObject = jsonify;
                messageDM = userBotControlMessageDM;
                break;
            case ADMIN_ACTION_CARD:
                ActionCard readActionCard = readActionCard(string);
                if (readActionCard != null) {
                    i = i2;
                    z = parseBooleanColumnSafe;
                    j = j3;
                    j2 = j4;
                    messageDM = new AdminActionCardMessageDM(string, string2, string5, j6, getAuthor(string6, string8, string7, string9, false), getStringFromJson(jsonify, "original_message_server_id", ""), readActionCard);
                    jSONObject = jsonify;
                    break;
                } else {
                    return null;
                }
            default:
                return null;
        }
        messageDM.conversationLocalId = Long.valueOf(j2);
        messageDM.localId = Long.valueOf(j);
        messageDM.deliveryState = i;
        messageDM.isRedacted = z;
        parseAndSetMessageSeenData(messageDM, jSONObject);
        return messageDM;
    }

    private List<String> parseIntentLabelFromMeta(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("intent_labels");
        return optJSONArray != null ? HSJSONUtils.convertJSONArrayToStringList(optJSONArray) : new ArrayList();
    }

    private ActionCard readActionCard(String str) {
        ActionCard actionCard;
        SQLiteDatabase sQLiteDatabase;
        String[] strArr = {String.valueOf(str)};
        String str2 = ActionCardTable.TABLE_NAME + "._id";
        String str3 = ActionCardTable.TABLE_NAME + ".title";
        String str4 = ActionCardTable.TABLE_NAME + ".image_url";
        String str5 = ActionCardTable.TABLE_NAME + "." + ActionCardTable.Columns.FILE_PATH;
        String str6 = ActionCardTable.TABLE_NAME + "." + ActionCardTable.Columns.IS_IMAGE_SECURE;
        String str7 = ActionCardTable.TABLE_NAME + "." + ActionCardTable.Columns.MESSAGE_ID;
        String str8 = "SELECT " + str2 + " AS ac_id, " + str3 + ", " + str4 + ", " + str5 + ", " + str6 + ", " + (ActionTable.TABLE_NAME + "._id") + " AS a_id, " + (ActionTable.TABLE_NAME + "." + ActionTable.Columns.ACTION_SHA) + ", " + (ActionTable.TABLE_NAME + "." + ActionTable.Columns.TITLE) + ", " + (ActionTable.TABLE_NAME + ".action_type") + ", " + (ActionTable.TABLE_NAME + "." + ActionTable.Columns.DATA) + " FROM " + ActionCardTable.TABLE_NAME + " JOIN " + ActionTable.TABLE_NAME + " ON " + str2 + " = " + (ActionTable.TABLE_NAME + "." + ActionTable.Columns.ACTION_CARD_ID) + " WHERE " + str7 + " = ?  LIMIT 1";
        SQLiteDatabase sQLiteDatabase2 = null;
        r1 = null;
        ActionCard actionCard2 = null;
        sQLiteDatabase2 = null;
        try {
            try {
                sQLiteDatabase = this.dbHelper.getReadableDatabase();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = sQLiteDatabase2;
            }
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor rawQuery = sQLiteDatabase.rawQuery(str8, strArr);
                    if (rawQuery.moveToFirst()) {
                        Action action = new Action(rawQuery.getString(rawQuery.getColumnIndex(ActionTable.Columns.TITLE)), rawQuery.getString(rawQuery.getColumnIndex(ActionTable.Columns.ACTION_SHA)), ActionType.fromValue(rawQuery.getString(rawQuery.getColumnIndex("action_type"))), HSJSONUtils.toStringMap(jsonify(rawQuery.getString(rawQuery.getColumnIndex(ActionTable.Columns.DATA)))));
                        action.actionLocalId = Long.valueOf(rawQuery.getLong(rawQuery.getColumnIndex("a_id")));
                        String string = rawQuery.getString(rawQuery.getColumnIndex("title"));
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("image_url"));
                        boolean z = true;
                        if (rawQuery.getInt(rawQuery.getColumnIndex(ActionCardTable.Columns.IS_IMAGE_SECURE)) != 1) {
                            z = false;
                        }
                        actionCard = new ActionCard(string, string2, z, action);
                        try {
                            actionCard.actionCardLocalId = Long.valueOf(rawQuery.getLong(rawQuery.getColumnIndex("ac_id")));
                            actionCard.filePath = rawQuery.getString(rawQuery.getColumnIndex(ActionCardTable.Columns.FILE_PATH));
                            actionCard2 = actionCard;
                        } catch (Exception e) {
                            e = e;
                            sQLiteDatabase2 = sQLiteDatabase;
                            HSLogger.e(TAG, "Error in read action card", e);
                            if (sQLiteDatabase2 != null) {
                                try {
                                    sQLiteDatabase2.endTransaction();
                                } catch (Exception e2) {
                                    HSLogger.e(TAG, "Error in read action card inside finally block", e2);
                                }
                            }
                            return actionCard;
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    if (sQLiteDatabase == null) {
                        return actionCard2;
                    }
                    try {
                        sQLiteDatabase.endTransaction();
                        return actionCard2;
                    } catch (Exception e3) {
                        HSLogger.e(TAG, "Error in read action card inside finally block", e3);
                        return actionCard2;
                    }
                } catch (Exception e4) {
                    e = e4;
                    actionCard = actionCard2;
                }
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                        throw th3;
                    } catch (Exception e5) {
                        HSLogger.e(TAG, "Error in read action card inside finally block", e5);
                        throw th3;
                    }
                }
                throw th3;
            }
        } catch (Exception e6) {
            e = e6;
            actionCard = null;
        }
    }

    private OptionInput.Type parseInputOptionTypeFromMeta(JSONObject jSONObject, int i) {
        return OptionInput.Type.getType(getStringFromJson(jSONObject, "option_type", ""), i);
    }

    private boolean parseIsMessageEmptyFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "is_message_empty", false);
    }

    private String parseBotActionTypeFromMeta(JSONObject jSONObject) {
        return jSONObject.optString("bot_action_type", "");
    }

    private String parseBotEndedReasonFromMeta(JSONObject jSONObject) {
        return jSONObject.optString("bot_ended_reason", "");
    }

    private String parseSuggestionReadFAQPublishId(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "suggestion_read_faq_publish_id", "");
    }

    private boolean parseIsSuggestionsReadEventSent(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "is_suggestion_read_event_sent", false);
    }

    private List<FAQListMessageDM.FAQ> parseFAQListFromMeta(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("faqs");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new FAQListMessageDM.FAQ(jSONObject2.getString("faq_title"), jSONObject2.getString("faq_publish_id"), jSONObject2.getString("faq_language")));
            }
            return arrayList;
        } catch (JSONException unused) {
            return arrayList;
        }
    }

    private String parseFAQListSourceFromMeta(JSONObject jSONObject) {
        try {
            return jSONObject.getString("faq_source");
        } catch (JSONException unused) {
            return "";
        }
    }

    private List<OptionInput.Option> parseInputOptionsFromMeta(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("input_options");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                arrayList.add(new OptionInput.Option(jSONObject2.getString("option_title"), jSONObject2.getString("option_data")));
            }
            return arrayList;
        } catch (JSONException unused) {
            return arrayList;
        }
    }

    private int parseAttachmentCountFromMeta(JSONObject jSONObject) {
        return getIntFromJson(jSONObject, "attachment_count", 0);
    }

    private int getIntFromJson(JSONObject jSONObject, String str, int i) {
        return jSONObject.optInt(str, i);
    }

    private String getStringFromJson(JSONObject jSONObject, String str, String str2) {
        return jSONObject.optString(str, str2);
    }

    private boolean getBooleanFromJson(JSONObject jSONObject, String str, boolean z) {
        return jSONObject.optBoolean(str, z);
    }

    private MessageType parseReferredMessageTypeFromMeta(JSONObject jSONObject) {
        return MessageType.fromValue(getStringFromJson(jSONObject, "referred_message_type", ""));
    }

    private String parseSelectedOptionDataFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "selected_option_data", "{}");
    }

    private boolean parseIsResponseSkippedFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "is_response_skipped", false);
    }

    private int parseInputKeyboardFromMeta(JSONObject jSONObject) {
        return getIntFromJson(jSONObject, "input_keyboard", 1);
    }

    private String parseInputSkipLabelFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_skip_label", "");
    }

    private String parseInputLabelFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_label", "");
    }

    private boolean parseInputRequiredFromMeta(JSONObject jSONObject) {
        return getBooleanFromJson(jSONObject, "input_required", false);
    }

    private String parseInputPlaceholderFromMeta(JSONObject jSONObject) {
        return getStringFromJson(jSONObject, "input_placeholder", "");
    }

    private String parseBotInfoFromMeta(JSONObject jSONObject) {
        return jSONObject.optString("chatbot_info", "{}");
    }

    private long parseDateTimeFromMeta(JSONObject jSONObject) {
        return jSONObject.optLong("dt", 0L);
    }

    private String parseTimeZoneIdFromMeta(JSONObject jSONObject) {
        return jSONObject.optString("timezone_id");
    }

    private Boolean parseHasNextBotFromMeta(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean("has_next_bot", false));
    }

    private int parseAndGetMessageSyncState(String str, JSONObject jSONObject) {
        if (StringUtils.isEmpty(str)) {
            return jSONObject.optInt("message_sync_status", 1);
        }
        return 2;
    }

    private void parseAndSetMessageSeenData(MessageDM messageDM, JSONObject jSONObject) {
        String optString = jSONObject.optString("read_at", "");
        String optString2 = jSONObject.optString("seen_cursor", null);
        boolean optBoolean = jSONObject.optBoolean("seen_sync_status", false);
        messageDM.seenAtMessageCursor = optString2;
        messageDM.isMessageSeenSynced = optBoolean;
        messageDM.readAt = optString;
    }

    private JSONObject jsonify(String str) {
        JSONObject jSONObject = new JSONObject();
        if (StringUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            HSLogger.e(TAG, "Exception in jsonify", e);
            return jSONObject;
        }
    }

    private String parseReferredMessageIdFromMeta(JSONObject jSONObject) {
        return jSONObject.optString("referredMessageId", null);
    }

    private boolean parseIsAnsweredFromMeta(JSONObject jSONObject) {
        return jSONObject.optBoolean("is_answered", false);
    }

    private AttachmentInfo parseAttachmentInfoFromMeta(JSONObject jSONObject) {
        return new AttachmentInfo(jSONObject);
    }

    private ImageAttachmentInfo parseImageAttachmentInfoFromMeta(JSONObject jSONObject) {
        return new ImageAttachmentInfo(jSONObject);
    }

    private void parseAndSetFollowUpRejectedDataFromMeta(FollowupRejectedMessageDM followupRejectedMessageDM, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("rejected_reason");
        String optString = jSONObject.optString("rejected_conv_id", null);
        followupRejectedMessageDM.reason = optInt;
        followupRejectedMessageDM.openConversationId = optString;
    }

    private String getMessageMeta(MessageDM messageDM) throws JSONException {
        JSONObject jSONObject;
        switch (messageDM.messageType) {
            case USER_RESP_FOR_TEXT_INPUT:
                jSONObject = new JSONObject();
                UserResponseMessageForTextInputDM userResponseMessageForTextInputDM = (UserResponseMessageForTextInputDM) messageDM;
                buildMetaForBotInfo(jSONObject, userResponseMessageForTextInputDM.botInfo);
                buildMetaForInputKeyboard(jSONObject, userResponseMessageForTextInputDM.keyboard);
                buildMetaForIsResponseSkipped(jSONObject, userResponseMessageForTextInputDM.skipped);
                buildMetaForReferredMessageId(jSONObject, userResponseMessageForTextInputDM.getReferredMessageId());
                buildMetaForIsMessageEmpty(jSONObject, userResponseMessageForTextInputDM.isMessageEmpty);
                buildMetaForDateTime(jSONObject, userResponseMessageForTextInputDM);
                break;
            case USER_RESP_FOR_OPTION_INPUT:
                jSONObject = new JSONObject();
                UserResponseMessageForOptionInput userResponseMessageForOptionInput = (UserResponseMessageForOptionInput) messageDM;
                buildMetaForBotInfo(jSONObject, userResponseMessageForOptionInput.botInfo);
                buildMetaForIsResponseSkipped(jSONObject, userResponseMessageForOptionInput.skipped);
                buildMetaForReferredMessageId(jSONObject, userResponseMessageForOptionInput.getReferredMessageId());
                buildMetaForReferredMessageType(jSONObject, userResponseMessageForOptionInput.referredMessageType);
                buildMetaForSelectedOptionData(jSONObject, userResponseMessageForOptionInput.optionData);
                break;
            case USER_SMART_INTENT:
                jSONObject = new JSONObject();
                buildMetaForIntentLabels(jSONObject, (UserSmartIntentMessageDM) messageDM);
                break;
            case ADMIN_TEXT:
                jSONObject = new JSONObject();
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case ADMIN_TEXT_WITH_TEXT_INPUT:
                jSONObject = new JSONObject();
                AdminMessageWithTextInputDM adminMessageWithTextInputDM = (AdminMessageWithTextInputDM) messageDM;
                buildMetaForMessageSeenData(jSONObject, messageDM);
                buildMetaForInput(jSONObject, adminMessageWithTextInputDM.input);
                buildMetaForIsMessageEmpty(jSONObject, adminMessageWithTextInputDM.isMessageEmpty);
                break;
            case ADMIN_TEXT_WITH_OPTION_INPUT:
                jSONObject = new JSONObject();
                buildMetaForMessageSeenData(jSONObject, messageDM);
                AdminMessageWithOptionInputDM adminMessageWithOptionInputDM = (AdminMessageWithOptionInputDM) messageDM;
                buildMetaForInput(jSONObject, adminMessageWithOptionInputDM.input);
                buildMetaForAttachmentCount(jSONObject, adminMessageWithOptionInputDM.attachmentCount);
                break;
            case FAQ_LIST:
                jSONObject = new JSONObject();
                buildMetaForMessageSeenData(jSONObject, messageDM);
                FAQListMessageDM fAQListMessageDM = (FAQListMessageDM) messageDM;
                buildMetaForFAQList(jSONObject, fAQListMessageDM);
                buildMetaForIsSuggestionsReadEvent(jSONObject, fAQListMessageDM);
                buildMetaForFAQListSource(jSONObject, fAQListMessageDM);
                break;
            case FAQ_LIST_WITH_OPTION_INPUT:
                jSONObject = new JSONObject();
                buildMetaForMessageSeenData(jSONObject, messageDM);
                buildMetaForFAQList(jSONObject, (FAQListMessageDM) messageDM);
                FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM = (FAQListMessageWithOptionInputDM) messageDM;
                buildMetaForInput(jSONObject, fAQListMessageWithOptionInputDM.input);
                buildMetaForIsSuggestionsReadEvent(jSONObject, fAQListMessageWithOptionInputDM);
                buildMetaForFAQListSource(jSONObject, fAQListMessageWithOptionInputDM);
                break;
            case ACCEPTED_APP_REVIEW:
                jSONObject = new JSONObject();
                AcceptedAppReviewMessageDM acceptedAppReviewMessageDM = (AcceptedAppReviewMessageDM) messageDM;
                buildMetaForReferredMessageId(jSONObject, acceptedAppReviewMessageDM.referredMessageId);
                buildMetaForAutoRetriableMessage(jSONObject, acceptedAppReviewMessageDM);
                break;
            case REQUESTED_APP_REVIEW:
                jSONObject = new JSONObject();
                buildMetaForIsAnswered(jSONObject, ((RequestAppReviewMessageDM) messageDM).isAnswered);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case FOLLOWUP_ACCEPTED:
                jSONObject = new JSONObject();
                FollowupAcceptedMessageDM followupAcceptedMessageDM = (FollowupAcceptedMessageDM) messageDM;
                buildMetaForReferredMessageId(jSONObject, followupAcceptedMessageDM.referredMessageId);
                buildMetaForAutoRetriableMessage(jSONObject, followupAcceptedMessageDM);
                break;
            case FOLLOWUP_REJECTED:
                jSONObject = new JSONObject();
                FollowupRejectedMessageDM followupRejectedMessageDM = (FollowupRejectedMessageDM) messageDM;
                buildMetaForFollowUpRejected(jSONObject, followupRejectedMessageDM);
                buildMetaForAutoRetriableMessage(jSONObject, followupRejectedMessageDM);
                break;
            case CONFIRMATION_ACCEPTED:
                jSONObject = new JSONObject();
                buildMetaForAutoRetriableMessage(jSONObject, (ConfirmationAcceptedMessageDM) messageDM);
                break;
            case CONFIRMATION_REJECTED:
                jSONObject = new JSONObject();
                buildMetaForAutoRetriableMessage(jSONObject, (ConfirmationRejectedMessageDM) messageDM);
                break;
            case SCREENSHOT:
                jSONObject = new JSONObject();
                buildMetaForScreenshotAttachmentMessage(jSONObject, (ScreenshotMessageDM) messageDM);
                break;
            case USER_ATTACHMENT:
                jSONObject = new JSONObject();
                buildJsonObjectForAttachmentMessage(jSONObject, (UserAttachmentMessageDM) messageDM);
                break;
            case REQUESTED_SCREENSHOT:
                jSONObject = new JSONObject();
                buildMetaForIsAnswered(jSONObject, ((RequestScreenshotMessageDM) messageDM).isAnswered);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case ADMIN_ATTACHMENT:
                jSONObject = new JSONObject();
                buildJsonObjectForAttachmentMessage(jSONObject, (AttachmentMessageDM) messageDM);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case ADMIN_IMAGE_ATTACHMENT:
                jSONObject = new JSONObject();
                buildMetaForImageAttachmentMessage(jSONObject, (ImageAttachmentMessageDM) messageDM);
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case REQUEST_FOR_REOPEN:
                jSONObject = new JSONObject();
                buildMetaForIsAnswered(jSONObject, ((RequestForReopenMessageDM) messageDM).isAnswered());
                buildMetaForMessageSeenData(jSONObject, messageDM);
                break;
            case ADMIN_BOT_CONTROL:
                jSONObject = new JSONObject();
                buildMetaForAdminBotControlMessage(jSONObject, (AdminBotControlMessageDM) messageDM);
                break;
            case USER_BOT_CONTROL:
                jSONObject = new JSONObject();
                UserBotControlMessageDM userBotControlMessageDM = (UserBotControlMessageDM) messageDM;
                buildMetaForUserBotControlMessage(jSONObject, userBotControlMessageDM);
                buildMetaForAutoRetriableMessage(jSONObject, userBotControlMessageDM);
                break;
            case ADMIN_ACTION_CARD:
                jSONObject = new JSONObject();
                buildMetaForActionCardMessage(jSONObject, (AdminActionCardMessageDM) messageDM);
                break;
            default:
                jSONObject = null;
                break;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    private void buildMetaForIntentLabels(JSONObject jSONObject, UserSmartIntentMessageDM userSmartIntentMessageDM) throws JSONException {
        jSONObject.put("intent_labels", HSJSONUtils.listToJsonArray(userSmartIntentMessageDM.intentLabels));
    }

    private void buildMetaForIsSuggestionsReadEvent(JSONObject jSONObject, FAQListMessageDM fAQListMessageDM) throws JSONException {
        jSONObject.put("is_suggestion_read_event_sent", fAQListMessageDM.isSuggestionsReadEventSent);
        jSONObject.put("suggestion_read_faq_publish_id", fAQListMessageDM.suggestionsReadFAQPublishId);
    }

    private void buildMetaForIsMessageEmpty(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("is_message_empty", z);
    }

    private void buildMetaForAdminBotControlMessage(JSONObject jSONObject, AdminBotControlMessageDM adminBotControlMessageDM) throws JSONException {
        jSONObject.put("bot_action_type", adminBotControlMessageDM.actionType);
        jSONObject.put("has_next_bot", adminBotControlMessageDM.hasNextBot);
    }

    private void buildMetaForUserBotControlMessage(JSONObject jSONObject, UserBotControlMessageDM userBotControlMessageDM) throws JSONException {
        jSONObject.put("bot_action_type", userBotControlMessageDM.actionType);
        jSONObject.put("chatbot_info", userBotControlMessageDM.botInfo);
        jSONObject.put("bot_ended_reason", userBotControlMessageDM.reason);
        jSONObject.put("referredMessageId", userBotControlMessageDM.refersMessageId);
    }

    private void buildMetaForFAQList(JSONObject jSONObject, FAQListMessageDM fAQListMessageDM) throws JSONException {
        if (fAQListMessageDM.faqs != null) {
            JSONArray jSONArray = new JSONArray();
            for (FAQListMessageDM.FAQ faq : fAQListMessageDM.faqs) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("faq_title", faq.title);
                jSONObject2.put("faq_publish_id", faq.publishId);
                jSONObject2.put("faq_language", faq.language);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("faqs", jSONArray);
        }
    }

    private void buildMetaForFAQListSource(JSONObject jSONObject, FAQListMessageDM fAQListMessageDM) throws JSONException {
        if (fAQListMessageDM.source != null) {
            jSONObject.put("faq_source", fAQListMessageDM.source);
        }
    }

    private void buildMetaForReferredMessageType(JSONObject jSONObject, MessageType messageType) throws JSONException {
        jSONObject.put("referred_message_type", messageType.getValue());
    }

    private void buildMetaForSelectedOptionData(JSONObject jSONObject, String str) throws JSONException {
        jSONObject.put("selected_option_data", str);
    }

    private void buildMetaForIsResponseSkipped(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("is_response_skipped", z);
    }

    private void buildMetaForInputKeyboard(JSONObject jSONObject, int i) throws JSONException {
        jSONObject.put("input_keyboard", i);
    }

    private void buildMetaForDateTime(JSONObject jSONObject, UserResponseMessageForTextInputDM userResponseMessageForTextInputDM) throws JSONException {
        if (userResponseMessageForTextInputDM.keyboard == 4) {
            jSONObject.put("dt", userResponseMessageForTextInputDM.dateInMillis);
            jSONObject.put("timezone_id", userResponseMessageForTextInputDM.timeZoneId);
        }
    }

    private void buildMetaForBotInfo(JSONObject jSONObject, String str) throws JSONException {
        jSONObject.put("chatbot_info", str);
    }

    private void buildMetaForInput(JSONObject jSONObject, TextInput textInput) throws JSONException {
        buildMetaForBotInfo(jSONObject, textInput.botInfo);
        jSONObject.put("input_required", textInput.required);
        jSONObject.put("input_skip_label", textInput.skipLabel);
        jSONObject.put("input_label", textInput.inputLabel);
        jSONObject.put("input_placeholder", textInput.placeholder);
        buildMetaForInputKeyboard(jSONObject, textInput.keyboard);
    }

    private void buildMetaForInput(JSONObject jSONObject, OptionInput optionInput) throws JSONException {
        buildMetaForBotInfo(jSONObject, optionInput.botInfo);
        jSONObject.put("input_required", optionInput.required);
        jSONObject.put("input_label", optionInput.inputLabel);
        jSONObject.put("input_skip_label", optionInput.skipLabel);
        if (optionInput.options != null) {
            JSONArray jSONArray = new JSONArray();
            for (OptionInput.Option option : optionInput.options) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("option_title", option.title);
                jSONObject2.put("option_data", option.jsonData);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("input_options", jSONArray);
        }
        jSONObject.put("option_type", optionInput.type.toString());
    }

    private JSONObject buildMetaForAttachmentCount(JSONObject jSONObject, int i) throws JSONException {
        jSONObject.put("attachment_count", i);
        return jSONObject;
    }

    private void buildMetaForMessageSeenData(JSONObject jSONObject, MessageDM messageDM) throws JSONException {
        jSONObject.put("seen_cursor", messageDM.seenAtMessageCursor);
        jSONObject.put("seen_sync_status", messageDM.isMessageSeenSynced);
        jSONObject.put("read_at", messageDM.readAt);
    }

    private void buildMetaForReferredMessageId(JSONObject jSONObject, String str) throws JSONException {
        jSONObject.put("referredMessageId", str);
    }

    private void buildMetaForFollowUpRejected(JSONObject jSONObject, FollowupRejectedMessageDM followupRejectedMessageDM) throws JSONException {
        jSONObject.put("referredMessageId", followupRejectedMessageDM.referredMessageId);
        jSONObject.put("rejected_reason", followupRejectedMessageDM.reason);
        jSONObject.put("rejected_conv_id", followupRejectedMessageDM.openConversationId);
    }

    private void buildMetaForIsAnswered(JSONObject jSONObject, boolean z) throws JSONException {
        jSONObject.put("is_answered", z);
    }

    private void buildJsonObjectForAttachmentMessage(JSONObject jSONObject, AttachmentMessageDM attachmentMessageDM) throws JSONException {
        jSONObject.put(FirebaseAnalytics.Param.CONTENT_TYPE, attachmentMessageDM.contentType);
        jSONObject.put("file_name", attachmentMessageDM.fileName);
        jSONObject.put(TbsReaderView.KEY_FILE_PATH, attachmentMessageDM.filePath);
        jSONObject.put("url", attachmentMessageDM.attachmentUrl);
        jSONObject.put("size", attachmentMessageDM.size);
        jSONObject.put("is_secure", attachmentMessageDM.isSecureAttachment);
        jSONObject.put("is_user_attachment_zipped", attachmentMessageDM.isZipped);
        jSONObject.put("is_user_attachment_rejected", attachmentMessageDM.isRejected);
    }

    private void buildMetaForScreenshotAttachmentMessage(JSONObject jSONObject, ScreenshotMessageDM screenshotMessageDM) throws JSONException {
        buildJsonObjectForAttachmentMessage(jSONObject, screenshotMessageDM);
        jSONObject.put("thumbnail_url", screenshotMessageDM.thumbnailUrl);
        jSONObject.put("referredMessageId", screenshotMessageDM.refersMessageId);
        jSONObject.put("is_secure", screenshotMessageDM.isSecureAttachment);
        jSONObject.put("is_user_attachment_zipped", screenshotMessageDM.isZipped);
        jSONObject.put("is_user_attachment_rejected", screenshotMessageDM.isRejected);
    }

    private void buildMetaForImageAttachmentMessage(JSONObject jSONObject, ImageAttachmentMessageDM imageAttachmentMessageDM) throws JSONException {
        buildJsonObjectForAttachmentMessage(jSONObject, imageAttachmentMessageDM);
        jSONObject.put("thumbnail_url", imageAttachmentMessageDM.thumbnailUrl);
        jSONObject.put("thumbnailFilePath", imageAttachmentMessageDM.thumbnailFilePath);
        jSONObject.put("is_secure", imageAttachmentMessageDM.isSecureAttachment);
    }

    private void buildMetaForAutoRetriableMessage(JSONObject jSONObject, AutoRetriableMessageDM autoRetriableMessageDM) throws JSONException {
        jSONObject.put("message_sync_status", autoRetriableMessageDM.getSyncStatus());
    }

    private void buildMetaForActionCardMessage(JSONObject jSONObject, AdminActionCardMessageDM adminActionCardMessageDM) throws JSONException {
        jSONObject.put("original_message_server_id", adminActionCardMessageDM.originalMessageServerId);
    }

    public synchronized DAOResult<MessageDM> readMessageWithServerId(String str) {
        DAOResult<List<MessageDM>> readMessages = readMessages("server_id = ?", new String[]{String.valueOf(str)});
        MessageDM messageDM = null;
        if (!readMessages.isSuccess()) {
            return new DAOResult<>(false, null);
        }
        List<MessageDM> data = readMessages.getData();
        if (!ListUtils.isEmpty(data)) {
            messageDM = data.get(0);
        }
        return new DAOResult<>(true, messageDM);
    }

    public synchronized DAOResult<MessageDM> readMessageWithLocalId(Long l) {
        DAOResult<List<MessageDM>> readMessages = readMessages("_id = ?", new String[]{String.valueOf(l)});
        MessageDM messageDM = null;
        if (!readMessages.isSuccess()) {
            return new DAOResult<>(false, null);
        }
        List<MessageDM> data = readMessages.getData();
        if (!ListUtils.isEmpty(data)) {
            messageDM = data.get(0);
        }
        return new DAOResult<>(true, messageDM);
    }

    public synchronized void dropAndCreateDatabase() {
        this.dbHelper.dropAndCreateAllTables(this.dbHelper.getWritableDatabase());
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.helpshift.support.Faq getAdminFAQSuggestion(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = com.helpshift.util.StringUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L56
            r1 = 0
            if (r0 != 0) goto L54
            boolean r0 = com.helpshift.util.StringUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto Lf
            goto L54
        Lf:
            com.helpshift.db.conversation.ConversationDBHelper r0 = r10.dbHelper     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.database.sqlite.SQLiteDatabase r2 = r0.getReadableDatabase()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r3 = "faq_suggestions"
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
            com.helpshift.support.Faq r1 = r10.cursorToFaq(r11)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L4c
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
            java.lang.String r0 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in getAdminFAQSuggestion"
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
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getAdminFAQSuggestion(java.lang.String, java.lang.String):com.helpshift.support.Faq");
    }

    public synchronized void insertOrUpdateAdminFAQSuggestion(Faq faq) {
        ContentValues faqToContentValues = faqToContentValues(faq);
        String[] strArr = {faq.publish_id, faq.language};
        try {
            SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
            if (!exists(writableDatabase, FaqsTable.TABLE_NAME, "publish_id = ? AND language = ?", strArr)) {
                writableDatabase.insert(FaqsTable.TABLE_NAME, null, faqToContentValues);
            } else {
                writableDatabase.update(FaqsTable.TABLE_NAME, faqToContentValues, "publish_id = ? AND language = ?", strArr);
            }
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in insertOrUpdateAdminFAQSuggestion", e);
        }
    }

    private Faq cursorToFaq(Cursor cursor) {
        return new Faq(cursor.getLong(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("question_id")), cursor.getString(cursor.getColumnIndex("publish_id")), cursor.getString(cursor.getColumnIndex("language")), cursor.getString(cursor.getColumnIndex("section_id")), cursor.getString(cursor.getColumnIndex("title")), cursor.getString(cursor.getColumnIndex("body")), cursor.getInt(cursor.getColumnIndex("helpful")), Boolean.valueOf(cursor.getInt(cursor.getColumnIndex("rtl")) == 1), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("tags"))), HSJSONUtils.jsonArrayToStringArrayList(cursor.getString(cursor.getColumnIndex("c_tags"))));
    }

    public synchronized void removeAdminFAQSuggestion(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                this.dbHelper.getWritableDatabase().delete(FaqsTable.TABLE_NAME, "publish_id = ? AND language = ?", new String[]{str, str2});
            } catch (Exception e) {
                HSLogger.e(TAG, "Error in removeAdminFAQSuggestion", e);
            }
        }
    }

    public synchronized void deleteConversationInboxData(long j) {
        try {
            this.dbHelper.getWritableDatabase().execSQL("delete from conversation_inbox where user_local_id = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            HSLogger.e(TAG, "Error in delete conversationInboxData with UserLocalId", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c4, code lost:
    
        if (r2 == null) goto L15;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void deleteConversations(long r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.lang.String r0 = "issues"
            java.lang.String r1 = "messages"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcf
            r2.<init>()     // Catch: java.lang.Throwable -> Lcf
            r2.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r3 = "."
            r2.append(r3)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r3 = "_id"
            r2.append(r3)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lcf
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcf
            r3.<init>()     // Catch: java.lang.Throwable -> Lcf
            r3.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = "."
            r3.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = "user_local_id"
            r3.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> Lcf
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcf
            r3.<init>()     // Catch: java.lang.Throwable -> Lcf
            r3.append(r1)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r1 = "."
            r3.append(r1)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r1 = "conversation_id"
            r3.append(r1)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lcf
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcf
            r3.<init>()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r4 = "select "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lcf
            r3.append(r2)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r2 = " from  "
            r3.append(r2)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r2 = "issues"
            r3.append(r2)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r2 = "  where "
            r3.append(r2)     // Catch: java.lang.Throwable -> Lcf
            r3.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = " = ?"
            r3.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> Lcf
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcf
            r2.<init>()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r3 = "delete from messages where "
            r2.append(r3)     // Catch: java.lang.Throwable -> Lcf
            r2.append(r1)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r1 = " IN  ( "
            r2.append(r1)     // Catch: java.lang.Throwable -> Lcf
            r2.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = " )"
            r2.append(r0)     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> Lcf
            java.lang.String r1 = "delete from issues where user_local_id = ?"
            r2 = 0
            com.helpshift.db.conversation.ConversationDBHelper r3 = r7.dbHelper     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            android.database.sqlite.SQLiteDatabase r2 = r3.getWritableDatabase()     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            r2.beginTransaction()     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            r2.execSQL(r0, r4)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            java.lang.String[] r0 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            r0[r6] = r8     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            r2.execSQL(r1, r0)     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> Lba java.lang.Exception -> Lbc
            if (r2 == 0) goto Lc7
        Lb6:
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lcf
            goto Lc7
        Lba:
            r8 = move-exception
            goto Lc9
        Lbc:
            r8 = move-exception
            java.lang.String r9 = "Helpshift_ConverDB"
            java.lang.String r0 = "Error in delete conversations with UserLocalId"
            com.helpshift.util.HSLogger.e(r9, r0, r8)     // Catch: java.lang.Throwable -> Lba
            if (r2 == 0) goto Lc7
            goto Lb6
        Lc7:
            monitor-exit(r7)
            return
        Lc9:
            if (r2 == 0) goto Lce
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lcf
        Lce:
            throw r8     // Catch: java.lang.Throwable -> Lcf
        Lcf:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.deleteConversations(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0082, code lost:
    
        if (r11 != null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0084, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0098, code lost:
    
        if (r11 == null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0 A[Catch: all -> 0x00a4, TRY_ENTER, TryCatch #1 {, blocks: (B:3:0x0001, B:13:0x0084, B:23:0x00a0, B:24:0x00a3), top: B:2:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.lang.String getOldestMessageCursor(long r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "message_create_at"
            java.lang.String r1 = "issues.user_local_id"
            java.lang.String r2 = "issues._id"
            java.lang.String r3 = "messages.conversation_id"
            java.lang.String r4 = "messages.created_at"
            java.lang.String r5 = "messages.epoch_time_created_at"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
            r6.<init>()     // Catch: java.lang.Throwable -> La4
            java.lang.String r7 = "SELECT "
            r6.append(r7)     // Catch: java.lang.Throwable -> La4
            r6.append(r4)     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = " AS "
            r6.append(r4)     // Catch: java.lang.Throwable -> La4
            r6.append(r0)     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = " FROM "
            r6.append(r4)     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = "issues"
            r6.append(r4)     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = " INNER JOIN "
            r6.append(r4)     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = "messages"
            r6.append(r4)     // Catch: java.lang.Throwable -> La4
            java.lang.String r4 = " ON "
            r6.append(r4)     // Catch: java.lang.Throwable -> La4
            r6.append(r2)     // Catch: java.lang.Throwable -> La4
            java.lang.String r2 = " = "
            r6.append(r2)     // Catch: java.lang.Throwable -> La4
            r6.append(r3)     // Catch: java.lang.Throwable -> La4
            java.lang.String r2 = " WHERE "
            r6.append(r2)     // Catch: java.lang.Throwable -> La4
            r6.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = " = ? ORDER BY "
            r6.append(r1)     // Catch: java.lang.Throwable -> La4
            r6.append(r5)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = "  ASC LIMIT 1"
            r6.append(r1)     // Catch: java.lang.Throwable -> La4
            java.lang.String r1 = r6.toString()     // Catch: java.lang.Throwable -> La4
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> La4
            r3 = 0
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> La4
            r2[r3] = r10     // Catch: java.lang.Throwable -> La4
            r10 = 0
            com.helpshift.db.conversation.ConversationDBHelper r11 = r9.dbHelper     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8f
            android.database.sqlite.SQLiteDatabase r11 = r11.getReadableDatabase()     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8f
            android.database.Cursor r11 = r11.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L8a java.lang.Exception -> L8f
            boolean r1 = r11.moveToFirst()     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L9d
            if (r1 == 0) goto L82
            int r0 = r11.getColumnIndex(r0)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L9d
            java.lang.String r10 = r11.getString(r0)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L9d
        L82:
            if (r11 == 0) goto L9b
        L84:
            r11.close()     // Catch: java.lang.Throwable -> La4
            goto L9b
        L88:
            r0 = move-exception
            goto L91
        L8a:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L9e
        L8f:
            r0 = move-exception
            r11 = r10
        L91:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in read messages"
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L9d
            if (r11 == 0) goto L9b
            goto L84
        L9b:
            monitor-exit(r9)
            return r10
        L9d:
            r10 = move-exception
        L9e:
            if (r11 == 0) goto La3
            r11.close()     // Catch: java.lang.Throwable -> La4
        La3:
            throw r10     // Catch: java.lang.Throwable -> La4
        La4:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getOldestMessageCursor(long):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        if (r12 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
    
        if (r12 == null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: all -> 0x005d, TRY_ENTER, TryCatch #3 {, blocks: (B:3:0x0001, B:14:0x003d, B:25:0x0059, B:26:0x005c), top: B:2:0x0001 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.lang.Long getOldestConversationEpochCreatedAtTime(long r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r3 = "user_local_id = ?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L5d
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch: java.lang.Throwable -> L5d
            r12 = 0
            r4[r12] = r11     // Catch: java.lang.Throwable -> L5d
            r11 = 0
            com.helpshift.db.conversation.ConversationDBHelper r1 = r10.dbHelper     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r2 = "issues"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            java.lang.String r0 = "epoch_time_created_at"
            r5[r12] = r0     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            r12 = 0
            r6 = 0
            java.lang.String r7 = "epoch_time_created_at ASC"
            java.lang.String r8 = "1"
            r0 = r1
            r1 = r2
            r2 = r5
            r5 = r12
            android.database.Cursor r12 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L43 java.lang.Exception -> L45
            boolean r0 = r12.moveToFirst()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            if (r0 == 0) goto L3b
            java.lang.String r0 = "epoch_time_created_at"
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            java.lang.Object r0 = com.helpshift.util.DatabaseUtils.parseColumnSafe(r12, r0, r1)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L53
            r11 = r0
        L3b:
            if (r12 == 0) goto L51
        L3d:
            r12.close()     // Catch: java.lang.Throwable -> L5d
            goto L51
        L41:
            r0 = move-exception
            goto L47
        L43:
            r12 = move-exception
            goto L57
        L45:
            r0 = move-exception
            r12 = r11
        L47:
            java.lang.String r1 = "Helpshift_ConverDB"
            java.lang.String r2 = "Error in getting latest conversation created_at time"
            com.helpshift.util.HSLogger.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L53
            if (r12 == 0) goto L51
            goto L3d
        L51:
            monitor-exit(r10)
            return r11
        L53:
            r11 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
        L57:
            if (r11 == 0) goto L5c
            r11.close()     // Catch: java.lang.Throwable -> L5d
        L5c:
            throw r12     // Catch: java.lang.Throwable -> L5d
        L5d:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.conversation.ConversationDB.getOldestConversationEpochCreatedAtTime(long):java.lang.Long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ImageAttachmentInfo extends AttachmentInfo {
        final String thumbnailFilePath;
        final String thumbnailUrl;

        ImageAttachmentInfo(JSONObject jSONObject) {
            super(jSONObject);
            this.thumbnailUrl = jSONObject.optString("thumbnail_url", null);
            this.thumbnailFilePath = jSONObject.optString("thumbnailFilePath", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class AttachmentInfo {
        final String contentType;
        final String fileName;
        final String filePath;
        final boolean isRejected;
        final boolean isSecure;
        final boolean isZipped;
        final int size;
        final String url;

        AttachmentInfo(JSONObject jSONObject) {
            this.fileName = jSONObject.optString("file_name", null);
            this.contentType = jSONObject.optString(FirebaseAnalytics.Param.CONTENT_TYPE, null);
            this.url = jSONObject.optString("url", null);
            this.size = jSONObject.optInt("size", 0);
            this.filePath = jSONObject.optString(TbsReaderView.KEY_FILE_PATH, null);
            this.isSecure = jSONObject.optBoolean("is_secure", false);
            this.isZipped = jSONObject.optBoolean("is_user_attachment_zipped", false);
            this.isRejected = jSONObject.optBoolean("is_user_attachment_rejected", false);
        }
    }
}
