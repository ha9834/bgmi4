package com.tencent.imsdk.android.base.auth;

/* loaded from: classes.dex */
public class IMSDKDB4ConnectResult {
    protected static final String COLUMN_CHANNEL = "channel";
    protected static final String COLUMN_DATA = "metadata";
    protected static final String COLUMN_OPEN_ID = "openid";
    protected static final String COLUMN_PLAYER_ID = "player";
    protected static final String COLUMN_TIMESTAMP = "uptime";
    protected static final String DB_NAME = "iMSDK.db";
    protected static final String DB_TABLE = "connect_info";
    private static final long EXPIRE_TIME = 72000;

    protected static String getDbName() {
        return DB_NAME;
    }

    protected static String getTableName() {
        return DB_TABLE;
    }

    protected static String getTableCreateSQL() {
        return "create table if not exists " + getTableName() + " (channel TEXT primary key, " + COLUMN_DATA + " INTEGER not null, " + COLUMN_TIMESTAMP + " TEXT not null, player TEXT not null, openid TEXT)";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean saveData(android.content.Context r14, java.lang.String r15, com.tencent.imsdk.android.api.IMSDKResult r16, java.lang.String r17) {
        /*
            r0 = r14
            r1 = r17
            r2 = 1
            r3 = 0
            r4 = -1
            r6 = 0
            java.lang.String r7 = "iMSDK.db"
            android.database.sqlite.SQLiteDatabase r7 = r14.openOrCreateDatabase(r7, r3, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La3
            java.lang.String r8 = getTableCreateSQL()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r7.execSQL(r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            android.content.ContentValues r8 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r8.<init>()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r9 = "player"
            r10 = r15
            r8.put(r9, r15)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r9 = "channel"
            r8.put(r9, r1)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r9 = "metadata"
            java.lang.String r10 = r16.toJSONString()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r8.put(r9, r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r9 = "uptime"
            long r10 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r12 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 / r12
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r8.put(r9, r10)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r9 = "5"
            com.tencent.imsdk.android.api.auth.IMSDKAuthResult r0 = com.tencent.imsdk.android.base.IMSDKDB4Login.getLoginData(r14, r9)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r0 == 0) goto L51
            int r9 = r0.imsdkRetCode     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            if (r9 != r2) goto L51
            java.lang.String r9 = "openid"
            java.lang.String r0 = r0.openId     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r8.put(r9, r0)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
        L51:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r0.<init>()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r9 = "save connect data of channel id "
            r0.append(r9)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            r0.append(r1)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            com.tencent.imsdk.android.tools.log.IMLogger.d(r0)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.String r0 = getTableName()     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            long r8 = r7.replace(r0, r6, r8)     // Catch: java.lang.Throwable -> L9a java.lang.Exception -> L9c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            r0.<init>()     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            java.lang.String r6 = "replace channel id "
            r0.append(r6)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            r0.append(r1)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            java.lang.String r1 = ", result : "
            r0.append(r1)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 == 0) goto L86
            java.lang.String r1 = "success"
            goto L88
        L86:
            java.lang.String r1 = "fail"
        L88:
            r0.append(r1)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            com.tencent.imsdk.android.tools.log.IMLogger.d(r0)     // Catch: java.lang.Exception -> L98 java.lang.Throwable -> L9a
            if (r7 == 0) goto Lc4
            r7.close()
            goto Lc4
        L98:
            r0 = move-exception
            goto L9e
        L9a:
            r0 = move-exception
            goto Lcb
        L9c:
            r0 = move-exception
            r8 = r4
        L9e:
            r6 = r7
            goto La5
        La0:
            r0 = move-exception
            r7 = r6
            goto Lcb
        La3:
            r0 = move-exception
            r8 = r4
        La5:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            r1.<init>()     // Catch: java.lang.Throwable -> La0
            java.lang.String r7 = "record connect data error : "
            r1.append(r7)     // Catch: java.lang.Throwable -> La0
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> La0
            r1.append(r0)     // Catch: java.lang.Throwable -> La0
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> La0
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La0
            com.tencent.imsdk.android.tools.log.IMLogger.w(r0, r1)     // Catch: java.lang.Throwable -> La0
            if (r6 == 0) goto Lc4
            r6.close()
        Lc4:
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 == 0) goto Lc9
            goto Lca
        Lc9:
            r2 = 0
        Lca:
            return r2
        Lcb:
            if (r7 == 0) goto Ld0
            r7.close()
        Ld0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.auth.IMSDKDB4ConnectResult.saveData(android.content.Context, java.lang.String, com.tencent.imsdk.android.api.IMSDKResult, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x016c, code lost:
    
        if (r13 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0143, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0141, code lost:
    
        if (r13 != 0) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.tencent.imsdk.android.api.auth.IMSDKAuthConnectResult getData(android.content.Context r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.auth.IMSDKDB4ConnectResult.getData(android.content.Context, java.lang.String, java.lang.String):com.tencent.imsdk.android.api.auth.IMSDKAuthConnectResult");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean cleanSavedLoginData(android.content.Context r7, java.lang.String r8) {
        /*
            r0 = -1
            r1 = 0
            r2 = 0
            java.lang.String r3 = "iMSDK.db"
            android.database.sqlite.SQLiteDatabase r7 = r7.openOrCreateDatabase(r3, r1, r2)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L32
            java.lang.String r3 = getTableName()     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            r4.<init>()     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            java.lang.String r5 = "channel='"
            r4.append(r5)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            r4.append(r8)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            java.lang.String r5 = "'"
            r4.append(r5)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            int r8 = r7.delete(r3, r4, r2)     // Catch: java.lang.Exception -> L2d java.lang.Throwable -> L62
            if (r7 == 0) goto L5e
            r7.close()
            goto L5e
        L2d:
            r2 = move-exception
            goto L36
        L2f:
            r8 = move-exception
            r7 = r2
            goto L63
        L32:
            r7 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
        L36:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r3.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r4 = "clean "
            r3.append(r4)     // Catch: java.lang.Throwable -> L62
            r3.append(r8)     // Catch: java.lang.Throwable -> L62
            java.lang.String r8 = " saved connect data error : "
            r3.append(r8)     // Catch: java.lang.Throwable -> L62
            java.lang.String r8 = r2.getMessage()     // Catch: java.lang.Throwable -> L62
            r3.append(r8)     // Catch: java.lang.Throwable -> L62
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L62
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L62
            com.tencent.imsdk.android.tools.log.IMLogger.w(r8, r2)     // Catch: java.lang.Throwable -> L62
            if (r7 == 0) goto L5d
            r7.close()
        L5d:
            r8 = -1
        L5e:
            if (r8 == r0) goto L61
            r1 = 1
        L61:
            return r1
        L62:
            r8 = move-exception
        L63:
            if (r7 == 0) goto L68
            r7.close()
        L68:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.base.auth.IMSDKDB4ConnectResult.cleanSavedLoginData(android.content.Context, java.lang.String):boolean");
    }
}
