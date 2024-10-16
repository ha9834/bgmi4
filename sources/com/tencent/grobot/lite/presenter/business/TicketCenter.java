package com.tencent.grobot.lite.presenter.business;

import com.tencent.grobot.lite.core.TicketPresenterCallback;
import com.tencent.grobot.lite.model.req.FormTemplateDetailReqInfo;
import com.tencent.grobot.lite.model.req.NewTicketReqInfo;
import com.tencent.grobot.lite.model.req.QueryTicketDetailReqInfo;
import com.tencent.grobot.lite.model.req.TicketReqInfo;
import com.tencent.grobot.lite.presenter.business.callback.TicketCallback;
import com.tencent.grobot.lite.presenter.business.engine.TicketEngine;
import com.tencent.grobot.lite.presenter.transport.json.JsonReqSender;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TicketCenter {
    protected static final String TAG = "TicketCenter";
    private TicketCallback ticketCallback = new TicketCallback() { // from class: com.tencent.grobot.lite.presenter.business.TicketCenter.1
        @Override // com.tencent.grobot.lite.presenter.business.callback.TicketCallback
        public void onQueryFormTemplateDetailResult(int i, int i2, String str, JSONObject jSONObject, TicketReqInfo ticketReqInfo) {
            if (TicketCenter.this.ticketPresenterCallback != null) {
                TicketCenter.this.ticketPresenterCallback.onQueryFormTemplateDetailResult(i, i2, str, jSONObject, ticketReqInfo instanceof FormTemplateDetailReqInfo ? ((FormTemplateDetailReqInfo) ticketReqInfo).formId : "");
            }
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.TicketCallback
        public void onNewTicketResult(int i, int i2, String str, TicketReqInfo ticketReqInfo) {
            if (TicketCenter.this.ticketPresenterCallback != null) {
                TicketCenter.this.ticketPresenterCallback.onNewTicketResult(i, i2, str, ticketReqInfo instanceof NewTicketReqInfo ? ((NewTicketReqInfo) ticketReqInfo).formId : "");
            }
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.TicketCallback
        public void onQueryTicketListResult(int i, int i2, String str, JSONObject jSONObject, TicketReqInfo ticketReqInfo) {
            if (TicketCenter.this.ticketPresenterCallback != null) {
                TicketCenter.this.ticketPresenterCallback.onQueryTicketListResult(i, i2, str, jSONObject);
            }
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.TicketCallback
        public void onQueryTicketDetailResult(int i, int i2, String str, JSONObject jSONObject, TicketReqInfo ticketReqInfo) {
            if (TicketCenter.this.ticketPresenterCallback != null) {
                TicketCenter.this.ticketPresenterCallback.onQueryTicketDetailResult(i, i2, str, jSONObject, ticketReqInfo instanceof QueryTicketDetailReqInfo ? ((QueryTicketDetailReqInfo) ticketReqInfo).ticketId : "");
            }
        }
    };
    private TicketEngine ticketEngine = new TicketEngine();
    private TicketPresenterCallback ticketPresenterCallback;

    public TicketCenter(JsonReqSender jsonReqSender) {
        this.ticketEngine.register(this.ticketCallback, jsonReqSender);
    }

    public void onDestory() {
        this.ticketEngine.unregister(this.ticketCallback);
        this.ticketPresenterCallback = null;
    }

    public int queryFormDetail(String str, String str2, TicketPresenterCallback ticketPresenterCallback) {
        if (ticketPresenterCallback != null) {
            this.ticketPresenterCallback = ticketPresenterCallback;
        }
        return this.ticketEngine.queryFormTemplateDetail(str, str2);
    }

    public int newTicket(String str, String str2, String str3, String str4, String str5, String str6) {
        return this.ticketEngine.newTicket(str, str2, str3, str4, str5, str6);
    }

    public int queryTicketList(String str, TicketPresenterCallback ticketPresenterCallback) {
        if (ticketPresenterCallback != null) {
            this.ticketPresenterCallback = ticketPresenterCallback;
        }
        return this.ticketEngine.queryTicketList(str);
    }

    public int queryTicketDetail(String str, String str2, TicketPresenterCallback ticketPresenterCallback) {
        if (ticketPresenterCallback != null) {
            this.ticketPresenterCallback = ticketPresenterCallback;
        }
        return this.ticketEngine.queryTicketDetail(str, str2);
    }
}
