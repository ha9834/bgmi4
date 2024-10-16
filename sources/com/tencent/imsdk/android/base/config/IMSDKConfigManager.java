package com.tencent.imsdk.android.base.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.PreferencesUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKConfigManager extends IMSDKManagerBase {
    private static final String CLEAR_ALL_DATA = "1";
    private static final String IMSDK_CONFIG_SIGN_CODE = "config_sign_code";
    private static final Object locked = new Object();
    private Map<String, String> mConfigCache;
    private SQLiteDatabase mDBController;
    private ConfigDBHelper mDBHelper;
    private boolean mIsConfigProcessed;
    private Map<String, String> mUserConfigCache;

    public IMSDKConfigManager(Context context) {
        super(context);
        this.mIsConfigProcessed = false;
        if (this.mCurCtx != context) {
            this.mCurCtx = context;
            this.mDBHelper = new ConfigDBHelper(context);
            this.mConfigCache = T.getSortableMap();
            this.mUserConfigCache = T.getSortableMap();
            cacheAllConfig();
        }
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        StringBuilder sb = new StringBuilder();
        String orDefault = getOrDefault(IR.meta.IMSDK_SERVER_CONFIG, T.Meta.readFromApplication(this.mCurCtx, IR.meta.IMSDK_SERVER_CONFIG.toUpperCase(), IR.meta.IMSDK_SERVER_CONFIG));
        String orDefault2 = getOrDefault(IR.meta.IMSDK_SERVER_CONFIG_VERSION, T.Meta.readFromApplication(this.mCurCtx, IR.meta.IMSDK_SERVER_CONFIG_VERSION, "1.0"));
        sb.append(enableHttps() ? "https" : "http");
        sb.append("://");
        sb.append(orDefault);
        sb.append("/v");
        sb.append(orDefault2);
        sb.append("/");
        sb.append(str);
        sb.append("?");
        return sb.toString();
    }

    public void getConfigs() {
        getConfigs(null);
    }

    public void getConfigs(final IMSDKResultListener iMSDKResultListener) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("sSign", new PreferencesUtils().getString(this.mCurCtx, IMSDK_CONFIG_SIGN_CODE, ""));
        this.mIsConfigProcessed = false;
        connectIMSDK(IR.path.GET_CONFIG_PATH, sortableMap, new IMSDKResultListener() { // from class: com.tencent.imsdk.android.base.config.IMSDKConfigManager.1
            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
            public void onResult(IMSDKResult iMSDKResult) {
                IMSDKConfigManager.this.mIsConfigProcessed = true;
                IMLogger.d("get config result : code = " + iMSDKResult.thirdRetCode + " ,  msg = " + iMSDKResult.thirdRetMsg);
                IMSDKResultListener iMSDKResultListener2 = iMSDKResultListener;
                if (iMSDKResultListener2 != null) {
                    iMSDKResultListener2.onResult(iMSDKResult);
                }
            }
        });
    }

    public String getOrDefault(String str, String str2) {
        Map<String, String> map = this.mUserConfigCache;
        if (map != null && map.containsKey(str)) {
            return this.mUserConfigCache.get(str);
        }
        Map<String, String> map2 = this.mConfigCache;
        return (map2 == null || !map2.containsKey(str)) ? str2 : this.mConfigCache.get(str);
    }

    public int getOrDefault(String str, int i) {
        try {
            if (this.mUserConfigCache != null && this.mUserConfigCache.containsKey(str)) {
                i = Integer.valueOf(this.mUserConfigCache.get(str)).intValue();
            } else if (this.mConfigCache != null && this.mConfigCache.containsKey(str)) {
                i = Integer.valueOf(this.mConfigCache.get(str)).intValue();
            }
        } catch (Exception unused) {
        }
        return i;
    }

    public boolean isConfigProcessed() {
        return this.mIsConfigProcessed;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        try {
            String str2 = new String(bArr, "UTF-8");
            IMLogger.json(str2);
            ConfigResult configResult = new ConfigResult(str2);
            if (configResult.thirdRetCode == 1) {
                configResult.imsdkRetCode = 1;
                IMLogger.d(new PreferencesUtils().putString(this.mCurCtx, IMSDK_CONFIG_SIGN_CODE, configResult.validKey) ? "cache config sign code success" : "cache config sign code fail");
            } else {
                configResult.imsdkRetCode = 5;
            }
            configResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(configResult.imsdkRetCode);
            if (configResult.configData == null) {
                configResult.configData = new JSONObject();
            }
            if ("1".equals(String.valueOf(configResult.updateAllTag))) {
                synchronized (locked) {
                    this.mConfigCache.clear();
                    this.mConfigCache = T.jsonToMap(configResult.configData);
                }
                clearDB();
            } else {
                this.mConfigCache.putAll(T.jsonToMap(configResult.configData));
            }
            updateDB(T.jsonToMap(configResult.configData), ConfigDBHelper.TABLE_NAME_CONFIG);
            return configResult;
        } catch (Exception e) {
            ConfigResult configResult2 = new ConfigResult();
            configResult2.imsdkRetCode = 5;
            configResult2.imsdkRetMsg = IMSDKErrCode.getMessageByCode(configResult2.imsdkRetCode);
            configResult2.thirdRetCode = 3;
            configResult2.thirdRetMsg = e.getMessage();
            return configResult2;
        }
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return new ConfigResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg);
    }

    private void cacheAllConfig() {
        cacheConfig(this.mConfigCache, ConfigDBHelper.TABLE_NAME_CONFIG);
        cacheConfig(this.mUserConfigCache, ConfigDBHelper.TABLE_NAME_USER_CONFIG);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        r5 = r4.mDBController;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
    
        if (r5 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
    
        if (r0 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
    
        if (r0.moveToFirst() != false) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
    
        r5.put(r0.getString(r0.getColumnIndex("key")), r0.getString(r0.getColumnIndex("value")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0041, code lost:
    
        if (r0.moveToNext() != false) goto L33;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void cacheConfig(java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            com.tencent.imsdk.android.base.config.ConfigDBHelper r1 = r4.mDBHelper     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r4.mDBController = r1     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            android.database.sqlite.SQLiteDatabase r1 = r4.mDBController     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r2.<init>()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r2.append(r6)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            android.database.Cursor r0 = r1.rawQuery(r6, r0)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            boolean r6 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r6 == 0) goto L43
        L26:
            java.lang.String r6 = "key"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r6 = r0.getString(r6)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r1 = "value"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r5.put(r6, r1)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            boolean r6 = r0.moveToNext()     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            if (r6 != 0) goto L26
        L43:
            android.database.sqlite.SQLiteDatabase r5 = r4.mDBController
            if (r5 == 0) goto L4a
            r5.close()
        L4a:
            if (r0 == 0) goto L74
            goto L71
        L4d:
            r5 = move-exception
            goto L75
        L4f:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r6.<init>()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = "get value from config error "
            r6.append(r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L4d
            r6.append(r5)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L4d
            com.tencent.imsdk.android.tools.log.IMLogger.d(r5)     // Catch: java.lang.Throwable -> L4d
            android.database.sqlite.SQLiteDatabase r5 = r4.mDBController
            if (r5 == 0) goto L6f
            r5.close()
        L6f:
            if (r0 == 0) goto L74
        L71:
            r0.close()
        L74:
            return
        L75:
            android.database.sqlite.SQLiteDatabase r6 = r4.mDBController
            if (r6 == 0) goto L7c
            r6.close()
        L7c:
            if (r0 == 0) goto L81
            r0.close()
        L81:
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.config.IMSDKConfigManager.cacheConfig(java.util.Map, java.lang.String):void");
    }

    public void clearDB() {
        this.mConfigCache.clear();
        clearDB(ConfigDBHelper.TABLE_NAME_CONFIG);
    }

    public void clearUserDB() {
        this.mUserConfigCache.clear();
        clearDB(ConfigDBHelper.TABLE_NAME_USER_CONFIG);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void clearDB(String str) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (locked) {
            this.mDBController = this.mDBHelper.getWritableDatabase();
            try {
                try {
                    this.mDBController.delete(str, null, null);
                } catch (Exception e) {
                    IMLogger.w(e.getMessage(), new Object[0]);
                    if (this.mDBController != null) {
                        sQLiteDatabase = this.mDBController;
                    }
                }
                if (this.mDBController != null) {
                    sQLiteDatabase = this.mDBController;
                    sQLiteDatabase.close();
                }
            } catch (Throwable th) {
                if (this.mDBController != null) {
                    this.mDBController.close();
                }
                throw th;
            }
        }
    }

    public boolean updateUserDB(Map<String, String> map) {
        synchronized (locked) {
            this.mUserConfigCache.putAll(map);
        }
        return updateDB(map, ConfigDBHelper.TABLE_NAME_USER_CONFIG);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x008d A[Catch: all -> 0x00d3, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0089, B:11:0x008d, B:12:0x00c2, B:24:0x00c4, B:26:0x00c8, B:27:0x00d2, B:18:0x00b3, B:20:0x00b7, B:29:0x0014, B:31:0x001a, B:32:0x0022, B:34:0x0028, B:8:0x0084, B:17:0x009b), top: B:3:0x0003, inners: #1, #2 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean updateDB(java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.Object r0 = com.tencent.imsdk.android.base.config.IMSDKConfigManager.locked
            monitor-enter(r0)
            com.tencent.imsdk.android.base.config.ConfigDBHelper r1 = r8.mDBHelper     // Catch: java.lang.Throwable -> Ld3
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> Ld3
            r8.mDBController = r1     // Catch: java.lang.Throwable -> Ld3
            android.database.sqlite.SQLiteDatabase r1 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            r1.beginTransaction()     // Catch: java.lang.Throwable -> Ld3
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L83
            int r3 = r9.size()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            if (r3 <= 0) goto L83
            java.util.Set r9 = r9.entrySet()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
        L22:
            boolean r3 = r9.hasNext()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            if (r3 == 0) goto L84
            java.lang.Object r3 = r9.next()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r4.<init>()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r5 = "update db : key = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.Object r5 = r3.getKey()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r4.append(r5)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r5 = ", value = "
            r4.append(r5)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.Object r5 = r3.getValue()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r4.append(r5)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            com.tencent.imsdk.android.tools.log.IMLogger.i(r4, r5)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            android.database.sqlite.SQLiteDatabase r4 = r8.mDBController     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r5.<init>()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r6 = "REPLACE INTO "
            r5.append(r6)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r5.append(r10)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r6 = " VALUES(null, ?, ?)"
            r5.append(r6)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.Object r7 = r3.getKey()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r6[r2] = r7     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r6[r1] = r3     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r4.execSQL(r5, r6)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            goto L22
        L83:
            r1 = 0
        L84:
            android.database.sqlite.SQLiteDatabase r9 = r8.mDBController     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r9.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            android.database.sqlite.SQLiteDatabase r9 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            if (r9 == 0) goto Lc2
            android.database.sqlite.SQLiteDatabase r9 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            r9.endTransaction()     // Catch: java.lang.Throwable -> Ld3
            android.database.sqlite.SQLiteDatabase r9 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            r9.close()     // Catch: java.lang.Throwable -> Ld3
            goto Lc2
        L98:
            r9 = move-exception
            goto Lc4
        L9a:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98
            r10.<init>()     // Catch: java.lang.Throwable -> L98
            java.lang.String r1 = "update config error "
            r10.append(r1)     // Catch: java.lang.Throwable -> L98
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L98
            r10.append(r9)     // Catch: java.lang.Throwable -> L98
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Throwable -> L98
            com.tencent.imsdk.android.tools.log.IMLogger.d(r9)     // Catch: java.lang.Throwable -> L98
            android.database.sqlite.SQLiteDatabase r9 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            if (r9 == 0) goto Lc1
            android.database.sqlite.SQLiteDatabase r9 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            r9.endTransaction()     // Catch: java.lang.Throwable -> Ld3
            android.database.sqlite.SQLiteDatabase r9 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            r9.close()     // Catch: java.lang.Throwable -> Ld3
        Lc1:
            r1 = 0
        Lc2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld3
            return r1
        Lc4:
            android.database.sqlite.SQLiteDatabase r10 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            if (r10 == 0) goto Ld2
            android.database.sqlite.SQLiteDatabase r10 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            r10.endTransaction()     // Catch: java.lang.Throwable -> Ld3
            android.database.sqlite.SQLiteDatabase r10 = r8.mDBController     // Catch: java.lang.Throwable -> Ld3
            r10.close()     // Catch: java.lang.Throwable -> Ld3
        Ld2:
            throw r9     // Catch: java.lang.Throwable -> Ld3
        Ld3:
            r9 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Ld3
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.config.IMSDKConfigManager.updateDB(java.util.Map, java.lang.String):boolean");
    }
}
