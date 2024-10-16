package com.helpshift.util;

import android.content.Context;
import com.helpshift.logger.logmodels.ILogExtrasModel;
import com.helpshift.logger.logmodels.LogExtrasModelProvider;
import com.helpshift.providers.CrossModuleDataProvider;
import com.helpshift.providers.ISupportDataProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ErrorReportProvider {
    public static final long BATCH_TIME = 86400000;
    public static final String KEY_ACTIVE_CONVERSATION_ID = "actconvid";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_FUNNEL = "funnel";
    public static final String KEY_NETWORK_TYPE = "nt";
    public static final String KEY_THREAD_INFO = "thread";
    private static String TAG = "HS_ErrorReport";

    public static List<ILogExtrasModel> getErrorReportExtras(Context context, Thread thread) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(LogExtrasModelProvider.fromString(KEY_APP_ID, context.getPackageName()));
            arrayList.add(LogExtrasModelProvider.fromString("nt", HelpshiftConnectionUtil.getNetworkType(context)));
            ISupportDataProvider supportDataProvider = CrossModuleDataProvider.getSupportDataProvider();
            String actionEvents = supportDataProvider == null ? "" : supportDataProvider.getActionEvents();
            if (actionEvents != null) {
                arrayList.add(LogExtrasModelProvider.fromString(KEY_FUNNEL, actionEvents));
            }
            String activeConversationId = supportDataProvider == null ? "" : supportDataProvider.getActiveConversationId();
            if (!TextUtils.isEmpty(activeConversationId)) {
                arrayList.add(LogExtrasModelProvider.fromString(KEY_ACTIVE_CONVERSATION_ID, activeConversationId));
            }
            arrayList.add(LogExtrasModelProvider.fromString(KEY_THREAD_INFO, thread != null ? thread.toString() : "Unknown"));
        } catch (Exception e) {
            HSLogger.e(TAG, "Error creating error report", e);
        }
        return arrayList;
    }
}
