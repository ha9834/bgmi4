package com.helpshift.account.dao.legacy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.helpshift.account.dao.ProfileDTO;
import com.helpshift.db.legacy_profile.LegacyProfileDBHelper;
import com.helpshift.db.legacy_profile.LegacyProfileDatabaseContract;
import com.helpshift.db.legacy_profile.tables.ProfileTable;
import com.helpshift.migration.legacyUser.LegacyProfileDAO;
import com.helpshift.util.HSLogger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AndroidLegacyProfileDAO implements LegacyProfileDAO {
    private static final String TAG = "Helpshift_ALProfileDAO";
    private static AndroidLegacyProfileDAO instance;
    private LegacyProfileDBHelper dbHelper;

    private AndroidLegacyProfileDAO(Context context) {
        this.dbHelper = new LegacyProfileDBHelper(context, new LegacyProfileDatabaseContract());
    }

    public static synchronized AndroidLegacyProfileDAO getInstance(Context context) {
        AndroidLegacyProfileDAO androidLegacyProfileDAO;
        synchronized (AndroidLegacyProfileDAO.class) {
            if (instance == null) {
                instance = new AndroidLegacyProfileDAO(context);
            }
            androidLegacyProfileDAO = instance;
        }
        return androidLegacyProfileDAO;
    }

    private static int getColumnIndexForIdentifier(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(ProfileTable.Columns.COLUMN_IDENTIFIER);
        return columnIndex == -1 ? cursor.getColumnIndex(ProfileTable.Columns.COLUMN_IDENTIFIER.toLowerCase()) : columnIndex;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.migration.legacyUser.LegacyProfileDAO
    public List<ProfileDTO> fetchProfiles() {
        ArrayList arrayList;
        Cursor query;
        Cursor cursor = null;
        ArrayList arrayList2 = null;
        cursor = null;
        try {
            try {
                query = this.dbHelper.getReadableDatabase().query(ProfileTable.TABLE_NAME, null, null, null, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    if (query.moveToFirst()) {
                        arrayList = new ArrayList();
                        do {
                            try {
                                arrayList.add(cursorToProfile(query));
                            } catch (Exception e) {
                                e = e;
                                cursor = query;
                                HSLogger.e(TAG, "Error in fetchProfiles", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return arrayList;
                            }
                        } while (query.moveToNext());
                        arrayList2 = arrayList;
                    }
                    if (query == null) {
                        return arrayList2;
                    }
                    query.close();
                    return arrayList2;
                } catch (Exception e2) {
                    arrayList = null;
                    cursor = query;
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
    }

    @Override // com.helpshift.migration.legacyUser.LegacyProfileDAO
    public void deleteProfiles() {
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.execSQL("DROP TABLE IF EXISTS profiles");
        }
    }

    private ProfileDTO cursorToProfile(Cursor cursor) {
        return new ProfileDTO(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), cursor.getString(getColumnIndexForIdentifier(cursor)), cursor.getString(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_PROFILE_ID)), cursor.getString(cursor.getColumnIndex("name")), cursor.getString(cursor.getColumnIndex("email")), cursor.getString(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_SALT)), cursor.getString(cursor.getColumnIndex("uid")), cursor.getString(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_DID)), cursor.getInt(cursor.getColumnIndex(ProfileTable.Columns.COLUMN_PUSH_TOKEN_SYNC_STATUS)) == 1);
    }
}
