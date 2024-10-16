package com.tencent.grobot.lite.presenter.business;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.grobot.lite.core.IMPresenterCallback;
import com.tencent.grobot.lite.model.AnswerModelConverter;
import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.tencent.grobot.lite.model.local.IMMsgInfo;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.model.req.IMReqInfo;
import com.tencent.grobot.lite.presenter.business.callback.IMCallback;
import com.tencent.grobot.lite.presenter.business.engine.IMEngine;
import com.tencent.grobot.lite.presenter.transport.json.JsonReqSender;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IMCenter {
    public static final int INVALID_POSTION = -1;
    private IMPresenterCallback imPresenterCallback;
    private int lastPosition = 0;
    private Map<Integer, BaseNode> quNodeMap = new ConcurrentHashMap();
    private IMCallback imCallback = new IMCallback() { // from class: com.tencent.grobot.lite.presenter.business.IMCenter.1
        @Override // com.tencent.grobot.lite.presenter.business.callback.IMCallback
        public void onCreateIMResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo) {
            if (IMCenter.this.imPresenterCallback != null) {
                IMCenter.this.imPresenterCallback.onCreateIMResult(i, i2, str, jSONObject);
            }
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.IMCallback
        public void onPushIMMsgResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo) {
            int i3;
            BaseNode baseNode = (BaseNode) IMCenter.this.quNodeMap.remove(Integer.valueOf(i));
            int i4 = -1;
            if (baseNode != null) {
                QuTextNode quTextNode = (QuTextNode) baseNode;
                quTextNode.quSendingState = 1;
                i4 = quTextNode.position;
                i3 = quTextNode.questionOrderId;
                String str2 = quTextNode.text;
            } else {
                i3 = -1;
            }
            IMCenter.this.resolvePushMsgResult(i2, null, i4, i3);
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.IMCallback
        public void onPullIMMsgResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo) {
            if (i2 == 0) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("im_msg");
                    if (optJSONArray == null) {
                        return;
                    }
                    ArrayList<IMMsgInfo> arrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        int optInt = optJSONArray.optJSONObject(i3).optInt("msg_type");
                        IMMsgInfo iMMsgInfo = new IMMsgInfo();
                        iMMsgInfo.msgType = optInt;
                        iMMsgInfo.agentName = optJSONArray.optJSONObject(i3).optString("agent_name");
                        if (optInt == 1) {
                            iMMsgInfo.content = optJSONArray.optJSONObject(i3).optString(FirebaseAnalytics.Param.CONTENT);
                        } else if (optInt == 0) {
                            JSONObject jSONObject2 = new JSONObject(optJSONArray.optJSONObject(i3).optString(FirebaseAnalytics.Param.CONTENT));
                            iMMsgInfo.sysMsg.subType = jSONObject2.optInt("sub_type");
                            JSONObject optJSONObject = jSONObject2.optJSONObject("sub_content");
                            if (optJSONObject == null) {
                                return;
                            }
                            iMMsgInfo.sysMsg.sessionStatus = optJSONObject.optInt("session_status");
                            iMMsgInfo.sysMsg.msg = optJSONObject.optString("msg");
                        } else if (optInt == 6) {
                            EvaluateInfo convertEvaluateInfo = AnswerModelConverter.convertEvaluateInfo(new JSONObject(optJSONArray.optJSONObject(i3).optString(FirebaseAnalytics.Param.CONTENT)), EvaluateInfo.TYPE_IM);
                            iMMsgInfo.sessionId = convertEvaluateInfo.evaluateId;
                            iMMsgInfo.evaluateInfo = convertEvaluateInfo;
                        }
                        arrayList.add(iMMsgInfo);
                    }
                    if (IMCenter.this.imPresenterCallback != null) {
                        IMCenter.this.imPresenterCallback.onPullIMMsgResult(i2, arrayList);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.IMCallback
        public void onCloseIMResult(int i, int i2, String str, JSONObject jSONObject, IMReqInfo iMReqInfo) {
            if (IMCenter.this.imPresenterCallback != null) {
                IMCenter.this.imPresenterCallback.onCloseIMResult(i, i2, str, jSONObject);
            }
        }
    };
    private IMEngine imEngine = new IMEngine();

    public IMCenter(JsonReqSender jsonReqSender) {
        this.imEngine.register(this.imCallback, jsonReqSender);
    }

    public void onDestory() {
        this.imEngine.unregister(this.imCallback);
    }

    public int createIM(String str, String str2, IMPresenterCallback iMPresenterCallback) {
        if (iMPresenterCallback != null) {
            this.imPresenterCallback = iMPresenterCallback;
        }
        return this.imEngine.createIM(str, str2);
    }

    public int pushIMMsg(String str, int i, String str2, String str3, int i2) {
        if (i2 >= 0) {
            this.lastPosition = i2;
        }
        QuTextNode buildQuestionNode = buildQuestionNode("", str2);
        int pushIMMsg = this.imEngine.pushIMMsg(str, i, str2, str3);
        this.quNodeMap.put(Integer.valueOf(pushIMMsg), buildQuestionNode);
        return pushIMMsg;
    }

    private QuTextNode buildQuestionNode(String str, String str2) {
        ArrayList<BaseNode> arrayList = new ArrayList<>();
        QuTextNode parseQuestion = DataProcessor.parseQuestion(str, str2, this.lastPosition, 0);
        arrayList.add(parseQuestion);
        resolvePushMsgResult(0, arrayList, -1, -1);
        return parseQuestion;
    }

    public int pullIMMsg(String str, IMPresenterCallback iMPresenterCallback) {
        if (iMPresenterCallback != null) {
            this.imPresenterCallback = iMPresenterCallback;
        }
        return this.imEngine.pullIMMsg(str);
    }

    public int closeIM(String str, String str2, IMPresenterCallback iMPresenterCallback) {
        if (iMPresenterCallback != null) {
            this.imPresenterCallback = iMPresenterCallback;
        }
        return this.imEngine.closeIM(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resolvePushMsgResult(int i, ArrayList<BaseNode> arrayList, int i2, int i3) {
        IMPresenterCallback iMPresenterCallback = this.imPresenterCallback;
        if (iMPresenterCallback != null) {
            iMPresenterCallback.onPushIMMsgResult(i, arrayList, i2, i3);
        }
    }
}
