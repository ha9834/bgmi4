package com.tencent.uqm.crash;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.crashsight.core.api.CrashSightPlatform;
import com.tencent.crashsight.core.api.crash.UQMCrash;
import com.tencent.crashsight.core.crash.CrashInterface;
import com.tencent.crashsight.core.tools.NDKHelper;
import com.tencent.crashsight.core.tools.UQMLog;
import com.uqm.crashsight.crashreport.CrashReport;
import com.uqm.crashsight.crashreport.CrashSightLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class CrashSight implements CrashInterface {
    private static final long CS_REPORT_DELAY = 0;
    private static final String LOG_TAG = "CrashSightAgent";
    private static final int LogLevelDebug = 4;
    private static final int LogLevelError = 1;
    private static final int LogLevelInfo = 3;
    private static final int LogLevelSilent = 0;
    private static final int LogLevelVerbose = 5;
    private static final int LogLevelWarn = 2;
    private static final String domesticServerUrl = "https://android.crashsight.qq.com/rqd/pb/async";
    private static String mAppChannel = null;
    private static String mAppVersion = null;
    private static int mCallbackType = 31;
    private static int mCrashHandleTimeout = 2;
    private static String mCrashUploadServerUrl = null;
    private static boolean mDebugMode = false;
    private static long mDelay = 0;
    private static String mUserId = null;
    private static final String overseaServerUrl = "https://android.crashsight.wetest.net/rqd/pb/async";

    private String getOpenId() {
        return "";
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void configCrashReporterLogLevelBeforeInit(int i) {
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void configCallbackTypeBeforeInit(int i) {
        UQMLog.d("configDefaultBeforeInit invoked: " + i);
        mCallbackType = i;
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void configCrashHandleTimeout(int i) {
        UQMLog.d("configCrashHandleTimeout invoked: " + i);
        mCrashHandleTimeout = i;
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void init(String str, boolean z, boolean z2, String str2) {
        UQMLog.d("init invoked");
        if (str2 != null) {
            if (str2.equals("domestic")) {
                CrashReport.setServerUrl(domesticServerUrl);
            } else if (str2.equals("oversea")) {
                CrashReport.setServerUrl(overseaServerUrl);
            } else if (str2.startsWith("http")) {
                CrashReport.setServerUrl(str2);
            } else {
                UQMLog.e("serverUrl invalid: " + str2);
            }
        } else {
            UQMLog.e("serverUrl is null");
        }
        Context activityCur = CrashSightPlatform.getActivityCur();
        if (activityCur != null) {
            if (NDKHelper.loadSO()) {
                UQMLog.e("CrashSightCore.so is loaded successfully");
                CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(activityCur);
                userStrategy.setAppReportDelay(0L);
                userStrategy.setCallBackType(mCallbackType);
                userStrategy.setCrashHandleTimeout(mCrashHandleTimeout);
                UQMLog.d("strategy.setCallBackType: " + mCallbackType);
                userStrategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() { // from class: com.tencent.uqm.crash.CrashSight.1
                    @Override // com.uqm.crashsight.CrashSightStrategy.a
                    public synchronized Map<String, String> onCrashHandleStart(int i, String str3, String str4, String str5) {
                        String str6;
                        Map<String, String> onCrashHandleStart;
                        switch (i) {
                            case 0:
                                str6 = "JAVA_CRASH";
                                break;
                            case 1:
                                str6 = "JAVA_CATCH";
                                break;
                            case 2:
                                str6 = "JAVA_NATIVE";
                                break;
                            case 3:
                                str6 = "JAVA_U3D";
                                break;
                            default:
                                str6 = "unknown";
                                break;
                        }
                        UQMLog.d("Crash happen type : " + i + ", typeName : " + str6 + ", errorType : " + str3 + ", errorMessage : " + str4 + ", errorStack: " + str5);
                        onCrashHandleStart = super.onCrashHandleStart(i, str3, str4, str5);
                        if (onCrashHandleStart == null) {
                            onCrashHandleStart = new HashMap<>();
                        }
                        try {
                            String attachmentMessageForException = UQMCrash.attachmentMessageForException(i);
                            if (attachmentMessageForException.length() > 0) {
                                UQMLog.d("CrashSight extra message report ok, message : " + attachmentMessageForException);
                                onCrashHandleStart.put("extmsg", attachmentMessageForException);
                            } else {
                                UQMLog.d("CrashSight extra message is empty");
                            }
                        } catch (Exception e) {
                            UQMLog.e("onCrashHandleStart extra message report error, message : " + e.getMessage());
                        }
                        return onCrashHandleStart;
                    }

                    @Override // com.uqm.crashsight.CrashSightStrategy.a
                    public byte[] onCrashHandleStart2GetExtraDatas(int i, String str3, String str4, String str5) {
                        try {
                            byte[] attachmentForException = UQMCrash.attachmentForException(i);
                            if (attachmentForException != null && attachmentForException.length > 0) {
                                UQMLog.d("CrashSight extraBinaryMessage data report ok");
                                return attachmentForException;
                            }
                            UQMLog.d("CrashSight extraBinaryMessage data is empty");
                            return null;
                        } catch (Exception e) {
                            UQMLog.e("onCrashHandleStart2GetExtraData exception, message : " + e.getMessage());
                            return null;
                        }
                    }
                });
                String appVersionNameAndCode = getAppVersionNameAndCode(activityCur);
                userStrategy.setAppVersion(appVersionNameAndCode);
                UQMLog.d("CrashSightStat setAppVersion defaultVersion : " + appVersionNameAndCode);
                CrashReport.initCrashReport(activityCur, str, z2, userStrategy);
                String openId = getOpenId();
                UQMLog.d("CS setUserId with: " + openId);
                setUserId(openId);
                return;
            }
            UQMLog.e("CrashSightCore.so is loaded failed");
            return;
        }
        UQMLog.e("UQMApplications get context failed");
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void logInfo(int i, String str, String str2) {
        UQMLog.d("logInfo invoked, level : " + i + ", tag : " + str + ", log : " + str2);
        switch (i) {
            case 0:
            default:
                return;
            case 1:
                CrashSightLog.e(str, str2);
                return;
            case 2:
                CrashSightLog.w(str, str2);
                return;
            case 3:
                CrashSightLog.i(str, str2);
                return;
            case 4:
                CrashSightLog.d(str, str2);
                return;
            case 5:
                CrashSightLog.v(str, str2);
                return;
        }
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setUserValue(String str, String str2) {
        UQMLog.d("setUserValue invoked, key : " + str + ", value : " + str2);
        CrashReport.putUserData(CrashSightPlatform.getActivity().getApplicationContext(), str, str2);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setUserId(String str) {
        if (str == null) {
            str = "";
        }
        CrashReport.setUserId(str);
        UQMLog.d("set user id as " + str);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setAppId(String str) {
        if (str == null) {
            str = "";
        }
        CrashReport.setAppID(str);
        UQMLog.d("set app id as " + str);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setUserSceneTag(String str) {
        if (str == null) {
            str = "";
        }
        CrashReport.setUserSceneTagStr(str);
        UQMLog.d("set user scene tag as " + str);
    }

    private String getAppVersionNameAndCode(Context context) {
        String str = "";
        int i = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            i = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            UQMLog.d(" getAppVersionNameAndCode exception : " + e.getMessage());
        }
        if (str == null || str.isEmpty()) {
            UQMLog.e(" CSCrash versionName is null, plz check! ");
            return "1.0";
        }
        if (i == 0) {
            return str;
        }
        return str + "." + i;
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void reportException(int i, String str, String str2, String str3, HashMap<String, String> hashMap) {
        UQMLog.d("CS Crash reportException type : " + i + " , exceptionName : " + str + " , exceptionMsg : " + str2 + " , exceptionStack : " + str3 + " , extInfo : " + hashMap);
        CrashReport.postException(i, str, str2, str3, hashMap);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setIsAppForeground(boolean z) {
        CrashReport.setIsAppForeground(z);
        UQMLog.d("set is app foreground as " + z);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setAppVersion(String str) {
        if (str == null) {
            str = "";
        }
        CrashReport.setAppVersion(str);
        UQMLog.d("set app version as " + str);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void initWithAppId(String str) {
        UQMLog.d("initWithAppId invoked, appId: " + str);
        String str2 = mCrashUploadServerUrl;
        if (str2 != null) {
            CrashReport.setServerUrl(str2);
        }
        Context activity = CrashSightPlatform.getActivity();
        if (activity != null) {
            if (NDKHelper.loadSO()) {
                UQMLog.e("CrashSightCore.so is loaded successfully");
                CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(activity);
                userStrategy.setAppReportDelay(mDelay);
                userStrategy.setCallBackType(mCallbackType);
                UQMLog.d("strategy.setCallBackType: " + mCallbackType);
                userStrategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() { // from class: com.tencent.uqm.crash.CrashSight.2
                    @Override // com.uqm.crashsight.CrashSightStrategy.a
                    public synchronized Map<String, String> onCrashHandleStart(int i, String str3, String str4, String str5) {
                        String str6;
                        Map<String, String> onCrashHandleStart;
                        switch (i) {
                            case 0:
                                str6 = "JAVA_CRASH";
                                break;
                            case 1:
                                str6 = "JAVA_CATCH";
                                break;
                            case 2:
                                str6 = "JAVA_NATIVE";
                                break;
                            case 3:
                                str6 = "JAVA_U3D";
                                break;
                            default:
                                str6 = "unknown";
                                break;
                        }
                        UQMLog.d("Crash happen type : " + i + ", typeName : " + str6 + ", errorType : " + str3 + ", errorMessage : " + str4 + ", errorStack: " + str5);
                        onCrashHandleStart = super.onCrashHandleStart(i, str3, str4, str5);
                        if (onCrashHandleStart == null) {
                            onCrashHandleStart = new HashMap<>();
                        }
                        try {
                            String attachmentMessageForException = UQMCrash.attachmentMessageForException(i);
                            if (attachmentMessageForException.length() > 0) {
                                UQMLog.d("CrashSight extra message report ok, message : " + attachmentMessageForException);
                                onCrashHandleStart.put("extmsg", attachmentMessageForException);
                            } else {
                                UQMLog.d("CrashSight extra message is empty");
                            }
                        } catch (Exception e) {
                            UQMLog.e("onCrashHandleStart extra message report error, message : " + e.getMessage());
                        }
                        return onCrashHandleStart;
                    }

                    @Override // com.uqm.crashsight.CrashSightStrategy.a
                    public byte[] onCrashHandleStart2GetExtraDatas(int i, String str3, String str4, String str5) {
                        try {
                            byte[] attachmentForException = UQMCrash.attachmentForException(i);
                            if (attachmentForException != null && attachmentForException.length > 0) {
                                UQMLog.d("CrashSight extraBinaryMessage data report ok");
                                return attachmentForException;
                            }
                            UQMLog.d("CrashSight extraBinaryMessage data is empty");
                            return null;
                        } catch (Exception e) {
                            UQMLog.e("onCrashHandleStart2GetExtraData exception, message : " + e.getMessage());
                            return null;
                        }
                    }
                });
                CrashReport.initCrashReport(activity, str, mDebugMode, userStrategy);
                UQMLog.d("mAppChannel: " + mAppChannel);
                UQMLog.d("mAppVersion: " + mAppVersion);
                UQMLog.d("mUserId: " + mUserId);
                UQMLog.d("mDelay: " + mDelay);
                String str3 = mAppChannel;
                if (str3 != null) {
                    CrashReport.setAppChannel(activity, str3);
                }
                String str4 = mAppVersion;
                if (str4 != null) {
                    CrashReport.setAppVersion(activity, str4);
                }
                String str5 = mUserId;
                if (str5 != null) {
                    CrashReport.setUserId(str5);
                    return;
                }
                return;
            }
            UQMLog.e("CrashSightCore.so is loaded failed");
            return;
        }
        UQMLog.e("crashsight platform get activity failed.");
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setGameType(int i) {
        UQMLog.d("setGameType invoked, gameType: " + i);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void configDefaultBeforeInit(String str, String str2, String str3, long j) {
        UQMLog.d("configDefaultBeforeInit invoked");
        mAppChannel = str;
        mAppVersion = str2;
        mUserId = str3;
        mDelay = j;
        UQMLog.d("mAppChannel: " + mAppChannel);
        UQMLog.d("mAppVersion: " + mAppVersion);
        UQMLog.d("mUserId: " + mUserId);
        UQMLog.d("mDelay: " + mDelay);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void configCrashServerUrlBeforeInit(String str) {
        mCrashUploadServerUrl = str;
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void configDebugModeBeforeInit(boolean z) {
        mDebugMode = z;
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void reportException(int i, String str, String str2, String str3, String str4, boolean z) {
        HashMap<String, String> hashMap;
        if (str4 == null || str4.length() <= 0) {
            hashMap = null;
        } else {
            HashMap<String, String> hashMap2 = new HashMap<>(1);
            hashMap2.put("Extra", str4);
            hashMap = hashMap2;
        }
        reportException(i, str, str2, str3, hashMap);
        if (z) {
            new Thread(new Runnable() { // from class: com.tencent.uqm.crash.CrashSight.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(3000L);
                        int myPid = Process.myPid();
                        UQMLog.w("Exit application by kill process: " + myPid);
                        Process.killProcess(myPid);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void setScene(int i) {
        CrashReport.setUserSceneTag(i);
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void printLog(int i, String str) {
        UQMLog.d("printLog level: " + i + " msg: " + str);
        switch (i) {
            case 0:
                return;
            case 1:
                CrashSightLog.v(LOG_TAG, str);
                return;
            case 2:
                CrashSightLog.i(LOG_TAG, str);
                return;
            case 3:
            case 4:
                CrashSightLog.w(LOG_TAG, str);
                return;
            case 5:
            case 6:
                CrashSightLog.e(LOG_TAG, str);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void closeCrashReport() {
        CrashReport.closeCrashReport();
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void startCrashReport() {
        CrashReport.startCrashReport();
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void testJavaCrash() {
        throw new RuntimeException("This Crash create for Test! You can go to CrashSight see more detail!");
    }

    @Override // com.tencent.crashsight.core.crash.CrashInterface
    public void testOomCrash() {
        CrashReport.testOomCrash();
    }
}
