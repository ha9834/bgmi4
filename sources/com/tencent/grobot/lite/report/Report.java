package com.tencent.grobot.lite.report;

import android.text.TextUtils;
import com.tencent.grobot.lite.common.TLog;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Report {
    private static final String TAG = "Report";
    private String eventType = null;
    private String ext;
    private String indexId;
    private String itemId;
    private String itemSub1;
    private String moduleId;
    private String subId;

    public void report(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(this.eventType)) {
                jSONObject.put(ReportBridge.KEY_EVENT_TYPE, this.eventType);
            }
            if (!TextUtils.isEmpty(this.itemId)) {
                jSONObject.put(ReportBridge.KEY_ITEM_ID, this.itemId);
            }
            if (!TextUtils.isEmpty(this.subId)) {
                jSONObject.put(ReportBridge.KEY_SUB_ID, this.subId);
            }
            if (!TextUtils.isEmpty(this.itemSub1)) {
                jSONObject.put(ReportBridge.KEY_ITEM_SUB_1, this.itemSub1);
            }
            if (!TextUtils.isEmpty(this.indexId)) {
                jSONObject.put(ReportBridge.KEY_INDEX_ID, this.indexId);
            }
            if (!TextUtils.isEmpty(this.moduleId)) {
                jSONObject.put(ReportBridge.KEY_MODULE_ID, this.moduleId);
            }
            if (!TextUtils.isEmpty(this.ext)) {
                jSONObject.put("ext", this.ext);
            }
            ReportBridge.report(jSONObject, z);
        } catch (Exception e) {
            TLog.d(TAG, "report failed, ex=" + e);
        }
    }

    public Report eventType(String str) {
        this.eventType = str;
        return this;
    }

    public Report itemId(String str) {
        this.itemId = str;
        return this;
    }

    public Report subId(String str) {
        this.subId = str;
        return this;
    }

    public Report itemSub1(String str) {
        this.itemSub1 = str;
        return this;
    }

    public Report indexId(String str) {
        this.indexId = str;
        return this;
    }

    public Report moduleId(String str) {
        this.moduleId = str;
        return this;
    }

    public Report ext(String str) {
        this.ext = str;
        return this;
    }
}
