package com.tencent.grobot.lite.presenter.business.engine;

import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.req.FormTemplateDetailReqInfo;
import com.tencent.grobot.lite.model.req.NewTicketReqInfo;
import com.tencent.grobot.lite.model.req.QueryTicketDetailReqInfo;
import com.tencent.grobot.lite.model.req.QueryTicketListReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.model.req.TicketReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.TicketCallback;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TicketEngine extends BaseEngine<TicketCallback> {
    public int queryFormTemplateDetail(String str, String str2) {
        try {
            FormTemplateDetailReqInfo formTemplateDetailReqInfo = new FormTemplateDetailReqInfo();
            buildTicketReqInfo(formTemplateDetailReqInfo, 0);
            formTemplateDetailReqInfo.certificate = str;
            formTemplateDetailReqInfo.formId = str2;
            JSONObject jsonObject = formTemplateDetailReqInfo.getJsonObject();
            jsonObject.put("form_template_id", str2);
            return sendJsonRequest(formTemplateDetailReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int newTicket(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            NewTicketReqInfo newTicketReqInfo = new NewTicketReqInfo();
            buildTicketReqInfo(newTicketReqInfo, 1);
            newTicketReqInfo.certificate = str;
            newTicketReqInfo.ticketInfo = str2;
            newTicketReqInfo.tagId = str3;
            newTicketReqInfo.formId = str4;
            newTicketReqInfo.email = str5;
            JSONObject jsonObject = newTicketReqInfo.getJsonObject();
            jsonObject.put("ticket_info", str2);
            jsonObject.put("tag_id", str3);
            jsonObject.put("form_template_id", str4);
            jsonObject.put("email", str5);
            jsonObject.put("form_template_type", str6);
            return sendJsonRequest(newTicketReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int queryTicketList(String str) {
        try {
            QueryTicketListReqInfo queryTicketListReqInfo = new QueryTicketListReqInfo();
            buildTicketReqInfo(queryTicketListReqInfo, 2);
            queryTicketListReqInfo.certificate = str;
            return sendJsonRequest(queryTicketListReqInfo, queryTicketListReqInfo.getJsonObject());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int queryTicketDetail(String str, String str2) {
        try {
            QueryTicketDetailReqInfo queryTicketDetailReqInfo = new QueryTicketDetailReqInfo();
            buildTicketReqInfo(queryTicketDetailReqInfo, 3);
            queryTicketDetailReqInfo.certificate = str;
            queryTicketDetailReqInfo.ticketId = str2;
            JSONObject jsonObject = queryTicketDetailReqInfo.getJsonObject();
            jsonObject.put("ticket_id", str2);
            return sendJsonRequest(queryTicketDetailReqInfo, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void buildTicketReqInfo(TicketReqInfo ticketReqInfo, int i) {
        ticketReqInfo.type = i;
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, final JSONObject jSONObject, final ReqInfo reqInfo) {
        if (jSONObject != null) {
            notifyDataChanged(new CallbackHelper.Caller<TicketCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.TicketEngine.1
                @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                public void call(TicketCallback ticketCallback) {
                    ReqInfo reqInfo2 = reqInfo;
                    if (reqInfo2 == null || !(reqInfo2 instanceof TicketReqInfo)) {
                        return;
                    }
                    TicketReqInfo ticketReqInfo = (TicketReqInfo) reqInfo2;
                    switch (((TicketReqInfo) reqInfo2).type) {
                        case 0:
                            ticketCallback.onQueryFormTemplateDetailResult(i, 0, "", jSONObject, ticketReqInfo);
                            return;
                        case 1:
                            ticketCallback.onNewTicketResult(i, 0, "", ticketReqInfo);
                            return;
                        case 2:
                            ticketCallback.onQueryTicketListResult(i, 0, "", jSONObject, ticketReqInfo);
                            return;
                        case 3:
                            ticketCallback.onQueryTicketDetailResult(i, 0, "", jSONObject, ticketReqInfo);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else {
            handleJsonFail(i, getErrorCode(reqInfo), "resObj is null", null, reqInfo);
        }
    }

    private int getErrorCode(ReqInfo reqInfo) {
        if (reqInfo == null || !(reqInfo instanceof TicketReqInfo)) {
            return PresenterCode.Code_Engine_UNKNOWN_Error;
        }
        switch (((TicketReqInfo) reqInfo).type) {
            case 0:
                return PresenterCode.Code_Engine_Query_Template_Detail_Error;
            case 1:
                return PresenterCode.Code_Engine_New_Ticket_Error;
            case 2:
                return PresenterCode.Code_Engine_Query_Ticket_List_Error;
            case 3:
                return PresenterCode.Code_Engine_Query_Ticket_Detail_Error;
            default:
                return PresenterCode.Code_Engine_UNKNOWN_Error;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, final int i2, final String str, final JSONObject jSONObject, final ReqInfo reqInfo) {
        TLog.d("Presenter.Engine", "handleFail seq:" + i + ",resultCode:" + i2 + ",msg:" + str);
        notifyDataChanged(new CallbackHelper.Caller<TicketCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.TicketEngine.2
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(TicketCallback ticketCallback) {
                ReqInfo reqInfo2 = reqInfo;
                if (reqInfo2 instanceof TicketReqInfo) {
                    TicketReqInfo ticketReqInfo = (TicketReqInfo) reqInfo2;
                    switch (((TicketReqInfo) reqInfo2).type) {
                        case 0:
                            ticketCallback.onQueryFormTemplateDetailResult(i, i2, str, jSONObject, ticketReqInfo);
                            return;
                        case 1:
                            ticketCallback.onQueryFormTemplateDetailResult(i, i2, str, jSONObject, ticketReqInfo);
                            return;
                        case 2:
                            ticketCallback.onQueryFormTemplateDetailResult(i, i2, str, jSONObject, ticketReqInfo);
                            return;
                        case 3:
                            ticketCallback.onQueryFormTemplateDetailResult(i, i2, str, jSONObject, ticketReqInfo);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
