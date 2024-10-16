package com.tencent.grobot.lite.core;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface TicketPresenterCallback extends IServiceCallback {
    void onNewTicketResult(int i, int i2, String str, String str2);

    void onQueryFormTemplateDetailResult(int i, int i2, String str, JSONObject jSONObject, String str2);

    void onQueryTicketDetailResult(int i, int i2, String str, JSONObject jSONObject, String str2);

    void onQueryTicketListResult(int i, int i2, String str, JSONObject jSONObject);
}
