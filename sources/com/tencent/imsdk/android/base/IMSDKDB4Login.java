package com.tencent.imsdk.android.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.auth.IMSDKAuthResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.PreferencesUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKDB4Login {
    private static final int AUTH_ACCOUNT_TYPE = 1;
    private static String DB_NAME = "iMSDK.db";
    private static final int DB_VERSION = 1;
    private static final int LOGIN_ACCOUNT_TYPE = 2;
    private static final int UNKNOWN_ACCOUNT_TYPE = -1;
    private static boolean mEncryptInfoEnabled;
    private static String LOGIN_DB_TABLE = "login_info";
    private static final String TABLE_CREATION = "create table if not exists " + LOGIN_DB_TABLE + " (channel text primary key, metadata text not null)";
    private static IMSDKAuthResult mAuthResult = null;
    private static PreferencesUtils mPreferencesUtils = new PreferencesUtils();
    private static volatile boolean mWriteOperating = true;
    private static volatile boolean mAccountTypeChanged = true;
    private static volatile IMSDKDBLoginData mLoginData = null;
    private static boolean hasSetAccountType = false;
    public static int mAccountType = -1;

    public static void setAccountType(int i) {
        new InnerStat.Builder(T.mGlobalActivityUpToDate, "2.10.1").setMethod("setAccountType").setStage("start with params type = " + i).create().reportEvent();
        if (i == 1 || i == 2) {
            if (i == mAccountType) {
                mAccountTypeChanged = false;
            } else {
                mAccountTypeChanged = true;
            }
            mAccountType = i;
            hasSetAccountType = true;
            return;
        }
        IMLogger.e("please set right account type with 1 or 2 , 1 means auth and 2 means login", new Object[0]);
    }

    public static int getAccountType() {
        return mAccountType;
    }

    private static SQLiteDatabase openOrCreateDatabase(Context context) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = context.openOrCreateDatabase(DB_NAME, 0, null);
            sQLiteDatabase.execSQL(TABLE_CREATION);
            mEncryptInfoEnabled = IMSDKConfig.getOrMetaData(IR.meta.IMSDK_ENCRYPT_LOGIN_INFO.toUpperCase(), IR.meta.IMSDK_ENCRYPT_LOGIN_INFO, false);
            if (mEncryptInfoEnabled && sQLiteDatabase.getVersion() != 1) {
                sQLiteDatabase.execSQL("alter table " + LOGIN_DB_TABLE + " add column encrypt_key text");
                sQLiteDatabase.setVersion(1);
            }
        } catch (Exception e) {
            IMLogger.e("get database failed : " + e.getMessage(), new Object[0]);
        }
        return sQLiteDatabase;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b9 A[Catch: all -> 0x00d1, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0004, B:22:0x0081, B:27:0x00b9, B:37:0x00ae, B:44:0x00cd, B:45:0x00d0), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean saveLoginData(android.content.Context r9, com.tencent.imsdk.android.api.IMSDKResult r10, java.lang.String r11) {
        /*
            java.lang.Class<com.tencent.imsdk.android.base.IMSDKDB4Login> r0 = com.tencent.imsdk.android.base.IMSDKDB4Login.class
            monitor-enter(r0)
            r1 = 0
            com.tencent.imsdk.android.base.IMSDKDB4Login.mAuthResult = r1     // Catch: java.lang.Throwable -> Ld1
            r2 = 0
            r3 = -1
            android.database.sqlite.SQLiteDatabase r5 = openOrCreateDatabase(r9)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L90
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            r6.<init>()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r7 = "channel"
            r6.put(r7, r11)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            boolean r7 = com.tencent.imsdk.android.base.IMSDKDB4Login.mEncryptInfoEnabled     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            if (r7 == 0) goto L32
            java.lang.String r7 = com.tencent.imsdk.android.tools.DigestUtils.getAESSecretKey()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r10 = r10.toJSONString()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r10 = com.tencent.imsdk.android.tools.DigestUtils.encryptAES(r10, r7)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r8 = "metadata"
            r6.put(r8, r10)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r10 = "encrypt_key"
            r6.put(r10, r7)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            goto L3b
        L32:
            java.lang.String r7 = "metadata"
            java.lang.String r10 = r10.toJSONString()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            r6.put(r7, r10)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
        L3b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            r10.<init>()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r7 = "save login data of channel id '"
            r10.append(r7)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            r10.append(r11)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r7 = "'"
            r10.append(r7)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            com.tencent.imsdk.android.tools.log.IMLogger.d(r10)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.String r10 = com.tencent.imsdk.android.base.IMSDKDB4Login.LOGIN_DB_TABLE     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            long r6 = r5.replace(r10, r1, r6)     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L89
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            r10.<init>()     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            java.lang.String r1 = "replace channel id '"
            r10.append(r1)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            r10.append(r11)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            java.lang.String r1 = "', result : "
            r10.append(r1)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 == 0) goto L73
            java.lang.String r1 = "success"
            goto L75
        L73:
            java.lang.String r1 = "fail"
        L75:
            r10.append(r1)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            com.tencent.imsdk.android.tools.log.IMLogger.d(r10)     // Catch: java.lang.Exception -> L85 java.lang.Throwable -> L87
            if (r5 == 0) goto Lb1
            r5.close()     // Catch: java.lang.Throwable -> Ld1
            goto Lb1
        L85:
            r10 = move-exception
            goto L8b
        L87:
            r9 = move-exception
            goto Lcb
        L89:
            r10 = move-exception
            r6 = r3
        L8b:
            r1 = r5
            goto L92
        L8d:
            r9 = move-exception
            r5 = r1
            goto Lcb
        L90:
            r10 = move-exception
            r6 = r3
        L92:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8d
            r5.<init>()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r8 = "record login data error : "
            r5.append(r8)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L8d
            r5.append(r10)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r10 = r5.toString()     // Catch: java.lang.Throwable -> L8d
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L8d
            com.tencent.imsdk.android.tools.log.IMLogger.w(r10, r5)     // Catch: java.lang.Throwable -> L8d
            if (r1 == 0) goto Lb1
            r1.close()     // Catch: java.lang.Throwable -> Ld1
        Lb1:
            r10 = 1
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 == 0) goto Lb7
            r2 = 1
        Lb7:
            if (r2 == 0) goto Lc9
            com.tencent.imsdk.android.base.IMSDKDB4Login.mWriteOperating = r10     // Catch: java.lang.Throwable -> Ld1
            com.tencent.imsdk.android.tools.PreferencesUtils r10 = com.tencent.imsdk.android.base.IMSDKDB4Login.mPreferencesUtils     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r1 = "imsdk_channel"
            r10.setPreferenceFileName(r1)     // Catch: java.lang.Throwable -> Ld1
            com.tencent.imsdk.android.tools.PreferencesUtils r10 = com.tencent.imsdk.android.base.IMSDKDB4Login.mPreferencesUtils     // Catch: java.lang.Throwable -> Ld1
            java.lang.String r1 = "channel_key"
            r10.putString(r9, r1, r11)     // Catch: java.lang.Throwable -> Ld1
        Lc9:
            monitor-exit(r0)
            return r2
        Lcb:
            if (r5 == 0) goto Ld0
            r5.close()     // Catch: java.lang.Throwable -> Ld1
        Ld0:
            throw r9     // Catch: java.lang.Throwable -> Ld1
        Ld1:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.IMSDKDB4Login.saveLoginData(android.content.Context, com.tencent.imsdk.android.api.IMSDKResult, java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009a A[Catch: all -> 0x00e4, TRY_ENTER, TryCatch #3 {all -> 0x00e4, blocks: (B:14:0x009a, B:16:0x009f, B:33:0x00e0, B:35:0x00e8, B:36:0x00eb, B:25:0x00d3, B:27:0x00d8), top: B:4:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009f A[Catch: all -> 0x00e4, TRY_LEAVE, TryCatch #3 {all -> 0x00e4, blocks: (B:14:0x009a, B:16:0x009f, B:33:0x00e0, B:35:0x00e8, B:36:0x00eb, B:25:0x00d3, B:27:0x00d8), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized java.lang.String getLoginRawData(android.content.Context r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.IMSDKDB4Login.getLoginRawData(android.content.Context, java.lang.String):java.lang.String");
    }

    public static synchronized IMSDKAuthResult getLoginData(Context context, String str) {
        synchronized (IMSDKDB4Login.class) {
            if (mAuthResult != null) {
                return mAuthResult;
            }
            String loginRawData = getLoginRawData(context, str);
            if (loginRawData != null) {
                try {
                    mAuthResult = new IMSDKAuthResult(loginRawData);
                } catch (Exception e) {
                    IMLogger.w(str + " get saved login data failed : " + e.getMessage(), new Object[0]);
                }
            }
            return mAuthResult;
        }
    }

    public static synchronized IMSDKLoginResult getLoginResult(Context context, String str) {
        IMSDKLoginResult iMSDKLoginResult;
        synchronized (IMSDKDB4Login.class) {
            iMSDKLoginResult = null;
            String loginRawData = getLoginRawData(context, str);
            if (loginRawData != null) {
                try {
                    iMSDKLoginResult = new IMSDKLoginResult(loginRawData);
                } catch (Exception e) {
                    IMLogger.w(str + " get saved login data failed : " + e.getMessage(), new Object[0]);
                }
            } else {
                iMSDKLoginResult = new IMSDKLoginResult(1001, 1001);
            }
        }
        return iMSDKLoginResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0067 A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #4 {, blocks: (B:5:0x0004, B:12:0x002a, B:17:0x0067, B:30:0x007b, B:31:0x007e, B:25:0x005d), top: B:4:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007b A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #4 {, blocks: (B:5:0x0004, B:12:0x002a, B:17:0x0067, B:30:0x007b, B:31:0x007e, B:25:0x005d), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized boolean cleanSavedLoginData(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.Class<com.tencent.imsdk.android.base.IMSDKDB4Login> r0 = com.tencent.imsdk.android.base.IMSDKDB4Login.class
            monitor-enter(r0)
            r1 = 0
            com.tencent.imsdk.android.base.IMSDKDB4Login.mAuthResult = r1     // Catch: java.lang.Throwable -> L7f
            r2 = -1
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = openOrCreateDatabase(r9)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L35
            java.lang.String r5 = com.tencent.imsdk.android.base.IMSDKDB4Login.LOGIN_DB_TABLE     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r6.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.String r7 = "channel='"
            r6.append(r7)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r6.append(r10)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.String r7 = "'"
            r6.append(r7)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            int r10 = r4.delete(r5, r6, r1)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r4 == 0) goto L61
            r4.close()     // Catch: java.lang.Throwable -> L7f
            goto L61
        L2e:
            r9 = move-exception
            goto L79
        L30:
            r1 = move-exception
            goto L39
        L32:
            r9 = move-exception
            r4 = r1
            goto L79
        L35:
            r4 = move-exception
            r8 = r4
            r4 = r1
            r1 = r8
        L39:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2e
            r5.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = "clean "
            r5.append(r6)     // Catch: java.lang.Throwable -> L2e
            r5.append(r10)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = " saved login data error : "
            r5.append(r10)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = r1.getMessage()     // Catch: java.lang.Throwable -> L2e
            r5.append(r10)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r10 = r5.toString()     // Catch: java.lang.Throwable -> L2e
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L2e
            com.tencent.imsdk.android.tools.log.IMLogger.w(r10, r1)     // Catch: java.lang.Throwable -> L2e
            if (r4 == 0) goto L60
            r4.close()     // Catch: java.lang.Throwable -> L7f
        L60:
            r10 = -1
        L61:
            r1 = 1
            if (r10 == r2) goto L65
            r3 = 1
        L65:
            if (r3 == 0) goto L77
            com.tencent.imsdk.android.base.IMSDKDB4Login.mWriteOperating = r1     // Catch: java.lang.Throwable -> L7f
            com.tencent.imsdk.android.tools.PreferencesUtils r10 = com.tencent.imsdk.android.base.IMSDKDB4Login.mPreferencesUtils     // Catch: java.lang.Throwable -> L7f
            java.lang.String r1 = "imsdk_channel"
            r10.setPreferenceFileName(r1)     // Catch: java.lang.Throwable -> L7f
            com.tencent.imsdk.android.tools.PreferencesUtils r10 = com.tencent.imsdk.android.base.IMSDKDB4Login.mPreferencesUtils     // Catch: java.lang.Throwable -> L7f
            java.lang.String r1 = "channel_key"
            r10.remove(r9, r1)     // Catch: java.lang.Throwable -> L7f
        L77:
            monitor-exit(r0)
            return r3
        L79:
            if (r4 == 0) goto L7e
            r4.close()     // Catch: java.lang.Throwable -> L7f
        L7e:
            throw r9     // Catch: java.lang.Throwable -> L7f
        L7f:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.IMSDKDB4Login.cleanSavedLoginData(android.content.Context, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r1 == null) goto L15;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void clearDB(android.content.Context r4) {
        /*
            java.lang.Class<com.tencent.imsdk.android.base.IMSDKDB4Login> r0 = com.tencent.imsdk.android.base.IMSDKDB4Login.class
            monitor-enter(r0)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r1 = openOrCreateDatabase(r4)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r4.<init>()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r2 = "DELETE FROM "
            r4.append(r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r2 = com.tencent.imsdk.android.base.IMSDKDB4Login.LOGIN_DB_TABLE     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r4.append(r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            r1.execSQL(r4)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L26
            if (r1 == 0) goto L45
        L20:
            r1.close()     // Catch: java.lang.Throwable -> L4d
            goto L45
        L24:
            r4 = move-exception
            goto L47
        L26:
            r4 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L24
            r2.<init>()     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = "clear DB error "
            r2.append(r3)     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L24
            r2.append(r4)     // Catch: java.lang.Throwable -> L24
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L24
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L24
            com.tencent.imsdk.android.tools.log.IMLogger.w(r4, r2)     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L45
            goto L20
        L45:
            monitor-exit(r0)
            return
        L47:
            if (r1 == 0) goto L4c
            r1.close()     // Catch: java.lang.Throwable -> L4d
        L4c:
            throw r4     // Catch: java.lang.Throwable -> L4d
        L4d:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.IMSDKDB4Login.clearDB(android.content.Context):void");
    }

    private static synchronized IMSDKDBLoginData getDBLoginData(Context context, String str) {
        synchronized (IMSDKDB4Login.class) {
            IMSDKDBLoginData iMSDKDBLoginData = null;
            if (context == null) {
                return null;
            }
            if (str == null) {
                return null;
            }
            String loginRawData = getLoginRawData(context, str);
            if (loginRawData != null) {
                try {
                    iMSDKDBLoginData = new IMSDKDBLoginData(loginRawData);
                } catch (JSONException e) {
                    IMLogger.w(str + " get saved login data failed : " + e.getMessage(), new Object[0]);
                }
            }
            return iMSDKDBLoginData;
        }
    }

    public static synchronized IMSDKDBLoginData getDBLoginData(Context context) {
        IMSDKDBLoginData dBLoginData;
        synchronized (IMSDKDB4Login.class) {
            if (!mWriteOperating && !mAccountTypeChanged && mLoginData != null) {
                return mLoginData;
            }
            if (context == null) {
                return null;
            }
            if (1 == mAccountType) {
                mPreferencesUtils.setPreferenceFileName(IR.preferences.PREFS_CHANNEL_FILE);
                IMSDKDBLoginData dBLoginData2 = getDBLoginData(context, "5");
                if (dBLoginData2 != null) {
                    mLoginData = dBLoginData2;
                    mWriteOperating = false;
                    mAccountTypeChanged = false;
                    return mLoginData;
                }
            } else if (2 == mAccountType) {
                mPreferencesUtils.setPreferenceFileName(IR.preferences.PREFS_CHANNEL_FILE);
                String string = mPreferencesUtils.getString(context, IR.preferences.PREFS_CHANNEL_KEY, null);
                if (string != null && !"5".equals(string) && (dBLoginData = getDBLoginData(context, string)) != null) {
                    mLoginData = dBLoginData;
                    mWriteOperating = false;
                    mAccountTypeChanged = false;
                    return mLoginData;
                }
            } else if (!hasSetAccountType) {
                mPreferencesUtils.setPreferenceFileName(IR.preferences.PREFS_CHANNEL_FILE);
                String string2 = mPreferencesUtils.getString(context, IR.preferences.PREFS_CHANNEL_KEY, null);
                if (string2 == null) {
                    return null;
                }
                IMSDKDBLoginData dBLoginData3 = getDBLoginData(context, string2);
                if (dBLoginData3 != null) {
                    mLoginData = dBLoginData3;
                    mWriteOperating = false;
                    mAccountTypeChanged = false;
                    return mLoginData;
                }
            } else {
                IMLogger.e("please set right account with 1 or 2 , 1 means auth and 2 means login", new Object[0]);
            }
            return null;
        }
    }

    public static synchronized String getOpenId(Context context) {
        synchronized (IMSDKDB4Login.class) {
            IMSDKDBLoginData dBLoginData = getDBLoginData(context);
            if (dBLoginData == null) {
                return null;
            }
            return dBLoginData.openId;
        }
    }

    public static synchronized String getInnerToken(Context context) {
        synchronized (IMSDKDB4Login.class) {
            IMSDKDBLoginData dBLoginData = getDBLoginData(context);
            if (dBLoginData == null) {
                return null;
            }
            return dBLoginData.openId;
        }
    }
}
