package com.tencent.midas.oversea.business.pay;

import android.os.Message;

/* loaded from: classes.dex */
public interface XCallback {
    void notifyInner(Message message);

    void notifyOuterLoginErr();

    void notifyOuterRiskErr(int i, String str);
}
