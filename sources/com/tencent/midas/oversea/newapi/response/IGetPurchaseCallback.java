package com.tencent.midas.oversea.newapi.response;

import com.tencent.midas.oversea.data.APPayReceipt;
import java.util.List;

/* loaded from: classes.dex */
public interface IGetPurchaseCallback {
    void callback(List<APPayReceipt> list);
}
