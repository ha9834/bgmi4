package com.tencent.imsdk.android.api.login;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKModules;
import com.tencent.imsdk.android.base.login.GuestLogin;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.base.login.UnifiedAccountLogin;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.PreferencesUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class IMSDKLogin {
    private static final int BASE_RESULT = 0;
    private static final String EXTRA_PERMISSON_KEY = "permissions";
    private static final int SERVER_BIND_INFO = 2;
    private static final int SERVER_LOGIN_RESULT = 1;
    private static final String UNIFIED_ACCOUNT_CHANNEL = "UnifiedAccount";
    private static InnerStat.Builder mAPIStatBuilder;
    private static String mCurChannel;
    private static Context mCurCtx;
    private static IMSDKLoginBase mLoginImpl;
    private static PreferencesUtils mPreferencesUtils = new PreferencesUtils();

    private static boolean isInit(int i, IMSDKResultListener iMSDKResultListener) {
        JsonSerializable iMSDKLoginResult;
        if (mLoginImpl == null && iMSDKResultListener != null) {
            int i2 = T.ckIsEmpty(mCurChannel) ? 18 : 17;
            switch (i) {
                case 1:
                    iMSDKLoginResult = new IMSDKLoginResult(i2, -1);
                    break;
                case 2:
                    iMSDKLoginResult = new IMSDKBindInfoResult(i2, -1);
                    break;
                default:
                    iMSDKLoginResult = new IMSDKResult(i2, -1);
                    break;
            }
            iMSDKResultListener.onResult(iMSDKLoginResult);
        }
        return mLoginImpl != null;
    }

    private static IMSDKLoginBase getLoginInstance(String str) {
        IMSDKLoginBase iMSDKLoginBase;
        if ("Guest".equalsIgnoreCase(str)) {
            IMLogger.d("Getting 'Guest' channel instance");
            iMSDKLoginBase = new GuestLogin(mCurCtx);
        } else if (UNIFIED_ACCOUNT_CHANNEL.equalsIgnoreCase(str)) {
            IMLogger.d("Getting 'UnifiedAccount' channel instance");
            iMSDKLoginBase = new UnifiedAccountLogin(mCurCtx);
        } else {
            String format = String.format(IR.def.DEFAULT_PACKAGE_NAME_LOGIN_FORMAT, str.toLowerCase(Locale.US), str);
            IMLogger.d("Getting '" + format + "' channel instance");
            IMSDKLoginBase iMSDKLoginBase2 = (IMSDKLoginBase) IMSDKModules.getInstance(mCurCtx).getChannelInstance(IMSDKLoginBase.class, format);
            if (iMSDKLoginBase2 == null) {
                T.HelperLog.channelSetFailed(str, format);
            }
            iMSDKLoginBase = iMSDKLoginBase2;
        }
        if (iMSDKLoginBase != null) {
            iMSDKLoginBase.setChannel(str);
        }
        return iMSDKLoginBase;
    }

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAPIStatBuilder = new InnerStat.Builder(mCurCtx, "2.10.1", IR.MODULE_LOGIN, "Init<IMSDKLogin>");
        }
        return mCurCtx != null;
    }

    public static boolean setChannel(String str) {
        if (mCurCtx == null) {
            T.HelperLog.contextIsNull();
            return false;
        }
        if (str.length() <= 0) {
            T.HelperLog.channelIsNullOrEmpty();
            return false;
        }
        if (str.length() > 0 && (!str.equals(mCurChannel) || mLoginImpl == null)) {
            mLoginImpl = getLoginInstance(str);
        }
        IMSDKLoginBase iMSDKLoginBase = mLoginImpl;
        if (iMSDKLoginBase != null) {
            iMSDKLoginBase.setChannel(str);
            mCurChannel = str;
            mPreferencesUtils.setPreferenceFileName(IR.preferences.PREFS_CHANNEL_FILE);
            mPreferencesUtils.putString(mCurCtx, IR.preferences.PREFS_CHANNEL_KEY, mLoginImpl.getSqlChannelKey());
            InnerStat.Builder builder = mAPIStatBuilder;
            if (builder != null) {
                builder.setChannel(mCurChannel);
            }
        } else {
            T.HelperLog.channelSetFailed(str, null);
        }
        return mLoginImpl != null;
    }

    public static void login(IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        login(new ArrayList(), iMSDKResultListener);
    }

    public static void login(List<String> list, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        login(false, list, iMSDKResultListener);
    }

    public static void login(boolean z, List<String> list, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        login("", z, list, iMSDKResultListener);
    }

    public static void login(String str, List<String> list, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        login(str, false, list, iMSDKResultListener);
    }

    public static void login(String str, boolean z, List<String> list, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        login("", str, z, list, iMSDKResultListener);
    }

    public static void login(String str, String str2, boolean z, List<String> list, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        login(str, str2, z, list, iMSDKResultListener, null);
    }

    public static void login(List<String> list, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, String str) {
        login("", "", false, list, iMSDKResultListener, str);
    }

    public static void login(String str, String str2, boolean z, List<String> list, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, String str3) {
        InnerStat.Builder builder = mAPIStatBuilder;
        IMSDKResultListener<IMSDKLoginResult> proxyListener4EventReport = builder != null ? builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener) : iMSDKResultListener;
        if (isInit(1, proxyListener4EventReport)) {
            mLoginImpl.login(str, z ? IR.path.CHECK_LOGIN_PATH : "user/login", str2, proxyListener4EventReport, list, str3);
        }
    }

    public static void refreshLogin(IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener)) {
            IMSDKLoginResult loginResult = getLoginResult();
            if (loginResult != null && loginResult.imsdkRetCode == 1) {
                mLoginImpl.refreshLogin(loginResult, iMSDKResultListener);
            } else if (iMSDKResultListener != null) {
                iMSDKResultListener.onResult(new IMSDKLoginResult(10, -1));
            }
        }
    }

    public static boolean isLogin() {
        if (isInit(0, null)) {
            return mLoginImpl.isLogin();
        }
        return false;
    }

    public static void quickLogin(IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener)) {
            mLoginImpl.quickLogin(iMSDKResultListener);
        }
    }

    public static void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener)) {
            mLoginImpl.logout(iMSDKResultListener);
        }
    }

    public static void logoutAll(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat.Builder builder = mAPIStatBuilder;
        if (builder != null) {
            iMSDKResultListener = builder.create().proxyListener4EventReport(mCurChannel, iMSDKResultListener);
        }
        if (isInit(1, iMSDKResultListener)) {
            mLoginImpl.logoutAll(iMSDKResultListener);
        }
    }

    public static IMSDKLoginResult getLoginResult() {
        if (isInit(1, null)) {
            return IMSDKDB4Login.getLoginResult(mCurCtx, mLoginImpl.getSqlChannelKey());
        }
        return new IMSDKLoginResult(17, 17);
    }

    public static void getBindInfo(String str, IMSDKResultListener<IMSDKBindInfoResult> iMSDKResultListener) {
        if (isInit(2, iMSDKResultListener)) {
            mLoginImpl.getBindInfo(iMSDKResultListener, new Object[0]);
        }
    }

    public static void bind(String str, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener) {
        bind(str, "", iMSDKResultListener, new Object[0]);
    }

    public static void bind(String str, String str2, IMSDKResultListener<IMSDKLoginResult> iMSDKResultListener, Object... objArr) {
        bind("", str, str2, iMSDKResultListener, objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void bind(java.lang.String r6, java.lang.String r7, java.lang.String r8, com.tencent.imsdk.android.api.IMSDKResultListener<com.tencent.imsdk.android.api.login.IMSDKLoginResult> r9, java.lang.Object... r10) {
        /*
            com.tencent.imsdk.android.tools.InnerStat$Builder r0 = com.tencent.imsdk.android.api.login.IMSDKLogin.mAPIStatBuilder
            if (r0 == 0) goto Le
            com.tencent.imsdk.android.tools.InnerStat r0 = r0.create()
            com.tencent.imsdk.android.api.IMSDKResultListener r9 = r0.proxyListener4EventReport(r7, r9)
            r4 = r9
            goto Lf
        Le:
            r4 = r9
        Lf:
            r9 = 0
            r0 = 0
            if (r10 == 0) goto L62
            int r1 = r10.length     // Catch: java.lang.Exception -> L49
            if (r1 <= 0) goto L62
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L49
            r2 = r10[r0]     // Catch: java.lang.Exception -> L49
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L49
            r1.<init>(r2)     // Catch: java.lang.Exception -> L49
            java.lang.String r2 = "permissions"
            boolean r2 = r1.has(r2)     // Catch: java.lang.Exception -> L49
            if (r2 == 0) goto L62
            java.lang.String r2 = "permissions"
            org.json.JSONArray r1 = r1.getJSONArray(r2)     // Catch: java.lang.Exception -> L49
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> L49
            r2.<init>()     // Catch: java.lang.Exception -> L49
            r9 = 0
        L33:
            int r3 = r1.length()     // Catch: java.lang.Exception -> L45
            if (r9 >= r3) goto L43
            java.lang.String r3 = r1.getString(r9)     // Catch: java.lang.Exception -> L45
            r2.add(r3)     // Catch: java.lang.Exception -> L45
            int r9 = r9 + 1
            goto L33
        L43:
            r9 = r2
            goto L62
        L45:
            r9 = move-exception
            r1 = r9
            r9 = r2
            goto L4a
        L49:
            r1 = move-exception
        L4a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "process bind permission unknown error "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.tencent.imsdk.android.tools.log.IMLogger.d(r1)
        L62:
            r1 = 1
            boolean r2 = isInit(r1, r4)
            if (r2 == 0) goto Ld5
            com.tencent.imsdk.android.base.login.IMSDKLoginBase r2 = com.tencent.imsdk.android.api.login.IMSDKLogin.mLoginImpl
            boolean r2 = r2.isLogin()
            if (r2 == 0) goto L9c
            com.tencent.imsdk.android.base.login.IMSDKLoginBase r7 = getLoginInstance(r7)
            if (r7 == 0) goto L91
            android.content.Context r2 = com.tencent.imsdk.android.api.login.IMSDKLogin.mCurCtx
            com.tencent.imsdk.android.base.login.IMSDKLoginBase r3 = com.tencent.imsdk.android.api.login.IMSDKLogin.mLoginImpl
            java.lang.String r3 = r3.getSqlChannelKey()
            com.tencent.imsdk.android.api.login.IMSDKLoginResult r2 = com.tencent.imsdk.android.base.IMSDKDB4Login.getLoginResult(r2, r3)
            r3 = 2
            java.lang.Object[] r5 = new java.lang.Object[r3]
            r5[r0] = r9
            r5[r1] = r10
            r0 = r7
            r1 = r6
            r3 = r8
            r0.bind(r1, r2, r3, r4, r5)
            goto Ld5
        L91:
            com.tencent.imsdk.android.api.login.IMSDKLoginResult r6 = new com.tencent.imsdk.android.api.login.IMSDKLoginResult
            r7 = 9
            r6.<init>(r7, r7)
            r4.onResult(r6)
            goto Ld5
        L9c:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r9 = "You must login to current channel '"
            r6.append(r9)
            java.lang.String r9 = com.tencent.imsdk.android.api.login.IMSDKLogin.mCurChannel
            r6.append(r9)
            java.lang.String r9 = "' before bind to '"
            r6.append(r9)
            r6.append(r7)
            java.lang.String r7 = "' channel with sub channel '"
            r6.append(r7)
            r6.append(r8)
            java.lang.String r7 = "'"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r7 = new java.lang.Object[r0]
            com.tencent.imsdk.android.tools.log.IMLogger.w(r6, r7)
            com.tencent.imsdk.android.api.login.IMSDKLoginResult r6 = new com.tencent.imsdk.android.api.login.IMSDKLoginResult
            java.lang.String r7 = "source channel need login first"
            r8 = 10
            r6.<init>(r8, r8, r7)
            r4.onResult(r6)
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.api.login.IMSDKLogin.bind(java.lang.String, java.lang.String, java.lang.String, com.tencent.imsdk.android.api.IMSDKResultListener, java.lang.Object[]):void");
    }
}
