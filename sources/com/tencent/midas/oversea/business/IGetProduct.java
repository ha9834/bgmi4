package com.tencent.midas.oversea.business;

import android.content.Context;
import com.tencent.midas.oversea.newapi.response.InfoCallback;
import java.util.List;

/* loaded from: classes.dex */
public interface IGetProduct {
    void getProductInfo(Context context, List<String> list, InfoCallback infoCallback);
}
