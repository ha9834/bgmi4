package com.tdatamaster.tdm.gcloud.service;

import com.tdatamaster.tdm.system.TDMLog;

/* loaded from: classes2.dex */
public class PluginReportService {
    private static final String TDM_LIBRARY = "TDataMaster";

    private static native boolean registerTdmReportServiceNative();

    public static boolean registerTdmReportService() {
        try {
            System.loadLibrary(TDM_LIBRARY);
            return registerTdmReportServiceNative();
        } catch (Throwable th) {
            TDMLog.e(TDM_LIBRARY, th.getMessage());
            return false;
        }
    }
}
