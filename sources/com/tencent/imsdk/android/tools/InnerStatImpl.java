package com.tencent.imsdk.android.tools;

import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.mid.api.MidEntity;
import com.tencent.msdk.stat.StatConfig;
import com.tencent.msdk.stat.StatServiceImpl;
import com.tencent.msdk.stat.StatSpecifyReportedInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InnerStatImpl {
    static final String IMSDK_INNER_REPORT_TDM_PKN = "com.tdatamaster.tdm.TDataMaster";
    static final String IMSDK_INNER_REPORT_TDM_TENCENT_PKN = "com.tencent.tdm.TDataMaster";
    static final String IMSDK_INNER_REPORT_TYPE_MTA = "MTA";
    static final String IMSDK_INNER_REPORT_TYPE_TDM = "TDM";
    static final int IMSDK_TDM_SOURCE_ID = 20004;
    private static boolean mEnableReportLog;
    private static boolean mIsInited;
    private static StatSpecifyReportedInfo mSpecifyReportedInfo;

    InnerStatImpl() {
    }

    private static String getReportType() {
        return IMSDKConfig.getOrMetaData(IR.meta.IMSDK_INNER_REPORT_TYPE, IR.meta.IMSDK_INNER_REPORT_TYPE, IMSDK_INNER_REPORT_TYPE_MTA);
    }

    private static String getTdmPackageName() {
        try {
            Class.forName(IMSDK_INNER_REPORT_TDM_TENCENT_PKN);
            return IMSDK_INNER_REPORT_TDM_TENCENT_PKN;
        } catch (ClassNotFoundException unused) {
            return IMSDK_INNER_REPORT_TDM_PKN;
        }
    }

    private static void init() {
        if (mIsInited) {
            return;
        }
        if (T.isDebug() && IMSDKConfig.getOrMetaData(IR.meta.IMSDK_INNER_REPORT_LOG, IR.meta.IMSDK_INNER_REPORT_LOG, false)) {
            mEnableReportLog = true;
        }
        if (IMSDK_INNER_REPORT_TYPE_TDM.equalsIgnoreCase(getReportType())) {
            try {
                Class<?> cls = Class.forName(getTdmPackageName());
                cls.getMethod("initialize", new Class[0]).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (ClassNotFoundException e) {
                IMLogger.d("TMD class not found, no report : " + e.getMessage());
            } catch (IllegalAccessException e2) {
                IMLogger.w("tdm report get IllegalAccessException : " + e2.getMessage(), new Object[0]);
            } catch (NoSuchMethodException e3) {
                IMLogger.w("get TDM function error : " + e3.getMessage(), new Object[0]);
            } catch (InvocationTargetException e4) {
                IMLogger.w("tdm report get  InvocationTargetException : " + e4.getTargetException().getMessage(), new Object[0]);
            } catch (Exception e5) {
                IMLogger.w("tdm report get  : " + e5.getMessage(), new Object[0]);
            }
        } else if (mSpecifyReportedInfo == null) {
            mSpecifyReportedInfo = new StatSpecifyReportedInfo();
            mSpecifyReportedInfo.setAppKey("AH3HVXV384J1");
            mSpecifyReportedInfo.setSendImmediately(true);
            mSpecifyReportedInfo.setImportant(true);
            mSpecifyReportedInfo.setInstallChannel(IR.def.IMSDK_KEYWORD);
            if (T.isDebug() && IMSDKConfig.getOrMetaData(IR.meta.IMSDK_MTA_REPORT_LOG, IR.meta.IMSDK_MTA_REPORT_LOG, false)) {
                StatConfig.setDebugEnable(true);
            } else {
                StatConfig.setDebugEnable(false);
            }
        }
        mIsInited = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void report(String str, Properties properties) {
        init();
        if (mEnableReportLog) {
            try {
                IMLogger.d("inner stat " + getReportType() + " report : " + new JSONObject(properties).toString());
            } catch (Exception e) {
                IMLogger.d("report errror " + e.getMessage());
            }
        }
        if (IMSDK_INNER_REPORT_TYPE_TDM.equalsIgnoreCase(getReportType())) {
            Set<String> stringPropertyNames = properties.stringPropertyNames();
            HashMap hashMap = new HashMap();
            Iterator<String> it = stringPropertyNames.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if ("version".equalsIgnoreCase(next)) {
                    next = MidEntity.TAG_VER;
                }
                if ("interval".equalsIgnoreCase(next)) {
                    next = "intvl";
                }
                hashMap.put(next, properties.getProperty(next));
            }
            try {
                Class<?> cls = Class.forName(getTdmPackageName());
                Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                cls.getMethod("reportEvent", Integer.TYPE, String.class, Map.class).invoke(invoke, Integer.valueOf(IMSDK_TDM_SOURCE_ID), "tdm_" + str, hashMap);
                return;
            } catch (ClassNotFoundException e2) {
                IMLogger.d("TMD class not found, no report : " + e2.getMessage());
                return;
            } catch (IllegalAccessException e3) {
                IMLogger.w("tdm report get IllegalAccessException : " + e3.getMessage(), new Object[0]);
                return;
            } catch (NoSuchMethodException e4) {
                IMLogger.w("get TDM function error : " + e4.getMessage(), new Object[0]);
                return;
            } catch (InvocationTargetException e5) {
                IMLogger.w("tdm report get  InvocationTargetException : " + e5.getTargetException().getMessage(), new Object[0]);
                return;
            } catch (Exception e6) {
                IMLogger.w("tdm report get  : " + e6.getMessage(), new Object[0]);
                return;
            }
        }
        StatServiceImpl.trackCustomKVEvent(T.mGlobalActivityUpToDate.getApplicationContext(), str, properties, mSpecifyReportedInfo);
    }
}
