package com.tencent.grobot.lite.report;

import com.tencent.grobot.lite.GRobotApplication;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ReportBridge {
    public static final String KEY_EVENT_TYPE = "eventtype";
    public static final String KEY_EXT = "ext";
    public static final String KEY_INDEX_ID = "indexid";
    public static final String KEY_ITEM_ID = "itemid";
    public static final String KEY_ITEM_SUB_1 = "item_sub1";
    public static final String KEY_MODULE_ID = "moduleid";
    public static final String KEY_SUB_ID = "subId";
    public static final int TYPE_PIC = 1;
    public static final int TYPE_TIP = 2;
    public static final int TYPE_VIDEO = 0;
    public static final String VALUE_CLICK = "1002";
    public static final String VALUE_EXPOSURE = "1001";
    public static final String VALUE_GIFT = "1017";

    public static void reportViewsClick(int i, String str) {
        ReportService reportService;
        if (GRobotApplication.getInstance().isHms() || (reportService = (ReportService) GRobotApplication.getInstance().getService(ReportService.class)) == null) {
            return;
        }
        if (i == 0) {
            reportService.reportEvent("7128", "1002", str);
        } else if (i == 1) {
            reportService.reportEvent("7129", "1002", str);
        } else if (i == 2) {
            reportService.reportEvent("7130", "1002", str);
        }
    }

    public static void report(JSONObject jSONObject, boolean z) {
        ReportService reportService;
        if (GRobotApplication.getInstance().isHms() || (reportService = (ReportService) GRobotApplication.getInstance().getService(ReportService.class)) == null) {
            return;
        }
        reportService.report(jSONObject, z);
    }
}
