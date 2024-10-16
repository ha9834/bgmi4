package com.tencent.grobot.lite.model;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.node.IMServerTextNode;
import com.tencent.grobot.lite.model.node.QuTextNode;
import com.tencent.grobot.lite.presenter.business.DataProcessor;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LogAnwserModelConverter {
    public static ArrayList<BaseNode> buildNodes(JSONObject jSONObject) {
        ArrayList<BaseNode> arrayList = new ArrayList<>();
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("logs");
                if (optJSONArray == null) {
                    return arrayList;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (optJSONArray.optJSONObject(i).optInt("msg_type") == 1000) {
                        String optString = optJSONArray.optJSONObject(i).optString("question");
                        String optString2 = optJSONArray.optJSONObject(i).optString("question_id");
                        String optString3 = optJSONArray.optJSONObject(i).optString("answer_id");
                        if (optString != null && !TextUtils.isEmpty(optString) && !optString.equals("init")) {
                            QuTextNode quTextNode = new QuTextNode();
                            quTextNode.quSendingState = 1;
                            quTextNode.questionId = optString2;
                            quTextNode.text = optString;
                            arrayList.add(quTextNode);
                        }
                        String optString4 = optJSONArray.optJSONObject(i).optString("answer");
                        if (optString4 != null && !TextUtils.isEmpty(optString4)) {
                            arrayList.addAll(DataProcessor.parseAnswer(optString3, optString2, optString, (byte) 0, AnswerModelConverter.convertAnswerItems(new JSONArray(optString4), optString3, true), true));
                        }
                    } else {
                        optJSONArray.optJSONObject(i).optString("question");
                        optJSONArray.optJSONObject(i).optString("question_id");
                        String optString5 = optJSONArray.optJSONObject(i).optString("answer");
                        if (optString5 != null && !TextUtils.isEmpty(optString5)) {
                            JSONObject jSONObject2 = new JSONObject(optString5);
                            int optInt = jSONObject2.optInt("msg_type");
                            boolean z = jSONObject2.optInt("is_send") == 1;
                            if (optInt == 1) {
                                if (z) {
                                    IMServerTextNode iMServerTextNode = new IMServerTextNode();
                                    iMServerTextNode.agentName = jSONObject2.optString("agent_name");
                                    iMServerTextNode.msg = jSONObject2.optString(FirebaseAnalytics.Param.CONTENT);
                                    if (iMServerTextNode.msg != null && !TextUtils.isEmpty(iMServerTextNode.msg)) {
                                        arrayList.add(iMServerTextNode);
                                    }
                                } else {
                                    QuTextNode quTextNode2 = new QuTextNode();
                                    quTextNode2.quSendingState = 1;
                                    quTextNode2.text = jSONObject2.optString(FirebaseAnalytics.Param.CONTENT);
                                    arrayList.add(quTextNode2);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }
}
