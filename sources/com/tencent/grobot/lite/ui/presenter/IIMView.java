package com.tencent.grobot.lite.ui.presenter;

import com.tencent.grobot.lite.model.local.IMMsgInfo;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface IIMView {
    FrameActivity context();

    void onFormCommitResult(int i, String str);

    void onGetTicketDetail(String str, int i, JSONObject jSONObject);

    void onUserScored(String str, int i);

    void setFormData(int i, JSONObject jSONObject);

    void updateBottomActionView(int i, String str, IMMsgInfo.SysMsg sysMsg);
}
