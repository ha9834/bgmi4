package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.req.TicketReqInfo;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface TicketCallback extends ActionCallback {
    void onNewTicketResult(int i, int i2, String str, TicketReqInfo ticketReqInfo);

    void onQueryFormTemplateDetailResult(int i, int i2, String str, JSONObject jSONObject, TicketReqInfo ticketReqInfo);

    void onQueryTicketDetailResult(int i, int i2, String str, JSONObject jSONObject, TicketReqInfo ticketReqInfo);

    void onQueryTicketListResult(int i, int i2, String str, JSONObject jSONObject, TicketReqInfo ticketReqInfo);
}
